import java.util.Scanner;

public class StudentGradeCalculation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("*********Student grade Calculator*********");
        System.out.println("Enter the no of  subjects:");
        //Here sub is no of subjects
        int sub = sc.nextInt();
        int total = 0;
        System.out.println("Enter the marks obtained in "+sub+" subjects respectively : ");
        for (int i=0; i<sub; i++){
            int marks=sc.nextInt();
            total = total+ marks;
        }
        
        //avgPer is average percentage
        double avgPer=(double)total/sub;
        String Grade;
        if (avgPer>=90){
            Grade ="A+";

        } 
        else if(avgPer>=80){
            Grade ="A";
        }
        else if(avgPer>=70){
            Grade ="B";
        }
        else if(avgPer>=60){
            Grade ="C";
        }
        else if(avgPer>=50){
            Grade ="D";
        }
        else if(avgPer>=40){
            Grade ="E";
        }
        else{
            Grade ="Fail(F)";

        }
        System.out.println("**********Results**********");
 System.out.println("Total marks ="+total);
 System.out.println("Average percentage =" +avgPer+" %");
 System.out.println("Grade is : " + Grade);
    }
    
}
