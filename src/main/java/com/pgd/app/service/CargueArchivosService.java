package com.pgd.app.service;

import com.opencsv.exceptions.CsvException;
import com.pgd.app.Exception.FormularioNotFoundException;
import com.pgd.app.Util.CSVUtil;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CargueArchivosService {

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaRepository preguntaRepository;

    public CargueArchivosService(FormularioFURAGRepository formularioFURAGRepository, PreguntaRepository preguntaRepository) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaRepository = preguntaRepository;
    }

    public void cargarArchivoPreguntaFormularioFURAG(Long formularioFURAGID, File archivo) {

        FormularioFURAG formularioFURAG = formularioFURAGRepository.findById(formularioFURAGID)
                .orElseThrow(() -> new FormularioNotFoundException("Formulario Furag no encontrado"));
        try {
            List<Pregunta> preguntasToAdd = new ArrayList<>();
            List<String[]> filas =  CSVUtil.readCsv(archivo);
            filas.forEach(string -> {
                /*if (preguntaRepository.existsById(string[0])) {

                }*/
                Pregunta pregunta = new Pregunta(
                        string[0],
                        string[1],
                        string[2]
                );
                pregunta.getFormulariosFURAG().add(formularioFURAG);
                preguntasToAdd.add(pregunta);
            });
            preguntaRepository.saveAll(preguntasToAdd);
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
