
class Main {
    public static void main(String[] args) {
        System.out.println("2a. onesDigit(987)\t\t" + onesDigit(987));
        System.out.println("2a. onesDigit(94)\t\t" + onesDigit(94));
        System.out.println("2b. tensOnesDigit(1234)\t\t" + tensOnesDigit(1234));
        System.out.println("2b. tensOnesDigit(123)\t\t" + tensOnesDigit(123));
        System.out.println("2c. tensDigit(12334)\t\t" + tensDigit(12334));
        System.out.println("2c. tensDigit(12345)\t\t" + tensDigit(12345));
        System.out.println("2d. nthDigit(1233, 3)\t\t" + nthDigit(1233, 3));
        System.out.println("2d. nthDigit(1233, 1)\t\t" + nthDigit(1233, 1));
        System.out.println("3a. digits(987)\t\t" + digits(987));
        System.out.println("3a. digits(94)\t\t" + digits(94));
        System.out.println("3b. countEvenDigits(1234)\t\t" + countEvenDigits(1234));
        System.out.println("3b. countEvenDigits(123)\t\t" + countEvenDigits(123));
        System.out.println("4a. phoneNumberToString(987, 1230030)\t\t" + phoneNumberToString(987, 1231030));
        System.out.println("4a. phoneNumberToString(944, 2811382)\t\t" + phoneNumberToString(944, 2811382));
        System.out.println("5a. getDigits(944331, 2, 1)\t\t" + getDigits(944331, 2, 1));
        System.out.println("5a. getDigits(948244, 4, 2)\t\t" + getDigits(948244, 4, 2));

        System.out.println(longDivision(7700117, 70));
    }

    public static int tensDigit(int a) {
        return (a % 100) / 10;
    }

    public static int onesDigit(int a) {
        return a % 10;
    }

    public static int countEvenDigits(int a) {
        if (a == 0)
            return 0;
        return (a % 10 + 1) % 2 + countEvenDigits(a / 10);
    }

    public static int getDigits(int a, int biggestDigit, int smallestDigit) {
        return a % power(10, biggestDigit + 1) / power(10, smallestDigit);
    }

    public static String phoneNumberToString(int areaCode, int phoneNumber) {
        return "(" + areaCode + ") " + phoneNumber / 10000 + " - " + phoneNumber % 10000;
    }

    public static int tensOnesDigit(int a) {
        return (a % 100) / 10;
    }

    public static int power(int base, int exp) {
        int ans = 1;
        for (int i = 0; i < exp; i++)
            ans *= base;
        return ans;
    }

    public static int nthDigit(int a, int n) {
        return a / power(10, n) % 10;
    }

    public static int getLength(int a) {
        if (a == 0)
            return 0;
        return 1 + getLength(a / 10);
    }

    public static int digits(int a) {
        if (a == 0)
            return 0;
        return 1 + getLength(a / 10);
    }

    public static String longDivision(int big, int small) {
        String out = "";
        int length = getLength(small) + 3;
        int bigL = getLength(big);
        out += (new String(new char[length]).replace("\0", " ")) + (big / small) + " " + (big % small) + "\n";
        out += small + " | " + big + "\n";
        int mult = 1;
        while (big >= small) {
            while (big - lowest(small, big) * mult * small > 0) {
                mult *= 10;
            }
            out += (new String(new char[-1 + length + (bigL - getLength(lowest(small, big) * small * (mult / 10)))])
                    .replace("\0", " ")) + "-" + lowest(small, big) * small + "\n";
            big = big - (lowest(small, big) * small * (mult / 10));
            mult = 1;
            out += (new String(new char[length + (bigL - getLength(big))]).replace("\0", " ")) + big + "\n";
        }
        return out;
    }

    public static int lowest(int d, int i) {
        int past = i / d;
        int result = 0;
        while (past != 0) {
            i /= 10;
            result = past;
            past = i / d;
            // System.out.println(past);
        }
        return result;
    }
}