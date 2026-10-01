package P185_S2_CommunicationProtocol;

public class Test {
    public static void main(String[] args) {
        //Communication Protocol 通信协议
          //OSI Reference Model (Open Systems Interconnection) (OSI 网络参考模型)
          //TCP/IP Model (Transmission Control Protocol/Internet Protocol Model) (TCP/IP 网络模型)
            //Network Access Layer (网络接入层): Data Link Layer (数据链路层) + Physical Layer (物理层): Bit Stream, ...
            //Internet Layer (网络层): IP, ...
            //Transport Layer (传输层): TCP, UDP, ...
            //Application Layer (应用层): HTTP, FTP, SMTP, ... (develop here)

          //UDP (User Datagram Protocol) (用户数据报协议)
            //Connectionless & Unreliable & Low-efficiency
            //usage eg：Voice-Call, Live-Streaming
          //TCP (Transmission Control Protocol) (传输控制协议)
            //Connection-required & Reliable
              //Three-Way Handshake (三次握手): build up reliable connection (both sides of communication can send and receive messages normally)
              //Data Transmission Conformation
              //Four-Way Handshake (四次挥手): Disconnected
            //usage eg: File-Download, Online-Payment
    }
}
