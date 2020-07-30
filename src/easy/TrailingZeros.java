package easy;

import java.util.ArrayList;
import java.util.List;

public class TrailingZeros {

    public static void main(String[] args) {
        int[] result = {};
        List<String> list = new ArrayList<>();
        print(13);
        print(13 << 2);
        print(13 >> 2);
        print(19);
        print(19 << 2);
        print(19 >> 2);
    }

    public static int trailingZeros(long number){
        return 0;
    }

    public static int paw(int number){
        return 1 << number;
    }

    public static void print(int number){
        System.out.println(Integer.toBinaryString(number));
    }
}
