import java.util.Calendar;

public class GetDayofUnixEpoch {
    static final int[] dayofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        Calendar today = Calendar.getInstance();
        int todayYear = today.get(Calendar.YEAR);
        int todayMonth = today.get(Calendar.MONTH) + 1;
        long todayDay = today.get(Calendar.DATE);
        long todayDayofWeek = today.get(Calendar.DAY_OF_WEEK) - 1;

        System.out.println("TODAY: year = " + todayYear +
                        ", month = " + todayMonth +
                        ", day = " + todayDay +
                        ", day of week = " + todayDayofWeek);

        long currentTimeHour = currentTime /1000 / 3600;
        long currentDay = currentTimeHour / 24;

        int year = todayYear;
        while (currentDay > 365) {
            if (checkLeapYear(year)) {
                currentDay -= 366;

            } else {
                currentDay -= 365;
            }
            year--;
        }

        todayDayofWeek = ((todayDayofWeek - currentDay) % 7 + 7) % 7;
        System.out.println("result = " + dayName[(int)todayDayofWeek]);
    }

    public static boolean checkLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
