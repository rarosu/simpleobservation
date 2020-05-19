package com.rarosu.simpleobservation.taxaimporter;

import com.rarosu.simpleobservation.common.models.Taxon;
import com.rarosu.simpleobservation.common.models.TaxonRanking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TaxonReader {
    public final String SHEET_NAME = "Taxa";
    
    public final String COLUMN_HEADER_TAXON_ID = "TaxonId";
    public final String COLUMN_HEADER_TAXON_RANKING = "Taxonkategori";
    public final String COLUMN_HEADER_SCIENTIFIC_NAME = "Vetenskapligt namn";
    public final String COLUMN_HEADER_SWEDISH_NAME = "Svenskt namn";
    
    public List<Taxon> readTaxa(Workbook workbook) {
        // The sheet is always named Taxa when downloaded from Dyntaxa.
        Sheet sheet = workbook.getSheet(SHEET_NAME);
        
        Map<String, Integer> columnsByHeader = getColumnsByHeader(sheet);
        
        List<Taxon> taxa = new ArrayList<>();
        for (int rowIndex = sheet.getFirstRowNum() + 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            
            int dyntaxaId = (int)row.getCell(columnsByHeader.get(COLUMN_HEADER_TAXON_ID)).getNumericCellValue();
            TaxonRanking taxonRanking = mapTaxonRanking(row.getCell(columnsByHeader.get(COLUMN_HEADER_TAXON_RANKING)).getStringCellValue());
            String scientificName = row.getCell(columnsByHeader.get(COLUMN_HEADER_SCIENTIFIC_NAME)).getStringCellValue();
            String swedishName = getStringCellValueOrNull(row.getCell(columnsByHeader.get(COLUMN_HEADER_SWEDISH_NAME)));
            
            Taxon taxon = new Taxon(0, dyntaxaId, taxonRanking, scientificName, swedishName);
            taxa.add(taxon);
        }
        
        return taxa;
    }
    
    private Map<String, Integer> getColumnsByHeader(Sheet sheet) {
        HashMap<String, Integer> columnsByHeader = new HashMap<>();

        // The first row contains the headers.
        Row row = sheet.getRow(sheet.getFirstRowNum());
        
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            
            if (cell.getStringCellValue().equalsIgnoreCase(COLUMN_HEADER_TAXON_ID)) {
                columnsByHeader.put(COLUMN_HEADER_TAXON_ID, cell.getColumnIndex());
            }
            
            if (cell.getStringCellValue().equalsIgnoreCase(COLUMN_HEADER_TAXON_RANKING)) {
                columnsByHeader.put(COLUMN_HEADER_TAXON_RANKING, cell.getColumnIndex());
            }
            
            if (cell.getStringCellValue().equalsIgnoreCase(COLUMN_HEADER_SCIENTIFIC_NAME)) {
                columnsByHeader.put(COLUMN_HEADER_SCIENTIFIC_NAME, cell.getColumnIndex());
            }
            
            if (cell.getStringCellValue().equalsIgnoreCase(COLUMN_HEADER_SWEDISH_NAME)) {
                columnsByHeader.put(COLUMN_HEADER_SWEDISH_NAME, cell.getColumnIndex());
            }
        }
        
        return columnsByHeader;
    }
    
    private TaxonRanking mapTaxonRanking(String taxonRanking) {
        switch (taxonRanking) {
            case "Stam":
                return TaxonRanking.PHYLUM;
            case "Klass":
                return TaxonRanking.CLASS;
            case "Ordning":
                return TaxonRanking.ORDER;
            case "Familj":
                return TaxonRanking.FAMILY;
            case "Släkte":
                return TaxonRanking.GENUS;
            case "Art":
                return TaxonRanking.SPECIES;
            default:
                throw new IllegalArgumentException(String.format("Taxon ranking %s was not expected.", taxonRanking));
        }
    }
    
    private String getStringCellValueOrNull(Cell cell) {
        if (cell == null) {
            return null;
        }
        
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        }
        
        return null;
    }
}
