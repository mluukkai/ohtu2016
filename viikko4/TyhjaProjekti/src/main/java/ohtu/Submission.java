package ohtu;

import java.util.Arrays;

public class Submission {
    private String student_number;
    private String week;
    private String hours;
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

    private boolean[] array;
    private int count;

    public String getStudent_number() {
        return student_number;
    }
    public int getHours() {
        return Integer.parseInt(hours);
    }
    public int getCount() {
        getArray();
        return count;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    private void getArray() {
        int i;
        if(array != null) return;

        array = new boolean[21];
        array[0] = a1;
        array[1] = a2;
        array[2] = a3;
        array[3] = a4;
        array[4] = a5;
        array[5] = a6;
        array[6] = a7;
        array[7] = a8;
        array[8] = a9;
        array[9] = a10;
        array[10] = a11;
        array[11] = a12;
        array[12] = a13;
        array[13] = a14;
        array[14] = a15;
        array[15] = a16;
        array[16] = a17;
        array[17] = a18;
        array[18] = a19;
        array[19] = a20;
        array[20] = a21;

        for(i = 0; i < 21; i++) {
            if(array[i]) {
                count++;
            }
        }
    }

    @Override
    public String toString() {
        String str;
        int i;
        getArray();

        str = "viikko " + week +": tehtyjä tehtäviä yhteensä: "+ count +", aikaa kului " + hours + " tuntia, tehdyt tehtävät:";

        for(i = 0; i < array.length; i++) {
            if(!array[i]) continue;
            str += " " + (i+1);
        }
        return str;
    }
    
}