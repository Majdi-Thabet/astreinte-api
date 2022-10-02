package com.proxym.gestionastreintes.controller;

import com.proxym.gestionastreintes.model.Historique;
import com.proxym.gestionastreintes.repository.HistoriqueRepository;
import com.proxym.gestionastreintes.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//mark class as Controller
@RestController
public class HistoriqueController {

    //autowire the historiqueservice class
    @Autowired
    HistoriqueService historiqueService;
    //creating a get mapping that retrieves all the historique detail from the database
    @GetMapping("/getallhistorique")
    private List<Historique> getAllHistoriques()
    {
            return historiqueService.getAllHistoriques();
    }
    //creating a get mapping that retrieves the detail of a specific historique
    @GetMapping("/historique/{id}")
    private Historique getHistorique(@PathVariable("id") long id)
    {
        return historiqueService.gethistoriqueById(id);
    }
    //creating a delete mapping that deletes a specified historique
    @DeleteMapping("/historique/{id}")
    private void deleteHistorique(@PathVariable("id") long id)
    {
        historiqueService.delete(id);
    }
    //creating post mapping that post the historique detail in the database
    @PostMapping("/historique/{iddemande}")
    private Historique savehistorique(@RequestBody Historique historique, @PathVariable("iddemande")Long iddemande)
    {
        return historiqueService.save(historique,iddemande);

    }

    @GetMapping("/historiquebyidcollab/{idcollab}")
    private List<Historique> getHistoriqueByIdCollaborateur(@PathVariable("idcollab") long idcollab)
    {
        return historiqueService.getHistoriqueByIdCollaborateur(idcollab);
    }

    //creating put mapping that updates the historique detail
    @Autowired
    private HistoriqueRepository historiqueRepository;
    @PutMapping("/historique/{id}")
    public ResponseEntity<Historique> update(@PathVariable("id") long id, @RequestBody Historique historique){
        Optional<Historique> historiqueData = historiqueRepository.findById(id);

        if(historiqueData.isPresent()) {
            Historique _historique = historiqueData.get();
            _historique.setTypeintervention(historique.getTypeintervention());

            _historique.setDemandeastreinte(_historique.getDemandeastreinte());


            return new ResponseEntity<>(historiqueRepository.saveAndFlush(_historique), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
