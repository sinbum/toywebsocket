package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//@RequestMapping("/websocket")
public class WebsocketHandler extends TextWebSocketHandler{
	private List<WebSocketSession> sessions=
			new ArrayList<WebSocketSession>();
	//websocket 객체가 생성될 때
	public WebsocketHandler() {
		System.out.println("websocket 초기화");
	}
	//처음 연결 될때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	System.out.println("socket연결될 때");
	sessions.add(session);
	}
	//메시지를 받을 때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("메시지 받을 때");
		System.out.println(message.getPayload());
		//연결되는 세션에 다시 메시지 echo 기능
		//한명한테 보내는 작업
		//session.sendMessage(new TextMessage(message.getPayload()));
		for(WebSocketSession s:sessions)
		s.sendMessage(new TextMessage(message.getPayload()));
	}
	//연결이 끊겼을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("socket해제 될 때");
		sessions.remove(session);
	}
	//에러가 발생할 때
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("에러가 발생할 때");
	}

}
