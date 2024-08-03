package menu;

import manager.StudentManager;
import object.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    Scanner inputString  = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);
    StudentManager manager = new StudentManager();
   public void mainMenu () {
       int option;
       do {
           System.out.println("1. Add Student");
           System.out.println("2. Remove Students");
           System.out.println("3. Update Student");
           System.out.println("4. Find Student By Key");
           System.out.println("5. Display List of Students By Name");
           System.out.println("6. Display Student Have Score Max");
           System.out.println("7. Display All");
           System.out.println();
           System.out.println("Enter your option: ");
           option = inputNumber.nextInt();
           System.out.println();
           switch (option) {
               case 1:
                   menuAdd();
                   break;
               case 2:
                   menuRemove();
                   break;
               case 3:
                   menuUpdate();
                   break;
               case 4:
                   menuFindBykey();
                   break;
               case 5:
                   menuFind();
                   break;
               case 6:
                   menuScoreMax();
                   break;
                case 7:
                    menuDisplayAll();
                    break;

           }

       }while (option != 0);
   }
   public void menuAdd() {
       try {
           System.out.println("Enter Student Name :");
           String name = inputString.nextLine();
           System.out.println("Enter Student Gender :");
           String gender = inputString.nextLine();
           System.out.println("Enter Student Score :");
           double score = inputNumber.nextDouble();
           System.out.println("Enter Student Key :");
           String key = inputString.nextLine();
           Student student = new Student(name, score, gender);
           manager.addStudent(key, student);
           System.out.println("Added student successfully !!");
       }catch (Exception e) {
           System.out.println("Wrong data entered !!");
       }

   }
   public void menuRemove() {
       System.out.println("Enter Student key :");
       String key = inputString.nextLine();
       if (manager.checkKey(key)) {
           manager.removeStudent(key);
           System.out.println("Removed student successfully !!");
       }else {
           System.out.println("Student not found !!");
       }
   }
   public void menuUpdate() {
       System.out.println("Enter Student key :");
       String key = inputString.nextLine();
       if (manager.checkKey(key)) {
           System.out.println("Enter Student New Name :");
           String name = inputString.nextLine();
           System.out.println("Enter Student New Gender :");
           String gender = inputString.nextLine();
           System.out.println("Enter Student New Score :");
           double score = inputNumber.nextDouble();

           Student student = new Student(manager.getStudent().get(key).getId(),name, score, gender);
           manager.editStudent(key, student);
           System.out.println("Edited student successfully !!");
       }else {
           System.out.println("Student not found !!");
       }
   }
   public void menuFindBykey() {
       System.out.println("Enter Student key :");
       String key = inputString.nextLine();
       if (manager.checkKey(key)) {
           System.out.println(manager.getStudent().get(key));
       }else {
           System.out.println("Student not found !!");
       }
   }
   public void menuFind() {
       System.out.println("Enter Student name :");
       String name = inputString.nextLine();
       HashMap <String, Student> newStudent = new HashMap<>();
       newStudent = manager.findStudentByName(name);
       if (newStudent != null) {
           Set <String> keys = newStudent.keySet();
           for (String key : keys) {
               System.out.println(newStudent.get(key));
           }
       }else {
           System.out.println("Student not found !!");
       }
   }
   public void menuScoreMax() {
       System.out.println("Student Score Max : ");
       double score = manager.highestPoint();
       Set <String> keys = manager.getStudent().keySet();
       for (String key : keys) {
           if (manager.getStudent().get(key).getScore() == score) {
               System.out.println(manager.getStudent().get(key) + " : " + score);
           }
       }

   }
   public void menuDisplayAll() {
       System.out.println("All students : ");
       Set<String> keys = manager.getStudent().keySet();
       for (String key : keys) {
           System.out.println(manager.getStudent().get(key));
       }
   }

}
