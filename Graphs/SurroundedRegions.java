
class Main{
    public static void main(String[] args){
        char arr[][] = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        fill(arr);
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }


    }
    public static char[][] fill(char arr[][]) {
        // code here
        
        int n = arr.length;
        int m = arr[0].length;
        int visit[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    
                    if(visit[i][j] == 0 && arr[i][j]=='O'){
                        dfs(arr, visit, i, j);
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j] == 0 && arr[i][j] == 'O'){
                    arr[i][j] = 'X';
                }
            }
        }
        return arr;
        
    }
    public static void dfs(char arr[][], int visit[][], int x, int y){
        
        if(x<0||y<0||x>=arr.length||y>=arr[0].length||visit[x][y]==1||arr[x][y] != 'O')return;
        
        visit[x][y]=1;
        
        dfs(arr, visit, x-1, y);
        dfs(arr, visit, x+1, y);
        dfs(arr, visit, x, y+1);
        dfs(arr, visit, x, y-1);
    }   
}