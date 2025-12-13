import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Map<String, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Management System (JDK 25) ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Search by National Code");
            System.out.println("3. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter National Code: ");
                    String code = scanner.nextLine();
                    studentMap.put(code, name);
                    System.out.println("Student added successfully!");
                }
                case "2" -> {
                    System.out.print("Enter National Code to search: ");
                    String searchCode = scanner.nextLine();
                    String result = studentMap.getOrDefault(searchCode, "Student not found.");
                    System.out.println("Result: " + result);
                }
                case "3" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
