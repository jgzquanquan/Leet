public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }

        char origin[] =  haystack.toCharArray();
        char target[] =  needle.toCharArray();
        for (int i = 0;i <origin.length;i++){
            if (origin[i] == target[0]){
                if (i+target.length > origin.length){
                    return -1;
                }else {
                    for (int j = i;j < i+target.length;j++){
                        if (origin[j] != target[j-i]){
                            break;
                        }
                        if (j == i + target.length -1){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi","issip"));
    }
}
