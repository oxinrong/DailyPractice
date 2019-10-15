package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class SendAndReceive {
    public static void main(String[] args) {
        new Receive().start();
        new Send().start();
    }

}


class Receive extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(6666);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);

            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] res = datagramPacket.getData();
                String ip = datagramPacket.getAddress().getHostAddress();
                int port = datagramPacket.getPort();
                String data = new String(res, 0, datagramPacket.getLength());
                System.out.println(ip + ":" + port + " " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Send extends Thread {
    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket datagramSocket = new DatagramSocket();

            while (true) {
                String line = sc.nextLine();

                DatagramPacket datagramPacket =
                        new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);

                datagramSocket.send(datagramPacket);
                if ("quit".equals(line)) break;

            }
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ConcurrentHashMap c = new ConcurrentHashMap();

}


