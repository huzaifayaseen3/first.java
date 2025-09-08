package Quiz_Application;
import java.util.List;

public class Quiz {
    private List<Question> questions;    // List of questions
    private int currentQuestionIndex;    // Tracks which question user is on
    private int score;                   // Number of correct answers

    // Constructor to initialize the quiz with questions
    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    // Get current question
    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null; // No more questions
    }

    // Check user's answer (index of chosen option)
    public boolean checkAnswer(int userAnswerIndex) {
        Question current = getCurrentQuestion();
        if (current != null && userAnswerIndex == current.getCorrectAnswerIndex()) {
            score++;
            return true;
        }
        return false;
    }

    // Move to next question
    public void nextQuestion() {
        currentQuestionIndex++;
    }

    // Check if quiz is finished
    public boolean isFinished() {
        return currentQuestionIndex >= questions.size();
    }

    // Get user's score
    public int getScore() {
        return score;
    }

    // Get total number of questions
    public int getTotalQuestions() {
        return questions.size();
    }

    public void reset() {
    }
}

