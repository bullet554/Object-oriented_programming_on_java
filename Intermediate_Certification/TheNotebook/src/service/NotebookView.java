package service;

import java.util.List;

public interface NotebookView {
    void displayMessage(String message);
    void displayNotes(List<INote> notes);
    String getUserInput(String prompt);
}
