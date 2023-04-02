package test;

import com.arquitectura.net.client.ClientRunnable;

public class TestClient extends ClientRunnable{

	public TestClient() {
		super("localhost", 2023);
	}
	
	public static void main(String[] args) {
		TestClient client = new TestClient();
		Thread thread = new Thread(client);
		thread.start();
	}

}
