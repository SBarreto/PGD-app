package com.pgd.app.service;

import com.pgd.app.exception.EntidadNotFoundException;
import com.pgd.app.exception.FormularioNotFoundException;
import com.pgd.app.dto.puntaje.GetPuntajesEntidadDTO;
import com.pgd.app.dto.puntaje.PuntajeEntidadDTO;
import com.pgd.app.model.Entidad;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Puntaje;
import com.pgd.app.model.Respuesta;
import com.pgd.app.repository.EntidadRepository;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PuntajeRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PuntajeService {

    private final PuntajeRepository puntajeRepository;
    private final EntidadRepository entidadRepository;
    private final FormularioFURAGRepository formularioFURAGRepository;

    public PuntajeService(PuntajeRepository puntajeRepository, EntidadRepository entidadRepository, FormularioFURAGRepository formularioFURAGRepository) {
        this.puntajeRepository = puntajeRepository;
        this.entidadRepository = entidadRepository;
        this.formularioFURAGRepository = formularioFURAGRepository;
    }

    public GetPuntajesEntidadDTO getPuntajesEntidad(int codigosigep) {
        Entidad entidad = entidadRepository.findById(codigosigep)
                .orElseThrow(() -> new EntidadNotFoundException("Codigo de entidad no encontrado"));
        List<Puntaje> puntajes = puntajeRepository.findAllByEntidad_Codigosigep(codigosigep);
        List<PuntajeEntidadDTO> puntajesEntidadDTO = puntajes.stream().map(
                puntaje -> new PuntajeEntidadDTO(
                        puntaje.getValor(),
                        puntaje.getCategoria(),
                        puntaje.getVigencia()
                )
        ).toList();
        return new GetPuntajesEntidadDTO(
                entidad.getNombre(),
                entidad.getCodigosigep(),
                puntajesEntidadDTO);
    }

    public void calcularPuntajes(Long formularioFURAGID) {
        //Tomar las respuestas guardadas de un formulario
        //Tomar el "elemento" que es lo mismo que la categoria de las preguntas respondidas
            //para esto, dividir todas las respuestas del formulario en subgrupos por categoria
        //tomar todos los puntajes individuales de cada respuestaGE y promediarlas en cada categoria
        //guarcar en la tabla puntaje con los datos pertinentes


        FormularioFURAG formularioFURAG = formularioFURAGRepository.findById(formularioFURAGID)
                .orElseThrow(() -> new FormularioNotFoundException("Id de formulario no encontrado"));

        Map<String, Set<Respuesta>> gruposCategorias = new HashMap<>();
        formularioFURAG.getRespuestas().forEach(
                respuesta -> gruposCategorias.computeIfAbsent(
                        respuesta.getPregunta().getElemento(),
                        e -> new HashSet<>()).add(respuesta)
        );
        gruposCategorias.keySet().forEach(
                s -> {
                    AtomicInteger sumaPuntajes = new AtomicInteger();
                    AtomicInteger cantidadPuntajes = new AtomicInteger();
                    gruposCategorias.get(s).forEach(
                            respuesta -> {
                                if (respuesta.getPuntaje() != 0) {
                                    sumaPuntajes.set(sumaPuntajes.get() + respuesta.getPuntaje());
                                    cantidadPuntajes.getAndIncrement();
                                }
                            }
                    );
                    Puntaje puntaje = new Puntaje();
                    puntaje.setCategoria(s);
                    puntaje.setValor(Math.round((float) sumaPuntajes.get() / cantidadPuntajes.get()));
                    puntaje.setEntidad(formularioFURAG.getEntidad());
                    puntaje.setVigencia(formularioFURAG.getVigencia());
                    puntajeRepository.save(puntaje);
                }
        );
    }
}
