package test;

import java.net.Socket;

import com.arquitectura.net.server.ServerRunnable;

public class TestServer extends ServerRunnable {

    private static final int DEFAULT_PORT = 2023;

    public TestServer() {
        super(DEFAULT_PORT);
    }

    public TestServer(int port) {
        super(port);
    }

    @Override
    public void connectionAccepted(Socket client) {
    	User user = new User(client);
    	Thread thread = new Thread(user);
    	thread.start();
        
    }

    public static void main(String[] args) {
        TestServer server = new TestServer();
        Thread thread = new Thread(server);
        
        thread.start();
        
        System.out.println("hola");
    }
}