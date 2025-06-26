
import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args){
        int n = 5 ;
        System.out.println("All the binary string of length "+n+" are : ");
        System.out.println(validStrings(n));
    }
    public static List<String> validStrings(int n) {
        
        List<String> list = new ArrayList<>();
        String res = "";
        generate(list, res, n);
        return list;
    }
    public static void generate(List<String> list, String res, int n){

        if(res.length() == n){
            list.add(res);
            return;
        }

        int len  = res.length();
        if(len >0 && res.charAt(len-1) == '0'){
            generate(list, res+'1', n);
        }else{
            generate(list, res+'0', n);
            generate(list, res+'1', n);
        }
    }
}