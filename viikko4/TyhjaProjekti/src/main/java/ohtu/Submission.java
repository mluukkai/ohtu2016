package ohtu;

public class Submission {
    private String student_number;
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
    
    
    public String done(){
        String done = "";
        
        if(a1)
            done += "1 ";
        if(a2)
            done += "2 ";
        if(a3)
            done += "3 ";
        if(a4)
            done += "4 ";
        if(a5)
            done += "5 ";
        if(a6)
            done += "6 ";
        if(a7)
            done += "7 ";
        if(a8)
            done += "8 ";
        if(a9)
            done += "9 ";
        
        return done;
    }
    
    public int howManyDone(){
        int done = 0;
        
        if(a1)
            done++;
        if(a2)
            done++;
        if(a3)
            done++;
        if(a4)
            done++;
        if(a5)
            done++;
        if(a6)
            done++;
        if(a7)
            done++;
        if(a8)
            done++;
        if(a9)
            done++;
        
        return done;
    }
    
    @Override
    public String toString() {
        return "viikko " + week + ", tunteja kului yhteensä: " + hours + ", tehtyjä tehtäviä oli: " + this.done();
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}