package main;

import model.Notebook;
import presenter.NotebookPresenter;
import service.INotebook;
import service.NotebookView;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        INotebook notebook = new Notebook();
        NotebookView view = new ConsoleView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);

        while (true) {
            view.displayMessage("\n1. Добавить запись\n2. Просмотреть записи по дате\n3. Просмотреть записи по неделе\n4. Сохранить записи\n5. Загрузить записи\n6. Выход");
            String choice = view.getUserInput("Выберите действие");
            switch (choice) {
                case "1":
                    presenter.addNote();
                    break;
                case "2":
                    presenter.viewNotesByDate();
                    break;
                case "3":
                    presenter.viewNotesByWeek();
                    break;
                case "4":
                    presenter.saveNotes();
                    break;
                case "5":
                    presenter.loadNotes();
                    break;
                case "6":
                    return;
                default:
                    view.displayMessage("Неверный выбор.");
            }
        }
    }
}