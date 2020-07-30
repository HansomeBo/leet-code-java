package util;

public class StringUtil {

    public static String getNumbersSameString(String s , int number){
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < number; j++) {
            buffer.append(s);
        }
        return buffer.toString();
    }
}
