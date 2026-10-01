package P133_S1_Case1_RegexForDataVerification;

public class Test {
    public static void main(String[] args) {
        //1.手机号：1开头，第二位不为0，共11位，全数字，允许以+86 /+86-/+86开头
        System.out.println("+86-13888888888".matches("(\\+86(-|\\s?))?1[1-9](\\d{9})"));

        //2.邮箱号：至少2位，数字或字母，大小写均可，@，至少2位，数字或字母，大小写均可，.，至少2位，数字或字母，大小写均可，允许1或2个域名（.xxx）
        System.out.println("user123@example.invalid".matches("([a-zA-Z0-9]{2,})@([a-zA-Z0-9]{2,})(\\.([a-zA-Z0-9]{2,})){1,2}")); //"\\w&&[^_]" is invalid ("\\x&&" is invalid)

        //3.时间：0-23，：，0-59，：，0-59
        System.out.println("18:00:32".matches("((([0-1]?)[0-9])|(1[0-3])):([0-5]?)[0-9]:([0-5]?)[0-9]"));
    }
}
