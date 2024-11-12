package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.professor.DtoCreateProfessor;
import com.AppNotifica_o.Notificacao.dtos.professor.DtoListProfessor;
import com.AppNotifica_o.Notificacao.dtos.professor.DtoUpdateProfessor;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import com.AppNotifica_o.Notificacao.service.ProfessorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateProfessor data) {
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        var professor = this.service.createProfessor(data);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var professor = this.service.getProfessor(id);
        return ResponseEntity.ok(professor);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListProfessor>> list(@PageableDefault Pageable pageable) {
        var page = this.service.getAllProfessor(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateProfessor data) {
        var professor = this.service.updateProfessor(data);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.service.deactivate(id);
        return ResponseEntity.ok().build();

    }
}
