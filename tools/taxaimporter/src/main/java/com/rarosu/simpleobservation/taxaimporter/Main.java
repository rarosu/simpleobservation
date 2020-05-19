package com.rarosu.simpleobservation.taxaimporter;

import com.rarosu.simpleobservation.common.models.Taxon;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running the taxa importer...");
        
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Only one argument with the path to the excel file can be specified. Quote the path if there are spaces in it.");
            System.exit(1);
        }
        
        String filePath = args[0];
        
        Workbook workbook;
        try (InputStream file = new FileInputStream(filePath)) {
            workbook = WorkbookFactory.create(file);
        }
        catch (IOException ex) {
            System.out.println(String.format("Failed to open workbook at location %s. Exception: %s.", filePath, ex));
            System.exit(1);
            return;
        }
        
        var taxonReader = new TaxonReader();
        List<Taxon> taxa = taxonReader.readTaxa(workbook);
        
        var taxonPersister = new TaxonPersister();
        
        TaxaUpdateSummary summary = taxonPersister.previewChanges(taxa);
        System.out.println(String.format("%s taxa will be added, %s taxa will be updated and %s taxa exists in the database that does not exist in the provided excel (will not be modified).", summary.getTaxaToBeCreated().size(), summary.getTaxaToBeUpdated().size(), summary.getTaxaNoLongerPresent().size()));
        
        Optional<Boolean> answer;
        try {
            do {
                System.out.println("Continue with import (y/n)?");
                answer = getYesNoInput();
            } while (answer.isEmpty());
        }
        catch (IOException ex) {
            System.out.println(String.format("Error on fetching user input. Exception %s.", ex));
            System.exit(1);
            return;
        }
        
        if (answer.orElseThrow()) {
            taxonPersister.saveTaxa(taxa);
        }
        
        System.out.println("Finished running the taxa importer!");
    }
    
    private static Optional<Boolean> getYesNoInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line.equalsIgnoreCase("y"))
            return Optional.of(true);
        else if (line.equalsIgnoreCase("n"))
            return Optional.of(false);
        return Optional.empty();
    }
}
