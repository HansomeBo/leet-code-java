package easy;

public class Uppercase {

    public static char paseToUppercase(char input){
        input = (char) (input - 32);
        return input;
    }

    public static void main(String[] args) {
        System.out.println(paseToUppercase('f'));
    }
}
