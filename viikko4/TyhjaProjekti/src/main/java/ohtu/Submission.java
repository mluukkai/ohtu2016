package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a19, a20, a21;
    private int hours;
    private int week;
    private ArrayList<Integer> assignments;
    
    public void assignments() {
        boolean[] assignment = 
        { false, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a19, a20, a21 };
        
        assignments = new ArrayList<Integer>();
        
        for (int i = 0; i < 21; i++) {
            if (assignment[i]) assignments.add(i);
        }
    }

    public String getStudent_number() {
        return student_number;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getAssignmentsAmount() {
        return assignments.size();
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + assignments.size() + ", aikaa kului: " +
                hours + " tuntia, tehdyt tehtävät: " + assignments.toString();
    }
    
}