
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args){

        String str = "Aabb";
        String res = frequencySort(str);
        System.out.println("Given String : "+str);
        System.out.println("After sorting by frequency : "+res);
    }
    public static String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue() );

        for( Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> mp = pq.poll();
            char ch = mp.getKey();
            int freq = mp.getValue();
            for(int i=0;i<freq;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

/*

Time complexity and Space complexity: 

1. Storing in map : 
    Tc : O(n) n traversal
    Sc : O(k) k storing
2. Priority queue :
    Tc : O(n * logn) n entries and each entry take logk time for insertions
    Sc : O(k) k entries
3. Building the string :
    Tc : O(n * logn + f) n*logn => entries polled, f => freq times for loop runned
    Sc : O(s) => Storing in string builder

    TC : O( n + nlogn + nlogn + f ) 
    SC : O( n+ k)

*/