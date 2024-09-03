package exam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class ChatRoom {
	//필드 : 방의 갯수를 세어서 각 채팅방에 고유한 번호를 부여할 변수
	private static int count = 1;
	//필드 : 채팅방 이름을 저장한다.
	private String roomName;
	//필드 : 채팅방 번호를 저장한다.
	private String chatRoomId = "";
	//필드 : 채팅방에 접속한 클라이언트를 관리하는 map이다.
	Map<String, SocketClient> mapSocketClient = Collections.synchronizedMap(new HashMap<>());
	//////////////////////////////
	//생성자 : 채팅방의 이름과 ID를 초기화
	public ChatRoom(String roomName) {
		this.roomName = roomName;
		//채팅방에 고유 아이디 
		chatRoomId = String.valueOf(count++);
	}//public ChatRoom
	//////////////////////////////
	//메소드 : 채팅방에 사람 추가
	public void add(String key, SocketClient socketClient) {
		mapSocketClient.put(key, socketClient);
	}//public void add
//	/////////////////////////
//	//메소드 : 채팅방에서 나간 사람을 삭
//	public void remove(SocketClient socketClient) {
//		mapSocketClient.put(socketClient.getKey(), socketClient);
//	}
	/////////////////////
	//메소드 : 채팅방 입장
	public void incoming(SocketClient socketClient, JSONObject jsonObject) {
		
		//채팅방에 입장한다
		socketClient.chatName = jsonObject.getString("data");
		//채팅방에 있는 사람들에게 새로운 사용자가 들어왔음을 알리는 메세지를 전송한다.
		sendToAll(socketClient, "들어오셨습니다.");
		//클라이언트를 채팅방에 입장한 사람을 관리하는 map에 넣는다
		addSocketClient(socketClient);
	}//public void incoming
	///////////////////////////////
	//메소드: 메세지를 보내는 사용자 제외하고 모든 클라이언트에게 메시지 보냄
	public void sendToAll(SocketClient sender, String message) {
		//메세지를 보내는 사용자 정보와 메세지를 json에 담는다.
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		//현재 보내는 사용자를 제외한 모든 사용자에게 메세지르르 보낸다
		Collection<SocketClient> socketClients = mapSocketClient.values();
		for(SocketClient sc : socketClients) {
			if(sc == sender) continue;
			sc.send(json);
		}
	}//public void sendToAll
	///////////////////////////////////////////
	//메소드: 클라이언트 연결시 SocketClient 생성 및 추가
	public void addSocketClient(SocketClient socketClient) {
		//클라이언트의 정보로부터 사용할 키 값을 가져온다
		String key = socketClient.getKey();
		//클라이언트의 채팅상에 사용할 키와 클라이언트 정보를 현재 채팅방에 접속한 사용자를 관리하는 곳에 넣는다
		mapSocketClient.put(socketClient.getKey(), socketClient);
		//누가 입장했는지
		System.out.println("입장: " + key);
		//채팅방의 크기를 출력한다
		System.out.println("현재 채팅자 수: " + mapSocketClient.size() + "\n");
	}//public void addSocketClient
	/////////////////////////////////////////
	//메소드: 클라이언트 연결 종료시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.getKey();
		mapSocketClient.remove(key);
		System.out.println("나감: " + key);
		System.out.println("현재 채팅자 수: " + mapSocketClient.size() + "\n");
	}//public void removeSocketClient
	////////////////////////////
	//메소드 : 채팅방 종료
	public void stop() {
		try {
			//채팅방에 입장한 모든 사람들의 소켓을 닫는다
			mapSocketClient.values().stream().forEach(sc -> sc.close());
			System.out.println( "[채팅방에 입력한 모든 사람] 종료됨 ");
		} catch (Exception e1) {}
	}	
	
//	public String getKey() {
//		return chatRoomId;
//	}
	////////////////////////
	//getter/setter
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	
	
}
