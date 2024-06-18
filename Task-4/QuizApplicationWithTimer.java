import java.util.List;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.Timer;
import java.util.Scanner;

public class QuizApplicationWithTimer {
     private static List<Question> questions = new ArrayList<>();
     private static int score = 0;
     private static int currentQuestionIndex = 0;
     private static Timer timer= new Timer();
     private static Scanner scanner = new Scanner(System.in);
     private static boolean isAnswered = false;
     public static void main(String[] args) {
        //sample quiz questions
        questions.add(new Question("Who Invented Java Programming?",
           Arrays.asList("Guido van Rossum", "James Gosling", "Dennis Ritche", "Bjarne Stroustrup"), 1));
        questions.add(new Question("Which of theese is not a feature of java?",
        Arrays.asList("Object-oriented", "Platform-Independent" , "Complied", "Interpreted language"), 3));
        questions.add(new Question("Which Component of Java is responsible for running the compiled java bytecode?",
        Arrays.asList("JDK" , "JVM" , "JRE", "JIT"), 1));
     //add more questions here ....
     startQuiz();   

    }

     private static void startQuiz() {
        if (currentQuestionIndex < questions.size()) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        System.out.println("Question: " + currentQuestion.getQuestion());
     List<String> options = currentQuestion.getOptions();
     for (int i = 0; i < options.size(); i++) {
        System.out.println((i + 1) + ". " + options.get(i));
     }

     //Set timer for 10 sec to answer the question
     timer.schedule(new TimerTask() {
        @Override
        public void run() {
            if(!isAnswered){
            System.out.println("Time's up!");
            showNextQuestion();
        }
    }
     }, 10000); // 10 second in milliseconds
     // User i/p for answering the question 
     while(!isAnswered){
        if(scanner.hasNextInt()){
            int userChoice = scanner.nextInt();
            isAnswered = true;
            checkAnswer(userChoice - 1, currentQuestion);
        } else {
            System.out.println("Invalid input.Please enter a number between 1 and " + options.size());
            scanner.next();
            //clear the invalid input
        }
    }
}
     
      else {
       endQuiz();
    }
}
private static void checkAnswer(int userChoice, Question question) {
    if (userChoice == question.getCorrectOptionIndex()) {
        System.out.println("Correct!");
        score++;
    } else {
        System.out.println("Incorrect!");
    }
    showNextQuestion();

}

 private static void showNextQuestion() {
    currentQuestionIndex++;
    timer.cancel(); // Cancel the previous timer
    timer = new Timer();
    isAnswered = false;
    startQuiz();
 }

 private static void endQuiz() {
    System.out.println("Quiz ended!");
    System.out.println("Your score: " + score + " out of " + questions.size());
    //display other summary information if needed
   
 }
 }

   class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return  options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}