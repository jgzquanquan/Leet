package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-28 15:18
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> track = new ArrayList<>();
        String tmp = String.join("", Collections.nCopies(n,"."));
        for (int i=0; i<n; i++){
            track.add(tmp);
        }
        backTrack(res, n, track, 0);
        return res;
    }

    private void backTrack(List<List<String>> res, int n, List<String> track, int row) {
        if (row == n){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int col = 0; col<n; col++){
            if (!isValid(row, col, track)){
                continue;
            }
            setChar(track, row, col, 'Q');
            backTrack(res, n, track, row+1);
            setChar(track, row, col, '.');
        }


    }

    private void setChar(List<String> track, int row, int col, char q) {
        StringBuilder str = new StringBuilder(track.get(row));
        str.setCharAt(col,q);
        track.set(row, str.toString());

    }

    private boolean isValid(int row, int col, List<String> board) {
        for (int i = 0; i < row; ++i){
            if (board.get(i).charAt(col)=='Q'){
                return false;
            }
        }

        for (int i=row-1,j=col-1;i>=0&&j>=0;--i,--j){
            if (board.get(i).charAt(j)=='Q'){
                return false;
            }
        }

        for (int i=row-1,j=col+1;i>=0&&j<board.size();--i,++j){
            if (board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4).size());
    }
}
