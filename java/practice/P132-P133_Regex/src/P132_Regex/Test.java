package P132_Regex;

public class Test {
    public static void main(String[] args) {
        //Regex 正则表达式
        //used for String, call .match() method

        // 1. 字符类（只能匹配单个字符）（中文字符不可匹配）
        //匹配是否属于字符类 [abc]
        System.out.println("a".matches("[abc]")); // true
        System.out.println("e".matches("[abcd]")); // false

        //匹配是否不属于字符类 [abc]
        System.out.println("d".matches("[^abc]")); // true
        System.out.println("a".matches("[^abc]")); // false

        //匹配是否为大小写英文字母
        System.out.println("b".matches("[a-zA-Z]")); // true
        System.out.println("2".matches("[a-zA-Z]")); // false

        //匹配是否为 a-z 且排除b和c
        System.out.println("k".matches("[a-z&&[^bc]]")); // true
        System.out.println("b".matches("[a-z&&[^bc]]")); // false

        //：匹配是否为单个字母或数字
        System.out.println("ab".matches("[a-zA-Z0-9]")); // false



        // 2. 预定义字符（只能匹配单个字符）（中文字符不可匹配）（\\ == "\"）
        //匹配是否为任意单个字符
        System.out.println(".".matches(".")); // true
        System.out.println("徐".matches(".")); // true

        //匹配是否为单个数字
        System.out.println("1".matches("\\d")); // true
        System.out.println("12".matches("\\d")); // false

        //匹配是否为空白字符
        System.out.println(" ".matches("\\s")); // true
        System.out.println("a".matches("\\s")); // false
        //匹配是否不为空白字符
        System.out.println(" ".matches("\\s")); // false
        System.out.println("a".matches("\\s")); // true

        //匹配是否为字母、数字或下划线(a-zA-Z0-9_)
        System.out.println("a".matches("\\w")); // true
        System.out.println("徐".matches("\\w")); // false
        //匹配是否不为字母、数字或下划线(a-zA-Z0-9_)
        System.out.println("a".matches("\\W")); // false
        System.out.println("徐".matches("\\W")); // true



        // 3. 数量词 （中文字符不可匹配）
        //{n} 匹配字符串是否为恰好n个单字符
        System.out.println("a3c".matches("\\w{3}")); // true：
        System.out.println("abcd".matches("\\w{3}")); // false
        System.out.println("ab".matches("\\w{3}")); // false

        //{n, } 匹配字符串是否为至少n个单字符 （要求 >=n ）
        System.out.println("abcde徐".matches("\\w{3,}")); // false

        //{n, m} 匹配字符串是否为n到m个单字符 （要求 >=n&&<=m ）
        System.out.println("abc232d".matches("\\w{3,9}")); // true

        //? == {0, 1}
        System.out.println("a".matches("\\w?")); // true
        System.out.println("".matches("\\w?")); // true
        System.out.println("abc".matches("\\w?")); // false

        //* == {0, }
        System.out.println("abc12".matches("\\w*")); // true
        System.out.println("".matches("\\w*")); // true
        System.out.println("abc12张".matches("\\w*")); // false

        //+ == {1, }
        System.out.println("abc12".matches("\\w+")); // true
        System.out.println("".matches("\\w+")); // false
        System.out.println("abc12张".matches("\\w+")); // false



        // 4. 其他常用符号
        // 1. (?i) 忽略大小写
        System.out.println("aBc".matches("(?i)abc")); // true
        System.out.println("aBc".matches("a(?i)(b)c")); // true

        // 2. | 或
        System.out.println("abc".matches("\\d{3}|[a-z]{3}")); // true
        System.out.println("123".matches("\\d{3}|[a-z]{3}")); // true

        // 3. () 分组
        System.out.println("六六六六666".matches("六(六六六)+(666)+")); // true
        System.out.println("六六六六6666".matches("六(六六六)+(666)+")); // false

    }
}
