package object;

public class Student {
    private int id;
    private String name;
    private double score;
    private String gender;

    private static int count = 1 ;

    public Student( String name, double score, String gender) {
        this.id = count;
        this.name = name;
        this.score = score;
        this.gender = gender;
        count++;
    }
    public Student(int id, String name, double score, String gender) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Student [" +
                "ID = " + id +
                ", Name = '" + name + '\'' +
                ", Score = " + score +
                ", Gender = '" + gender + '\'' +
                ']';
    }
}
