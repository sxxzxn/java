package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class SocketClient {
	//필드 : chatServer의 함수를 가져다 쓰기 위한 변수
	ChatServer chatServer;
	//필드 : 클라이언트의 정보를 기록하기 위한 변수
	Socket socket;
	//필드 : 클라이언트와 스트림 연결
	DataInputStream dis;
	DataOutputStream dos;
	//필드 : 클라이언트의 Ip저장하기 위한 변수
	String clientIp;	
	//필드 : 클라이언트의 이름을 저장하기 위한 변수
	String chatName;
	//필드 : 채팅방의 ID를 저장하기 위한변수
	String chatRoomId;
	//필드 : chatserver로부터 받아온 회원정보를 저장할 변수
	static Map<String, Member> memberMap;
	////////////////
	//생성자 : 서버와 클라이언트에 관한 정보로 필드를 초기화
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			//클라이언트의 ip주소를 받아옴
			this.clientIp = isa.getHostName();
			//회원들에 대한 정보를 받아온다
			this.memberMap = ChatServer.getMemberMap();
			//클라이언트의 요청을기다리는 스레드 실행
			receive();
		} catch(IOException e) {
		}
	}//	public SocketClient
	//////////////////
	//메소드 : 클라이언트가 채팅방안에서 통신할 키를 생성
	public String getKey() {
		return chatName + "@" + clientIp;
	}//public String getKey()
	/////////////////
	//메소드: JSON 받기
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				//회원관리는 동기로 채팅방은 비동기로 진행하기 위한 변수
				boolean loop = true;
				//회원관리는 한번수행하고 스레드가 바로 끝나고
				//채팅방은 수행하고 다시 요청을 받는 형태로 돌아온다
				while(loop) {
					//클라이언트로부터 json을 기다림
					String receiveJson = dis.readUTF();
					System.out.println("receiveJson->" + receiveJson);
					//클라이언트로 받아온 json에서 command값을 가져와 필요한명령을 실행한다.
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");
					
					switch(command) {
						case "incoming":
							incoming(jsonObject);
							break;
						case "message":
							message(jsonObject);
							break;
						case "existUserId":
							existUserId(dos, jsonObject);
							loop = false;
							break;
						case "existUserPwd":
							existUserPwd(dos,jsonObject);
							loop = false;
							break;
						case "existUserName":
							existUserName(dos,jsonObject);
							loop = false;
							break;
						case "serverInsertMember":
							serverInsertMember(dos, jsonObject);
							loop = false;
							break;
						case "serverLoginMember":
							serverLoginMember(dos,jsonObject);
							loop = false;
							break;
						case "serverLogoutMember":
							serverLogoutMember(dos,jsonObject);
							loop = false;
							break;
						case "serverUserDetail":
							serverUserDetail(dos,jsonObject);
							loop = false;
							break;
						case "serverAllMemberListPrint":
							serverAllMemberListPrint(dos,jsonObject);
							loop = false;
							break;
						case "serverModifyMember":
							serverModifyMember(dos,jsonObject);
							loop = false;
							break;
						case "serverFindPassword":
							serverFindPassword(dos,jsonObject);
							loop = false;
							break;
						case "serverRemoveMember":
							serverRemoveMember(dos,jsonObject);
							loop = false;
							break;
						case "serverCreateChatRoom":
							serverCreateChatRoom(dos, jsonObject);
							loop = false;
							break;
						case "serverChatRoomList":
							serverChatRoomList(dos, jsonObject);
							loop = false;
							break;
					}
				}
			} catch(IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
			
			//소켓 종료
			close();
			
		});
	}//public void receive()
	//////////////////////
	//메소드 : 채팅방 목록 출력
	private void serverChatRoomList(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			//채팅방 목록이 존재한다면
			if (chatServer.mapChatRoom.size() != 0) {
				jsonObjectResult.put("result", true);
				//json 배열에 채팅방 번호와 이름을 쌍으로 담아 전달한다
				JSONArray chatRoomList = new JSONArray();
				//chatRoom에 대해 for문을 돌며 각각의 이름과 번호를 json에 담는다
				for (ChatRoom chatRoom : chatServer.mapChatRoom.values()) {
					JSONObject chatRoomJSON = new JSONObject();
					
					chatRoomJSON.put("chatRoomId", chatRoom.getChatRoomId());
					chatRoomJSON.put("roomName", chatRoom.getRoomName());
					
					chatRoomList.put(chatRoomJSON);
				}
				
				jsonObjectResult.put("chatRoomList", chatRoomList);
				
			} else {//채팅방 목록이 존재 하지 않으면 채팅방이 존재 하지 않는다는 메세지를 전달한다
				jsonObjectResult.put("result", false);
				jsonObjectResult.put("message", "채팅방이 존재하지 않습니다");
			}
			
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}//private void serverChatRoomList
	//////////////////////////////
	//메소드 : 채팅방 생성
	private void serverCreateChatRoom(DataOutputStream dos, JSONObject jsonObject) {
		//채팅방 이름을 넘겨받아
		String roomName = jsonObject.getString("data");
		//chatRoom 객체를 생성한다
		ChatRoom chatRoom = chatServer.addChatRoom(roomName);
		
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			//채팅방이 정상 생성 되었으면
			if (chatRoom != null) {
				//채팅방으로 들어갈수 있게끔 id를 전달한다
				jsonObjectResult.put("result", true);
				jsonObjectResult.put("chatRoomId", chatRoom.getChatRoomId());
			} else {
				jsonObjectResult.put("result", false);
			}
			
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//private void serverCreateChatRoom
	////////////////////
	//메소드 : 채팅방에 입장
	private void incoming(JSONObject jsonObject) {
		//채팅방의 아이디를 얻는다 
		chatRoomId = jsonObject.getString("chatRoomId");
		//채팅방의 아이디를 이용하여 채팅방 객체를 얻는다
		ChatRoom chatRoom = chatServer.mapChatRoom.get(chatRoomId);
		//채팅방에 사람을 추가하고 채팅방에 들어왔다는 메세지를 보낸다
		chatRoom.incoming(this, jsonObject);
	}//private void incoming
	///////////////////
	//메소드 : 메세지 전달
	private void message(JSONObject jsonObject) {
		String message = jsonObject.getString("data");
		chatServer.sendToAll(this, message);
	}//private void message
	///////////////////
	//메소드: JSON 보내기
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch(IOException e) {
		}
	}//public void send
	////////////////
	//메소드: 연결 종료
	public void close() {
		try { 
			socket.close();
		} catch(Exception e) {}
	}//public void close()
	//////////////////////
	//메소드 : id 존재여부 판단
	void existUserId(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			System.out.println("아이디 존재 여부 -> "+jsonObject.get("uid"));
			//아이디를 key값으로 받아온 객체가 존재하면 존재하는 아이디다
			Member temp = memberMap.get(jsonObject.get("uid"));
			boolean result = false;
			if(temp!=null)
				result=true;
			else result=false;
			jsonObjectResult.put("result",result );
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//void existUserId
	/////////////////
	//메소드 : 회원 추가
	void serverInsertMember(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			boolean result;
			//회원이 존재한다면 false를 리턴
			Member temp = memberMap.get(jsonObject.get("uid"));
			if(temp!=null)
				result=true;
			else result=false;
			jsonObjectResult.put("result", result);
			//존재하지 않는 회원이라면 map에 회원의 아이디와 함께 추가한다.
			if (!result) {
				memberMap.put(jsonObject.getString("uid"),Member.of(jsonObject));
				//회원정보에 변경사항이 있으니 재저장
				chatServer.saveFileMemberMap();
				jsonObjectResult.put("result", true);
			} else {//아이디가 존재하면 존재한다는 메세지 출력
				jsonObjectResult.put("message", "아이디가 존재 합니다");
				jsonObjectResult.put("result", false);
			}
			
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/////////////////////
	//메소드 : 로그인
	private void serverLoginMember(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		final String uid = jsonObject.getString("uid");
		final String pwd = jsonObject.getString("pwd");
		try {
			
			jsonObjectResult.put("result", true);
			//member 값들중 uid가 일치하는 값을 json으로 바꿔서 client에게 전달한다.
			for(Member member: memberMap.values()) {
				if(member.getUid().equals(jsonObject.getString("uid"))) {
					jsonObjectResult.put("loginMember", member.getJSONObject());
					break;
				}
			}
			
			/*
			 * else { jsonObjectResult.put("message", "아이디  또는 비밀번호가 잘못되었습니다");
			 * jsonObjectResult.put("result", false); }
			 */
			
			
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//private void serverLoginMember
	//////////////////////
	//메소드 : 비밀번호가 존재여부 판단
	static void existUserPwd(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			System.out.println("비밀번호 일치 여부 -> "+jsonObject.get("pwd"));
			//uid가 일치하는 member 객체 얻어옴
			Member temp = memberMap.get(jsonObject.get("uid"));
			//member 객체와 pwd가 일치하는 지 판단
			boolean result =temp.getPwd().equals(jsonObject.get("pwd"));
			jsonObjectResult.put("result",result);
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//static void existUserPwd
	////////////////////////////
	//메소드 : 이름이 일치하는 지 판단
	static void existUserName(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		
		try {
			System.out.println("이름 일치 여부 -> "+jsonObject.get("name"));
			
			Member temp = memberMap.get(jsonObject.get("uid"));
			//uid 키값으로부터 가져온 member 객체의 이름과 일치하는지 확인
			boolean result =temp.getName().equals(jsonObject.get("name"));
			jsonObjectResult.put("result",result);
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//static void existUserName
	////////////////////
	//메소드 : 로그아웃
	static void serverLogoutMember(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		//로그인이 되었음을 알리는 메세지를 출력한다.
		jsonObjectResult.put("message", jsonObject.getString("uid")+"님이 로그아웃 하셨습니다.");
		
		try {
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//static void serverLogoutMember
	//////////////////////
	//메소드 : 사용자의 상세정보
	static void serverUserDetail(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		//member 객체들을 순회하면서 uid와 일치하는 값이 있으면 json에 넣어 전달
		for(Member member: memberMap.values()) {
			if(member.getUid().equals(jsonObject.getString("uid"))) {
				jsonObjectResult.put("uid", member.getUid());
				jsonObjectResult.put("name", member.getName());
				jsonObjectResult.put("pwd", member.getPwd());
				jsonObjectResult.put("age", member.getAge());
				jsonObjectResult.put("phone", member.getPhone());
				jsonObjectResult.put("address", member.getAddress());
				jsonObjectResult.put("gender", member.getGender());
				break;
			}
		}
		
		try {
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//static void serverUserDetail
	//////////////////////
	//메소드 : 전체 회원 정보
	static void serverAllMemberListPrint(DataOutputStream dos, JSONObject jsonObject) {
		JSONArray jsonObjectResult = new JSONArray();
		
		//전체 회원의 정보를 json으로 변경해서 클라이언트에게 전달한다
		for(Member member : memberMap.values()) {
			jsonObjectResult.put(member.getJSONObject());
		}
		JSONObject json = new JSONObject();
		json.put("result", jsonObjectResult);
		
		try {
			dos.writeUTF(json.toString());
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//static void serverAllMemberListPrint
	/////////////////////
	//메소드 : 회원 정보 수정
	void serverModifyMember(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		//uid에 변경된 회원 정보를 저장한다
		memberMap.put(jsonObject.getString("uid"),new Member(jsonObject.getString("uid"),
				jsonObject.getString("name"),
				jsonObject.getString("pwd"),
				jsonObject.getString("age"),
				jsonObject.getString("phone"),
				jsonObject.getString("address"),
				jsonObject.getString("gender")));
		
		//uid와 일치하는 member의 값을 클라이언트에게 전달해 변경한 내용을 확인할 수있도록한다.
		for(Member member: memberMap.values()) {
			if(member.getUid().equals(jsonObject.getString("uid"))) {
				jsonObjectResult.put("uid", member.getUid());
				jsonObjectResult.put("name", member.getName());
				jsonObjectResult.put("pwd", member.getPwd());
				jsonObjectResult.put("age", member.getAge());
				jsonObjectResult.put("phone", member.getPhone());
				jsonObjectResult.put("address", member.getAddress());
				jsonObjectResult.put("gender", member.getGender());
				break;
			}
		}
	
		try {
			//변경사항을 저장한다
			chatServer.saveFileMemberMap();
			
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//void serverModifyMember
	//////////////////////
	//메소드 : 비밀번호 찾기
	void serverFindPassword(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		//uid에 해당하는 member의 pwd를 변경한다.
		memberMap.get(jsonObject.getString("uid")).setPwd(jsonObject.getString("pwd"));
		//변경된 pwd를 클라이언트가 확인할 수 있도록 전달한다
		jsonObjectResult.put("uid", memberMap.get(jsonObject.getString("uid")).getUid());
		jsonObjectResult.put("pwd", memberMap.get(jsonObject.getString("uid")).getPwd());
		jsonObjectResult.put("message", "비밀번호가 변경되었습니다.");
		try {
			//서버에 변경된 멤버 값을 저장한다.
			chatServer.saveFileMemberMap();
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//void serverFindPassword
	////////////////////////
	//메소드 : 회원탈퇴
	public void serverRemoveMember(DataOutputStream dos, JSONObject jsonObject) {
		JSONObject jsonObjectResult = new JSONObject();
		//회원정보가 삭제되었음을 알리는 메세지 전달
		jsonObjectResult.put("message",memberMap.get(jsonObject.getString("uid")).getUid()+"님의 회원정보가 삭제되었습니다.");
		//uid에 해당하는 회원정보 삭제
		memberMap.remove(jsonObject.getString("uid"));
		try {
			//변경된 map을 저장한다
			chatServer.saveFileMemberMap();
			dos.writeUTF(jsonObjectResult.toString());
			dos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}