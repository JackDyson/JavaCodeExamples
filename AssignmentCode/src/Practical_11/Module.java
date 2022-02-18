package Practical_11;

public class Module {
    String moduleID;
    Student[] classList = new Student[5];
    int listSize = classList.length;
    int stuInMod = 0;
// constructor
    public Module(String moduleID) {
        this.moduleID = moduleID;
    }
// methods

    public void enroll(Student s){
        boolean inList = false;
        for (int n = 0; n<listSize;n++){
            if(classList[n] == s){
                inList = true;
                break;
            }
        }
        if (!inList){
            classList[stuInMod] = s;
            this.stuInMod++;
            sortMembers();
        }
    }

    public void unenroll(Student s){//takes student id as a parameter
        for (int n = 0; n< listSize;n++){
            if (classList[n] == s){//finds student in the list
                classList[n] = null;//sets index where student was found = to null
                for (int i = n; i< listSize-1; i++){//moves everything left so all of the nulls are on the right
                    classList[i] = classList[i+1];
                }
                break;
            }
        }
        this.stuInMod--;//takes away 1 from the students in module
    }

    public void sortMembers(){
        boolean swaps = true;
        while(swaps){
            int swapCounter = 0;
            for (int n = 0; n<listSize-1;n++){
                if (this.classList[n+1] == null){//if the next one to be compared is null
                    break;//stop the sort
                }
                if (n+1 == listSize){//if n+1 is the size of the list there will be an error on the next loop
                    break; //therefore the loop should be stopped here
                }
                if (this.classList[n].compareTo(this.classList[n + 1]) > 0) {//compares 1 element to the one next to it
                    Student tempMember = this.classList[n + 1];//stores smaller element in a variable
                    this.classList[n + 1] = this.classList[n];//moves larger element to the right
                    this.classList[n] = tempMember;//puts the smaller element to the left
                    swapCounter++;//increments counter for every swap made
                }
            }
            if(swapCounter == 0){ //if no swaps were made
                swaps = false;// break the loop
            }
        }
    }

    public void printModule(){
        int listSize = classList.length;
        System.out.println("Module: "+this.moduleID);
        System.out.println("Contains "+stuInMod+" student(s)");
        System.out.println("Students Enrolled:");
        for (int n = 0; n < listSize; n++){
            if(this.classList[n] != null){//if the element is not null, print it
                System.out.println("    "+this.classList[n]);
            }

        }
    }
}
