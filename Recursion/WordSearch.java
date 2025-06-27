class Main{
    public static void main(String[] args){

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = exist(board, word);
        if(result){
            System.out.println("The word is present in the board");
        }else{
            System.out.println("The word is not present in the board");
        }

    }
    public static boolean exist(char[][] board, String word) {
        
        boolean visit[][] = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(i, j, board, visit, word, 0))
                    return true ;
            }
        } 

        return false;
    }
    public static boolean dfs(int x, int y, char[][] board, boolean visit[][], String word, int ind){

        if( ind == word.length() )return true;

        if(x<0 || y<0 || x>=board.length || y>= board[0].length || visit[x][y] ||board[x][y] != word.charAt(ind)){
            return false;
        }

        visit[x][y] = true;

        boolean found = dfs(x+1, y, board, visit, word, ind+1) || dfs(x-1, y, board, visit, word, ind+1) || dfs(x, y+1, board, visit, word, ind+1) || dfs(x, y-1, board, visit, word, ind+1);

        visit[x][y] = false;

        return found ;
    }
}