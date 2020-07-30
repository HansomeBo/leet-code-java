package easy;

public class ReverseNumber {

    public static int reverseInteger(int number){
        int a = number%10;
        number = number - a;
        int b = number%100/10;
        number = number - b;
        int c = number%1000/100;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return a*100 + b*10 + c;
    }

    public static int reverseInteger2(int number){
        String tmp = String.valueOf(number);
        String[] s = tmp.split("");
        String result = "";
        for (int i = s.length - 1; i >= 0 ; i --){
            result = result + s[i];
        }
        return Integer.valueOf(result);
    }



    public static void main(String[] args) {
        System.out.println(reverseInteger2(124466763));
    }
}
