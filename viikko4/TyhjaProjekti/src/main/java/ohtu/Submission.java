package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private int id;
    private String last_name;
    private String first_name;
    private int week;
    private int points;
    private String identifier;
    private int hours;
    private String comments;
    private String email;
    private boolean[] tehtavat;
    private String created_at;
    private String updated_at;
    private int course_id;
    private String github;
    private int student_id;
    private int challenging;
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
    private int tasks;
    private String tasksDone;
    
    public Submission() {
        tasks = done();
        tasksDone = tasksDone();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean[] getTehtavat() {
        return tehtavat;
    }

    public void setTehtavat(boolean[] tehtavat) {
        this.tehtavat = tehtavat;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getChallenging() {
        return challenging;
    }

    public void setChallenging(int challenging) {
        this.challenging = challenging;
    }

    public boolean isA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }
            
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void printLn() {
        System.out.println("");
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean isA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean isA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean isA5() {
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean isA6() {
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean isA7() {
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean isA8() {
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean isA9() {
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean isA10() {
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public boolean isA11() {
        return a11;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }
    
    public int done() {
        int luku = 0;
        if (a1) luku++;
        if (a2) luku++;
        if (a3) luku++;
        if (a4) luku++;
        if (a5) luku++;
        if (a6) luku++;
        if (a7) luku++;
        if (a8) luku++;
        if (a9) luku++;
        if (a10) luku++;
        if (a11) luku++;
        return luku;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }
    
    public String tasksDone() {
        StringBuilder builder = new StringBuilder();
        if (a1) builder.append("1 ");
        if (a2) builder.append("2 ");
        if (a3) builder.append("3 ");
        if (a4) builder.append("4 ");
        if (a5) builder.append("5 ");
        if (a6) builder.append("6 ");
        if (a7) builder.append("7 ");
        if (a8) builder.append("8 ");
        if (a9) builder.append("9 ");
        if (a10) builder.append("10 ");
        if (a11) builder.append("11 ");
        return builder.toString();
    }
    
    @Override
    public String toString() {
        tasks = done();
        tasksDone = tasksDone();
        return "viikko " + week + ": " + "tehtyjä tehtäviä yhteensä: " + tasks + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + tasksDone;
    }
    //student_number + id + last_name + first_name + week + points + identifier + hours + comments + email + a1 + created_at + updated_at + course_id + github + student_id + challenging

    
    
}