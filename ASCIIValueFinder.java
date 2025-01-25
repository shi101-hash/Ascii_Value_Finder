import java.util.ArrayList;
import java.util.Scanner;

public class ASCIIValueFinder {

    static class Record {
        char character;
        int asciiValue;

        Record(char character, int asciiValue) {
            this.character = character;
            this.asciiValue = asciiValue;
        }

        @Override
        public String toString() {
            return "Character: '" + character + "', ASCII Value: " + asciiValue;
        }
    }

    public static void main(String[] args) {

        ArrayList<Record> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nASCII Value Finder System");
            System.out.println("1. Enter a character");
            System.out.println("2. View stored records");
            System.out.println("3. Clear all records");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter a character: ");
                    String input = scanner.nextLine();
                    if (input.length() != 1) {
                        System.out.println("Error: Please enter a single character.");
                    } else {
                        char character = input.charAt(0);
                        int asciiValue = (int) character;
                        System.out.println("The ASCII value of '" + character + "' is: " + asciiValue);

                        // Store in memory
                        records.add(new Record(character, asciiValue));
                    }
                    break;

                case 2:
                    if (records.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("Stored Records:");
                        for (Record record : records) {
                            System.out.println(record);
                        }
                    }
                    break;

                case 3: // Clear all records
                    records.clear();
                    System.out.println("All records have been cleared.");
                    break;

                case 4: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
