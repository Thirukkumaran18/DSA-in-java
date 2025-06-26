import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args){

        int n = 3;
        
        System.out.println("All possible paranthesis are : ");
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        String res = "";
        int open = n ;
        int close = n;
        generate(list, res, open, close);
        return list;
    }
    public static void generate(List<String> list, String res, int open, int close){

        if (open < 0 || close < 0 || close < open) return;

        if(open == 0 && close == 0){
            list.add(res);
            return;
        }

       if (open > 0)
            generate(list, res + "(", open - 1, close);

        if (close > open)
            generate(list, res + ")", open, close - 1);
    }
}