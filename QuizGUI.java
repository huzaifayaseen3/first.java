package Quiz_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class QuizGUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JPanel loginPanel, rulesPanel, quizPanel, scorePanel;

    private JTextField nameField;
    private JButton loginButton;

    private JTextArea rulesArea;
    private JButton backToLoginButton, startQuizButton;

    private JLabel questionLabel;
    private JLabel imageLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    private JLabel scoreLabel;
    private JButton playAgainButton;

    private User currentUser;
    private Quiz quiz;

    public QuizGUI() {
        setTitle("Meme Quiz");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createLoginPanel();
        createRulesPanel();
        createQuizPanel();
        createScorePanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(rulesPanel, "Rules");
        mainPanel.add(quizPanel, "Quiz");
        mainPanel.add(scorePanel, "Score");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel welcomeLabel = new JLabel("👋 Welcome to the Meme Quiz!");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel namePrompt = new JLabel("Enter your name to begin:");
        namePrompt.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameField = new JTextField(20);
        nameField.setMaximumSize(new Dimension(300, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton = new JButton("Start");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name.");
            } else {
                currentUser = new User(name);
                showRulesPanel();
            }
        });

        loginPanel.add(welcomeLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        loginPanel.add(namePrompt);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(nameField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        loginPanel.add(loginButton);
    }

    private void createRulesPanel() {
        rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout(10, 10));
        rulesPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        rulesArea = new JTextArea();
        rulesArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        rulesArea.setEditable(false);
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);
        rulesArea.setText("📋 Quiz Rules:\n\n"
                + "1. Each question includes a meme image.\n"
                + "2. Select the most appropriate answer.\n"
                + "3. Each correct answer earns 1 point.\n"
                + "4. Click Start when you're ready!\n"
                + "5. Enjoy and have fun!");

        backToLoginButton = new JButton("Back");
        startQuizButton = new JButton("Start Quiz");

        backToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        startQuizButton.addActionListener(e -> startQuiz());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backToLoginButton);
        buttonPanel.add(startQuizButton);

        rulesPanel.add(new JScrollPane(rulesArea), BorderLayout.CENTER);
        rulesPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createQuizPanel() {
        quizPanel = new JPanel();
        quizPanel.setLayout(new BorderLayout(10, 10));
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        questionLabel = new JLabel("Question");
        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(400, 250));

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton("Option " + (i + 1));
            optionButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> handleNextButton());

        quizPanel.add(questionLabel, BorderLayout.NORTH);
        quizPanel.add(imageLabel, BorderLayout.CENTER);
        quizPanel.add(optionsPanel, BorderLayout.SOUTH);
        quizPanel.add(nextButton, BorderLayout.EAST);
    }

    private void createScorePanel() {
        scorePanel = new JPanel(new BorderLayout());
        scorePanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel centerPanel = new JPanel(new GridBagLayout()); // Center contents
        scoreLabel = new JLabel("Your Score: 0");
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(scoreLabel);

        scorePanel.add(centerPanel, BorderLayout.CENTER);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.addActionListener(e -> resetQuiz());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(playAgainButton);

        scorePanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void showRulesPanel() {
        cardLayout.show(mainPanel, "Rules");
    }

    private void startQuiz() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "The tea was?",
                new String[]{"Majestic", "Fantastic", "Incredible", "Epic"},
                1,
                "abhinandan.png"
        ));
        questions.add(new Question(
                "Teesray mein dhum, chotay mein ghum?",
                new String[]{"Raw Oil", "Black Oil", "Poyon Oil", "Crude Oil"},
                2,
                "poyon-oil.png"
        ));

        quiz = new Quiz(questions);
        loadQuestion();
        cardLayout.show(mainPanel, "Quiz");
    }

    private void loadQuestion() {
        Question current = quiz.getCurrentQuestion();
        if (current != null) {
            questionLabel.setText(current.getQuestionText());

            try {
                ImageIcon icon = new ImageIcon("images/" + current.getImagePath());
                Image img = icon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                imageLabel.setText(""); // Clear fallback text if previously shown
            } catch (Exception e) {
                imageLabel.setIcon(null);
                imageLabel.setText("Image not found.");
            }

            String[] opts = current.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(opts[i]);
                optionButtons[i].setSelected(false);
            }
        }
    }

    private void handleNextButton() {
        int selectedOption = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer before proceeding.");
            return;
        }

        quiz.checkAnswer(selectedOption);
        quiz.nextQuestion();

        if (quiz.isFinished()) {
            showScore();
        } else {
            loadQuestion();
        }
    }

    private void showScore() {
        scoreLabel.setText("<html><div style='text-align:center;'>Thank you, <b>"
                + currentUser.getName() + "</b>!<br>Your Score: " + quiz.getScore()
                + " out of " + quiz.getTotalQuestions() + "</div></html>");
        cardLayout.show(mainPanel, "Score");
    }

    private void resetQuiz() {
        nameField.setText("");
        quiz = null;
        currentUser = null;
        cardLayout.show(mainPanel, "Login");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new QuizGUI().setVisible(true));
    }
}
