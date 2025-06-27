import java.util.ArrayList;
import java.util.List;


class Main{
    public static void main(String[] args){

        int k = 9 ; int n = 45 ;
        /*
        Testcases:
        k = 3, n = 7
        k = 3, n = 9
        k = 4, n = 1
        */
        System.out.println(combinationSum3(k, n));
        
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper1(mainList, list, 1, k, 0, n);
        return mainList;
    }
    public static void helper1(List<List<Integer>> mainList, List<Integer> list, int ind, int k, int sum, int n){

        if(ind > n || ind >9){
            if(sum == n && list.size() == k){
                mainList.add(new ArrayList<>(list));
            }
            return ;
        }

        list.add(ind);     
        helper1(mainList, list, ind+1, k, sum+ind, n);

        list.remove(list.size()-1);
        helper1(mainList, list, ind+1, k, sum, n);
    }
}