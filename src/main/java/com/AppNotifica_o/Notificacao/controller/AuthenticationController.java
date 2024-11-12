package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.user.UserAuthDto;
import com.AppNotifica_o.Notificacao.dtos.user.UserLoginResponseDto;
import com.AppNotifica_o.Notificacao.infra.security.TokenService;
import com.AppNotifica_o.Notificacao.models.User;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserAuthDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.genToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new UserLoginResponseDto(token));
    }
}
