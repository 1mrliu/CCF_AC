package JianZhiOffer;

public class _65_HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 将数组全部设置为false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 循环遍历二维数组，找到起点等于str第一个元素的值，在递归判断四周是否有符合条件的
                if (judge(matrix,i,j,rows,cols,flag,str,0)){
                    return true;
                }
            }
        }

        return false;

    }
//judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        // 终止条件
        if (i<0 || j<0 || i>=rows|| j>=cols || matrix[index] != str[k] || !flag[index]){
            return false;
        }
        // 到达str的末尾，说明之前匹配的已经成功 直接返回true
        if (k == str.length-1){
            return true;
        }

        // 已经走过的第一个位置，设置为true
        flag[index] = true;
        // 回溯 递归寻找，每次找到了就给k加1，找不到，还原
        if (    judge(matrix,i-1,j,rows,cols,flag,str,k+1)||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1)||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1)||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)){
            return true;
        }

        // 走到这说明这条路不通，还原，尝试其他路径
        flag[index] = false;
        return false;




    }

}
