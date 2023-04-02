package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.arquitectura.net.server.ServerThread;

public class TestServer implements Runnable {
    private int port;
    private ServerSocket serverSocket;

    public TestServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

                ServerThread serverThread = new ServerThread(clientSocket);
                serverThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
