/**
 * @author jgz
 * @Date 2020-04-12 18:33
 */
public class Test4 {
    public int GetMaxStaffs(char[][] pos){
        int count = 0;
        boolean[][] visted = new boolean[pos.length][pos[0].length];
        int[][] dirs = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};
        for (int i=0; i<pos.length; i++){
            for (int j=0; j<pos[0].length; j++){
                if (pos[i][j] == '.'){
                    boolean tag = true;
                    for (int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= pos.length || y < 0 || y >= pos[0].length)
                            continue;
                        if (pos[x][y] == '.' && visted[x][y]){
                            tag = false;
                            break;
                        }
                    }
                    if (tag){
                        visted[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Test4().GetMaxStaffs(new char[][]{
                {'*','.','*','*','.'},
                {'*','.','*','*','*'},
                {'*','.','*','*','.'}}));
    }
}
