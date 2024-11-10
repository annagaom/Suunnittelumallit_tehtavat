package Adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = Calendar.getInstance();
    }

    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setMonth(int month) {
        // Adjusting the month as Calendar months are 0-based (January is 0, December is 11)
        calendar.set(Calendar.MONTH, month - 1);
    }

    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        // Adjusting the month to be 1-based (January is 1, December is 12)
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
