package model;

import service.INote;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileManager {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void saveToFile(String filePath, List<INote> notes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (INote note : notes) {
                writer.write(note.getDateTime().format(formatter) + ";\n" + note.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<INote> loadFromFile(String filePath) {
        List<INote> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";\n");
                if (parts.length == 2) {
                    LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                    notes.add(new Note(dateTime, parts[1]));
                }
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
        return notes;
    }
}