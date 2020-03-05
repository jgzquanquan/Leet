/**
 * @author jgz
 * @Date 2020-03-03 17:40
 */
public class WordSearch {

    boolean[][] visted;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board.length * board[0].length < word.length())
        {
            return false;
        }

        visted = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (word.charAt(0) == board[i][j] && search(board, 0, word, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int index, String word, int i, int j) {
        if (index == word.length()){
            return true;
        }

        if (i<0 || i>=board.length || j<0 || j>=board[0].length || visted[i][j] || board[i][j]!=word.charAt(index)){
            return false;
        }

        visted[i][j] = true;

        if (search(board, index+1, word, i-1, j) ||
                search(board, index+1, word, i, j+1)||
                search(board, index+1, word, i, j-1)||
                search(board, index+1, word, i+1, j)){
            return true;
        }
        visted[i][j] = false;
        return false;
    }
}
