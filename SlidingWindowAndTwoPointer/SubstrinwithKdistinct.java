
import java.util.HashMap;

class Main{
    public static void main(String[] args){
        int arr[] = {0, 1, 2, 2};
        System.out.println(totalElements(arr));
    }
    public static int totalElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0;

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            r++;

            while (map.size() > 2) {
                int leftElem = arr[l];
                map.put(leftElem, map.get(leftElem) - 1);
                if (map.get(leftElem) == 0) {
                    map.remove(leftElem);
                }
                l++;
            }

            max = Math.max(max, r - l);
        }

        return max;
    }
}