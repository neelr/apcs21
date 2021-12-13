import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testCode1();
        testCode2();
        testCode3();
        testCode4a();
        testCode4c();
        testCode5();
    }

    public static void testCode4a() {
        int[] a = { 1, 3, 4, 8, 5, 7, 6, 2 };
        if (smallestIndex1(a) == 0)
            System.out.println("4a works");
    }

    public static void testCode4c() {
        int[] a = { 1, 3, 4, 8, 5, 7, 6, 2 };
        if (smallest(3, a) == 7)
            System.out.println("4c works");
    }

    public static void testCode5() {
        int[] a = { 1, 3, 4, 8, 5, 7, 6, 2 };
        int[] r = { 1, 2, 3, 4, 5, 6, 7, 8 };
        ss(a);
        for (int i = 0; i < a.length; i++)
            if (r[i] != a[i]) {
                System.out.println("Failed");
                return;
            }
        System.out.println("5 worked");
    }

    public static void testCode3() {
        int[] a = { 1, 3, 4, 8 }, b = { 1, 3, 4, 8 };
        int[] r = merge(a, b);
        int[] re = { 1, 1, 3, 3, 4, 4, 8, 8 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }

        a = null;
        b = new int[] { 1, 2, 3 };
        r = merge(a, b);
        re = new int[] { 1, 2, 3 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }

        a = new int[] { 1, 2, 3 };
        b = null;
        r = merge(a, b);
        re = new int[] { 1, 2, 3 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }
        System.out.println("part 3 works");
    }

    public static int[] collate2(int[] a, int[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int[] r = new int[a.length + b.length];
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            if (i == a.length) {
                for (int j = 0; j < b.length - i; j++)
                    r[i * 2 + j] = b[i + j];
                break;
            } else if (i == b.length) {
                for (int j = 0; j < a.length - i; j++)
                    r[i * 2 + j] = a[i + j];
                break;
            }
            r[i * 2] = a[i];
            r[i * 2 + 1] = b[i];
        }
        return r;
    }

    public static void testCode2() {
        int[] a = { 1, 2, 3, 4, 5 }, b = { 6, 7, 8 };
        int[] r = collate2(a, b);
        int[] re = { 1, 6, 2, 7, 3, 8, 4, 5 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }

        a = null;
        b = new int[] { 1, 2, 3 };
        r = collate2(a, b);
        re = new int[] { 1, 2, 3 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }

        a = new int[] { 1, 2, 3 };
        b = null;
        r = collate2(a, b);
        re = new int[] { 1, 2, 3 };
        for (int i = 0; i < r.length; i++)
            if (r[i] != re[i]) {
                System.out.println("Failed");
                return;
            }
        System.out.println("part 2 works");
    }

    public static int[] collate3(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null)
            return null;
        int[] r = new int[a.length * 3];
        for (int i = 0; i < a.length; i++) {
            r[i * 3] = a[i];
            r[i * 3 + 1] = b[i];
            r[i * 3 + 2] = c[i];
        }
        return r;
    }

    public static void testCode1() {
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        int[] c = { 1, 2, 3 };
        int[] ans = collate3(a, b, c);
        int[] correct = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
        boolean allElementsMatch = true;
        for (int i = 0; i < correct.length; i++)
            allElementsMatch &= ans[i] == correct[i];
        if (allElementsMatch)
            System.out.println("Part 1 works!!!");
        else
            System.out.println("Part 1 back to the drawing board");
    }

    public static int smallest(int i, int[] input) {
        int min = i;
        for (int j = i; j < input.length; j++)
            if (input[j] < input[min])
                min = j;
        return min;
    }

    public static int smallestIndex1(int[] a) {
        return smallest(0, a);
    }

    public static void ss(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i; j < input.length; j++)
                if (input[j] < input[min])
                    min = j;
            int buff = input[i];
            input[i] = input[min];
            input[min] = buff;
        }
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int ap = 0;
        int bp = 0;
        int[] r = new int[a.length + b.length];
        for (int i = 0; i < r.length; i++) {
            if (ap == a.length) {
                r[i] = b[bp];
                bp++;
                continue;
            } else if (bp == b.length) {
                r[i] = a[ap];
                ap++;
                continue;
            }
            if (a[ap] < b[bp]) {
                r[i] = a[ap];
                ap++;
            } else {
                r[i] = b[bp];
                bp++;
            }
        }
        return r;
    }

}
