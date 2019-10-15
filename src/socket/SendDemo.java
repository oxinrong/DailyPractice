package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendDemo {
    public static void main(String[] args) throws Exception {
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
    }
}
