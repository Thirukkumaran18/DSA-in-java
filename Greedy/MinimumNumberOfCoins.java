import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args){
        System.out.println(minPartition(43));
    }
    static List<Integer> minPartition(int N) {
        // code here
        
        int arr[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int r  = arr.length-1;
        List<Integer> list = new ArrayList<>();
        while(r>=0){
            
            
            while(N>=arr[r]){
                N-=arr[r];
                list.add(arr[r]);
            }
            r--;
        }
        return list;
    }
}