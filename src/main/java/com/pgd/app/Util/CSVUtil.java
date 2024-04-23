package com.pgd.app.Util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVUtil {

    public static List<String[]> readCsv(File file) throws IOException, CsvException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(file))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()
        ) {
            return reader.readAll();
        }
    }
}
