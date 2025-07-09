import java.util.* ;

class Main{
    public static void main(String[] args){
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] res = updateMatrix(mat);

        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int[][] updateMatrix(int[][] mat) {
        int visit[][] = new int[mat.length][mat[0].length];
        int res[][] = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    visit[i][j] = 1 ;
                }
            }
        }

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];

            res[x][y] = count;

            if(x-1>=0 && visit[x-1][y] != 1){
                visit[x-1][y] = 1;
                q.add(new int[]{x-1, y, count+1});
            }

            if(x+1<mat.length && visit[x+1][y] !=1){
                visit[x+1][y] = 1;
                q.add(new int[]{x+1, y, count+1});
            }

            if(y-1>=0 && visit[x][y-1] !=1){
                visit[x][y-1] =1 ;
                q.add(new int[]{x, y-1, count+1});
            }

            if(y+1<mat[0].length && visit[x][y+1]!=1){
                visit[x][y+1] = 1;
                q.add(new int[]{x, y+1, count+1});
            }

        }
        return res;
        
    }
}