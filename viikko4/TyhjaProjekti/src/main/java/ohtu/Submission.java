package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private int hours;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;
    private String a11;
    private String a12;
    private String a13;
    
    public int getHours() {
        return this.hours;
    }
    
    public void setHours(String hours) {
        this.hours = Integer.parseInt(hours);
    }

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
        this.week=week;
    }
    
    public int getTasksDone() {
        int laskuri = 0;
        if (a1!=null) {if (a1.contains("true")) {laskuri++;}}
        if (a2!=null) {if (a2.contains("true")) {laskuri++;}}
        if (a3!=null) {if (a3.contains("true")) {laskuri++;}}
        if (a4!=null) {if (a4.contains("true")) {laskuri++;}}
        if (a5!=null) {if (a5.contains("true")) {laskuri++;}}
        if (a6!=null) {if (a6.contains("true")) {laskuri++;}}
        if (a7!=null) {if (a7.contains("true")) {laskuri++;}}
        if (a8!=null) {if (a8.contains("true")) {laskuri++;}}
        if (a9!=null) {if (a9.contains("true")) {laskuri++;}}
        if (a10!=null) {if (a10.contains("true")) {laskuri++;}}
        if (a11!=null) {if (a11.contains("true")) {laskuri++;}}
        if (a12!=null) {if (a12.contains("true")) {laskuri++;}}
        if (a13!=null) {if (a13.contains("true")) {laskuri++;}}
        
        return laskuri;
    }
    
     public String getTasksList() {
        String tasks ="";
        if (a1!=null) {if (a1.contains("true")) {tasks+="1 ";}}
        if (a2!=null) {if (a2.contains("true")) {tasks+="2 ";}}
        if (a3!=null) {if (a3.contains("true")) {tasks+="3 ";}}
        if (a4!=null) {if (a4.contains("true")) {tasks+="4 ";}}
        if (a5!=null) {if (a5.contains("true")) {tasks+="5 ";}}
        if (a6!=null) {if (a6.contains("true")) {tasks+="6 ";}}
        if (a7!=null) {if (a7.contains("true")) {tasks+="7 ";}}
        if (a8!=null) {if (a8.contains("true")) {tasks+="8 ";}}
        if (a9!=null) {if (a9.contains("true")) {tasks+="9 ";}}
        if (a10!=null) {if (a10.contains("true")) {tasks+="10 ";}}
        if (a11!=null) {if (a11.contains("true")) {tasks+="11 ";}}
        if (a12!=null) {if (a12.contains("true")) {tasks+="12 ";}}
        if (a13!=null) {if (a13.contains("true")) {tasks+="13 ";}}
        
        return tasks;
    }
    
    public int getTaskTotal() {
        if (a13!=null) {return 13;}
        if (a12!=null) {return 12;}
        if (a11!=null) {return 11;}
        if (a10!=null) {return 10;}
        if (a9!=null) {return 9;}
        if (a8!=null) {return 8;}
        if (a7!=null) {return 7;}
        if (a6!=null) {return 6;}
        return 5;
    }
    
    @Override
    public String toString() {
        
        //return student_number+" (week: "+week+", hours: "+hours+", "+a1+","+a2+","+a3+","+a10+")";
        return "viikko "+week+": tehtyjä tehtäviä: "+getTasksDone()+", aikaa kului "+hours+" tuntia, tehdyt tehtävät: "+getTasksList();
    }
//    viikko 1: tehtyjä tehtäviä yhteensä: 9, aikaa kului 3 tuntia, tehdyt tehtävät: 1 2 3 4 5 6 7 9 11 

}