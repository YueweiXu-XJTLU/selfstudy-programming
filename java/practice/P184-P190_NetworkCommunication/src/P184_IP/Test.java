package P184_IP;

import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws Exception {
        //Communication Architecture (通信架构)：
          //1.CS Architecture (Client-Server): WeChat, IJ IDEA, ... (BOTH C & S need program development 程序开发)
          //2.BS Architecture (Browser-Server): baidu.com, ... (ONLY S need program development 程序开发)

        //IP:
          //Internet Protocol (协议) Address
          //a unique mark for a device on the Internet

          //IPv4: Internet Protocol version 4 // 32bits, 4bytes // 192.168.187.91
          //IPv6: Internet Protocol version 6 // 128bits, 16bytes // 2409:8924:509a:51f:2c06:98d8:c84e:efb1

          //Domain (域名): device send domain to DNS-Server, it returns a certain IP address for accessing
          //DNS: Domain Name System

          //Public IP (公网IP): can access directly through Internet (Wide Area Network (WAN))
          //Private IP (内网IP) = Local Area Network (LAN) IP (局域网IP): only access under organization's LAN

          //Special IP: 127.0.0.1 = localhost: localhost IP, only look for localhost

          //commands:
            //ipconfig: localhost IP
            //ping IP-Address: check network linkage

        //IP in Java: InetAddress Class
        //public static InetAddress getLocalHost(): get localhost IP in an InetAddress Object
        InetAddress ip1 = InetAddress.getLocalHost();

        //public static InetAddress getByName(String host): get certain IP or Domain in an InetAddress Object
        InetAddress ip2  = InetAddress.getByName("www.baidu.com");

        //public String getHostName()
        System.out.println(ip1.getHostName());
        System.out.println(ip2.getHostName());

        //public String getHostAddress()
        System.out.println(ip1.getHostAddress());
        System.out.println(ip2.getHostAddress());

        //public boolean isReachable(int timeout): same function as "Ping IP-Address", judge if the host is able to reach the specified IP within timeout milliseconds
        System.out.println(ip2.isReachable(5000));

    }
}
