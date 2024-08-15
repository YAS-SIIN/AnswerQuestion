package test;
import models.QuestionAnswer;
import services.MainService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainServiceTest {
    private MainService mainService;

    @Before
    public void setUp() {
        mainService = new MainService();
    }

    @Test
    public void testAddQuestion_Successful() {
        String input = "What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"";
        mainService.addQuestion(input);

        QuestionAnswer qa = getQuestionAnswer("What is Peters favorite food?");
        assertNotNull("Question should be stored", qa);
        assertEquals(3, qa.getAnswers().size());
        assertTrue(qa.getAnswers().contains("Pizza"));
        assertTrue(qa.getAnswers().contains("Spaghetti"));
        assertTrue(qa.getAnswers().contains("Ice cream"));
    }

    @Test
    public void testAddQuestion_InvalidFormat() {
        String input = "Invalid question format";
        mainService.addQuestion(input);

        QuestionAnswer qa = getQuestionAnswer("Invalid question format");
        assertNull("Invalid question should not be stored", qa);
    }

    @Test
    public void testGetQuestion_ExistingQuestion() {
        String input = "What is Peters favorite food? \"Pizza\" \"Spaghetti\"";
        mainService.addQuestion(input);

        String question = "What is Peters favorite food?";
        QuestionAnswer qa = getQuestionAnswer(question);
        assertNotNull("Question should exist", qa);
        assertEquals(2, qa.getAnswers().size());
    }

    @Test
    public void testGetQuestion_NonExistingQuestion() {
        String question = "What is Peters favorite book?";
        QuestionAnswer qa = getQuestionAnswer(question);
        assertNull("Question should not exist", qa);
    }

    // Utility method to get a QuestionAnswer object for testing
    private QuestionAnswer getQuestionAnswer(String question) {
        for (QuestionAnswer qa : mainService.questionAnswers) {
            if (qa.getQuestion().equals(question)) {
                return qa;
            }
        }
        return null;
    }

}
