package services;
import models.QuestionAnswer;

import java.util.*;
public class MainService {

    public List<QuestionAnswer> questionAnswers;

    public MainService()
    {
        questionAnswers = new ArrayList<>();
    }

    /**
     * Add new question to the list of questions
     * @param input the input string containing question and answers
     */
    public void addQuestion(String input) {
        // Ensure the input is valid and split by '?'
        String[] parts = input.split("\\?", 2);
        if (parts.length != 2) {
            System.out.println("Invalid input format. Use the format: <question>? \"<answer1>\" \"<answer2>\" ...");
            return;
        }

        String question = parts[0].trim() + "?";
        if (question.length() > 255) {
            System.out.println("Question exceeds the maximum allowed length of 255 characters.");
            return;
        }

        String[] rawAnswers = parts[1].split("\"");

        if (rawAnswers.length == 0 || parts[1].isEmpty()) {
            System.out.println("Every question must have at least one answer.");
            return;
        }

        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestion(question);

        questionAnswer = questionAnswers.stream()
                .filter(qa -> qa.getQuestion().equals(question))
                .findFirst()
                .orElse(questionAnswer);

// Optional: Handle case where no match is found


        for (String answer : rawAnswers) {
            if (!answer.trim().isEmpty() && answer.length() <= 255) {
                questionAnswer.getAnswers().add(answer);
            } else if (answer.length() > 255) {
                System.out.println("An answer exceeds the maximum allowed length of 255 characters.");
            }
        }

        questionAnswers.add(questionAnswer);

        System.out.println("Question added successfully!");
    }


    /**
     * Get question with answer
     * @param question the question string
     */
    public void getQuestion(String question) {
        if (question.length() > 255) {
            System.out.println("Question exceeds the maximum allowed length of 255 characters.");
            return;
        }

        QuestionAnswer userQuestion = questionAnswers.stream()
                .filter(qa -> qa.getQuestion().equals(question))
                .findFirst()
                .orElse(null);

        if (userQuestion != null) {
            for (String answer : userQuestion.getAnswers()) {
                System.out.println("\n * " + answer);
            }
        } else {
            System.out.println("The answer to life, universe and everything is 42");
        }
    }
}
