import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"Berlin", "Paris", "Rome", "Madrid"},
            2
        ));

        questions.add(new Question(
            "Which language is used for Android app development?",
            new String[]{"Python", "Swift", "Java", "Kotlin"},
            4
        ));

        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"extends", "implements", "inherit", "super"},
            1
        ));

        int score = 0;

        System.out.println("Welcome to the Java Quiz!");
        System.out.println("--------------------------");

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Incorrect!\n");
            }
        }

        System.out.println("You scored " + score + " out of " + questions.size());
        scanner.close();
    }
}
