package com.projet.GestionCabinet.Services;

import java.util.List;

import com.projet.GestionCabinet.Entities.OrdonnancetTraitement;


public interface OrdonnancetTraitementService {

    public List<OrdonnancetTraitement> getAllOrdonnancetTraitement();

    public OrdonnancetTraitement getOrdonnancetTraitementById(long id);

    public OrdonnancetTraitement addOrdonnancetTraitement(OrdonnancetTraitement ordonnancetTraitement);

    public OrdonnancetTraitement updateOrdonnancetTraitement(long id, OrdonnancetTraitement ordonnancetTraitement);

    public void deleteOrdonnancetTraitement(Long id);
    
}