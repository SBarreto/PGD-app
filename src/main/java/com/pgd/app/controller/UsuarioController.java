package com.pgd.app.controller;

import com.pgd.app.dto.usuario.CrearUsuarioDTO;
import com.pgd.app.dto.usuario.LoginDTO;
import com.pgd.app.dto.usuario.RetornarUsuarioDTO;
import com.pgd.app.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Crear usuario en sistema")
    @PostMapping("/api/usuario")
    public ResponseEntity<String> crearUsuario(@RequestBody CrearUsuarioDTO crearUsuarioDTO) {

        usuarioService.crearUsuario(crearUsuarioDTO);
        return ResponseEntity.ok("Usuario creado correctamente");
    }

    @Operation(summary = "Hacer login con un usuario existente")
    @PostMapping("/api/usuario/login")
    public ResponseEntity<RetornarUsuarioDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(usuarioService.login(loginDTO));
    }
}
