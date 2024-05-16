package com.pgd.app.dto.usuario;

import com.pgd.app.enums.TipoUsuario;

public record RetornarUsuarioDTO(
        String username,
        TipoUsuario tipoUsuario,
        int codigoentidad
) {
}
