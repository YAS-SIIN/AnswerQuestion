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

        if (rawAnswers.length == 0) {
            System.out.println("Every question must have at least one answer.");
            return;
        }

        List<String> answers = new ArrayList<>();
        for (String answer : rawAnswers) {
            if (!answer.trim().isEmpty()) {
                answers.add(answer.trim());
            }
        }

        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestion(question);

        for (QuestionAnswer existing : questionAnswers) {
            if (existing.getQuestion().equals(question)) {
                questionAnswer = existing;
                break;
            }
        }

        for (String answer : answers) {
            if (!answer.isEmpty() && answer.length() <= 255) {
                questionAnswer.getAnswers().add(answer);
            } else if (answer.length() > 255) {
                System.out.println("An answer exceeds the maximum allowed length of 255 characters.");
            }
        }

        questionAnswers.add(questionAnswer);

        System.out.println("Question added successfully!");
    }

}
