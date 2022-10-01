package main.java.ngntuli.chapter08;

import main.java.ngntuli.chapter07.EasyScanner;

public class TimeTableTester {
    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable(5, 7);
        char reply;

        do {
            menu();
            reply = EasyScanner.nextChar();

            switch (reply) {
                case '1':
                    try {
                        timeTable.makeBooking(enterDay(), enterPeriod(), booking());
                    } catch (TimeTableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '2':
                    try {
                        timeTable.cancelBooking(enterDay(), enterPeriod());
                    } catch (TimeTableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '3':
                    if (timeTable.isFree(enterDay(), enterPeriod())) {
                        System.out.println("Slot is free");
                    } else {
                        System.out.println("Slot is booked");
                    }
                    break;
                case '4':
                    Booking booking = timeTable.getBooking(enterDay(), enterPeriod());
                    if (booking != null) {
                        System.out.println("Room number: " + booking.getNumber());
                        System.out.println("Lecture name: " + booking.getName());
                    } else {
                        System.out.println("No booking is available in this slot");
                    }
                    break;
                case '5':
                    System.out.println("Days " + timeTable.numberOfDays());
                    System.out.println("Periods " + timeTable.numberOfPeriods());
                    break;
                case '6':
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Options [1-6]");
            }
        } while (reply != '6');
    }

    private static int enterDay() {
        System.out.print("Enter day: ");
        int day = EasyScanner.nextInt();
        while (day < 1 || day > 5) {
            System.out.println();
            System.out.print("Re enter day: ");
            day = EasyScanner.nextInt();
        }
        return day;
    }

    private static int enterPeriod() {
        System.out.print("Enter period: ");
        int period = EasyScanner.nextInt();
        while (period < 1 || period > 7) {
            System.out.println();
            System.out.print("Re enter period: ");
            period = EasyScanner.nextInt();
        }
        return period;
    }

    private static Booking booking() {
        System.out.print("Enter room number: ");
        String number = EasyScanner.nextString();

        System.out.print("Enter Lecture name: ");
        String name = EasyScanner.nextString();

        return new Booking(number, name);
    }
}
