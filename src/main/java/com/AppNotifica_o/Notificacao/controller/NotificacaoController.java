package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoListNotificacao;
import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.AppNotifica_o.Notificacao.service.NotificacaoService;
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
@RequestMapping("/notificacao")
public class NotificacaoController {
    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateNotificacao data) {
        var notificacao = this.notificacaoService.createNotificacao(data);
        return ResponseEntity.ok(notificacao);
    }

    @GetMapping("/{notificacaoId}/{remetenteId}")
    public ResponseEntity detail(@PathVariable UUID notificacaoId, @PathVariable UUID remetenteId) {
        var notificacao = this.notificacaoService.getNotificacao(notificacaoId,remetenteId);
        return ResponseEntity.ok(notificacao);
    }

    @GetMapping("/{remetenteId}")
    public ResponseEntity<Page<DtoListNotificacao>> list(@PathVariable UUID remetenteId, @PageableDefault Pageable pageable) {
        var page = this.notificacaoService.getAllNotificacao(remetenteId,pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateNotificacao data) {
        var notificacao =  this.notificacaoService.updateNotificacao(data);
        return ResponseEntity.ok(notificacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.notificacaoService.cancelaEnvio(id);
        return ResponseEntity.ok().build();
    }
}
