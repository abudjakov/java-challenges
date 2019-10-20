package classic;

/**
 * Convert the string number to decimal
 * <p>
 * Input: str = "1100", base = 2
 * Output: 12
 * <p>
 * Input: str = "11A", base = 16
 * Output: 282
 * <p>
 * Input: str = "123",  base = 8
 * Output: 83
 */
public class ConvertBaseToDecimal {

    public static int toDecimal(String value, int base) {
        int decimal = 0;
        int power = 1;
        for (int i = value.length() - 1; i >= 0; i--) {
            int val = Character.getNumericValue(value.charAt(i));
            if (val > base) {
                return -1;
            }
            decimal += val * power;
            power *= base;
        }

        return decimal;
    }

    public static String fromDecimal(int value, int base) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int reminder = value % base;
            value = value / base;
            sb.append(Character.forDigit(reminder, base));

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toDecimal("1100", 2)); // 12
        System.out.println(toDecimal("11A", 16)); // 282
        System.out.println(toDecimal("123", 8)); // 83

        System.out.println(fromDecimal(12, 2));  // 1100
        System.out.println(fromDecimal(282, 16));  // 11A
        System.out.println(fromDecimal(83, 8));  // 123
    }
}
