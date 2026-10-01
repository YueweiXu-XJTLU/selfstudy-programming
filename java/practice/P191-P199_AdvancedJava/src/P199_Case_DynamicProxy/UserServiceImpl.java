package P199_Case_DynamicProxy;

public class UserServiceImpl implements UserService {
    @Override
    public void login(String loginName, String password) throws Exception {
        if ("admin".equals(loginName) && "EXAMPLE_PASSWORD".equals(password)) {
            System.out.println("登录成功，欢迎使用");
        } else {
            System.out.println("登录失败，用户名或密码错误");
        }
        Thread.sleep(1000);
    }

    @Override
    public void deleteUsers() throws Exception {
        System.out.println("删除1000万条用户信息");
        Thread.sleep(1500);
    }

    @Override
    public String[] selectUsers() throws Exception {
        System.out.println("查询了3个用户");
        String[] names = {"张三","李四","王五"};
        Thread.sleep(1500);
        return names;
    }
}
