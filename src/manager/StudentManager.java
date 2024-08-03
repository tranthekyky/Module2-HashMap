package manager;

import object.Student;

import java.util.HashMap;
import java.util.Set;

public class StudentManager implements IStudent <Student> {
   private HashMap<String, Student> students ;
   public StudentManager() {
       students = new HashMap<>();
   }
    @Override
    public void addStudent(String key,Student student) {
        students.put(key, student);
    }

    @Override
    public void removeStudent(String key) {
        students.remove(key);
    }

    @Override
    public void editStudent(String key, Student student) {
        students.put(key, student);
    }
    public boolean checkKey(String key) {
       Set <String> keys = students.keySet();
       for (String k : keys) {
           if (k.equals(key)) {
               return true;
           }
       }
       return false;
    }
    public HashMap<String, Student> getStudent() {
       return students;
    }

    @Override
    public HashMap<String,Student> findStudentByName(String name) {
        Set<String> keys = students.keySet();
        HashMap<String,Student> stu = new HashMap<>();
        for (String key : keys) {
            if (students.get(key).getName().toLowerCase().contains(name.toLowerCase())) {
                stu.put(key, students.get(key));
            }
        }
        return stu;
    }

    @Override
    public double highestPoint() {
        Set<String> keys = students.keySet();
        double scoreMax = 0;
        for (String key : keys) {
            if (students.get(key).getScore() > scoreMax) {
                scoreMax = students.get(key).getScore();
            }
        }

        return scoreMax ;

    }
}
