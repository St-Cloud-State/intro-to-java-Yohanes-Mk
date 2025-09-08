import java.io.*;       
import java.util.*;     

public class MyMain {
    public static void main(String[] args) throws Exception {
        // make a LinkedList of Person
        LinkedList<Person> people = new LinkedList<>();

        // read data from persons.txt
        FileInputStream fis = new FileInputStream("persons.txt");
        store(fis, people);

        // display all people in the list
        display(System.out, people);

        // test the find method
        int index1 = find("Et02", people);
        System.out.println("Et02 found at index: " + index1);

        int index2 = find("Et05", people); // doesn’t exist
        System.out.println("Et05 found at index: " + index2);
    }

    // read from input file into list
    static void store(InputStream in, LinkedList<Person> list) throws IOException {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String fn = sc.next();
            String ln = sc.next();
            String id = sc.next();
            list.add(new Person(fn, ln, id));
        }
        sc.close();
    }

    // print each person
    static void display(PrintStream out, LinkedList<Person> list) {
        for (Person p : list) {
            out.println(p);  // calls Person.toString()
        }
    }

    // find person by id, return index or -1
    static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}

