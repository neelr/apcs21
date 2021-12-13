public class Main {
    public static void main(String[] args) {
        System.out.println("x");
    }

    public static Time createTime(int h, int m, int s, boolean ia) {
        Time t = new Time();
        t.hour = h;
        t.minute = m;
        t.second = s;
        t.isAM = ia;
        return t;
    }

    // In the Main class, create a function called timeToString() that takes a Time
    // object and returns a String representing that Time in the format "12:09:57
    // PM".
    public static String timeToString(Time t) {
        return (t.hour) + ":" + t.minute + ":" + t.second;
    }

    // In the Main class, create a function called test1() that creates and prints 2
    // Times representing the start and end of the period.
    public static void test1() {
        Time first = createTime(8, 30, 00, true);
        Time end = createTime(9, 10, 00, true);
        System.out.println(timeToString(first));
        System.out.println(timeToString(end));
    }

    // In the Main class, create a function called addSeconds() that takes a Time
    // object and a number of seconds to add, and returns the Time that many seconds
    // in the future. Precondition: The number of seconds will be positive.
    public static Time addSeconds(Time t, int s) {
        return createTime(t.hour + s / 60 / 60, t.minute + s / 60, t.second + s % 60, t.isAM);
    }

    // In the Main class, create a function called equals() that takes 2 Time
    // objects, and returns whether or not they represent the same Time.
    public static boolean equals(Time t1, Time t2) {
        return t1.hour == t2.hour && t1.minute == t2.minute && t1.second == t2.second && t1.isAM == t2.isAM;
    }

    // Using the functions #5, #6, and a loop, create a function called
    // secondsBetween() that is given 2 Time objects, and returns the number of
    // seconds between them. Precondition: The first time is before the second time
    // in the same day.
    public static int secondsBetween(Time t1, Time t2) {
        int s = 0;
        while (!equals(t1, t2)) {
            t1 = addSeconds(t1, 1);
            s++;
        }
        return s;
    }
}

// Create a class called Time, whose objects have ints hour, minute, second, and
// a boolean isAM which is true when the time is AM, and is false when the time
// is PM.
class Time {
    public int hour, minute, second;
    public boolean isAM;
}