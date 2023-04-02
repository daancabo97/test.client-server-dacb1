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
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		client.waitForConnection(); 
		
		Mensaje msj = new Mensaje();
		msj.string = "Hola Servidor";
		
		client.sendMessage(msj);
	}

	private void waitForConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveMessage(Object obj) {
		if (obj instanceof Mensaje) {
			System.out.println(((Mensaje) obj).string);
		}
		
	}

}
