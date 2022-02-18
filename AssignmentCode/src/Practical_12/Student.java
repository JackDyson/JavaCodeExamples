package Practical_12;

public class Student{
    private final String studentID;
    private float averageStuGrade;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public void setAverageStuGrade(float averageStuGrade) {
        this.averageStuGrade = averageStuGrade;
    }

    public void printStudent(){
        if(Float.isNaN(this.averageStuGrade)){
            System.out.println("The Student "+this.studentID+" does not have any grades");
        }
        else{
            System.out.println("Student: "+this.studentID);
            System.out.println("    Average grade: "+String.format("%.2f",this.averageStuGrade*100)+"%");
        }
        System.out.println();

    }
}
