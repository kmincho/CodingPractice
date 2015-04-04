package square;
/*
 * Square Interview Coding Questions:
 * How to code a program that gives you the day of the week given a date
 */

public class GetDayOfDate {
    static final int[] dayofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static final String baseDate = "29/3/2015"; //One of the Sunday
    public static void main(String[] args) {
        getDate("31/3/2007");
        getDate("30/10/1973");
        getDate("16/5/1956");
    }

    //format : DD.MM.YYYY
    public static int getDate(String dateStr) {
        int[] baseDateArray = parseDate(baseDate);
        int[] dateArray = parseDate(dateStr);

        int dayIndex = 0;
        dayIndex = dateArray[2] - baseDateArray[2];
        //count leap year
        int numLeapYear = 0;
        if (baseDateArray[2] <= dateArray[2]) {
            for (int i = baseDateArray[2]; i < dateArray[2]; i++) {
                numLeapYear += checkLeapYear(i) ? 1 : 0;
            }
        } else {
            for (int i = dateArray[2] + 1; i < baseDateArray[2]; i++) {
                numLeapYear += checkLeapYear(i) ? 1 : 0;
            }
        }
        dayIndex += baseDateArray[2] <= dateArray[2] ? numLeapYear : -numLeapYear;


        int dayIndex2 = 0;
        if (baseDateArray[1] <= dateArray[1]) {
            for (int i = baseDateArray[1]; i < dateArray[1]; i++) {
                dayIndex2 += dayofMonth[i - 1] % 7;
                if (i == 2 && checkLeapYear(dateArray[2])) {
                    dayIndex2 += 1;
                }
            }
            dayIndex2 += (dateArray[0] - baseDateArray[0]);
        } else {
            for (int i = baseDateArray[1] - 1; i >= dateArray[1]; i--) {
                dayIndex2 -= dayofMonth[i - 1] % 7;
                if (i == 2 && checkLeapYear(dateArray[2])) {
                    dayIndex2 -= 1;
                }
            }
        }
        dayIndex += dayIndex2;
        dayIndex = (dayIndex % 7 + 7) % 7;
        System.out.println(dateStr + " " + dayName[dayIndex]);
        return dayIndex;
    }

    public static boolean checkLeapYear(int i) {
        return (i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0);
    }

    public static int[] parseDate(String dateStr) {
        int[] ret = new int[3];
        String[] tokens = dateStr.split("/");

        ret[0] = Integer.valueOf(tokens[0]);
        ret[1] = Integer.valueOf(tokens[1]);
        ret[2] = Integer.valueOf(tokens[2]);
        return ret;
    }
}
