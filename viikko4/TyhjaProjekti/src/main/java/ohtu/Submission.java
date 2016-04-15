package ohtu;

public class Submission {
    private int week;
    private int hours;
    private String student_number;
    private boolean a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return hours;
    }
    
    public int completedAssignments() {
        boolean[] arr = createArray();
        int c = 0;
        
        for (int i=0; i<16; i++) {
            if (arr[i]) c++;
        }
        
        return c;
    }
    
    private boolean[] createArray() {
        boolean[] arr = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16};
        return arr;
    }

    @Override
    public String toString() {
        return "Viikko "+week + "; Tehtyjä tehtäviä " + completedAssignments() + "; aikaa kului "+ hours;
    }
    
}