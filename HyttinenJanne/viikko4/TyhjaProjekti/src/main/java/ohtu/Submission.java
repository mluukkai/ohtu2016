package ohtu;



public class Submission {
    private String student_number;
    private int hours;
    private int week;
    private boolean a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;

    

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
    
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

 

    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    public int aDone(){
        int size = 0;
        if(this.isA1()){size++;}
        if(this.isA2()){size++;}
        if(this.isA3()){size++;}
        if(this.isA4()){size++;}
        if(this.isA5()){size++;}
        if(this.isA6()){size++;}
        if(this.isA7()){size++;}
        if(this.isA8()){size++;}
        if(this.isA9()){size++;}
        if(this.isA10()){size++;}
        return size;
    }
       @Override
    public String toString() {
        int size = aDone();
        
        String output = "viikko "+this.week+": tehtyjä tehtäviä yhteensä:"+size+", aikaa kului "+this.hours+" tuntia, tehdyt tehtävät:";
        if(this.isA1()){output=output+" 1";}
        if(this.isA2()){output=output+" 2";}
        if(this.isA3()){output=output+" 3";}
        if(this.isA4()){output=output+" 4";}
        if(this.isA5()){output=output+" 5";}
        if(this.isA6()){output=output+" 6";}
        if(this.isA7()){output=output+" 7";}
        if(this.isA8()){output=output+" 8";}
        if(this.isA9()){output=output+" 9";}
        if(this.isA10()){output=output+" 10";}
            
       
        return output;
    }
    
}