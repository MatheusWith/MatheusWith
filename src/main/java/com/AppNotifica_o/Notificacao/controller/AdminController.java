package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.admin.DtoCreateAdmin;
import com.AppNotifica_o.Notificacao.dtos.admin.DtoListAdmin;
import com.AppNotifica_o.Notificacao.dtos.admin.DtoUpdateAdmin;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import com.AppNotifica_o.Notificacao.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateAdmin data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        var admin = this.adminService.crateAdmin(data);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var admin = this.adminService.getAdmin(id);
        return ResponseEntity.ok(admin);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListAdmin>> list(@PageableDefault Pageable pageable) {
        var page = this.adminService.getAllAdmin(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateAdmin data) {
        var admin = this.adminService.updateAdmin(data);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.adminService.delete(id);
        return ResponseEntity.ok().build();
    }
}
