import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(3 + 3 + "7");
    }

    public static int sum(int[] a) {
        return a.length == 0 ? 0 : sum(shift(a)) + a[0];
    }

    public static double sum(double[] a) {
        return a.length == 0 ? 0 : sum(shift(a)) + a[0];
    }

    public static int countZero(int[] a) {
        return a.length == 0 ? 0 : countZero(shift(a)) + (a[0] == 0 ? 1 : 0);
    }

    public static int countPositive(int[] a) {
        return a.length == 0 ? 0 : countPositive(shift(a)) + (a[0] > 0 ? 1 : 0);
    }

    public static int countN(int[] a, int n) {
        return a.length == 0 ? 0 : countN(shift(a), n) + (a[0] == n ? 1 : 0);
    }

    public static String arrayToString(int[] a) {
        String o = "{";
        for (int i = 0; i < a.length - 1; i++)
            o += a[i] + ", ";
        return o + a[a.length - 1] + "}";
    }

    public static void printArray(int[] a) {
        System.out.println(arrayToString(a));
    }

    public static int[] copy(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }

    public static void makeReversed(int[] a) {
        int[] b = reverse(a);
        for (int i = 0; i < a.length; i++)
            a[i] = b[i];
    }

    public static double[] copy(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }

    public static int[] bigger(int[] a) {
        int[] b = new int[a.length + 1];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }

    public static int[] smaller(int[] a) {
        int[] b = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++)
            b[i] = a[i];
        return b;
    }

    public static int[] shift(int[] a) {
        int[] b = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++)
            b[i] = a[i + 1];
        return b;
    }

    public static double[] shift(double[] a) {
        double[] b = new double[a.length - 1];
        for (int i = 0; i < a.length - 1; i++)
            b[i] = a[i + 1];
        return b;
    }

    public static void makeSquared(double[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] *= a[i];
    }

    public static void makeSquared(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] *= a[i];
    }

    public static int[] square(int[] a) {
        int[] b = copy(a);
        makeSquared(b);
        return b;
    }

    public static double[] square(double[] a) {
        double[] b = copy(a);
        makeSquared(b);
        return b;
    }

    public static int[] concat2(int[] a, int[] b) {
        int[] sum = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            sum[i] = a[i];
        for (int i = 0; i < b.length; i++)
            sum[a.length + i] = b[i];
        return sum;
    }

    public static double[] concat2(double[] a, double[] b) {
        double[] sum = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            sum[i] = a[i];
        for (int i = 0; i < b.length; i++)
            sum[a.length + i] = b[i];
        return sum;
    }

    public static int[] splitDigits(int a) {
        return a == 0 ? new int[] {} : concat2(splitDigits(a / 10), new int[] { a % 10 });
    }

    public static int[] append(int[] a, int[] b) {
        return concat2(a, b);
    }

    public static int[] reverse(int[] a) {
        return a.length == 0 ? a : concat2(reverse(shift(a)), new int[] { a[0] });
    }

    public static int[] remove(int[] a, int n) {
        return a.length == 0 ? a : concat2(a[0] == n ? new int[] {} : new int[] { a[0] }, remove(shift(a), n));
    }

    public static double min(double[] a) {
        return a.length == 0 ? Double.POSITIVE_INFINITY : Math.min(a[0], min(shift(a)));
    }

    public static double max(double[] a) {
        return a.length == 0 ? Double.NEGATIVE_INFINITY : Math.max(a[0], max(shift(a)));
    }

    public static double mean(double[] a) {
        return sum(a) / a.length;
    }

    public static double median(double[] a) {
        return a.length % 2 == 0 ? (a[a.length / 2] + a[a.length / 2 - 1]) / 2 : a[a.length / 2];
    }

    public static double[] subtract(double[] a, double n) {
        return a.length == 0 ? a : concat2(new double[] { a[0] - n }, subtract(shift(a), n));
    }

    public static double standardDev(double[] a) {
        return Math.sqrt(sum(square(subtract(a, mean(a)))) / a.length);
    }

    public static void gradeLab5() {
        int score = 0;
        int number = 1;
        try {
            number = 1;
            int[] a = { 0, 4, 0, 12, 1, 6, 100, 0 };
            boolean b = sum(a) == 123;
            if (b)
                score++;
            System.out.println(number + ". sum():\t\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 2;
            int[] a = { 0, 4, 0, 12, 1, 6, 100, 0 };
            boolean b = countZero(a) == 3;
            if (b)
                score++;
            System.out.println(number + ". countZero():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 3;
            int[] a = { 0, 4, 0, -12, 1, -6, 100, 0 };
            boolean b = countPositive(a) == 3;
            if (b)
                score++;
            System.out.println(number + ". countPositive():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 4;
            int[] a = { 0, 4, 0, 12, 4, 4, 100, 0 };
            boolean b = countN(a, 4) == 3;
            if (b)
                score++;
            System.out.println(number + ". countN():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 5;
            int[] a = { 0, 4, 0, 12, 1, 6, 100, 0 };
            boolean b = arrayToString(a).equals("{0, 4, 0, 12, 1, 6, 100, 0}");
            if (b)
                score++;
            System.out.println(number + ". arrayToString():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 6;
            int[] a = { 0, 2, 4 };
            int[] c = copy(a);
            c[1] = 3;
            boolean b = a[1] == 2 && c[1] == 3 && c[2] == 4;
            if (b)
                score++;
            System.out.println(number + ". copyFunction():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 7;
            int[] a = { 1, 3, 5 };
            int[] c = bigger(a);
            boolean b = c.length == 4 && c[0] == 1 && c[1] == 3 && c[2] == 5 && c[3] == 0;
            if (b)
                score++;
            System.out.println(number + ". bigger():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 8;
            int[] a = { 1, 3, 5 };
            int[] c = bigger(a);
            boolean b = c.length == 4 && c[0] == 1 && c[1] == 3 && c[2] == 5 && c[3] == 0;
            if (b)
                score++;
            System.out.println(number + ". bigger():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 9;
            int[] a = { 1, 3, 5 };
            int[] c = smaller(a);
            boolean b = c.length == 2 && c[0] == 1 && c[1] == 3;
            if (b)
                score++;
            System.out.println(number + ". smaller():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 10;
            int[] a = { 1, -3, 5 };
            makeSquared(a);
            boolean b = a.length == 3 && a[0] == 1 && a[1] == 9 && a[2] == 25;
            if (b)
                score++;
            System.out.println(number + ". makeSquared():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 11;
            int[] a = { 1, -3, 5 };
            int[] c = square(a);
            boolean b = a.length == 3 && a[0] == 1 && a[1] == -3 && a[2] == 5 && c != null && c.length == 3 && c[0] == 1
                    && c[1] == 9 && c[2] == 25;
            if (b)
                score++;
            System.out.println(number + ". makeSquared():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 12;
            int[] a = splitDigits(2010);
            boolean b = a.length == 4 && a[0] == 2 && a[1] == 0 && a[2] == 1 && a[3] == 0;
            if (b)
                score++;
            System.out.println(number + ". splitDigits():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 13;
            int[] a = { 1, 0, 0 }, d = { 0, 2, 3, 0, 4 }, c = append(a, d);
            boolean b = c.length == 8 && c[0] == 1 && c[1] == 0 && c[2] == 0 && c[3] == 0 && c[4] == 2 && c[5] == 3
                    && c[6] == 0 && c[7] == 4;
            if (b)
                score++;
            System.out.println(number + ". append():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 14;
            int[] a = { 1, 2, 3, 4 };
            makeReversed(a);
            boolean b = a.length == 4 && a[0] == 4 && a[1] == 3 && a[2] == 2 && a[3] == 1;
            if (b)
                score++;
            System.out.println(number + ". makeReversed():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 15;
            int[] a = { 7, 8, 9, 0 };
            int[] c = reverse(a);
            boolean b = a.length == 4 && a[0] == 7 && a[1] == 8 && a[2] == 9 && a[3] == 0 && c.length == 4 && c[0] == 0
                    && c[1] == 9 && c[2] == 8 && c[3] == 7;
            if (b)
                score++;
            System.out.println(number + ". splitDigits():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 16;
            int[] a = { 1, 2, 3, 1, 1 };
            int[] c = remove(a, 1);
            boolean b = a.length == 5 && a[0] == 1 && a[1] == 2 && a[2] == 3 && a[3] == 1 && a[4] == 1 && c.length == 2
                    && c[0] == 2 && c[1] == 3;
            if (b)
                score++;
            System.out.println(number + ". remove():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 17;
            double[] a = { 1, -2, 3, 1, 1 };
            boolean b = min(a) == -2;
            if (b)
                score++;
            System.out.println(number + ". min():\t\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 18;
            double[] a = { 1, -2, 3, 1, 1 };
            boolean b = max(a) == 3;
            if (b)
                score++;
            System.out.println(number + ". max():\t\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 19;
            double[] a = { 1, 2, 4, 5, 3 };
            boolean b = mean(a) == 3;
            if (b)
                score++;
            System.out.println(number + ". mean():\t\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 20;
            double[] a = { 1, 2, 4, 6, 7 };
            boolean b = Math.abs(standardDev(a) - 2.28) < .001;
            if (b)
                score++;
            System.out.println(number + ". standardDev():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        System.out.println("Score: " + score + " / 20");
    }

}
