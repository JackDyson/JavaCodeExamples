package Practical_12;

import java.util.ArrayList;

public class StudentSupportOffice {

    public static void main(String args[]) {
        Student s1 = new Student("U0000001");
        Student s2 = new Student("U0000002");
        Student s3 = new Student("U0000003");
        Module m1 = new Module("CIS2344");
        Module m2 = new Module("CIS2360");
        ArrayList<Grade> GradeList = new ArrayList<>();
        insert(GradeList,s1,m1,0.50f);
        insert(GradeList,s2,m1,0.50f);
        insert(GradeList,s3,m1,0.5f);
        insert(GradeList,s1,m2,0.5f);
        insert(GradeList,s2,m2,0.50f);
        insert(GradeList,s3,m2,0.50f);
        update(GradeList,s1,m2,0.67f);
        delete(GradeList,s3,m1);
        s1.printStudent();
        s2.printStudent();
        s3.printStudent();
        m1.printModule();
        m2.printModule();

    }
    //methods

    public static void insert(ArrayList<Grade> GradeList, Student s, Module m, float score){
        if(!inList(GradeList,s,m)){//checks if the student module pair isnt in the list
            Grade grade = new Grade(m,s,score);//creates new student module pair
            GradeList.add(grade);//adds it to the grade list
            calcModAvg(GradeList,m);
            calcStuAvg(GradeList,s);
        }

    }
    public static void update(ArrayList<Grade> GradeList,Student s, Module m, float newScore){//find grade list location for a given student and module. then change the score
        for(int n = 0; n< GradeList.size(); n++){
            if(GradeList.get(n).getStudent() == s){//checks if the student is equal to what the user wants to change
                if(GradeList.get(n).getModule() == m){//then checks if the module is the same as what the user wants to change
                    GradeList.get(n).setScore(newScore);//changes the score
                }
            }
        }
        calcModAvg(GradeList,m);
        calcStuAvg(GradeList,s);
    }
    public static void delete(ArrayList<Grade> GradeList,Student s, Module m){//find grade list location for a given student and module. then remove from the list and delete object??
        for(int n = 0; n<GradeList.size(); n++){
            if(GradeList.get(n).getStudent() == s){//checks if the student is equal to what the user wants to change
                if(GradeList.get(n).getModule() == m){//then checks if the module is the same as what the user wants to change
                    GradeList.remove(n);
                }
            }
        }
        calcModAvg(GradeList,m);
        calcStuAvg(GradeList,s);
    }
    public static void calcModAvg(ArrayList<Grade> GradeList, Module m){
        float total = 0;//total overall score
        int counter = 0;//how many students are in the module
        for(int n = 0; n< GradeList.size(); n++){
            if(GradeList.get(n).getModule() == m){//checks if the module for the nth element in list is what the user wants the avg for
                total = total + GradeList.get(n).getScore();//increases the total
                counter++;//increments amount of students in module
            }
        }
        float modAvg = total/counter;//total score divided by total students
        m.setAvgModGrade(modAvg);
    }
    public static void calcStuAvg(ArrayList<Grade> GradeList, Student s){
        float total = 0;//total overall score
        int counter = 0;//how many modules the student is in
        for(int n = 0; n< GradeList.size(); n++){
            if(GradeList.get(n).getStudent() == s){//checks if the module for the nth element in list is what the user wants the avg for
                total = total + GradeList.get(n).getScore();//increases total score
                counter++;//increments amount of modules student is apart of
            }
        }
        float stuAvg = total/counter;//total score divided by how many modules the student is in
        s.setAverageStuGrade(stuAvg);
    }
    public static boolean inList(ArrayList<Grade> GradeList, Student s, Module m){
        for(int n = 0; n< GradeList.size();n++){
            if(GradeList.get(n).getStudent() == s){
                if(GradeList.get(n).getModule() == m){
                    return true;//if the nth member of the list contains s and m then return true
                }
            }
        }
        return false;
    }
}
