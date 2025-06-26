class Main{
    public static void main(String[] args){
        // input 1 : 
        double x = 2.00000;
        int n = 10;

        double res = myPow(x, n);
        System.out.println("Result : "+res);

        /*
        input 2 :
        double x = 2.00000;
        int n = -2
        */
    }
    public static double myPow(double x, int n) {
        long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    private static double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
                                                                            
    }
}