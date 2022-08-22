package main.java.ngntuli.chapter08;

public class TimeTable {
    private final Booking[][] times;

    public TimeTable(int days, int periods) {
        times = new Booking[days][periods];
    }

    public boolean makeBooking(int day, int period, Booking booking) {
        if (times[day - 1][period - 1] == null) {
            times[day - 1][period - 1] = booking;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelBooking(int day, int period) {
        if (times[day - 1][period - 1] != null) {
            times[day - 1][period - 1] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFree(int day, int period) {
        return times[day - 1][period - 1] == null;
    }

    public Booking getBooking(int day, int period) {
        if (times[day - 1][period - 1] != null) {
            return times[day - 1][period - 1];
        } else {
            return null;
        }
    }

    public int numberOfDays() {
        return times.length;

    }

    public int numberOfPeriods() {
        return times[0].length;
    }
}