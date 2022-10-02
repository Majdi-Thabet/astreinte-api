package com.proxym.gestionastreintes.controller;

import com.proxym.gestionastreintes.model.Demandeastreinte;
import com.proxym.gestionastreintes.repository.DemandeastreinteRepository;
import com.proxym.gestionastreintes.service.DemandeastreinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//mark class as Controller
@RestController
public class DemandeastreinteController {
    //autowire the demandeastreinteservice class
    @Autowired
    DemandeastreinteService demandeastreinteService;
    //creating a get mapping that retrieves all the demandeastreinte detail from the database
    @GetMapping("/getalldemandeastreinte")
    private List<Demandeastreinte> getAllDemandeAstreintes()
    {
        return demandeastreinteService.getAllDemandeAstreintes();

    }
    //creating a get mapping that retrieves the detail of a specific demandeastreinte
    @GetMapping("/demandeastreinte/{id}")
    private Demandeastreinte getDemandeAstreinte(@PathVariable("id") long id)
    {
        return demandeastreinteService.getdemandeastreinteById(id);
    }

    @GetMapping("/demandeastreintebyidcollab/{idcollab}")
    private List<Demandeastreinte> getDemandeAstreinteByIdCollaborateur(@PathVariable("idcollab") long idcollab)
    {
        return demandeastreinteService.getDemandeAstreinteByIdCollaborateur(idcollab);
    }

    //creating a delete mapping that deletes a specified demandeastreinte
    @DeleteMapping("/demandeastreinte/{id}")
    private void deleteAstreinte(@PathVariable("id") long id)
    {
        demandeastreinteService.delete(id);
    }
    //creating post mapping that post the demandeastreinte detail in the database
    @PostMapping("/demandeastreinte/{idcollab}/{idastreinte}")
    private Demandeastreinte savedemandeastreinte(@RequestBody Demandeastreinte demandeastreinte, @PathVariable("idcollab")Long idcollab,@PathVariable("idastreinte")Long idastreinte)
    {
        return demandeastreinteService.save(demandeastreinte,idcollab,idastreinte);

    }

    @GetMapping("/accepterdemande/{iddemande}")
    private Demandeastreinte accepterdemandeastreinte(@PathVariable("iddemande")Long iddemande)
    {
        return demandeastreinteService.accepterdemandeastreinte(iddemande);

    }

    @GetMapping("/annulerdemande/{iddemande}")
    private Demandeastreinte annulerdemandeastreinte(@PathVariable("iddemande")Long iddemande)
    {
        return demandeastreinteService.annulerdemandeastreinte(iddemande);
    }

    @GetMapping("/startdemande/{iddemande}")
    private Demandeastreinte startdemandeastreinte(@PathVariable("iddemande")Long iddemande)
    {
        return demandeastreinteService.startdemandeastreinte(iddemande);
    }

//    @GetMapping("/pendingdemande/{iddemande}")
//    private Demandeastreinte pendingdemandeastreinte(@PathVariable("iddemande")Long iddemande)
//    {
//        return demandeastreinteService.pendingdemandeastreinte(iddemande);
//    }


    //creating put mapping that updates the astreinte detail
    @Autowired
    private DemandeastreinteRepository demandeastreinteRepository;
    @PutMapping("/demandeastreinte/{id}")
    public ResponseEntity<Demandeastreinte> update(@PathVariable("id") long id, @RequestBody Demandeastreinte demandeastreinte){
        Optional<Demandeastreinte> demandeastreinteData = demandeastreinteRepository.findById(id);

        if(demandeastreinteData.isPresent()) {
            Demandeastreinte _demandeastreinte = demandeastreinteData.get();
            _demandeastreinte.setTypedemande(demandeastreinte.getTypedemande());
            _demandeastreinte.setStatusdemande(demandeastreinte.getStatusdemande());
            _demandeastreinte.setCommentaire(demandeastreinte.getCommentaire());
            _demandeastreinte.setCollaborateur(_demandeastreinte.getCollaborateur());
            _demandeastreinte.setAstreinte(_demandeastreinte.getAstreinte());

            return new ResponseEntity<>(demandeastreinteRepository.saveAndFlush(_demandeastreinte), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
