package com.proxym.gestionastreintes.service;

import com.proxym.gestionastreintes.enumuration.StatusdemandeEnum;
import com.proxym.gestionastreintes.model.Astreinte;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Demandeastreinte;
import com.proxym.gestionastreintes.model.Historique;
import com.proxym.gestionastreintes.repository.AstreinteRepository;
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
public class DemandeastreinteService {
    @Autowired
    private DemandeastreinteRepository demandeastreinteRepository;
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    @Autowired
    private AstreinteRepository astreinteRepository;

    @Autowired
    private HistoriqueRepository historiqueRepository;


    //getting all demandeastreintes record by using the method findaAll() of CrudRepository
    public List<Demandeastreinte> getAllDemandeAstreintes()
    {

        return this.demandeastreinteRepository.findAll();
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Demandeastreinte getdemandeastreinteById(long id)
    {
        return demandeastreinteRepository.getById(id);
    }



    //saving a specific record by using the method save() of CrudRepository
    public Demandeastreinte save(Demandeastreinte demandeastreinte,long idcollab,long idastreinte)
    {

        Collaborateur c =  collaborateurRepository.getById(idcollab);
        demandeastreinte.setCollaborateur(c);
        Astreinte a =  astreinteRepository.getById(idastreinte);
        demandeastreinte.setAstreinte(a);
        demandeastreinte.setStatusdemande(StatusdemandeEnum.EN_ATTENTE);
        return demandeastreinteRepository.save(demandeastreinte);
    }

    public Demandeastreinte accepterdemandeastreinte(long iddemande)
    {

        Demandeastreinte d =  demandeastreinteRepository.getById(iddemande);
        d.setStatusdemande(StatusdemandeEnum.PASSEE);
        return demandeastreinteRepository.save(d);
    }

    public Demandeastreinte annulerdemandeastreinte(long iddemande)
    {

        Demandeastreinte a =  demandeastreinteRepository.getById(iddemande);
        a.setStatusdemande(StatusdemandeEnum.ANNULEE);
        return demandeastreinteRepository.save(a);
    }

    public Demandeastreinte  startdemandeastreinte(long iddemande)
    {

        Demandeastreinte e =  demandeastreinteRepository.getById(iddemande);
        e.setStatusdemande(StatusdemandeEnum.ENCOURS);
        return demandeastreinteRepository.save(e);
    }

    public Demandeastreinte  pendingdemandeastreinte(long iddemande)
    {

        Demandeastreinte p =  demandeastreinteRepository.getById(iddemande);
        p.setStatusdemande(StatusdemandeEnum.EN_ATTENTE);
        return demandeastreinteRepository.save(p);
    }






    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(long id)
    {
        demandeastreinteRepository.deleteById(id);
    }
    //updating a record
    public Demandeastreinte update(Demandeastreinte demandeastreinte, long id)
    {
        return  demandeastreinteRepository.saveAndFlush(demandeastreinte);
    }




    public List<Demandeastreinte> getDemandeAstreinteByIdCollaborateur(long idcollab) {

        return demandeastreinteRepository.findDemandeastreinteByCollaborateurId(idcollab);
    }


//
//    private void getDemandeAstreinteByIdCollaborateur() {
//    }


//    public Demandeastreinte save(Demandeastreinte demandeastreinte,long idcollab,long idastreinte)
//    {
//
//        Collaborateur c =  collaborateurRepository.getById(idcollab);
//        demandeastreinte.setCollaborateur(c);
//        Astreinte a =  astreinteRepository.getById(idastreinte);
//        demandeastreinte.setAstreinte(a);
//        return demandeastreinteRepository.save(demandeastreinte);
//    }
}
