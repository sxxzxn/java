package exam;

import java.io.Serializable;
import java.util.Objects;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
	//필드 : 객체를 파일로 저장하기 위해 직렬화가 필요한데 이를위한 Serializable의 번호
	private static final long serialVersionUID = -1036524153261734687L;
	//필드 : 회원들의 정보를 저장하기 위한 변수
	private String uid;
	private String name;
	private String pwd;
	private String age;
	private String phone;
	private String address;
	private String gender;
	
	
//	public Member(String uid, String name, String pwd) {
//		this.uid = uid;
//		this.name = name;
//		this.pwd = pwd;
//	}
	
//	public Member(String uid, String name, String pwd, String address, String phone, String age) {
//		this.uid = uid;
//		this.name = name;
//		this.pwd = pwd;
//		this.address = address;
//		this.phone = phone;
//		this.age = age;
//	}
	///////////////////////////////////////////////
	//메소드 : json에 저장된 정보로 초기화된 Member 객체를 반환
	public static Member of(JSONObject jsonObject) {
		Member member = new Member();
		
		member.uid     = jsonObject.getString("uid");
		member.name    = jsonObject.getString("name");
		member.pwd     = jsonObject.getString("pwd");
		member.address = jsonObject.getString("address");
		member.phone   = jsonObject.getString("phone");
		member.age     = jsonObject.getString("age");
		member.gender  = jsonObject.getString("gender");
		return  member;
	}
	////////////////////////////////
	//메소드 : 회원의 정보를 출력
	public static void ofPrint(JSONObject jsonObject) {
		
		System.out.println("["+jsonObject.getString("name")+"]님의 상세정보");
		System.out.printf(" 아 이 디 : %12s\n", jsonObject.getString("uid"));
		System.out.printf(" 이   름 : %12s\n", jsonObject.getString("name"));
		System.out.printf(" 비밀번호 : %12s\n", jsonObject.getString("pwd"));
		System.out.printf(" 나   이 : %12s\n", jsonObject.getString("age"));
		System.out.printf(" 전화번호 : %12s\n", jsonObject.getString("phone"));
		System.out.printf(" 주   소 : %12s\n", jsonObject.getString("address"));
		System.out.printf(" 성   별 : %12s\n", jsonObject.getString("gender"));
	}//public static void ofPrint
	///////////////////
	//메소드 : 객체 비교를 위한 equals 와 hashcode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(uid, other.uid);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(uid);
	}
	///////////////////////////
	//메소드 : 현재 Member 객체를 json에 저장해 리턴
	public JSONObject getJSONObject() {
		JSONObject jsonMember = new JSONObject();
		
		jsonMember.put("uid", uid);
		jsonMember.put("pwd", pwd);
		jsonMember.put("name", name);
		jsonMember.put("age", age);
		jsonMember.put("address", address);
		jsonMember.put("phone", phone);
		jsonMember.put("gender", gender);
		
		return jsonMember;
	}//public JSONObject getJSONObject()
}
