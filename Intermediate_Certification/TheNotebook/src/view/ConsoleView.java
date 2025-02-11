package view;

import service.INote;
import service.NotebookView;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements NotebookView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayNotes(List<INote> notes) {
        if (notes.isEmpty()) {
            System.out.println("Нет записей.");
        } else {
            for (INote note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}