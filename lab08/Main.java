public class Main {
    public static void main(String[] args) {
        System.out.println(arrayToString(new int[] { 1, 2, 3, 4 }));
        System.out.println(array2dString(new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } }));
        int[][] a = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
        System.out.println(array2dString(a));
        int[][] b = expand(a);
        printStuff();
    }

    public static String arrayToString(int[] a) {
        String r = "{";
        for (int i = 0; i < a.length - 1; i++)
            r += a[i] + ", ";
        return r + a[a.length - 1] + "}";
    }

    public static String array2dString(int[][] a) {
        String r = "{";
        for (int i = 0; i < a.length - 1; i++)
            r += arrayToString(a[i]) + ",\n ";
        return r + arrayToString(a[a.length - 1]) + "}";
    }

    public static int sum2d(int[][] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                b += a[i][j];
        return b;
    }

    public static int major2d(int[][] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++)
            b += a[i][i];
        return b;
    }

    public static int minor2d(int[][] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++)
            b += a[i][a[0].length - i - 1];
        return b;
    }

    public static int sum(int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++)
            s += a[i];
        return s;
    }

    public static boolean TicTacToe(int[][] a) {
        if (Math.abs(minor2d(a)) == 3 || Math.abs(major2d(a)) == 3)
            return true;
        for (int i = 0; i < a.length; i++)
            if (Math.abs(sum(a[i])) == 3)
                return true;
        return false;
    }

    public static int min(int[] a) {
        int smol = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] < smol)
                smol = a[i];
        return smol;
    }

    public static int min2(int[][] a) {
        int smol = a[0][0];
        for (int i = 0; i < a.length; i++)
            if (min(a[i]) < smol)
                smol = min(a[i]);
        return smol;
    }

    public static int min2d(int[][] a) {
        int smol = a[0][0];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] < smol)
                    smol = a[i][j];
        return smol;
    }

    public static void rotate(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                b[j][a[0].length - i - 1] = a[i][j];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = b[i][j];
    }

    public static int[][] expand(int[][] a) {
        int[][] b = new int[a.length * 2][a.length * 2];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                b[i][j] = a[i / 2][j / 2];
        return b;
    }

    public static int getPascal(int a, int b) {
        if (a == b || b == 0)
            return 1;
        return getPascal(a - 1, b - 1) + getPascal(a - 1, b);
    }

    public static void printPascal(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(getPascal(i, j) + " ");
            System.out.print("\n");
        }
    }

    public static void printStuff() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(j + 1 + " ");
            System.out.print("\n");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++)
                System.out.print(5 - i - j + " ");
            System.out.print("\n");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(5 - i + " ");
            System.out.print("\n");
        }
    }
}
