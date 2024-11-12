package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.aluno.DtoCreateAluno;
import com.AppNotifica_o.Notificacao.dtos.aluno.DtoListAluno;
import com.AppNotifica_o.Notificacao.dtos.aluno.DtoUpdateAluno;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import com.AppNotifica_o.Notificacao.service.AlunoService;
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
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateAluno data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        var aluno = this.alunoService.createAluno(data);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var aluno = this.alunoService.getAluno(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListAluno>> list(@PageableDefault Pageable pageable) {
        var page = this.alunoService.getAllAluno(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateAluno data) {
        var aluno = this.alunoService.updateAluno(data);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.alunoService.deactivate(id);
        return ResponseEntity.ok().build();
    }
}
