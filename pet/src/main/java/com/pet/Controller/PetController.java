package com.pet.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.Entity.Pet;
import com.pet.Service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	private final PetService petService;

	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Pet>> getAllPet(){
		List<Pet> pets = petService.getAllPet();
		return ResponseEntity.ok(pets);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> getPetFindById(@PathVariable Long id){
		Pet pet = petService.getPetFindById(id);
		if (pet != null) {
			return ResponseEntity.ok(pet);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Pet> criarPet(@RequestBody Pet pet){
		Pet criarPet = petService.savePet(pet);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pet> criarPet(@PathVariable Long id, @RequestBody Pet pet){
		Pet alteraPet = petService.alteraPet(id, pet);
		if (alteraPet != null) {
			return ResponseEntity.ok(alteraPet);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> criarPet(@PathVariable Long id) {
		boolean deleted = petService.deletePet(id);
		if (deleted) {
			return ResponseEntity.ok().body("Pet excluido com sucesso!!!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
