package CCF.CCF_201912;

import java.util.Scanner;

public class CCF_2 {

    public static boolean isValid(int i, int j, int[][] mat){
        for (int k = 0; k < mat.length; k++) {
                if (mat[k][0] == i && mat[k][1] == j)return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[] score = new int[5];
        for (int i = 0; i < n ; i++) {
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (isValid(mat[i][0]+1,mat[i][1],mat)
                    && isValid(mat[i][0],mat[i][1]+1,mat)
                    && isValid(mat[i][0]-1,mat[i][1],mat)
                    && isValid(mat[i][0],mat[i][1]-1,mat)){
                if (isValid(mat[i][0]+1,mat[i][1]+1,mat))count++;
                if (isValid(mat[i][0]-1,mat[i][1]+1,mat))count++;
                if (isValid(mat[i][0]+1,mat[i][1]-1,mat))count++;
                if (isValid(mat[i][0]-1,mat[i][1]-1,mat))count++;

                score[count]++;

            }

        }

        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }



    }
}
