package top;

/**
 *
 */
public class TitleToNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i] - 64;
            sum += num * Math.pow(26, array.length - i - 1);
        }
        return sum;
    }
}
