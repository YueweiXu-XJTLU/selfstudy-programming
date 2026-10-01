package P133_S3_Case3_RegexForOtherScrapingUsage;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //1.Searching Replacing: .replaceAll()
        String str = "张三asdf234李四asdfrv423423h王五";
        String result = str.replaceAll("\\w+", "-"); //.replaceAll will create a new String object
        System.out.println(result);

        String nooooo = "我爱爱爱爱爱爱爱编程程程程程程程程程程程程";
        String yes = nooooo.replaceAll("(.)\\1+", "$1"); //Use "()\\groupNumber" to state the group number, then use "$groupNumber" to call and refer to the group
        System.out.println(yes);

        //2/Searching Extracting: .split()
        String s = "张三asdf234李四asdfrv423423h王五";
        String[] names = s.split("\\w+");
        System.out.println(Arrays.toString(names));
    }
}
