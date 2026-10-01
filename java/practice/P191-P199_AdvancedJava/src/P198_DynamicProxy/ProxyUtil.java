package P198_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//Dynamic Util
public class ProxyUtil {
    public static Proxy createProxy(Star s) {

        //public static Object newProxyInstance(
        //ClassLoader loader, ---> className.class.getClassLoader()
        //Class<?>[] interfaces, ---> state which interfaces the proxy has
        //InvocationHandler h ---> tasks for the proxy object to handle
        //)
        Proxy proxy = (Proxy) java.lang.reflect.Proxy.newProxyInstance
                (ProxyUtil.class.getClassLoader(), new Class[]{Proxy.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //invoke method determine what the proxy will do
                        //Object proxy: current proxy object; Method method: the method called; Object[] args:parameters of the method
                        if (method.getName().equals("sing")) {
                            System.out.println("account + $500");
                        } else if (method.getName().equals("dance")) {
                            System.out.println("account + $1000");
                        }
                        return method.invoke(s, args); //use "return" as the original methods may have return values
                    }
                }); //Proxy must under "java.lang.reflect"

        return proxy;
    }
}
