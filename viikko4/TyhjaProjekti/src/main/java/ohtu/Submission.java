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



	public int getWeek() {
		return this.week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getHours() {
		return this.hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public boolean[] getTasks() {
		boolean[] tasks = new boolean[22];
		tasks[1] = a1;
		tasks[2] = a2;
		tasks[3] = a3;
		tasks[4] = a4;
		tasks[5] = a5;
		tasks[6] = a6;
		tasks[7] = a7;
		tasks[8] = a8;
		tasks[9] = a9;
		tasks[10] = a10;
		tasks[11] = a11;
		tasks[12] = a12;
		tasks[13] = a13;
		tasks[14] = a14;
		tasks[15] = a15;
		tasks[16] = a16;
		tasks[17] = a17;
		tasks[18] = a18;
		tasks[19] = a19;
		tasks[20] = a20;
		tasks[21] = a21;
		return tasks;
	}
	public String getCompletedTasksString() {
		String ret = "";
		boolean tasks[] = getTasks();
		for (int i = 1; i <= 21; i++) {
			if (tasks[i] == true)
				ret += i + " ";
		}
		return ret;
	}
	public int getCompletedTasksCount() {
		int count = 0;
		boolean tasks[] = getTasks();
		for (int i = 1; i <= 21; i++) {
			if (tasks[i] == true)
				count++;
		}
		return count;
	}
	

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
		String ret = "";
		ret += "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + getCompletedTasksCount();
		ret += ", aikaa kului " + hours + " tuntia";
		ret += ", tehdyt tehtävät: ";
		ret += getCompletedTasksString();
        return ret;
    }
	public boolean getA1() {
		return this.a1;
	}
	public void setA1(boolean val) {
		this.a1 = val;
	}
	public boolean getA2() {
		return this.a2;
	}
	public void setA2(boolean val) {
		this.a2 = val;
	}
	public boolean getA3() {
		return this.a3;
	}
	public void setA3(boolean val) {
		this.a3 = val;
	}
	public boolean getA4() {
		return this.a4;
	}
	public void setA4(boolean val) {
		this.a4 = val;
	}
	public boolean getA5() {
		return this.a5;
	}
	public void setA5(boolean val) {
		this.a5 = val;
	}
	public boolean getA6() {
		return this.a6;
	}
	public void setA6(boolean val) {
		this.a6 = val;
	}
	public boolean getA7() {
		return this.a7;
	}
	public void setA7(boolean val) {
		this.a7 = val;
	}
	public boolean getA8() {
		return this.a8;
	}
	public void setA8(boolean val) {
		this.a8 = val;
	}
	public boolean getA9() {
		return this.a9;
	}
	public void setA9(boolean val) {
		this.a9 = val;
	}
	public boolean getA10() {
		return this.a10;
	}
	public void setA10(boolean val) {
		this.a10 = val;
	}
	public boolean getA11() {
		return this.a11;
	}
	public void setA11(boolean val) {
		this.a11 = val;
	}
	public boolean getA12() {
		return this.a12;
	}
	public void setA12(boolean val) {
		this.a12 = val;
	}
	public boolean getA13() {
		return this.a13;
	}
	public void setA13(boolean val) {
		this.a13 = val;
	}
	public boolean getA14() {
		return this.a14;
	}
	public void setA14(boolean val) {
		this.a14 = val;
	}
	public boolean getA15() {
		return this.a15;
	}
	public void setA15(boolean val) {
		this.a15 = val;
	}
	public boolean getA16() {
		return this.a16;
	}
	public void setA16(boolean val) {
		this.a16 = val;
	}
	public boolean getA17() {
		return this.a17;
	}
	public void setA17(boolean val) {
		this.a17 = val;
	}
	public boolean getA18() {
		return this.a18;
	}
	public void setA18(boolean val) {
		this.a18 = val;
	}
	public boolean getA19() {
		return this.a19;
	}
	public void setA19(boolean val) {
		this.a19 = val;
	}
	public boolean getA20() {
		return this.a20;
	}
	public void setA20(boolean val) {
		this.a20 = val;
	}
	public boolean getA21() {
		return this.a21;
	}
	public void setA21(boolean val) {
		this.a21 = val;
	}
    
}