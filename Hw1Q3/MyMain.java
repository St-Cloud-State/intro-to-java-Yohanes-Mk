import java.io.*;

public class MyMain {
    public static void main(String[] args) throws Exception {
        PersonList people = new PersonList();

        // read persons.txt into the list
        FileInputStream fis = new FileInputStream("persons.txt");
        people.store(fis);

        // display all persons
        people.display(System.out);

        // test the find method
        int index1 = people.find("Et02");
        System.out.println("Et02 found at index: " + index1);

        int index2 = people.find("Et05");
        System.out.println("Et05 found at index: " + index2);
    }
}
