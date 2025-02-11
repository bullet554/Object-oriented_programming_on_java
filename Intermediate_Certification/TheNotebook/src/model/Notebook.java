package model;

import service.INote;
import service.INotebook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Notebook implements INotebook {
    private final List<INote> notes = new ArrayList<>();

    @Override
    public void addNote(INote note) {
        notes.add(note);
        notes.sort(Comparator.comparing(INote::getDateTime)); // Сортировка по дате и времени
    }

    @Override
    public List<INote> getNotesForDay(String date) {
        LocalDate targetDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().equals(targetDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<INote> getNotesForWeek(String startDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = start.plusDays(6);
        return notes.stream()
                .filter(note -> !note.getDateTime().toLocalDate().isBefore(start) &&
                        !note.getDateTime().toLocalDate().isAfter(end))
                .collect(Collectors.toList());
    }

    @Override
    public List<INote> getAllNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public void saveToFile(String filePath) {
        FileManager.saveToFile(filePath, notes);
    }

    @Override
    public void loadFromFile(String filePath) {
        notes.clear();
        notes.addAll(FileManager.loadFromFile(filePath));
        notes.sort(Comparator.comparing(INote::getDateTime)); // Сортировка после загрузки
    }
}