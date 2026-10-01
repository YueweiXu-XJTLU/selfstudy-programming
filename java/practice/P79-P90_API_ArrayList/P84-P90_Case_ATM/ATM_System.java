package S9_Case_ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM_System {
    //创建封装账户的容器，一定要先private！！！
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in); //private
    private int input; //private
    private Account loginAccount;
    private Account transferTargetAccount;

    //启动系统
    public void start() {
        while (true) {
            //展示欢迎页面
            System.out.println("----------欢迎进入ATM系统----------");
            System.out.println("1.登录");
            System.out.println("2.开户");
            System.out.println("请输入：");
            input = sc.nextInt();
            sc.nextLine();

            //判断第一个指令
            switch (input) {
                case 1:
                    //登录
                    logIn();
                    break;
                case 2:
                    //开户
                    createAccount();
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
            }
        }
    }



    //登陆方法
    public void logIn() {
        System.out.println("---欢迎进入登陆界面---");

        //判断系统中有无账户
        if (accounts.size() == 0) {
            System.out.println("系统中暂时无账户，请创建新账户");
            return;
        }

        //若有账户：
        //判断卡号是否存在
        String input_cardID = new String();
        String input_password =new String();
        Account temp_account = new Account();
        int command;

        Outer:
        while (true) {
            System.out.println("请输入卡号：");
            input_cardID = sc.nextLine();
            temp_account = searchForAccountUsingCardID(input_cardID);
            if (temp_account != null) {
                    //卡号存在，输入密码并二次确认
                    Inner:
                    while (true) {
                        System.out.println("请输入账户密码：");
                        input_password = sc.nextLine();
                        if (!(passwordValid(input_password))) {
                            System.out.println("密码不合理，请重新输入！");
                            continue Inner;
                        }
                        if (input_password.equals(temp_account.getPassword())) {
                            this.loginAccount = temp_account;
                            System.out.println("尊敬的" + this.loginAccount.getName() + (this.loginAccount.getGender() == 'M'? "先生":"女士") + "，欢迎您登录账户！");

                            //展示账户界面
                            accountPage();
                            return;
                        } else {
                            System.out.println("密码有误，请重新输入！");
                    }
            }
                } else {
                Inner2:
                while (true) {
                    System.out.println("卡号不存在!");
                    System.out.println("1.重新输入");
                    System.out.println("2.退出");
                    System.out.println("请输入：");
                    command = sc.nextInt();
                    sc.nextLine();
                    switch (command) {
                        case 1:
                            break Inner2;
                        case 2:
                            break Outer;
                        default:
                            System.out.println("输入有误，请重新输入！");
                    }
                }
            }
        }
    }





    private void accountPage() {
        while (true) {
            System.out.println("---请选择您需要办理的业务---");
            System.out.println("1.查询账户信息");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出登录");
            System.out.println("7.注销账户");
            System.out.println("请输入指令：");

            input = sc.nextInt();
            sc.nextLine();

            //判断用户指令
            switch (input) {
                case 1:
                    //查询账户信息
                    showAccount();
                    break;
                case 2:
                    //存款
                    depositMoney();
                    break;
                case 3:
                    //取款
                    withdrawalMoney();
                    break;
                case 4:
                    //转账
                    transferMoney();
                    break;
                case 5:
                    //修改密码
                    if (changePassword()) {
                        break;
                    } else {
                        return;
                    }
                case 6:
                    //退出登录
                    System.out.println("已退出！");
                    return; //结束当前方法
                case 7:
                    //注销账户
                    if (deleteAccount()) {
                        break;
                    } else {
                        return;
                    }
                default:
                    System.out.println("输入有误，请重试！");
            }
        }

    }

    private boolean changePassword() {
        String oldPassword = new String();
        String newPassword1 = new String();
        String newPassword2 = new String();

        while1:
        while (true) {
            System.out.println("请输入旧密码(输入-1退出该界面)：");
            oldPassword = sc.nextLine();
            //判断旧密码是否正确
            if (oldPassword.equals(loginAccount.getPassword())) {


                //第一次输入新密码
                while2:
                while (true) {
                System.out.println("请输入新密码(输入-1退出该界面)：");
                newPassword1 = sc.nextLine();
                if (newPassword1.equals("-1")) {
                    return true;
                } else if (newPassword1.equals(loginAccount.getPassword())) {
                    System.out.println("新密码不能与旧密码一致，请重新输入！");
                } else if (passwordValid(newPassword1)) {


                    //第二次输入新密码
                    System.out.println("请再次输入新密码：");
                    newPassword2 = sc.nextLine();
                    if (newPassword1.equals(newPassword2)) {
                        //新密码一致，修改密码
                        loginAccount.setPassword(newPassword1);
                        return false;
                    } else {
                        System.out.println("两次密码不一致，请重新输入！");
                        continue while2;
                    }



                } else {
                    System.out.println("新密码不合理，请重试！");
                }


                }


            } else if (oldPassword.equals("-1")) {
                return true;
            } else {
                System.out.println("密码有误，请重新输入！");
            }


        }
    }

    private boolean deleteAccount() {
        String command = new String();

        //账户中若有余额，无法销户
        if (loginAccount.getBalance() != 0.0) {
            System.out.println("账户中有余额" + loginAccount.getBalance() + "元，无法销户！");
            return true;
        }

        //确认销户
        while (true) {
            System.out.println("您确定要销户吗？（Y/N）");
            command = sc.nextLine();

            //here we can also use SWITCH if we only want to adjust "Y" or "N"
            if (command.equals("Y")) {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getCardID() == loginAccount.getCardID()) {
                        accounts.remove(i);
                        System.out.println("销户成功！");
                        return false;
                    }
                }
            } else if (command.equals("N")) {
                return false;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }


    }

    private void transferMoney() {
        //系统中不足两个账户则无法转账
        if (accounts.size() < 2) {
            System.out.println("账户中不足两个用户，无法转账！");
            return;
        }

        //判断是否有余额
        if (loginAccount.getBalance() < 0.0) {
            System.out.println("当前余额：" + loginAccount.getBalance() + "，余额不足，无法转账！");
            return;
        }

        //开始转账流程
        String targetCardID;
        double transferMoney;
        String staredName= new String();
        String inputFamilyName = new String();
        int input;

        While_1:
        while (true) {
            System.out.println("请输入目标转账账户的卡号：");
            targetCardID = sc.nextLine();
            for (int i = 0; i < accounts.size(); i++) {
                if(!(targetCardID.equals(loginAccount.getCardID())) && targetCardID.equals(accounts.get(i).getCardID())) {
                  transferTargetAccount = accounts.get(i);

                  //输入卡号对应到账户
                  While_2:
                  while (true) {
                    System.out.println("请输入转账金额：");
                    transferMoney = sc.nextDouble();
                    sc.nextLine();

                    //判断余额不足与超限额情况
                    if (transferMoney > loginAccount.getBalance()) {
                        System.out.println("当前余额：" + loginAccount.getBalance() + "，余额不足，无法转账！");
                        While_3:
                        while (true) {
                            System.out.println("1.继续转账");
                            System.out.println("2.返回账户界面");
                            System.out.println("请输入:");
                            input = sc.nextInt();
                            sc.nextLine();

                            switch (input) {
                                case 1:
                                    continue While_2;
                                case 2:
                                    return;
                                default:
                                    System.out.println("输入指令无效，请重新输入！");

                            }
                        }
                    } else if (transferMoney > loginAccount.getWithdrawalLimits()) {
                          System.out.println("当前账户提款限额：" + loginAccount.getWithdrawalLimits() + "，超过限额，无法转账！");
                        While_4:
                        while (true) {
                            System.out.println("1.继续转账");
                            System.out.println("2.返回账户界面");
                            System.out.println("请输入:");
                            input = sc.nextInt();
                            sc.nextLine();

                            switch (input) {
                                case 1:
                                    continue While_2;
                                case 2:
                                    return;
                                default:
                                    System.out.println("输入指令无效，请重新输入！");

                            }
                        }
                    } else {
                        //确认收款人姓名
//                        char[] nameCharArray = new char[transferTargetAccount.getName().length()];
//                        for (int j = 0; j < transferTargetAccount.getName().length();j ++) {
//                            nameCharArray[j] = transferTargetAccount.getName().charAt(j);
//                        }
//                        nameCharArray[0] = '*';
//
//                        for (int k = 0; k < nameCharArray.length; k++) {
//                            staredName += nameCharArray[k];
//                        }
                        staredName = "*" + transferTargetAccount.getName().substring(1); //a much more elegant way

                        While_5:
                        while (true) {
                            System.out.println("请补全收款人姓氏：" + staredName);
                            System.out.println("请输入：");
                            inputFamilyName = sc.nextLine();
//                            if (inputFamilyName.charAt(0) == transferTargetAccount.getName().charAt(0)) {
                            if (inputFamilyName.startsWith(transferTargetAccount.getName().substring(0,1))) { //a slightly more elegant way
                                  loginAccount.setBalance(loginAccount.getBalance() - transferMoney);
                                transferTargetAccount.setBalance(transferTargetAccount.getBalance() + transferMoney);
                                System.out.println("转账成功！");
                                System.out.println("已转出：" + transferMoney + "元， 当前账户余额：" + loginAccount.getBalance() + "元");
                                return;
                             } else {
                               System.out.println("姓氏不正确！");
                            }
                        }
                    }
                  }
                }
            }
            System.out.println("账户无效！");
            While_6:
            while (true) {
                System.out.println("1.继续提款");
                System.out.println("2.返回账户界面");
                System.out.println("请输入:");
                input = sc.nextInt();
                sc.nextLine();

                switch (input) {
                    case 1:
                        continue While_1;
                    case 2:
                        return;
                    default:
                        System.out.println("输入指令无效，请重新输入！");

                }
            }
        }
    }

    private void withdrawalMoney() {
        double withdrawalMoney;
        While_1:
        while (true) {
            System.out.println("请输入取款金额：");
            withdrawalMoney = sc.nextDouble();
            sc.nextLine();

            if (withdrawalMoney <= 0.0) {
                System.out.println("请输入正确的金额！");
            } else if (withdrawalMoney > loginAccount.getBalance()) {
                System.out.println("余额：" + loginAccount.getBalance() + "元，余额不足！");
                while (true) {
                    System.out.println("1.继续提款");
                    System.out.println("2.返回账户界面");
                    System.out.println("请输入:");
                    input = sc.nextInt();
                    sc.nextLine();

                    switch (input) {
                        case 1:
                            continue While_1;
                        case 2:
                            return;
                        default:
                            System.out.println("输入指令无效，请重新输入！");

                    }
                }
            } else if (withdrawalMoney > loginAccount.getWithdrawalLimits()) {
                System.out.println("您的账户最大取款限额为：" + loginAccount.getWithdrawalLimits() + "元，超出最大取款限额！");
                while (true) {
                    System.out.println("1.继续转账");
                    System.out.println("2.返回账户界面");
                    System.out.println("请输入:");
                    input = sc.nextInt();
                    sc.nextLine();

                    switch (input) {
                        case 1:
                            continue While_1;
                        case 2:
                            return;
                        default:
                            System.out.println("输入指令无效，请重新输入！");

                    }
                }
            } else {
                loginAccount.setBalance(loginAccount.getBalance() - withdrawalMoney);
                System.out.println("已取出" + withdrawalMoney + "元，账户余额为" + loginAccount.getBalance() + "元");
                break;
            }
        }
    }

    private void depositMoney() {
        System.out.println("请输入存款金额：");
        double depositMoney = sc.nextDouble();
        loginAccount.setBalance(loginAccount.getBalance() + depositMoney);
        System.out.println("您已成功存入" + depositMoney + "元，您现在的的账户余额为："  + loginAccount.getBalance()); //not simply "getBalance += depositMoney"
    }

    private void showAccount() {
        System.out.println("以下为该账户的信息：");
        System.out.println("姓名：" + loginAccount.getName());
        System.out.println("性别：" + loginAccount.getGender());
        System.out.println("卡号：" + loginAccount.getCardID());
        System.out.println("余额：" + loginAccount.getBalance());
        System.out.println("提现最大额度：" + loginAccount.getWithdrawalLimits());
    }





    //开户方法（完全由ATM_System内部调用，最好直接private）
    private void createAccount() {
        //1.创建用户对象
        Account account = new Account();

        //2.1.接收姓名
        System.out.println("请输入姓名：");
        account.setName(sc.nextLine());

        //2.2.接收性别
        char temp_gender;
        while (true) {
            System.out.println("请输入性别（M/F）：");
            temp_gender = sc.nextLine().charAt(0);
            if (temp_gender == 'M' || temp_gender == 'F') {
                account.setGender(temp_gender);
                break;
            } else {
                System.out.println("No LGBT!!!");
            }
        }

        //2.3.接收并二次确认密码
        String temp_password = new String();
        String temp_password2 = new String();
        while (true) {
            System.out.println("请输入密码(6位数)：");
            temp_password = sc.nextLine();
            if (!(passwordValid(temp_password))) {
                System.out.println("密码不合理，请输入6位数字密码！");
                continue;
            }
            System.out.println("请确认密码：");
            temp_password2 = sc.nextLine();
            if (!(temp_password.equals(temp_password2))) {
                System.out.println("两次输入的密码不一致！");
            } else {
                account.setPassword(temp_password);
                break;
            }
        }

        //2.4.接收提现额度
        double temp_withdrawalLimit;
        while (true) {
        System.out.println("请输入提现最大额度：");
        temp_withdrawalLimit = Double.parseDouble(sc.nextLine());
        if (temp_withdrawalLimit >= 0.0) {
        account.setWithdrawalLimits(temp_withdrawalLimit);
        break;
        } else {
            System.out.println("请输入正确的提现最大额度！");
        }
        }

        //2.5.随机生成卡号(随机8位数， 不可重复)
        char c;
        String temp_cardID = new String();
        boolean notRepeated = true;
        while (true) {
            for (int i = 0; i < 8; i++) {
             c = (char)(48 + (int) (Math.random() * 10));
             temp_cardID += c;
            }
            //判断是否重复：根据卡号查询集合中的Account对象（这个需求要多次用到，单独写成方法）
            if (searchForAccountUsingCardID(temp_cardID) == null) {
                account.setCardID(temp_cardID);
                break;
            }
        }

        //3.将账号存入ATM系统，提示创建成功
        accounts.add(account);
        System.out.println("尊敬的" + account.getName() + (account.getGender() == 'M'? "先生":"女士") + "，恭喜您开户成功，您的卡号是：" + account.getCardID());
    }

    //判断输入的密码是否合理
    private boolean passwordValid(String tempPassword) {
        if (tempPassword.length() != 6) {
            return false;
        }

        for (int i = 0; i < tempPassword.length(); i++) {
            if (tempPassword.charAt(i) < 48 || tempPassword.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    private Account searchForAccountUsingCardID(String cardID) {
        for (int i = 0; i < accounts.size(); i++) {
         if (accounts.get(i).getCardID().equals(cardID)) {
             return accounts.get(i);
         }
        }
        return null; //查无此庄户
    }
}