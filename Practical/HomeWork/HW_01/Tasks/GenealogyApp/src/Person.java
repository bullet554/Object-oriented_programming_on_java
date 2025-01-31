<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        if (this.mother != mother) {
            this.mother = mother;
            if (mother != null && !mother.getChildren().contains(this)) {
                mother.addChild(this);
            }
        }
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        if (this.father != father) {
            this.father = father;
            if (father != null && !father.getChildren().contains(this)) {
                father.addChild(this);
            }
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            if (this == child.getMother()) {
                child.setMother(this);
            } else if (this == child.getFather()) {
                child.setFather(this);
            }
        }
    }
=======
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        if (this.mother != mother) {
            this.mother = mother;
            if (mother != null && !mother.getChildren().contains(this)) {
                mother.addChild(this);
            }
        }
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        if (this.father != father) {
            this.father = father;
            if (father != null && !father.getChildren().contains(this)) {
                father.addChild(this);
            }
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            if (this == child.getMother()) {
                child.setMother(this);
            } else if (this == child.getFather()) {
                child.setFather(this);
            }
        }
    }
>>>>>>> fcc0234 (a new push attempt)
}