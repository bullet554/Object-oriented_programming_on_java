<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", 1980);
        Person mary = new Person("Mary", 1982);
        Person alice = new Person("Alice", 2005);
        Person bob = new Person("Bob", 2008);

        alice.setMother(mary);
        alice.setFather(john);
        bob.setMother(mary);
        bob.setFather(john);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(alice);
        familyTree.addPerson(bob);

        System.out.println("Дети Mary:");
        for (Person child : familyTree.getChildren("Mary")) {
            System.out.println(child.getName());
        }

        System.out.println("\nБратья и сестры Alice:");
        for (Person sibling : familyTree.getSiblings("Alice")) {
            System.out.println(sibling.getName());
        }

        System.out.println("\nПредки Bob:");
        for (Person ancestor : familyTree.getAncestors("Bob")) {
            System.out.println(ancestor.getName());
        }
    }
=======
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", 1980);
        Person mary = new Person("Mary", 1982);
        Person alice = new Person("Alice", 2005);
        Person bob = new Person("Bob", 2008);

        alice.setMother(mary);
        alice.setFather(john);
        bob.setMother(mary);
        bob.setFather(john);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(alice);
        familyTree.addPerson(bob);

        System.out.println("Дети Mary:");
        for (Person child : familyTree.getChildren("Mary")) {
            System.out.println(child.getName());
        }

        System.out.println("\nБратья и сестры Alice:");
        for (Person sibling : familyTree.getSiblings("Alice")) {
            System.out.println(sibling.getName());
        }

        System.out.println("\nПредки Bob:");
        for (Person ancestor : familyTree.getAncestors("Bob")) {
            System.out.println(ancestor.getName());
        }
    }
>>>>>>> fcc0234 (a new push attempt)
}