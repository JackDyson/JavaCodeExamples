package Practical_12;

public class Module {
    private final String moduleID;
    private float avgModGrade;

    // constructor
    public Module(String moduleID) {
        this.moduleID = moduleID;
    }

    public void setAvgModGrade(float avgModGrade) {
        this.avgModGrade = avgModGrade;
    }

    public void printModule(){
        System.out.println("Module: "+this.moduleID);//prints module ID
        System.out.println("    Average Grade: "+String.format("%.2f",this.avgModGrade*100)+"%");
        System.out.println();
    }
}
