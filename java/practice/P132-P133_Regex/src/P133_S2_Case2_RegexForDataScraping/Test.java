package P133_S2_Case2_RegexForDataScraping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        //Data Scraping 信息爬取

        //Procedure
        //1.Receive the data
        String data = "来黑马程序员学习Java，\n" +
                   "电话:18666688888，18699997777， \n" +
                   "或者联系邮箱:person1@example.invalid，\n" +
                   "邮箱:person2@example.invalid，\n" +
                   "邮箱:person3@example.invalid，\n" +
                   "热线电话:400-618-9090，400-618-4000，4006184000，400618909。 \n";

        //2.Write the regex (we need all the email_addresses & phone_numbers)
        String regex = "(([a-zA-Z0-9]{2,})@([a-zA-Z0-9]{2,})(\\.([a-zA-Z0-9]{2,})){1,2})|(\\+86(-|\\s?))?1[1-9](\\d{9})|(400(-?)(\\d{3,7})(-?)(\\d{3,7}))";

        //3.Encapsulate a regex into a pattern object
        Pattern pattern = Pattern.compile(regex);

        //4.Use pattern object to create a matcher for thr data
        Matcher matcher = pattern.matcher(data);

        //5.Begin to scrap the data: use while-loops
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
