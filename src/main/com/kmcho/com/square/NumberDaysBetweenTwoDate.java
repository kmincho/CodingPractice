package com.kmcho.com.square;
/*
 * Square Interview Coding Questions:
 * Find the number of days between two dates
 */

public class NumberDaysBetweenTwoDate {
	static final int[] dayofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		System.out.println(countDaysBetweenTwoDate("1/3/1970", "2/4/2015"));
	}
	
	public static int countDaysBetweenTwoDate(String s, String e) {
		int days = 0;
		int[] start = parseDate(s);
		int[] end = parseDate(e);
		if (end[2] > start[2]) {
			days = 365 * (end[2] - start[2]);
			for (int i = start[2]; i < end[2]; i++) {
				if (checkLeapYear(i)) {
					days++;
				}
			}
		}
		int startDays = getDays(start[1], start[0]);
		int endDays  = getDays(end[1], end[0]);
		days += endDays - startDays;
		return days;
	}
	
	public static int getDays(int month, int day) {
		int days = 0;
		for (int i = 0; i < month - 1; i++) {
			days += dayofMonth[i];
		}
		days += day;
		return days;
	}
	public static boolean checkLeapYear(int i) {
		return (i % 4 == 0 && i % 100 != 0) || (i % 400 == 0);
	}
	
	//Format: DD/MM/YYYY
    public static int[] parseDate(String dateStr) {
        int[] ret = new int[3];
        String[] tokens = dateStr.split("/");

        ret[0] = Integer.valueOf(tokens[0]);
        ret[1] = Integer.valueOf(tokens[1]);
        ret[2] = Integer.valueOf(tokens[2]);
        return ret;
    }
}
