public class Main {
    public static void main(String[] args) {

    }

    int[] collate3(int[] a, int[] b, int[] c) {
        int x = new int[a.length * 3];
        for (int i = 0; i<a.length; i++) {
            x[i*3] = a[i];
            x[i*3+1] = b[i];
            x[i*3+2] = c[i];
        }
    }
}
