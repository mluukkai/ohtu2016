package ohtu;

import java.util.*;

public class Submission {
    private String student_number;
    HashMap<Integer, Boolean> exercises;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public int getNumberOfExercises() {
        int sum = 0;
        for(Boolean a : exercises.values()) {
            if(a) sum++;
        }
        return sum;
    }
    private String getExercisesString() {
        String s = "";
        for(int i = 1; i < exercises.size()+1;i++) {
            if(exercises.get(i)) s += i + " ";
        }
        if(s.length() == 0) return "N/A";
        
        return s.substring(0,s.length()-1);
    }

    public int getHours() {
        return hours;
    }
    public void format() {
        this.exercises = new HashMap();
        exercises.put(1,a1);
        exercises.put(2,a2);
        exercises.put(3,a3);
        exercises.put(4,a4);
        exercises.put(5,a5);
        exercises.put(6,a6);
        exercises.put(7,a7);
        exercises.put(8,a8);
        exercises.put(9,a9);
        exercises.put(10,a10);
        exercises.put(11,a11);
        exercises.put(12,a12);
        exercises.put(13,a13);
        exercises.put(14,a14);
        exercises.put(15,a15);
        exercises.put(16,a16);
        exercises.put(17,a17);
        exercises.put(18,a18);
        exercises.put(19,a19);
        exercises.put(20,a20);
        exercises.put(21,a21);
    }

    @Override
    public String toString() {
        HashMap<Integer, Boolean> exercises = this.exercises;
        int done = getNumberOfExercises();
        String exercisesString = getExercisesString();
        String toReturn = "viikko " + this.week + ": tehtyjä tehtäviä yhteensä: " + 
                done + ", aikaa kului " + this.hours + 
                " tuntia, tehdyt tehtävät: " + exercisesString;
        return toReturn;
    }

}
