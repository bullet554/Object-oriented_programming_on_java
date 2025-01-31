<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
        }
    }

    public List<Person> findPersonsByName(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getChildren(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            result.addAll(person.getChildren());
        }
        return result;
    }

    public List<Person> getSiblings(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            if (person.getMother() != null) {
                result.addAll(person.getMother().getChildren());
            }
            result.remove(person);
        }
        return result;
    }

    public List<Person> getAncestors(String name) {
        List<Person> ancestors = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            if (person.getMother() != null) {
                ancestors.add(person.getMother());
                ancestors.addAll(getAncestors(person.getMother().getName()));
            }
            if (person.getFather() != null) {
                ancestors.add(person.getFather());
                ancestors.addAll(getAncestors(person.getFather().getName()));
            }
        }
        return ancestors;
    }
=======
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
        }
    }

    public List<Person> findPersonsByName(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getChildren(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            result.addAll(person.getChildren());
        }
        return result;
    }

    public List<Person> getSiblings(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            if (person.getMother() != null) {
                result.addAll(person.getMother().getChildren());
            }
            result.remove(person);
        }
        return result;
    }

    public List<Person> getAncestors(String name) {
        List<Person> ancestors = new ArrayList<>();
        for (Person person : findPersonsByName(name)) {
            if (person.getMother() != null) {
                ancestors.add(person.getMother());
                ancestors.addAll(getAncestors(person.getMother().getName()));
            }
            if (person.getFather() != null) {
                ancestors.add(person.getFather());
                ancestors.addAll(getAncestors(person.getFather().getName()));
            }
        }
        return ancestors;
    }
>>>>>>> fcc0234 (a new push attempt)
}