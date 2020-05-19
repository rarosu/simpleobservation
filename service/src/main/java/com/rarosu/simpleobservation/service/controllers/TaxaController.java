package com.rarosu.simpleobservation.service.controllers;

import com.rarosu.simpleobservation.common.models.Taxon;
import com.rarosu.simpleobservation.common.models.TaxonRanking;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxaController {

    private final SessionFactory sessionFactory;
    private final JinqJPAStreamProvider streamProvider;

    @Autowired
    public TaxaController(SessionFactory sessionFactory, JinqJPAStreamProvider streamProvider) {
        this.sessionFactory = sessionFactory;
        this.streamProvider = streamProvider;
    }
    
    @GetMapping(path = "/isAlive")
    public boolean isAlive() {
        return true;
    }
    
    @GetMapping(path = "/taxa")
    @Transactional
    public Taxon getAll() {
        // There exists only one clade (Tracheophyta) in this application. Return it and all its subtaxa.
        Session session = sessionFactory.getCurrentSession();
        JinqStream<Taxon> stream = streamProvider.streamAll(session, Taxon.class);
        return stream.where(t -> t.getRanking() == TaxonRanking.CLADE).findOne().orElseThrow();
    }
    
    @GetMapping(path = "/taxa/{id}")
    @Transactional
    public Taxon getById(@PathVariable("id")int id) {
        Session session = sessionFactory.getCurrentSession();
        JinqStream<Taxon> stream = streamProvider.streamAll(session, Taxon.class);
        return stream.where(t -> t.getId() == id).findOne().orElseThrow();
    }
}
