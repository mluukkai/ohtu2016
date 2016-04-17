package ohtu;

public class Submission {
    private String student_number;
    private int id;
    private String lastname;
    private String firstname;
    private int points;
    private int hours;
    private boolean[] tehtavat;
    private String viikko;

    public String getViikko() {
        return viikko;
    }

    public void setViikko(String viikko) {
        this.viikko = viikko;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return student_number + "\n" +  "Tehtäviä tehty yhteensä: " + points + ", joihin kului aikaa " + hours + " tuntia, tehdyt tehtävät: " + tehtavat;
    }
    
}