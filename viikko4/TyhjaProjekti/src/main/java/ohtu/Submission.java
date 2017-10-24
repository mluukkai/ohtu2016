package ohtu;

public class Submission {
    private int id;
    private String student_number;
    private String last_name;
    private String first_name;
    private int week;
    private int points;
    private String indentifier;
    private int hours;
    private String comments;
    private String email;
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
    private String created_at;
    private String updated_at;
    private int course_id;
    private String github;
    private String student_id;
    private String challenging;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String student_number;


    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
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

    public String getIndentifier() {
        return indentifier;
    }

    public void setIndentifier(String indentifier) {
        this.indentifier = indentifier;
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

    public boolean isA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
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

    public boolean isA12() {
        return a12;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    public boolean isA13() {
        return a13;
    }

    public void setA13(boolean a13) {
        this.a13 = a13;
    }

    public boolean isA14() {
        return a14;
    }

    public void setA14(boolean a14) {
        this.a14 = a14;
    }

    public boolean isA15() {
        return a15;
    }

    public void setA15(boolean a15) {
        this.a15 = a15;
    }

    public boolean isA16() {
        return a16;
    }

    public void setA16(boolean a16) {
        this.a16 = a16;
    }

    public boolean isA17() {
        return a17;
    }

    public void setA17(boolean a17) {
        this.a17 = a17;
    }

    public boolean isA18() {
        return a18;
    }

    public void setA18(boolean a18) {
        this.a18 = a18;
    }

    public boolean isA19() {
        return a19;
    }

    public void setA19(boolean a19) {
        this.a19 = a19;
    }

    public boolean isA20() {
        return a20;
    }

    public void setA20(boolean a20) {
        this.a20 = a20;
    }

    public boolean isA21() {
        return a21;
    }

    public void setA21(boolean a21) {
        this.a21 = a21;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getChallenging() {
        return challenging;
    }

    public void setChallenging(String challenging) {
        this.challenging = challenging;
    }

    public int getScore() {
        int score = 0;
        if (a1) {
            score++;
        }
        if (a2) {
            score++;
        }
        if (a3) {
            score++;
        }
        if (a4) {
            score++;
        }
        if (a5) {
            score++;
        }
        if (a6) {
            score++;
        }
        if (a7) {
            score++;
        }
        if (a8) {
            score++;
        }
        if (a9) {
            score++;
        }
        if (a10) {
            score++;
        }
        if (a11) {
            score++;
        }
        if (a12) {
            score++;
        }
        if (a13) {
            score++;
        }
        if (a14) {
            score++;
        }
        if (a15) {
            score++;
        }
        if (a16) {
            score++;
        }
        if (a17) {
            score++;
        }
        if (a18) {
            score++;
        }
        if (a19) {
            score++;
        }
        if (a20) {
            score++;
        }
        if (a21) {
            score++;
        }
        return score;
    }
    
    @Override
    public String toString() {
        String tehtavat = "";
        if (a1) {
            tehtavat += " 1";
        }
        if (a2) {
            tehtavat += " 2";
        }
        if (a3) {
            tehtavat += " 3";
        }
        if (a4) {
            tehtavat += " 4";
        }
        if (a5) {
            tehtavat += " 5";
        }
        if (a6) {
            tehtavat += " 6";
        }
        if (a7) {
            tehtavat += " 7";
        }
        if (a8) {
            tehtavat += " 8";
        }
        if (a9) {
            tehtavat += " 9";
        }
        if (a10) {
            tehtavat += " 10";
        }
        if (a11) {
            tehtavat += " 11";
        }
        if (a12) {
            tehtavat += " 12";
        }
        if (a13) {
            tehtavat += " 13";
        }
        if (a14) {
            tehtavat += " 14";
        }
        if (a15) {
            tehtavat += " 15";
        }
        if (a16) {
            tehtavat += " 16";
        }
        if (a17) {
            tehtavat += " 17";
        }
        if (a18) {
            tehtavat += " 18";
        }
        if (a19) {
            tehtavat += " 19";
        }
        if (a20) {
            tehtavat += " 20";
        }
        if (a21) {
            tehtavat += " 21";
        }
        
        return " viikko " + week + ": tehtyjä tehtäviä yhteensä: " + this.getScore() + ", aikaa kului " + hours + ", tehdyt tehtävät:" + tehtavat;

    @Override
    public String toString() {
        return student_number;

    }
    
}