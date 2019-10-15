package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);

        while (true) {
            datagramSocket.receive(datagramPacket);
            byte[] res = datagramPacket.getData();
            String ip = datagramPacket.getAddress().getHostAddress();
            int port = datagramPacket.getPort();
            String data = new String(res, 0, datagramPacket.getLength());
            if (data.equals("quit")) datagramSocket.close(); // 为什么无效嘞 搞不明白呀
            System.out.println(ip + ":" + port + " " + data);
        }
        //datagramSocket.close();
    }
}
