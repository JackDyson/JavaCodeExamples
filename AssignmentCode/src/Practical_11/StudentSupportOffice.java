package Practical_11;

public class StudentSupportOffice{

    public static void main(String args[]){
        Student s1 = new Student("U0000001");
        Student s2 = new Student("U0000002");
        Student s3 = new Student("U0000003");
        Student s4 = new Student("U0000004");
        Student s5 = new Student("U0000005");
        Module m1 = new Module("CIS2344");
        Module m2 = new Module("CIS2360");
        Module m3 = new Module("CIM2130");
        //CIS2344 should contain s1,s2,s3,s4,s5
        m1.enroll(s4);
        m1.enroll(s1);
        m1.enroll(s2);
        m1.enroll(s5);
        m1.enroll(s3);
        m1.printModule();
        //CIS2344 should now contain all the students
        //
        //CIS2360 should contain s1,s2,s5
        //CIS2360 already contains s1,s3,s5
        m2.enroll(s1);
        m2.enroll(s3);
        m2.enroll(s1);
        m2.enroll(s5);
        m2.enroll(s2);
        m2.unenroll(s3);
        m2.printModule();
        //CIS2360 should now be correct
        //
        //CIM2130 should contain s1,s3,s4
        //CIM2130 already contains s3,s4,s5
        m3.enroll(s3);
        m3.enroll(s4);
        m3.enroll(s5);
        m3.unenroll(s5);
        m3.enroll(s1);
        m3.printModule();
        //CIM2130 should now be correct
    }

}
