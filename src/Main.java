//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import services.MainService;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.printf("Hello and welcome!");

            MainService mainService = new MainService();
            while (true) {
                    System.out.println("\n");
                    System.out.println("Choose an option: \n1. Ask a question\n2. Add a question");
                    Scanner scanner = new Scanner(System.in);

                    String choice = scanner.nextLine().trim();
                    if (choice.equals("1")) {
                        System.out.println("Enter your question:");
                        String question = scanner.nextLine().trim();
                        mainService.getQuestion(question);
                    } else if (choice.equals("2")) {
                        System.out.println("Enter your question and answers (e.g., What is Peters favorite food? \"Pizza\" \"Spaghetti\"):");
                        String questionAnswer = scanner.nextLine().trim();
                        mainService.addQuestion(questionAnswer);
                    } else {
                        System.out.println("Invalid option. Please select 1 or 2.");
                    }
            }
        }
        catch(Exception e) {
            System.out.println("An error occurred.");
        }

    }
}