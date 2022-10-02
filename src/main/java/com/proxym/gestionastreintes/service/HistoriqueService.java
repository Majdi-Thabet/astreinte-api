package com.proxym.gestionastreintes.service;

import com.proxym.gestionastreintes.model.Demandeastreinte;
import com.proxym.gestionastreintes.model.Historique;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;
import com.proxym.gestionastreintes.repository.DemandeastreinteRepository;
import com.proxym.gestionastreintes.repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
//defining the business logic
@Service
public class HistoriqueService {
    @Autowired
    private HistoriqueRepository historiqueRepository;
    @Autowired
    private DemandeastreinteRepository demandeastreinteRepository;

    //getting all historiques record by using the method findaAll() of CrudRepository
    public List<Historique> getAllHistoriques()
    {

        return this.historiqueRepository.findAll();
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Historique gethistoriqueById(long id)
    {
        return historiqueRepository.getById(id);
    }

    public List<Historique> getHistoriqueByIdCollaborateur(long idcollab) {

        return historiqueRepository.findHistoriqueByCollaborateurId(idcollab);
    }

    //saving a specific record by using the method save() of CrudRepository
    public Historique save(Historique historique,long iddemande)
    {

        Demandeastreinte d =  demandeastreinteRepository.getById(iddemande);
        historique.setDemandeastreinte(d);
        return historiqueRepository.save(historique);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(long id)
    {
        historiqueRepository.deleteById(id);
    }
    //updating a record
    public Historique update(Historique historique, long id)
    {
        return  historiqueRepository.saveAndFlush(historique);
    }


}
