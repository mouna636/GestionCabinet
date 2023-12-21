package com.projet.GestionCabinet.Controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.GestionCabinet.DTO.CabinetForm;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Entities.ImageModel;
import com.projet.GestionCabinet.Services.CabinetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cabinets")

public class CabinetController {
    @Autowired
    private CabinetService cabinetService;

    /*
     * @PostMapping(value = { "" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE
     * })
     * public Cabinet addCabinet(@RequestPart("cabinet") Cabinet cabinet,
     * 
     * @RequestPart("imageFile") MultipartFile[] file) {
     * try {
     * Set<ImageModel> images = uploadImage(file);
     * cabinet.setCabinetImages(images);
     * return cabinetService.add(cabinet);
     * } catch (Exception e) {
     * System.out.println(e.getMessage());
     * return null;
     * }
     * }
     * 
     * public Set<ImageModel> uploadImage(MultipartFile[] MultipartFiles) throws
     * IOException {
     * Set<ImageModel> imageModels = new HashSet<>();
     * for (MultipartFile file : MultipartFiles) {
     * ImageModel imageModel = new ImageModel(
     * file.getOriginalFilename(),
     * file.getContentType(),
     * file.getBytes());
     * 
     * imageModels.add(imageModel);
     * }
     * return imageModels;
     * }
     */
    @PostMapping("/ajout")
    public ResponseEntity<Cabinet> ajouterCabinetAvecHoraires(@RequestBody CabinetForm cabinetForm) {
        Cabinet nouveauCabinet = cabinetService.AjouterCabinet(cabinetForm);
        return ResponseEntity.ok(nouveauCabinet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CabinetForm>> getAllCabinets() {
        List<CabinetForm> cabinets = cabinetService.getAllCabinets();
        return new ResponseEntity<>(cabinets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cabinet getCabinetById(@PathVariable Long id) {
        return cabinetService.findById(id);
    }

    @PutMapping("/{id}")
    public Cabinet updateCabinet(@PathVariable Long id, @RequestBody Cabinet cabinet) {
        return cabinetService.update(id, cabinet);
    }

    @DeleteMapping("/{id}")
    public void deleteCabinet(@PathVariable Long id) {
        cabinetService.delete(id);

    }

    @GetMapping("/search")
    public List<Cabinet> searchCabinetByName(@RequestParam String name) {
        return cabinetService.findCabinetByName(name);
    }

    @GetMapping("/searchadr")
    public List<Cabinet> searchCabinetByAdresse(@RequestParam String adresse) {
        return cabinetService.findCabinetByAdresse(adresse);
    }

    /*
     * @PostMapping("/{cabinetId}/ajouter-horaire")
     * public ResponseEntity<String> ajouterHoraireTravailAuCabinet(
     * 
     * @PathVariable Long cabinetId,
     * 
     * @RequestBody HoraireTravail horaireTravail) {
     * cabinetService.ajouterHoraireTravailAuCabinet(cabinetId, horaireTravail);
     * return
     * ResponseEntity.ok("Horaire de travail ajouté au cabinet avec succès.");
     * }
     */

}
