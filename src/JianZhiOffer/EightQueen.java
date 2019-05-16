package JianZhiOffer;

/**
 * 八皇后的问题
 */
public class EightQueen {
    // 全局或成员变量，下标表示行，值表示存储在哪一列
    int[]  result = new int[8];
    public void cal8queens(int row){
        // 八个棋子都放置好了，打印结果
        if (row == 8){
            printQueens(result);
            return;//8行棋子都放好了，无法继续递归，返回return
        }

        for (int column = 0; column < 8 ; column++) {
            if (isOk(row,column)){
                result[row] = column;
                // 考察下一行
                cal8queens(row+1);
            }
            
        }

    }

    private boolean isOk(int row, int column) {
        int leftup = column -1,rightup = column + 1;
        //逐行往上考虑每一行
        for (int i = row-1; i >= 0 ; --i) {
            if (result[i] == column) return false;
            // 考察左上对角线 第 i 行 leftup 列有棋子吗？
            if (leftup >= 0){
                if (result[i] == leftup) return false;
            }
            //// 考察右上对角线 第 i 行 rightup 列有棋子吗？
            if (rightup < 8){
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    // 打印二维矩阵
    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        EightQueen ss = new EightQueen();
        ss.cal8queens(8);
    }
}
