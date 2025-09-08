import java.io.*;     
import java.util.*;

public class PersonList {
    private LinkedList<Person> list;

    // constructor 
    public PersonList() {
        list = new LinkedList<>();
    }

    // read people from an input stream into this list
    public void store(InputStream in) throws IOException {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String fn = sc.next();
            String ln = sc.next();
            String id = sc.next();
            list.add(new Person(fn, ln, id));
        }
        sc.close();
    }

    // print all people to the given output stream
    public void display(PrintStream out) {
        for (Person p : list) {
            out.println(p);  // calls Person.toString()
        }
    }

    // find a person by id; return index or -1 if not found
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
