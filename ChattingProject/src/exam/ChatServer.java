package exam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ChatServer {
	//필드 : 서버의 소켓을 생성하기 위해 포트를 지정해줄 변수
	private ServerSocket serverSocket = null;
	//필드 : 서버에서 회원정보를 관리하기 위한 map변수 회원이름과 Member 객체 쌍으로 저장
	private static Map<String, Member> memberMap = new HashMap<>();
	//필드 : 한번에 실행 할 수 있는 스레드 수를 지정
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	//필드 : 채팅방을 채팅방 명과 ChatRoom의 객체 상으로 저장 , 스레드에서 함께 사용하기때문에 동기화한다.
	Map<String, ChatRoom> mapChatRoom = Collections.synchronizedMap(new HashMap<>());	
	///////////////////////
	//메소드: 서버 시작
	public void start() throws IOException {
		//서버 50001번으로실행
		serverSocket = new ServerSocket(50001);	
		System.out.println( "[서버] 시작됨");
		
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					//chatServer에서는 클라이언트를 받아다가 socketclient를 생성해서 
					//클라이언트의 요청을 socketclient에서 처리하도록한다.
					new SocketClient(this, serverSocket.accept());
				}
			} catch(IOException e) {
			}
		});
		thread.start();
	}//public void start()
	//////////////////
	//메소드: 채팅방 생성
	public ChatRoom addChatRoom(String roomName) {
		//채팅방명을 이용해서 chatRoom객체를 생성한다
		ChatRoom chatRoom = new ChatRoom(roomName);
		//chatRoom의 객체가 정상 생성 되었음
		if (chatRoom != null) {
			//채팅방을 관리하는 mapChatRoom변수에 채팅방 아이디와 chatRoom객체를 쌍으로 저장
			mapChatRoom.put(chatRoom.getChatRoomId(), chatRoom);
			//채팅방이름
			System.out.println("채팅방 생성: " + roomName);
			//채팅방에 사람수
			System.out.println("현재 채팅방  수: " + mapChatRoom.size() + "\n");
		}
		//생성된 chatRoom객체 리턴->socketclient에서 채팅방 ID를 클라이언트에 넘겨주는데 사용
		return chatRoom;
	}//public ChatRoom addChatRoom
	//////////////////////////////////////////
	//메소드: 클라이언트 연결 종료시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		//채팅방ID를 통해 채팅방 객체를 얻어온다.
		ChatRoom chatRoom = mapChatRoom.get(socketClient.chatRoomId);
		if (chatRoom != null) {
			//chatRoom객체를 통해 채팅방에 사람을 삭제한다
			chatRoom.removeSocketClient(socketClient);
		}
	}//public void removeSocketClient
	///////////////////////////////
	//메소드: 모든 클라이언트에게 메시지 보냄
	public void sendToAll(SocketClient sender, String message) {
		//채팅방을 가져옴
		ChatRoom chatRoom = mapChatRoom.get(sender.chatRoomId);
		if (chatRoom != null) {
			//chatRoom객체를 통해 현재 채팅방에 있는 사람들에게 메세지 전송
			chatRoom.sendToAll(sender, message);
		}
	}//public void sendToAll
	////////////////
	//메소드: 서버 종료
	public void stop() {
		try {
			//서버소켓 닫기
			serverSocket.close();
			//스레드 풀 종료
			threadPool.shutdownNow();
			//채팅방에 입장한 모든 사람 대상으로 종료한다 
			mapChatRoom.values().stream().forEach(sc -> sc.stop());
			System.out.println( "[서버] 종료됨 ");
		} catch (IOException e1) {}
	}//public void stop
	////////////////////////
	//메소드 : main
	public static void main(String[] args) throws Exception {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------------------------");

		//멤버 파일 로딩 
		loadFileMemberMap();
		
		ChatServer chatServer = new ChatServer();
		//TCP 서버 시작
		chatServer.start();

		//키보드 입력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			//q가 입력되면 종료
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		
		//TCP 서버 종료
		chatServer.stop();		
	}	

	////////////////////////
	//회원정보 읽어오기
	////////////////////////
	public static void loadFileMemberMap() throws Exception{
		String fileName = "D:\\temp\\member.db";
		File file = new File(fileName);
		//파일이 존재한다면 원래 있던 파일에서 읽어온다.
		if (file.exists()){
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            memberMap = (Map<String,Member>) ois.readObject();
            ois.close();
            System.out.println("회원 정보를 파일에서 로드했습니다." + memberMap);
        }else {//파일이 존재하지 않는다면 새로 HashMap을 생성한ㄷㅏ.
            memberMap  = new HashMap<>();
            System.out.println("회원 정보 파일이 존재하지 않아 빈 회원 목록으로 초기화했습니다.");
        }

	
	}//private void loadFileMemberList()
	////////////////////////
	//회원정보 기록하기
	////////////////////////
	public static void saveFileMemberMap() throws Exception{
		String fileName = "C:\\temp\\member.db";
		File file = new File(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(memberMap);
		oos.close();
	}//private void saveFileMemberList()
	//////////////////////////////
	//메소드 : 멤버관리객체를 반환하는 함수
	//Socketclient에서 멤버들을 사용할 수 있도록하기 위해서 
	public static Map<String, Member> getMemberMap() {
		return memberMap;
	}//public static Map<String, Member> getMemberMap()
}