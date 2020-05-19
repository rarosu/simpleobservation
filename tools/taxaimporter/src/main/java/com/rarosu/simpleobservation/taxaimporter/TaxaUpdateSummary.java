package com.rarosu.simpleobservation.taxaimporter;

import com.rarosu.simpleobservation.common.models.Taxon;
import java.util.Collections;
import java.util.List;


public class TaxaUpdateSummary {
    private final List<Taxon> taxaToBeCreated;
    private final List<Taxon> taxaToBeUpdated;
    private final List<Taxon> taxaNoLongerPresent;

    public TaxaUpdateSummary(List<Taxon> taxaToBeCreated, List<Taxon> taxaToBeUpdated, List<Taxon> taxaNoLongerPresent) {
        this.taxaToBeCreated = Collections.unmodifiableList(taxaToBeCreated);
        this.taxaToBeUpdated = Collections.unmodifiableList(taxaToBeUpdated);
        this.taxaNoLongerPresent = Collections.unmodifiableList(taxaNoLongerPresent);
    }

    public List<Taxon> getTaxaToBeCreated() {
        return taxaToBeCreated;
    }

    public List<Taxon> getTaxaToBeUpdated() {
        return taxaToBeUpdated;
    }

    public List<Taxon> getTaxaNoLongerPresent() {
        return taxaNoLongerPresent;
    }
}
