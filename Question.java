package Quiz_Application;

public class Question {
    private String questionText;
    private String[] options;    // Array to store answer choices
    private int correctAnswerIndex;  // Index of the correct option in the array
    private String imagePath;    // Path to the meme image for this question

    // Constructor
    public Question(String questionText, String[] options, int correctAnswerIndex, String imagePath) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.imagePath = imagePath;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String getImagePath() {
        return imagePath;
    }
}

