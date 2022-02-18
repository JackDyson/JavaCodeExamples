package Practical_12;

public class Grade {
    Module module;
    Student student;
    float score;

    public Grade(Module m, Student s, float score) {
        this.module = m;
        this.student = s;
        this.score = score;
    }

    public Module getModule() {
        return module;
    }

    public Student getStudent() {
        return student;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}

