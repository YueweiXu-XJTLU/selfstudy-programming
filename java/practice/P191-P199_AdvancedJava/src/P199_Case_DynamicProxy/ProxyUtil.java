package P199_Case_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static UserService createProxy(UserServiceImpl userServiceImpl) {
        UserService userService = (UserService) Proxy.newProxyInstance
                (ProxyUtil.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("login") || method.getName().equals("deleteUsers") || method.getName().equals("selectUsers")) {
                            long startTime = System.currentTimeMillis();
                            Object o = method.invoke(userServiceImpl, args);
                            long endTime = System.currentTimeMillis();
                            System.out.println(method.getName() + " method takes " + (endTime - startTime) / 1000.0 + "s");
                            return o;
                        } else {
                            return method.invoke(userServiceImpl, args);
                        }
                    }
                });
        return userService;
    }
}