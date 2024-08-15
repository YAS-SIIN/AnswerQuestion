package models;
import java.util.*;

public class QuestionAnswer {
    private String question;
    private List<String> answers;

    public QuestionAnswer() {
        answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
