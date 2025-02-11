package service;

import java.util.List;

public interface INotebook {
    void addNote(INote note);

    List<INote> getNotesForDay(String date);

    List<INote> getNotesForWeek(String startDate);

    List<INote> getAllNotes();

    void saveToFile(String filePath);

    void loadFromFile(String filePath);
}