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
            System.out.println("3. Remove by National Code");
            System.out.println("4. Edit by National Code");
            System.out.println("5. Exit ");
            System.out.print("> ");

            String choice = scanner.nextLine();
            int digit = 0;
            int sum = 0;
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter National Code: ");
                    String code = scanner.nextLine();
                    if (code.chars().distinct().count() == 1 || code.length() != 10) {
                        System.out.println("Invalid National Code.");
                    } else {
                        for (int i = 0; i < 9; i++) {
                            digit = Character.getNumericValue(code.charAt(i));
                            sum += digit * (10 - i);
                        }
                        int remainder = sum % 11;
                        int controlDigit = Character.getNumericValue(code.charAt(9));
                        ;
                        if ((remainder < 2 && controlDigit == remainder) || (remainder >= 2 && controlDigit == (11 - remainder))) {
                            studentMap.put(code, name);
                            System.out.println("Student added successfully!");
                        } else {
                            System.out.println("Invalid National Code.");
                        }
                    }

                }
                case "2" -> {
                    System.out.print("Enter National Code to search: ");
                    String searchCode = scanner.nextLine();
                    String result = studentMap.getOrDefault(searchCode, "Student not found.");
                    System.out.println("Result: " + result);
                }
                case "3" -> {
                    System.out.print("Enter National Code to search: ");
                    String searchCode = scanner.nextLine();
                    String result = studentMap.getOrDefault(searchCode, "null");
                    if (result != "null") {
                        System.out.printf("Do you wanna remove student \" %s \" ?(y/n)", result);
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                            studentMap.remove(searchCode);
                            System.out.printf("Result: student %s removed successful. ", result);
                        }
                    } else
                        System.out.println("Result: Student not found.");
                }
                case "4" -> {
                    System.out.print("Enter National Code to search: ");
                    String searchCode = scanner.nextLine();
                    String result = studentMap.getOrDefault(searchCode, "null");
                    if (result != "null") {
                        System.out.printf(" you are Editing student \" %s \" . \n", result);
                        System.out.print("Enter your new name: ");
                        String newName = scanner.nextLine();
                        studentMap.replace(searchCode,newName);
                        System.out.printf("Result:  Edit successful.");
                    } else
                        System.out.println("Result: Student not found.");
                }
                case "5" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
