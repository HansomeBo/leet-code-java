package tree.recursion;

import java.util.ArrayList;
import java.util.List;

public class BracketLCCI {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n,n,"");
        return res;
    }


    public void generateParenthesis(int left,int right,String currString) {
        //括号合法的充分必要条件
        if(left < 0 || right < 0 || left > right) return;

        if(left == right && left == 0){
            res.add(currString);
            return;
        }
        generateParenthesis(left - 1, right, currString + "(");
        generateParenthesis(left, right - 1, currString + ")");
    }

    public static void main(String[] args) {
        System.out.println(new BracketLCCI().generateParenthesis(3));
    }

}
