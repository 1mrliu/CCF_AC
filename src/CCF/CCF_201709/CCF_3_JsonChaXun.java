package CCF_201709;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liudong on 2018/12/15.
 * JSON (JavaScript Object Notation) 是一种轻量级的数据交换格式，可以用来描述半结构化的数据。JSON 格式中的基本单元是值 (value)，出于简化的目的本题只涉及 2 种类型的值：
 　　* 字符串 (string)：字符串是由双引号 ” 括起来的一组字符（可以为空）。如果字符串的内容中出现双引号 “，在双引号前面加反斜杠，也就是用 \” 表示；如果出现反斜杠 \，则用两个反斜杠 \ 表示。反斜杠后面不能出现 ” 和 \ 以外的字符。例如：”“、”hello”、”\”\”。
 　　* 对象 (object)：对象是一组键值对的无序集合（可以为空）。键值对表示对象的属性，键是属性名，值是属性的内容。对象以左花括号 { 开始，右花括号 } 结束，键值对之间以逗号 , 分隔。一个键值对的键和值之间以冒号 : 分隔。键必须是字符串，同一个对象所有键值对的键必须两两都不相同；值可以是字符串，也可以是另一个对象。例如：{}、{“foo”: “bar”}、{“Mon”: “weekday”, “Tue”: “weekday”, “Sun”: “weekend”}。
 　　除了字符串内部的位置，其他位置都可以插入一个或多个空格使得 JSON 的呈现更加美观，也可以在一些地方换行，不会影响所表示的数据内容。例如，上面举例的最后一个 JSON 数据也可以写成如下形式。
 　　{
 　　“Mon”: “weekday”,
 　　“Tue”: “weekday”,
 　　“Sun”: “weekend”
 　　}
 　　给出一个 JSON 格式描述的数据，以及若干查询，编程返回这些查询的结果。

 输入格式
 　　第一行是两个正整数 n 和 m，分别表示 JSON 数据的行数和查询的个数。
 　　接下来 n 行，描述一个 JSON 数据，保证输入是一个合法的 JSON 对象。
 　　接下来 m 行，每行描述一个查询。给出要查询的属性名，要求返回对应属性的内容。需要支持多层查询，各层的属性名之间用小数点 . 连接。保证查询的格式都是合法的。

 输出格式
 　　对于输入的每一个查询，按顺序输出查询结果，每个结果占一行。
 　　如果查询结果是一个字符串，则输出 STRING ，其中 是字符串的值，中间用一个空格分隔。
 　　如果查询结果是一个对象，则输出 OBJECT，不需要输出对象的内容。
 　　如果查询结果不存在，则输出 NOTEXIST。

 样例输入
 10 5
 {
 “firstName”: “John”,
 “lastName”: “Smith”,
 “address”: {
 “streetAddress”: “2ndStreet”,
 “city”: “NewYork”,
 “state”: “NY”
 },
 “esc\aped”: “\”hello\””
 }
 firstName
 address
 address.city
 address.postal
 esc\aped

 样例输出
 STRING John
 OBJECT
 STRING NewYork
 NOTEXIST
 STRING “hello”

 */
public class CCF_3_JsonChaXun {
    //多层结构
    @SuppressWarnings("unchecked")
    Map<String, Object>[] map = new Map[100];

    String[] arr = {"OBJECT", "STRING", "NOTEXIST"};
    //结果
    String res = "";
    //嵌套层数
    int round = 0;

    //对象中保存的键
    String key = "";
    //对象中保存的值
    Object value = null;

    public CCF_3_JsonChaXun(){
        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<String, Object>();
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += sc.nextLine();
        }
        s = s.replaceAll(" ","");
        s = s.replaceAll("\n","");
        //处理结果
        deal(s);

        //输出结果
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            String[] string;

            //按'.'划分
            if (str.contains(".")) {
                string = str.split("[.]");
            }else{
                string = new String[1];
                string[0] = str;
            }
            int len = string.length-1;

            //根据键值对输出结果
            if (map[len+1].containsKey(string[len])) {
                Object obj = map[len+1].get(string[len]);
                if (obj instanceof String) {
                   res += arr[1] + " " + obj + "\n";
                }else{
                    res += arr[0] + "\n";
                }
            }else{
                res += arr[2] + "\n";
            }
        }
        sc.close();
        System.out.print(res);
    }

    public void deal(String s){
        for (int i = 0; i < s.length(); i++) {
            switch (s.substring(i,i+1)){
                case "{":
                    round++;
                    break;
                case "\""://以 '//'开始的字符串，进行截取
                    key = getString(s,i+1);
                    i += key.length()+1;
                    key = sloveString(key);
                    break;
                //截取':'后的值，分object和string
                case ":":
                    char c = s.charAt(i+1);
                    if (c == '"') {
                        value = getString(s, i+2);
                        i += ((String)value).length()+2;
                        value = sloveString((String)value);
                        map[round].put(key,value);
                    }else{
                        map[round].put(key, map[round+1]);
                    }
                    break;
                case "}":
                    round--;
                    break;
                default:
                    break;
            }
        }
    }

    //获取'"'开始的字符串， '\'属于字符串中的内容，算在内
    private String getString(String s, int index) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\') {
                i++;
                continue;
            }
            if (s.charAt(i) == '"') {
                return s.substring(index,i);
            }
        }
        return "";
    }
    //找出要删除字符串中的某个字符串的位置
    private String sloveString(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '\\' && (s.charAt(i+1) == '\\' || s.charAt(i+1) =='"') ) {
                s = splitString(0,s.length(), i,s);
            }
        }

        return s;
    }

    private String splitString(int startIndex, int endIndex, int index, String s) {
          return s.substring(startIndex, index) + s.substring(index+1,endIndex);
    }


    public static void main(String[] args){
         new CCF_3_JsonChaXun().run();
    }
}
