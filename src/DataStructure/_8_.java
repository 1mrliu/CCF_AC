package DataStructure;

public class _8_ {
    /**
     * 大整数相加
     * @param bigNumberA
     * @param bigNumberB
     * @return
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB){
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length():bigNumberB.length();
        int[] arrayA = new int[maxLength+1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length()-1-i) - '0';
        }

        int[] arrayB = new int[maxLength+1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length()-1-i) - '0';
        }

        int[] result = new int[maxLength+1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp > 10){
                temp -= 10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length-1; i >= 0 ; i--) {
            if (!findFirst) {
                if (result[i] == 0) continue;
            }
            findFirst = true;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
