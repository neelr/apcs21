public class Part2 {
    public static void main(String[] args) {
        int a = 5;
        a += (int) a / 2.0 + 1;
        System.out.println(a);
    }

    public static int safeLength(int[] a) {
        return a == null ? -1 : a.length;
    }

    public static int[] smaller(int[] a) {
        int[] b = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++)
            b[i] = a[i];
        return b;
    }

    public static int[] smallerRight(int[] a) {
        int[] b = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++)
            b[i] = a[i + 1];
        return b;
    }

    public static boolean equals(int[] a, int[] b) {
        if (safeLength(a) == 0 && safeLength(b) == 0 || (safeLength(a) == -1 && safeLength(b) == -1))
            return true;
        if (safeLength(a) == 0 || safeLength(b) == 0 || safeLength(a) == -1 || safeLength(b) == -1)
            return false;
        return a[0] == b[0] && equals(smaller(a), smaller(b));
    }

    public static double[] append(double[] a, double[] b) {
        double[] sum = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            sum[i] = a[i];
        for (int i = 0; i < b.length; i++)
            sum[a.length + i] = b[i];
        return sum;
    }

    public static String arrayToString(int[] a) {
        String o = "{";
        for (int i = 0; i < a.length - 1; i++)
            o += a[i] + ", ";
        return o + a[a.length - 1] + "}";
    }

    public static String equalityType(int[] a, int[] b) {
        if (a == b)
            return "==";
        if (equals(a, b))
            return "equals";
        return "!=";
    }

    public static int getIndex(int[] a, int index) {
        return index < 0 ? a[a.length + index] : a[index];
    }

    public static int[] cutLeft(int[] a, int end) {
        return end == 0 ? a : cutLeft(smaller(a), end - 1);
    }

    public static int[] cutRight(int[] a, int end) {
        return end == 0 ? a : cutRight(smallerRight(a), end - 1);
    }

    public static int[] subArray(int[] a, int start, int end) {
        return cutRight(cutLeft(a, start), a.length - end);
    }
}
