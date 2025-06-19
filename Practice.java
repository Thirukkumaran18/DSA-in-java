import java.util.*;
class Main{
 
    public static void main(String[] args){
        
        // String str = "ABC";
        // f(str, 0, "");
       HashMap<Integer, Integer> map = new HashMap<>();  
       map.put(1, 7);
       System.out.println(map.get(6));
    }

    public static void f(String str, int ind, String res){

        if(res.length() == str.length()){
            System.out.println(res);
            return;
        }

        for(int i=ind;i<str.length();i++){

        f(str, i+1, res+str.charAt(i));
        f(str, i+1, res);
        }


       
    }
}