package Main;

import Model.FamilyTree;
import Model.Person;
import Service.FileOperations;
import Service.FileOperationImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
// Создаем людей
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);

// Устанавливаем родительские связи
        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);

// Добавляем людей в древо
        familyTree.addMember(john);
        familyTree.addMember(mary);
        familyTree.addMember(susan);

// Сортируем по имени
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthYear());
        }

// Сортируем по дате рождения
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthYear());
        }

// Создаем объект для работы с файлами
        FileOperations<Person> fileOps = new FileOperationImpl<>();

// Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree,
                    "familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

// Загружаем генеалогическое древо из файла
        FamilyTree<Person> loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

// Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getMembers()) {
                System.out.println("Loaded person: " + person.getName() + ", born in " + person.getBirthYear());
            }
        }
    }
}