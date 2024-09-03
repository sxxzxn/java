package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class ChatClient {
	//필드 : 서버와 stream으로 json교류중 오류가 생기면 반환해줄 비어있는 json이다.
	private final static JSONObject emptyObject = new JSONObject();
	//필드 : 로그인한 사용자의 정보를 저장할 변수
	private Member loginMember = null;
	//필드 : 채팅방에 입장해서 채팅중인 경우는 참
	private boolean incomed = false;
	//필드 : 클라이언트가 서버에 접속하기 위해서 사용해야하는 TCP소켓 변수
	Socket socket;
	//필드 : 서버와 데이터를 주고 받기 위해서 사용하는 변수
	DataInputStream dis;
	DataOutputStream dos;
	//필드 : 클라이언트가 접속하고 있는 채팅방 ID를 저장해서 메세지를 전달하기 위해서 사용할 변수
	String chatRoomId = "";
	////////////////
	//메소드: 서버 연결
	private void connect() throws IOException {
		//서버에 소켓을 통해서 TCP연결
		socket = new Socket("localhost", 50001);
		//연결된 소켓을 통해 서버와 연결할 스트림을 가져온다.
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");		
	}//private void connect
	///////////////////
	//메소드: JSON 보내기
	private void send(String json) throws IOException {
		//jsonObject.toString()을 통해 리턴되는 json 문자열을 스트림에 전달한다.
		dos.writeUTF(json);
		dos.flush();
	}//private void send(String json)
	///////////////////
	//메소드: 서버 연결 종료
	public void unconnect() throws IOException {
		//서버와의 연결이 종료되면 사용중인 소켓을 닫아 연결을 끊는다
		socket.close();
	}//public void unconnect()
	/////////////////////////
	//메소드 : 사용자에게 보여줄 메뉴
	public void displayMenu() {
		//로그인 하지 않은 사용자일경우 보일메뉴
		if (loginMember == null) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("7. 비밀번호 찾기");
			System.out.println("12. 종료");
		} else {//로그인한 사용자에게 보일 메뉴
			System.out.println("3. 로그아웃");
			System.out.println("4. 회원정보 상세 보기");
			System.out.println("5. 전체회원목록");
			System.out.println("6. 회원정보 수정");
			System.out.println("8. 회원 탈퇴");
			System.out.println("9. 채팅방입장");
			System.out.println("10. 채팅방생성");
			System.out.println("11. 채팅방목록출력");
			System.out.println("12. 종료");
		}
		System.out.print("원하는 번호를 입력하세요. 번호?");
	}//public void displayMenu
	///////////////////
	//메소드 : 회원정보 추가
	public void insertMember(Scanner scanner) throws Exception {
		System.out.println("[회원 가입]");
		//회원가입을 위한정보를 받아올 변수
		String uid="";
		String name="";
		String pwd="";
		String age="";
		String phone="";
		String address="";
		String gender="";
		
		//중복된 아이디는 입력받지 않는다.
		while(true) {
			System.out.print("아이디 :");
			uid = scanner.nextLine();
			//아이디가 중복된다면 다시 입력받는다.
			if(existUserId(uid)) {
				System.out.println("존재하는 아이디입니다.");
			}else break;
		}
		//아이디 중복이 아니라면 나머지 정보를 입력받는다
		System.out.print("이름 :");
		name = scanner.nextLine();
		System.out.print("비밀번호 :");
		pwd = scanner.nextLine();
		System.out.print("나이 :");
		age = scanner.nextLine();
		System.out.print("전화번호 :");
		phone = scanner.nextLine();
		System.out.print("주소 :");
		address = scanner.nextLine();
		System.out.print("성별 :");
		gender = scanner.nextLine();
		//입력받은 정보를 서버에 전달해주기 위해 JSONObject에 담는다.
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("uid",uid);
		jsonObject.put("name",name);
		jsonObject.put("pwd",pwd);
		jsonObject.put("age",age);
		jsonObject.put("phone",phone);
		jsonObject.put("address",address);
		jsonObject.put("gender",gender);
		//회원정보를 바탕으로 서버에서 수행해야할 명령
		jsonObject.put("command", "serverInsertMember");
		//서버에서 받아온 JSONObject 정보
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		//아이디 중복이라면 중복된다는 메세지출력!
		boolean result = jsonObjectReceive.getBoolean("result");
		if (!result) {
			System.out.println(jsonObjectReceive.getString("message"));
		}
			
	}//public void insertMember
	///////////
	//로그인하기
	private void loginMember(Scanner scanner) {
		System.out.println("[로그인]");
		//사용자의 id와 pwd를 입력받기 위한 변수
		String uid;
		String pwd;
		//아이디가 존재하지 않는다면 다시 입력받기
		while(true) {
			System.out.print("아이디 : ");
			uid = scanner.nextLine();
			if(existUserId(uid)) {
				break;
			}else System.out.println("아이디가 존재하지 않습니다.");
		}
		//비밀번호가 일치하지 않는다면 다시 입력받기
		while(true) {
			System.out.print("비밀번호 : ");
			pwd = scanner.nextLine();
			if(existUserPwd(pwd,uid)) {
				break; 
			}else System.out.println("비밀번호가 일치하지 않습니다.\n");
		}
		//아이디와 비밀번호를 서버에 json으로 넘긴다
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("uid", uid);
		jsonObject.put("pwd", pwd);
		//서버가 수행해주어야할 명령을 넘긴다	
		jsonObject.put("command", "serverLoginMember");
		//jsonObject를 서버에 전달하고 서버의 결과값을 받아온다.
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		//사용자를 정상적으로 받아오면 객체 받아오기
		if (jsonObjectReceive.getBoolean("result")) {
			//서버에서 로그인한 사용자의 정보를 통해 객체를 받아온다 
			loginMember = Member.of(jsonObjectReceive.getJSONObject("loginMember"));
			System.out.println("로그인 멤버 정보");
			System.out.println(loginMember);
		} /*
			 * else {// System.out.println(jsonObjectReceive.getString("message")); }
			 */
	}//private void loginMember
	/////////////
	//로그아웃하기
	private void logoutMember(Scanner scanner) {
		System.out.println("[로그아웃]");
		JSONObject jsonObject = new JSONObject();
		//서버가 수행해 주어야하는 메세지 전달
		jsonObject.put("command", "serverLogoutMember");
		jsonObject.put("uid", loginMember.getUid());
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		System.out.println(jsonObjectReceive.getString("message"));
		//현재 로그인한 사용자 정보를 없앤다
		loginMember = null;
		
	}//private void logoutMember
	////////////////////
	//로그인한 사용자 상세정보
	private void userDetail() {
		System.out.println("["+loginMember.getUid()+"] 님의 정보");
		JSONObject jsonObject = new JSONObject();
		//서버가 수행해야할 명령 전달
		jsonObject.put("command", "serverUserDetail");
		//사용자의 uid전달한다.
		jsonObject.put("uid", loginMember.getUid());
		//서버로부터 받아온 사용자 정보
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		
		//넘어온 사용자의 정보를 출력한다.
		System.out.println("로그인한 ["+loginMember.getName()+"]님의 상세정보");
		System.out.printf(" %4s:%12s\n","아이디", jsonObjectReceive.getString("uid"));
		System.out.printf(" %4s: %12s\n","이름", jsonObjectReceive.getString("name"));
		System.out.printf(" %4s: %12s\n","비밀번호", jsonObjectReceive.getString("pwd"));
		System.out.printf(" %4s: %12s\n","나이", jsonObjectReceive.getString("age"));
		System.out.printf(" %4s: %12s\n","전화번호", jsonObjectReceive.getString("phone"));
		System.out.printf(" %4s: %12s\n","주소", jsonObjectReceive.getString("address"));
		System.out.printf(" %4s: %12s\n","성별", jsonObjectReceive.getString("gender"));
		System.out.println();
		
	}//private void userDetail()
	///////////////////
	//전체사용자 정보 출력
	private void allMemberListPrint() {
		System.out.println("[전체회원목록]");
		JSONObject jsonObject = new JSONObject();
		//서버가 수행해야할 명령어 전달
		jsonObject.put("command", "serverAllMemberListPrint");
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		JSONArray memberList = jsonObjectReceive.getJSONArray("result");

		for(int i=0;i<memberList.length();i++) {
			//회원정보를 Array로 받아왔기 때문에 for문을통해 하나씩 순회하면서 한명한명의 상세정보를 출력한다.
			JSONObject memberJson = memberList.getJSONObject(i);
			Member.ofPrint(memberJson);
			System.out.println();
		}
	}//private void allMemberListPrint()
	///////////////////
	//회원정보 수정
	private void modifyMember(Scanner scanner) {
		System.out.println("[회원정보 수정]");
		String temp="";
		
		
		JSONObject jsonObject = new JSONObject();
		//현재 로그인하고 있는 사용자 정보 전달해서 서버가 변경할 대상을 찾도록한다
		jsonObject.put("uid", loginMember.getUid());
		
		//각 항목을 입력 받는 데 엔터가 입력되면 변경하지 않도록한다.
		System.out.print("이름 : ");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setName(temp);
		}
		//그리고 서버에 전달하기 위해 json에 넣는다
		jsonObject.put("name", loginMember.getName());
		
		System.out.println("패스워드 :");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setPwd(temp);
		}
		jsonObject.put("pwd", loginMember.getPwd());
		
		System.out.println("나이 :");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setAge(temp);
		}
		jsonObject.put("age", loginMember.getAge());
		
		System.out.println("전화번호 :");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setPhone(temp);
		}
		jsonObject.put("phone", loginMember.getPhone());
		
		System.out.println("주소 :");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setAddress(temp);
		}
		jsonObject.put("address", loginMember.getAddress());
		
		System.out.println("성별 :");
		temp = scanner.nextLine();
		if(!temp.equals("\n")) {
			loginMember.setGender(temp);
		}
		jsonObject.put("gender", loginMember.getGender());
		//서버가 수행해주어야할 명령 전달
		jsonObject.put("command", "serverModifyMember");
		
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		//수정된 회원정보를 받아 출력한다
		System.out.println("회원정보가 수정되었습니다.");
		System.out.println("로그인한 ["+loginMember.getName()+"]님의 상세정보");
		System.out.printf(" 아 이 디 : %12s\n", jsonObjectReceive.getString("uid"));
		System.out.printf(" 이   름 : %12s\n", jsonObjectReceive.getString("name"));
		System.out.printf(" 비밀번호 : %12s\n", jsonObjectReceive.getString("pwd"));
		System.out.printf(" 나   이 : %12s\n", jsonObjectReceive.getString("age"));
		System.out.printf(" 전화번호 : %12s\n", jsonObjectReceive.getString("phone"));
		System.out.printf(" 주   소 : %12s\n", jsonObjectReceive.getString("address"));
		System.out.printf(" 성   별 : %12s\n", jsonObjectReceive.getString("gender"));
		System.out.println();
		
	}
	////////////
	//패스워드 찾기
	private void findPassword(Scanner scanner) {
		System.out.println("[패스워드 찾기]");
		//패스워드 변경을 입력받을 이름과 아이디, 변경할 비밀번호를 선언한다
		String uid;
		String name;
		String revisePwd;

		JSONObject jsonObject = new JSONObject();
		//아이디가 잘못되었으면 다시 입력받는다
		while(true) {
			System.out.println("아이디 : ");
			uid = scanner.nextLine();
			jsonObject.put("uid", uid);
			if(existUserId(uid))break;
			else System.out.println("아이디가 잘못입력되었습니다.");
		}
		//본인인증을 위해 이름을 입력받는다
		//이름이 ID의 사용자와 일치하지않으면 다시 입력받는다.
		while(true) {
			System.out.print("본인인증을 위해 이름을 입력해주세요");
			name = scanner.nextLine();
			jsonObject.put("name", name);
			if(existUserName(uid,name)) {
				break;
			}
			else System.out.println("이름이 잘못 입력되었습니다.");
		}
		//변경할 비밀번호를 입력받는다
		System.out.print("[변경할 비밀번호를 입력해주세요] : ");
		revisePwd= scanner.nextLine();
		jsonObject.put("pwd", revisePwd);
		jsonObject.put("command", "serverFindPassword");
		//수정된 아이디와 비밀번호를 출력하여 변경을 확인한다.
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		System.out.println("비밀번호가 수정되었습니다. 수정된 비밀번호로 로그인해주세요");
		System.out.printf(" 아 이 디 : %12s\n", jsonObjectReceive.getString("uid"));
		System.out.printf(" 비밀번호 : %12s\n", jsonObjectReceive.getString("pwd"));
		System.out.println(jsonObjectReceive.getString("message"));
		System.out.println();

	}//private void findPassword
	///////////////////
	//메소드 : 회원 삭제
	private void removeMember(Scanner scanner) {
		System.out.println("[회원 탈퇴]");
		//회원 탈퇴를 하기전 본인 확인을 위해 비밀번호를 입력받는다
		//비밀번호가 일치 하지 않는다면 재입력
		while(true) {
			System.out.println("회원탈퇴를 위해 비밀번호를 입력해주세요");
			String temp = scanner.nextLine();
			if(existUserPwd(temp,loginMember.getUid())) break;
			else System.out.println("비밀번호가 잘못 입력되었습니다.");
		}
		JSONObject jsonObject = new JSONObject();
		//삭제되어야할 유저의 id 전달
		jsonObject.put("uid", loginMember.getUid());
		//탈퇴 후에는 로그인 정보를 없앤다
		loginMember=null;
		jsonObject.put("command", "serverRemoveMember");
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		//탈퇴했다는 메세지 받아옴
		System.out.println(jsonObjectReceive.getString("message"));
		System.out.println();
		
	}//private void removeMember
	///////////////////////
	//메소드 : 이름 일치 여부 판단
	private boolean existUserName(String uid, String name) {
				
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", "existUserName");
		jsonObject.put("uid", uid);
		jsonObject.put("name", name);
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		
		return jsonObjectReceive.getBoolean("result");
	
	}//private boolean existUserName
	/////////////////////////
	//메소드 : 아이디 존재 여부 판단
	private boolean existUserId(String uid) {
					
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", "existUserId");
		jsonObject.put("uid", uid);
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		return jsonObjectReceive.getBoolean("result");
	}//private boolean existUserId
	///////////////////////////
	//메소드 : 비밀번호 일치 여부 판단
	private boolean existUserPwd(String pwd,String uid) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", "existUserPwd");
		jsonObject.put("pwd", pwd);
		jsonObject.put("uid", uid);

		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		return jsonObjectReceive.getBoolean("result");

	}//private boolean existUserPwd
	//////////////////
	//메소드: 채팅방 안에서 JSON 받기
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				//채팅방에 입장했다면 실행될 while
				while(incomed) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					//서버로부터 전달받은 IP와 이름과 메세지를 출력한다
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch(Exception e1) {
				System.out.println("[클라이언트] 채팅방 나감");
			}
		});
		thread.start();
	}	
	//////////////////////
	//메소드 : 메인 : 클라이언트가 수행하고 싶은 함수 입력받음
	public static void main(String[] args) throws Exception {
		ChatClient chatClient = new ChatClient();
		
		Scanner scanner = new Scanner(System.in);

		exit:
		while(true) {
			//메뉴를 출력
			chatClient.displayMenu();
			//수행할 명령 번호입력
			String selectedMenu = scanner.nextLine();
			switch(selectedMenu) {
			case "1":
				chatClient.insertMember(scanner);
				break;
				case "2":
					chatClient.loginMember(scanner);
					break;
				case "3":
					chatClient.logoutMember(scanner);
					break;
				case "4":
					chatClient.userDetail();
					break;
				case "5":
					chatClient.allMemberListPrint();
					break;
				case "6":
					chatClient.modifyMember(scanner);
					break;
				case "7":
					chatClient.findPassword(scanner);
					break;
				case "8":
					chatClient.removeMember(scanner);
					break;

				case "9":
					chatClient.incoming(scanner);
					break;
				case "10":
					chatClient.createChatRoom(scanner);
					break;
				case "11":
					chatClient.printChatRoomList(scanner);
					break;
				case "12":
					//사용자가 종료하면 while문밖으로 빠져나갈수 있도록한다
					break exit;
			}
		}

	}//public static void main
	//////////////////////
	//메소드 채팅방 목록 불러오기
	private void printChatRoomList(Scanner scanner) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", "serverChatRoomList");
		
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		//채팅방목록의 존재 여부를 result로 받아온다
		boolean result = jsonObjectReceive.getBoolean("result");
		//존재하지 않는다면 메세지 출력
		if (!result) {
			System.out.println(jsonObjectReceive.getString("message"));
		} else {//존재한다면 Array형식으로 받아온 채팅방의 번호와 이름을 출력한다.
			JSONArray chatRoomList = jsonObjectReceive.getJSONArray("chatRoomList");
			for (int i=0;i<chatRoomList.length();i++) {
				JSONObject chatRoomJSON = chatRoomList.getJSONObject(i);
				System.out.println("[" + chatRoomJSON.getString("chatRoomId") + "] " + chatRoomJSON.getString("roomName"));
			}
		}
	}//private void printChatRoomList
	//////////////////
	//메소드 : 채팅방 생성
	private void createChatRoom(Scanner scanner) {
		//채팅방명 입력받기
		System.out.print("생성할 채팅방 이름 ? ");
		final String roomName = scanner.nextLine();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", "serverCreateChatRoom");
		jsonObject.put("data", roomName);
		
		//서버에 생성할 채팅방 이름을 전달
		JSONObject jsonObjectReceive = serverSendCommand(jsonObject);
		
		boolean result = jsonObjectReceive.getBoolean("result");
		//채팅방이 존재한다면 메세지 출력
		if (!result) {
			System.out.println(jsonObjectReceive.getString("message"));
		} else {
			//성공이면 생성된 채팅방 아이디를 얻는다
			chatRoomId = jsonObjectReceive.getString("chatRoomId");
			//생성한 채팅방에 입장 할 때는 생성된 채팅방 아이디 사용하여 입장한다
			helper_incoming(scanner);
		}
		
	}//private void createChatRoom
	////////////////////////////
	//메소드 : 목록있는 채팅방 입장
	private void incoming(Scanner scanner) {
		//채팅방 목록 출력
		printChatRoomList(scanner);
		
		 
		System.out.print("입장할 방번호 입력?");
		chatRoomId = scanner.nextLine();
		//채팅방 입장
		//채팅방 목록을 한번만 출력하기 위해 입장 함수를 분리해서 관리한다
		helper_incoming(scanner);
	}//	private void incoming
	/////////////////////////
	//메소드 : 목록없는 채팅방 입장
	private void helper_incoming(Scanner scanner) {
		try {
			//1. 입장을 메시지 생성
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			//메세지를 전달해야할 채팅방의 ID
			jsonObject.put("chatRoomId", chatRoomId);
			//사용자 이름
			jsonObject.put("data", loginMember.getName());
			
			//서버에 연결하여 스트림을 설정한다
			connect();
			
			//입장 메시지를 서버에 전달 
			send(jsonObject.toString());
			
			//입장상태 입장된걸로 설정 
			incomed = true;
			
			//메세지 수신 스레드를 생성한다
			receive();
			
			
			System.out.println("--------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅를 종료하려면 q를 입력하고 Enter");
			System.out.println("--------------------------------------------------");
			
			jsonObject.put("command", "message");
			//채팅 메시지를 입력 받아 서버에 전달한다
			while(true) {
				String message = scanner.nextLine();
				if(message.toLowerCase().equals("q")) {
					incomed = false;
					break;
				} else {
					jsonObject.put("data", message);
					send(jsonObject.toString());
				}
			}
			//소켓을 닫아 연결을 해제한다
			unconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}//private void helper_incoming
	///////////////////////////////////////
	//메소드 : 서버에 원하는 명령을 위한 json을 전달
	private JSONObject serverSendCommand(JSONObject jsonObject) {
		try {
			//서버에 연결요청
			Socket socket = new Socket("localhost", 50001);
			//서버와 연결된 스트림으로 json전달
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(jsonObject.toString());
			dos.flush();
			
			//데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			JSONObject jsonObjectReceive = new JSONObject(dis.readUTF());
			
	
			//연결 끊기
			socket.close();
			
			//서버로부터 받은 결과 json 리턴
			return jsonObjectReceive;
		} catch(Exception e) {
		}
		//스트림 전달과정 중 문제가 생기면 비어있는 json을 리턴한다.
		return emptyObject;
	}//private JSONObject serverSendCommand
	
	

}