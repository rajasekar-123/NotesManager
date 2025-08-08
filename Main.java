package NotesManager;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static final String FILE_PATH = ("C:\\Users\\rajas\\New folder\\Main\\file.text");

    public static void main(String[] args) throws IOException {
        System.out.println("\n Notes Manager");
        System.out.println("1.Add a notes");
        System.out.println("2.Read a notes");
        System.out.println("3.Delete a notes");
        System.out.println("4.Exist");
        while (true) {
            System.out.print("\nEnter choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    create();
                    break;
                }
                case 2: {
                    read();
                    break;
                }

                case 3: {
                    clear();
                    break;
                }
                case 4: {
                    return;
                }

                default: {
                    System.out.println("Enter a proper valid number");
                }
            }

        }


    }

    static void create() throws IOException {

        File f1 = new File(FILE_PATH);
        f1.createNewFile();
        System.out.println("Enter your Note :");
        String note = scan.next();
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(f1))) {
            ;
            fw.write(note);
            fw.newLine();
        }
        System.out.println("Notes added Successfully");
    }


    static void read() throws IOException {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No Notes Found");
            return;
        }
        try (BufferedReader fr = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void clear() throws IOException {
        File file = new File(FILE_PATH);
        if ((!file.exists())) {
            System.out.println("No Notes To Delete");
            return;
        } else {
            file.delete();
            System.out.println("Deleted Successfully");
        }
        //scan.close();
    }

}


