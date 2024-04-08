package fa.training.entities;

public class Student extends Person{
    private String studentID;

    private double theory, practice;

    public Student(String name, String gender, String phone, String email, String studentID, double theory, double practice) {
        super(name, gender, phone, email);
        this.studentID = studentID;
        this.theory = theory;
        this.practice = practice;
    }

    public double calculateFinalMark(){
        return (theory + practice) / 2 ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", studentID='" + studentID + '\'' +
                ", theory=" + theory +
                ", practice=" + practice +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }
}
