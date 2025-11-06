package com.labfisica.io;

import com.labfisica.xydata.XYData;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

public class CsvXYReader {
    public static XYData read(Path filePath) throws Exception {
        List<String> lines = Files.readAllLines(filePath);
        
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Archivo vacío");
        }
        
        // Leer encabezados
        String header = lines.get(0);
        String[] headers = header.split(",");
        String xName = headers[0].trim();
        String yName = headers[1].trim();
        
        // Leer datos
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (!line.isEmpty()) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    xValues.add(Double.parseDouble(values[0].trim()));
                    yValues.add(Double.parseDouble(values[1].trim()));
                }
            }
        }
        
        // Convertir a arrays
        double[] xArray = xValues.stream().mapToDouble(Double::doubleValue).toArray();
        double[] yArray = yValues.stream().mapToDouble(Double::doubleValue).toArray();
        
        return new XYData(xArray, yArray, xName, yName);
    }
}