package org.glassfish.javaee7Sample;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;

@ServerEndpoint("/websocket")
public class WebSocketTest {

	@OnMessage
    public void onMessage(String message, Session session) 
    	throws IOException, InterruptedException {

		// Print the client message for testing purposes
		System.out.println("Received: " + message);

		// Send the first message to the client
		session.getBasicRemote().sendText("This is the first server message");

		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while(sentMessages < 3){
			Thread.sleep(2000);
			session.getBasicRemote().
				sendText("This is an intermediate server message. Count: " 
					+ sentMessages);
			sentMessages++;
		}

		// Send a final message to the client
		session.getBasicRemote().sendText("This is the last server message");
    }

	@OnOpen
    public void onOpen (Session session) {
        System.out.println("Client connected");

		System.out.println("Session ID: " + session.getId());
		System.out.println("Session max timeout: " + session.getMaxIdleTimeout());
		session.setMaxIdleTimeout(5000);
		System.out.println("Session max timeout (nuevo): " + session.getMaxIdleTimeout());
    }

    @OnClose
    public void onClose (Session session, CloseReason closeReason) {
    	System.out.println("Connection closed - Session id:"+session.getId()+" - Reason: "+closeReason);
    }
}
