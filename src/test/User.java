package test;

import java.net.Socket;

import com.arquitectura.net.server.Connection;

public class User extends Connection {

	public User(Socket client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

//	public User(Socket client) {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void receiveMessage(Object obj) {
		if (obj instanceof Mensaje) {
			Mensaje msj = new Mensaje();
			msj.string = "Echo: " + ((Mensaje) obj).string;
			this.sendMessage(msj);
		}

	}

}
