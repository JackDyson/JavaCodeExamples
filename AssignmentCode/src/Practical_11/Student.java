package Practical_11;

public class Student implements Comparable<Student>{
    String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }
    public String toString(){
        return this.studentID;
    }
    @Override
    public int compareTo(Student std2){
        return this.studentID.compareTo(std2.studentID);
    }
}
