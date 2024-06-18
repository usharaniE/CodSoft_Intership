import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCourseManagementSystem {
// List to store course

private static List<Course> courses = new ArrayList<>();
// List to store course
private static List<Student> students = new ArrayList<>();
private static Scanner scanner = new Scanner(System.in); 
public static void main(String[] args) {
    // sample data 
    courses.add(new Course("CS501", "Intraduction of Java Programming", "Basics of java programming", 30 , "MWF 9:00-12:00"));
    courses .add(new Course("CS502", "Intraduction of Python Programming","Basics of Python programming", 25 , "TTh 1:00-3:00"));
    courses .add(new Course("CS503", "Intraduction of Data Structure", "Basics of DS", 20 , "MWF 4:00-6:00"));
    students.add(new Student(1, "Usha"));
    students.add(new Student(2, "Rani"));
      

    // Main menu
     while(true){
        System.out.println("\n  Course Management System");
        System.out.println("1. List Courses");
        System.out.println("2. Register for a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. Exit");
        System.out.println("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); //Consume newline

        switch (choice) {
         case 1:
         listCourses();
         break;
         case 2:
         registerCourse();
         break;
         case 3:
         dropCourse();
         break;
         case 4:
         System.out.println("Exiting the system.");
         scanner.close();
         System.exit(0);
         default :
         System.out.println("Invalid choice. Please try again.");

        }
      }
   }
   //Method for list availabale courses
   private static void listCourses() {
      System.out.println("\n Available Courses:");
      for (Course course : courses){
         System.out.println(course);
      }
   }
   //method for student to register for a course
   private static void registerCourse(){
      System.out.print("\n Enter student ID: ");
      int studentId = scanner.nextInt();
      Student student = getStudentById(studentId);
       
      if (student == null) {
        System.out.println("Student not found.");
        return;
      }

      System.out.print("Enter course code: ");
      String courseCode = scanner.next();
      Course course = getCourseByCode(courseCode);
      
      if (course == null) {
         System.out.println("Course not found.");
         return;
       }

       if (course.getCapacity() > 0){
         student.registerCourse(course);
         course.decrementCapacity();
         System.out.println("Registered successfully.");
       } else {
         System.out.println("Course is full.");
       }

   }
   //Method for student to drop a course
   private static void dropCourse() {
      System.out.print("\n Enter student ID: ");
     int studentId = scanner.nextInt();
     Student student = getStudentById(studentId);
 
  if (student == null) {
   System.out.println("Student not found.");
   return;
 }
 System.out.print("Enter course code: ");
      String courseCode = scanner.next();
      Course course = getCourseByCode(courseCode);
      
      if (course == null) {
         System.out.println("Course not found.");
         return;
       }
       if(student.dropCourse(course)) {
         course.incrementCapacity();
         System.out.println("Dropped course successfully. ");

       } else {
         System.out.println("Student is not registered for this course. ");
       }
       }
       //Helper method to get a student by ID
       private static Student getStudentById(int id){
         for(Student student : students){
            if(student.getId() == id) {
               return student;
            }
         }
         return null;
       }
   
    //Helper method to get a course by code
   private static Course getCourseByCode(String code){
      for(Course course : courses) {
         if(course.getCode().equals(code)){
            return course;
         }
      }
      return null;
   }
         
}
     class Course {
      private String code;
      private String title;
      private String description;
      private int capacity;
      private String schedule;

      public Course(String code, String title, String description, int capacity, String schedule) {
         this.code = code;
         this.title = title;
         this.description = description;
         this.capacity = capacity;
         this.schedule = schedule;
      }

      public String getCode(){
         return code;
      }
      public int getCapacity(){
         return capacity;
      }
      public void decrementCapacity() {
         if(capacity > 0) {
            capacity--;
         }
      }
      public void incrementCapacity(){
         capacity++;
      }

      @Override
      public String toString() {
         return "Course Code: " + code + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity + ", Schedule: " + schedule; 
      }
     }
     class Student {
      private int id;
      private String name;
      private List<Course> registeredCourses = new ArrayList<>();

      public Student(int id, String name){
         this.id = id;
         this.name = name;

      }
      public int getId() {
         return id;
      }
      public void registerCourse(Course course){
         registeredCourses.add(course);
      }
      public boolean dropCourse(Course course){
         return registeredCourses.remove(course);
      }
     }
   