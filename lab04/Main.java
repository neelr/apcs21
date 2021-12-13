
public class Main {
    public static void main(String[] args) {
        // System.out.println(pow(3, 2));
        System.out.println(4 + 2 + "7");
    }

    public static int intBinary8Bit(int a) {
        return String.valueOf(a).length() == 8 ? adder(a % (int) pow(10, String.valueOf(a).length() - 1))
                - (int) pow(2, String.valueOf(a).length() - 1) * (a / (int) pow(10, String.valueOf(a).length() - 1))
                : adder(a);
    }

    public static int intBinaryNBit(int a, int n) {
        return String.valueOf(a).length() == n ? adder(a % (int) pow(10, String.valueOf(a).length() - 1))
                - (int) pow(2, String.valueOf(a).length() - 1) * (a / (int) pow(10, String.valueOf(a).length() - 1))
                : adder(a);
    }

    public static double doubleBinary8Bit(int a) {
        return intBinaryNBit(a % 10000, 4) * Math.pow(2, intBinaryNBit(a / 10000, 4));
    }

    public static double pow(int b, int e) {
        if (e == 0)
            return 1;
        return b * pow(b, e - 1);
    }

    public static double doubleBinaryNBit(int a, int e, int m) {
        return intBinaryNBit(a % (int) Math.pow(10, m), m) * Math.pow(2, intBinaryNBit(a / (int) Math.pow(10, m), e));
    }

    public static int adder(int a) {
        if (a == 0)
            return 0;
        else if (a == 1)
            return 1;
        return (int) Math.pow(2, String.valueOf(a).length() - 1)
                * (a / (int) Math.pow(10, String.valueOf(a).length() - 1))
                + adder(a % (int) Math.pow(10, String.valueOf(a).length() - 1));
    }

    public static void gradeLab4() {
        int score = 0;
        int number = 1;
        try {
            number = 1;
            boolean b = intBinary8Bit(1001) == 9;
            if (b)
                score++;
            System.out.println(number + ". intBinary8Bit():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 2;
            boolean b = intBinary8Bit(10011100) == -100;
            if (b)
                score++;
            System.out.println(number + ". intBinary8Bit() negative:\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 3;
            boolean b = intBinaryNBit(1100, 5) == 12;
            if (b)
                score++;
            System.out.println(number + ". intBinaryNBit():\t\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 4;
            boolean b = intBinaryNBit(1000001100, 11) == 524;
            if (b)
                score++;
            System.out.println(number + ". intBinaryNBit() big:\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 5;
            boolean b = intBinaryNBit(1000001100, 11) == 524;
            if (b)
                score++;
            System.out.println(number + ". intBinaryNBit() big:\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 6;
            boolean b = intBinaryNBit(11100, 5) == -4;
            if (b)
                score++;
            System.out.println(number + ". intBinaryNBit() neg:\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 7;
            boolean b = Math.abs(doubleBinary8Bit(11) - 3) < .0001;
            if (b)
                score++;
            System.out.println(number + ". doubleBinary8Bit() mantissa:\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 8;
            boolean b = Math.abs(doubleBinary8Bit(110010) - 16) < .0001;
            if (b)
                score++;
            System.out.println(number + ". doubleBinary8Bit() exp:\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 9;
            boolean b = Math.abs(doubleBinary8Bit(1100110) - 384) < .0001;
            if (b)
                score++;
            System.out.println(number + ". doubleBinary8Bit() full:\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }
        try {
            number = 10;
            boolean b = Math.abs(doubleBinaryNBit(11001100, 3, 5) - 3) < .0001;
            if (b)
                score++;
            System.out.println(number + ". doubleBinaryNBit():\t\t\t\t\t" + b);
        } catch (Exception e1) {
            System.out.println("\n\n" + number + ". Your code crashed.");
        }

        System.out.println("\nTotal: " + score + " / 10\n");
    }

}
