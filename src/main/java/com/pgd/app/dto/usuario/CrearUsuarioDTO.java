package com.pgd.app.dto.usuario;

import com.pgd.app.enums.TipoUsuario;

public record CrearUsuarioDTO(
        String username,
        String password,
        TipoUsuario tipoUsuario,
        int codigoentidad
) {
}
