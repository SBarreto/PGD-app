package com.pgd.app.dto.entidad;

public record EntidadDTO(
        int codigoSigep,
        String nombre,
        String naturalezaJuridica,
        String orden,
        String sector,
        String codigoMunicipio,
        int codigoDepartamento
) {
}
