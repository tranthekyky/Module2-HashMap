package manager;

import object.Student;

import java.util.HashMap;

public interface IStudent <S>{
    public void addStudent(String kay,S s);
    public void removeStudent(String key);
    public void editStudent(String key,S s);
    public HashMap<String,S> findStudentByName(String name);
    public double highestPoint();
}
