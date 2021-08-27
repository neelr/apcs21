package lab02;

public class Main {
    public static void main(String[] args) {
        /*
         * for (int h = 0; h < 24; h++) for (int m = 0; m < 60; m++) for (int s = 0; s <
         * 60; s++) System.out.println(timeToString(h, m, s));
         */
        gradeProject();

    }

    public static String timeToString(int h, int m, int s) {
        if (h >= 24 || m >= 60 || s >= 60)
            return "Bad Format";
        return (h > 12) ? (h - 12) + ":" + (m >= 10 ? m : "0" + m) + ":" + (s >= 10 ? s : "0" + s) + " PM"
                : (h == 0 ? 12 : h) + ":" + (m >= 10 ? m : "0" + m) + ":" + (s >= 10 ? s : "0" + s) + " AM";
    }

    public static int[] add(int h, int m, int s, int addSeconds) {
        int[] r = { (h + (m + (s + addSeconds) / 60) / 60) % 24, (m + (s + addSeconds) / 60) % 60,
                (s + addSeconds) % 60 };
        return r;
    }

    public static int differenceInSeconds(int h1, int m1, int s1, int h2, int m2, int s2) {
        return ((h2 * 60 * 60) + (m2 * 60) + s2) - ((h1 * 60 * 60) + (m1 * 60) + s1);
    }

    public static int secondsToEndOfSchool(int h, int m, int s) {
        return ((h * 60 * 60) + (m * 60) + s) >= 54000 ? 0 : 54000 - ((h * 60 * 60) + (m * 60) + s);
    }

    public static void gradeProject() {
        int score = 0;
        int number = 1;
        try {
            number = 1;
            boolean b = timeToString(0, 0, 0).equals("12:00:00 AM");
            if (b)
                score++;
            System.out.println(number + ". timeToString() midnight:\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 2;
            boolean b = timeToString(1, 12, 59).equals("1:12:59 AM");
            if (b)
                score++;
            System.out.println(number + ". timeToString() AM:\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 3;
            boolean b = timeToString(14, 50, 11).equals("2:50:11 PM");
            if (b)
                score++;
            System.out.println(number + ". timeToString() PM:\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 4;
            boolean b = timeToString(4, 9, 1).equals("4:09:01 AM");
            if (b)
                score++;
            System.out.println(number + ". timeToString() Leading Zeros:\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 5;
            int[] a = add(1, 2, 3, 4);
            boolean b = a[0] == 1 && a[1] == 2 && a[2] == 7;
            if (b)
                score++;
            System.out.println(number + ". add():\t\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 6;
            int[] a = add(1, 2, 3, 3661);
            boolean b = a[0] == 2 && a[1] == 3 && a[2] == 4;
            if (b)
                score++;
            System.out.println(number + ". add() overflow:\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 7;
            int[] a = add(23, 59, 59, 1);
            boolean b = a[0] == 0 && a[1] == 0 && a[2] == 0;
            if (b)
                score++;
            System.out.println(number + ". add() overflow day:\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 8;
            int a = differenceInSeconds(1, 1, 1, 2, 2, 2);
            boolean b = a == 3661;
            if (b)
                score++;
            System.out.println(number + ". differenceInSeconds():\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 9;
            int a = differenceInSeconds(1, 1, 1, 15, 15, 15);
            boolean b = a == 14 * 3661;
            if (b)
                score++;
            System.out.println(number + ". differenceInSeconds() big:\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 10;
            int a = secondsToEndOfSchool(1, 1, 1);
            boolean b = a == 50339;
            if (b)
                score++;
            System.out.println(number + ". secondsToEndOfSchool():\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        System.out.println("\nTotal: " + score + " / 10\n");
    }

}
