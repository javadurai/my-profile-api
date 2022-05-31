package com.jabadurai;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class ProfessionalSummaryResource {
	
	@Autowired
	ProfessionalSummaryRepository repository;
	
	@GetMapping
	List<ProfessionalSummary> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<ProfessionalSummary> findOne(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping
	ProfessionalSummary create(@RequestBody ProfessionalSummary summary) {
		return repository.save(summary);
	}
	
	@PutMapping
	void update(@RequestBody ProfessionalSummary summary) {
		log.info(summary);
		repository.save(summary);
	}
	
	@DeleteMapping
	void delete(@RequestBody ProfessionalSummary summary) {
		repository.delete(summary);
	}

}
