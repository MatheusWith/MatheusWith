package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.admin.DtoCreateAdmin;
import com.AppNotifica_o.Notificacao.dtos.admin.DtoDetailAdmin;
import com.AppNotifica_o.Notificacao.dtos.admin.DtoListAdmin;
import com.AppNotifica_o.Notificacao.dtos.admin.DtoUpdateAdmin;
import com.AppNotifica_o.Notificacao.models.Admin;
import com.AppNotifica_o.Notificacao.repository.AdminRepository;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    public DtoDetailAdmin crateAdmin(DtoCreateAdmin data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Admin admin = new Admin(data.login(),encryptedPassword,data.name(), data.email());
        this.adminRepository.save(admin);
        return new DtoDetailAdmin(admin);
    }

    public DtoDetailAdmin updateAdmin(DtoUpdateAdmin data) {
        var admin = this.adminRepository.getReferenceById(data.id());
        if (data.login() != null) {
            if (this.userRepository.findByLogin(data.login()) == null) {
                admin.setLogin(data.login());
            }
        }
        if (data.name() != null) {
            admin.setName(data.name());
        }
        if (data.password() != null) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            admin.setPassword(encryptedPassword);
        }
        if (data.email() != null) {
            admin.setEmail(data.email());
        }
        if (data.active() != null) {
            admin.setActive(data.active());
        }
        this.adminRepository.save(admin);
        return new DtoDetailAdmin(admin);
    }

    public DtoDetailAdmin getAdmin(UUID id) {
        var admin = this.adminRepository.getReferenceById(id);
        return new DtoDetailAdmin(admin);
    }

    public Page<DtoListAdmin> getAllAdmin(Pageable pageable) {
        return this.adminRepository.findAll(pageable).map(DtoListAdmin::new);
    }

    public void delete(UUID id) {
        var admin = this.adminRepository.getReferenceById(id);
        admin.deactivate();
        this.adminRepository.save(admin);
    }
}
