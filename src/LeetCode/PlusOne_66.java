package LeetCode;

/**
 * Created by liudong on 2019/3/4.
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and
 each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.

 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
     return digits;
    }
    public static void main(String[] args){
        int[] a = new int[]{9};
        PlusOne_66 ss = new PlusOne_66();
        int[] aa = ss.plusOne(a);
        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i]);
        }

    }

}
