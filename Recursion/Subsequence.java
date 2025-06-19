
import java.util.ArrayList;

class Main{
    public static void main(String[] args){

        String str = "ABC" ;
        String res = "";

        System.out.println("Subsequence using String : ");
        allSubSequence1(str, 0, res);

        System.out.println("Subsequence using Backtracking : ");
        ArrayList<Character> list = new ArrayList<>();
        allSubSequence2(list, str, 0);
    }

    public static void allSubSequence1(String str, int index, String res){

        if(index == str.length()){
            System.out.println(res);
            return;
        }

        allSubSequence1(str, index+1, res+str.charAt(index));
        allSubSequence1(str, index+1, res);
    }
    public static void allSubSequence2(ArrayList<Character> list, String str, int index){

        if(index == str.length()){
            System.err.println(list);
            return;
        }

        list.add(str.charAt(index));
        allSubSequence2(list, str, index+1);
        list.remove(list.size() -1);
        allSubSequence2(list, str, index+1);
    }
}