public class CalendarUtil {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CalendarUtil <year> <month>");
            return;
        }

        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);

        printCalendar(year, month);
    }

    public static void printCalendar(int year, int month) {
        if (month < 1 || month > 12 || year < 1753) {
            System.out.println("Invalid input. Please provide a valid year (>= 1753) and month (1-12).");
            return;
        }

        String[] monthNames = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        String[] daysOfWeek = {"M", "T", "W", "T", "F", "S", "S"};
        int[] daysInMonth = {
            31, (isLeapYear(year) ? 29 : 28), 31, 30,
            31, 30, 31, 31,
            30, 31, 30, 31
        };

        System.out.println(monthNames[month - 1] + " " + year);
        for (String day : daysOfWeek) {
            System.out.print(" " + day + " ");
        }
        System.out.println();

        int dayOfWeek = getDayOfWeek(year, month, 1);

        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= daysInMonth[month - 1]; day++) {
            System.out.print(String.format("%2d", day) + " ");

            if (dayOfWeek == 6) {
                System.out.println();
            }

            dayOfWeek = (dayOfWeek + 1) % 7;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
    }
}
