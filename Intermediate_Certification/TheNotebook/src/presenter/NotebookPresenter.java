package presenter;

import model.Note;
import service.INotebook;
import service.NotebookView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotebookPresenter {
    private final INotebook notebook;
    private final NotebookView view;

    public NotebookPresenter(INotebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void addNote() {
        try {
            String dateTimeInput = view.getUserInput("Введите дату и время (yyyy-MM-dd HH:mm)");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String description = view.getUserInput("Введите описание");
            notebook.addNote(new Note(dateTime, description));
            view.displayMessage("Запись добавлена.");
        } catch (Exception e) {
            view.displayMessage("Ошибка ввода. Проверьте формат даты и времени.");
        }
    }

    public void viewNotesByDate() {
        String date = view.getUserInput("Введите дату (yyyy-MM-dd)");
        view.displayNotes(notebook.getNotesForDay(date));
    }

    public void viewNotesByWeek() {
        String startDate = view.getUserInput("Введите начальную дату недели (yyyy-MM-dd)");
        view.displayNotes(notebook.getNotesForWeek(startDate));
    }

    public void saveNotes() {
        String filePath = view.getUserInput("Введите путь для сохранения файла");
        notebook.saveToFile(filePath);
        view.displayMessage("Записи сохранены.");
    }

    public void loadNotes() {
        String filePath = view.getUserInput("Введите путь для загрузки файла");
        notebook.loadFromFile(filePath);
        view.displayMessage("Записи загружены.");
    }
}