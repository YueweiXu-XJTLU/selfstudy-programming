package P198_DynamicProxy;

public class Test {
    public static void main(String[] args) {
        //Proxy 代理:
        //An Object with too much codes inside methods can transfer part of tasks to a proxy
        //This proxy must have methods for those methods it handles corresponding in the original object (use interface).
        //Both Star & Proxy have to implements the interface or be the interface

        //Dynamic Util 动态代理: use ProxyUtil to automatically multiple proxies with different abilities(different interfaces, different manipulations ...)

        Star star = new Star("YangChaoYue");
        Proxy proxy = ProxyUtil.createProxy(star); //create a Proxy Object for the Star Object using ProxyUtil
        //Here, a legal object implements Proxy will be created automatically and implicitly

        //call methods of star through proxy
        String rs = proxy.sing("HaoRiZi");
        System.out.println(rs);

        System.out.println("----------");

        proxy.dance();

    }
}
