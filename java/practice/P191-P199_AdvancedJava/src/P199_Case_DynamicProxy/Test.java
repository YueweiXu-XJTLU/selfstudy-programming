package P199_Case_DynamicProxy;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserService userService = ProxyUtil.createProxy(userServiceImpl);

        userService.login("admin", "123456");
        System.out.println("----------");

        userService.deleteUsers();
        System.out.println("----------");

        String[] names = userService.selectUsers();
        System.out.println("Selected:" + Arrays.toString(names));
        System.out.println("----------");
    }
}
