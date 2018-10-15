package com.demo.netty.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            byte[] byteArray = new byte[4096];
            while (true) {
                int read = inputStream.read(byteArray, 0, byteArray.length);

                if (read == -1) {
                    break;
                }
            }
        }
    }
}
