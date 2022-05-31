package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    
    private String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private String digits;

    private List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)) return res;
        this.digits = digits;
        backTracking(0, new StringBuffer());
        return res;
    }

    public void backTracking(int digitsIndex,StringBuffer combinations) {
        if(digits.length() ==  combinations.length()){
            res.add(combinations.toString());
            return;
        }
        String phoneString = map[digits.charAt(digitsIndex) - '0'];
        for(int i = 0; i < phoneString.length(); i++){
            combinations.append(phoneString.charAt(i));
            backTracking(digitsIndex + 1,combinations);
            combinations.deleteCharAt(digitsIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }
}
