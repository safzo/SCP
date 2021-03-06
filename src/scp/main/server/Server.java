package scp.main.server;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import scp.main.networkencoder.NetworkEncoder;
import scp.main.serverconn.ServerConnection;
import scp.main.serverconn.User;

public class Server {
	private final Map<Socket, User> users = new HashMap<>();

	public Server() throws Throwable {
	}

	public void receiveMessage(String message, ServerConnection connection, Socket socket) throws Throwable {
		String msg = users.get(socket).getUsername() + ": " + message;
		for (Socket s : users.keySet())
			if (s != socket)
				s.getOutputStream().write(NetworkEncoder.encodeMessage(msg));
	}

	public void handleNewConnection(ServerConnection connection, Socket newConnection) throws Throwable {

		String name = NetworkEncoder.pollMessage(newConnection.getInputStream()).substring(7);

		User user = new User(newConnection, name);
		users.put(newConnection, user);

	}
}
