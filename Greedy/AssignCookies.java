
import java.util.Arrays;

class Main{
    public static void main(String[] args){

        int g[] = {1, 2, 3};
        int s[] = {1, 2} ;
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g) ;
        Arrays.sort(s);

        int l=0;int r=0;
        while(l<g.length && r<s.length){

            if(g[l] <= s[r]){
                l++;
            }
            r++;
        }
        return l;
    }
}