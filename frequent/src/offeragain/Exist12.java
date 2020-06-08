package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 10:21
 */
public class Exist12 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()){
            return true;
        }
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }

        visited[i][j] = true;
        if (    dfs(board, visited, i-1, j, word, index+1) ||
                dfs(board, visited, i+1, j, word, index+1) ||
                dfs(board, visited, i, j-1, word, index+1) ||
                dfs(board, visited, i, j+1, word, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }


}
