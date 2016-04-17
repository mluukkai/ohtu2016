package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private String points;
    private String hours;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    
    

    @Override
    public String toString() {
        return "Viikko " + week + ": Tehtyjä tehtäviä " + points + ", käytettyjä tunteja " + hours + "\n";
    }
    
}