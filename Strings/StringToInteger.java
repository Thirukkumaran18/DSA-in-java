class Main{
    public static void main(String[] args){

        String str = "   +-789";
        // String str = "567";

        int res = myAtoi(str);
        System.out.println("Answer : "+res);

    }
    public static int myAtoi(String s) {
        int i=0; int n = s.length();
        while(i<n && s.charAt(i)==' ')i++;
        int sign = 1;
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        int res = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            
            i++;
        }
        return res*sign;
    }
}

/*

Time complexity : O(n);
Space complexity : O(1);

*/
