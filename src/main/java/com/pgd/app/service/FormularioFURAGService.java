package com.pgd.app.service;

import com.pgd.app.dto.FormularioFURAG.CreateFormularioFURAGDTO;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class FormularioFURAGService {

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaRepository preguntaRepository;

    public FormularioFURAGService(FormularioFURAGRepository formularioFURAGRepository, PreguntaRepository preguntaRepository) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaRepository = preguntaRepository;
    }

    public void guardarFormularioFURAG(CreateFormularioFURAGDTO formularioFURAGDTO) {

        FormularioFURAG formularioFURAG = new FormularioFURAG(formularioFURAGDTO.vigencia());
        formularioFURAGDTO.preguntas().forEach(
                preguntaDTO -> {
                    preguntaRepository.findById(preguntaDTO.id()).ifPresentOrElse(
                            pregunta -> {
                                pregunta.setEnunciado(preguntaDTO.enunciado());
                                pregunta.setElemento(preguntaDTO.elemento());
                                pregunta.getFormulariosFURAG().add(formularioFURAG);
                                formularioFURAG.getPreguntas().add(pregunta);
                            },
                            () -> {
                                Pregunta pregunta = new Pregunta(
                                        preguntaDTO.id(),
                                        preguntaDTO.enunciado(),
                                        preguntaDTO.elemento());
                                pregunta.getFormulariosFURAG().add(formularioFURAG);
                                formularioFURAG.getPreguntas().add(pregunta);
                            }
                    );
                }
        );
        formularioFURAGRepository.save(formularioFURAG);
    }

    public File generarArchivoFurag() {
        String filePath = "example.txt";

        // Create a File object
        File file = new File(filePath);

        try {
            // Create the file if it doesn't exist
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

            // Write some content to the file (optional)
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, World!");
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }

        return file;
    }

    public File copyExcelFile(String sourceFilePath, String destinationFilePath) throws IOException {

        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Create FileInputStream for source Excel file
        FileInputStream fis = new FileInputStream(new File(sourceFilePath));

        // Read source Excel file into a Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(2);

        Row row = sheet.getRow(11);

        Cell cell = row.getCell(6);

        String test = cell.getStringCellValue();

        workbook.close();
        fis.close();

        return destinationFile;
    }
}
