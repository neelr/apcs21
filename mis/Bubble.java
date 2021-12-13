import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] b = { 3, 2, 5, 1, 4 };
        bubbleSort(b);
        System.out.println(Arrays.toString(b));
    }

    public static void bubble(int[] a) {
        for (int b = 0; b < a.length - 1; b++) {
            if (a[b] > a[b + 1]) {
                int buf = a[b];
                a[b] = a[b + 1];
                a[b + 1] = buf;
            }
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            for (int b = 0; b < a.length - 1; b++) {
                if (a[b] > a[b + 1]) {
                    int buf = a[b];
                    a[b] = a[b + 1];
                    a[b + 1] = buf;
                }
            }
        }
    }
}
