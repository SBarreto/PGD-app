package com.pgd.app.service;

import com.pgd.app.exception.ContrasenaIncorrectaException;
import com.pgd.app.exception.EntidadNotFoundException;
import com.pgd.app.exception.UsuarioNoEncontradoException;
import com.pgd.app.exception.UsuarioYaExisteException;
import com.pgd.app.dto.usuario.CrearUsuarioDTO;
import com.pgd.app.dto.usuario.LoginDTO;
import com.pgd.app.model.Usuario;
import com.pgd.app.repository.EntidadRepository;
import com.pgd.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EntidadRepository entidadRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, EntidadRepository entidadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.entidadRepository = entidadRepository;
    }

    public void crearUsuario(CrearUsuarioDTO crearUsuarioDTO) {

        if (!entidadRepository.existsById(crearUsuarioDTO.codigoentidad()))
            throw new EntidadNotFoundException("Codigo de Entidad no encontrado");
        if (usuarioRepository.existsByUsername(crearUsuarioDTO.username()))
            throw new UsuarioYaExisteException("Usuario ya existe");

        Usuario usuario = new Usuario();
        usuario.setUsername(crearUsuarioDTO.username());
        usuario.setPassword(crearUsuarioDTO.password());
        usuario.setTipo(crearUsuarioDTO.tipoUsuario());
        usuario.setEntidad(entidadRepository.getReferenceById(crearUsuarioDTO.codigoentidad()));
        usuarioRepository.save(usuario);
    }

    public void login(LoginDTO loginDTO) {

        if (!usuarioRepository.existsByUsername(loginDTO.username()))
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        if (!usuarioRepository.findByUsername(loginDTO.username()).getPassword().equals(loginDTO.password()))
            throw new ContrasenaIncorrectaException("Contrasena Incorrecta");
    }
}
