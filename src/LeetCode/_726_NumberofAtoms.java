package LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Problem:
 *
 * Given a chemical formula (given as a string), return the count of each atom.
 *
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 * Example 1:
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * Input:
 * formula = "H2O"
 * Output: "H2O"
 * Explanation:
 * The count of elements are {'H': 2, 'O': 1}.
 */

public class _726_NumberofAtoms {
    private int i;
    public String countOfAtoms(String formula){
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String,Integer> counts = countOfAtoms(formula.toCharArray());
        for (String name:counts.keySet()){
            ans.append(name);
            int count = counts.get(name);
            if (count > 1) ans.append("" + count);
        }
        return ans.toString();
    }

    private Map<String, Integer> countOfAtoms(char[] f) {
        Map<String,Integer> ans = new TreeMap<>();
        while (i != f.length){
            if (f[i] == '('){
                ++i;
                Map<String,Integer> tmp = countOfAtoms(f);
                int count = getCount(f);
                for (Map.Entry<String,Integer> entry: tmp.entrySet())
                    ans.put(entry.getKey(),ans.getOrDefault(entry.getKey(),0)+ entry.getValue() * count);
            }else if (f[i] == ')'){
                ++i;
                return ans;
            }else {
                String name = getName(f);
                ans.put(name,ans.getOrDefault(name,0) + getCount(f));
            }
        }
        return ans;
    }

    private String getName(char[] f) {
        String name = "" + f[i++];
        while (i < f.length && 'a' <= f[i] && f[i] <= 'z') {
            name += f[i++];
        }
        return name;
    }

    private int getCount(char[] f) {
        int count = 0;
        while (i < f.length && '0' <= f[i] && f[i] <= '9'){
            count = count * 10 + (f[i] - '0');
            ++i;
        }
        return count == 0 ? 1:count;
    }


}
