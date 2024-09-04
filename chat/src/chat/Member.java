package chat;

public class Member implements java.io.Serializable {

	private static final long serialVersionUID = -1036524153261734687L;

	private String uid;
	private String name;
	private String pwd;
	private String age;
	private String phone;
	private String address;
	private String gender;

	public static Member of(JSONObject jsonObject) {
		Member member = new Member();
		
		member.uid = jsonObject.getString("uid");
		member.name = jsonObject.getString("name");
		member.pwd = jsonObject.getString("pwd");
		member.age = jsonObject.getString("age");
		member.phone = jsonObject.getString("phone");
		member.address = jsonObject.getString("address");
		member.gender = jsonObject.getString("gender");
		return member;
	}
	
	public static void ofPrint(JSONObject jsonObject) {
		
		System.out.println(("["+jsonObject.getString("name")+"]님의 상세정보"));
		System.out.printf(" 아 이 디 : %12s\n", jsonObject.getString("uid"));
		System.out.printf(" 이   름 : %12s\n", jsonObject.getString("name"));
		System.out.printf(" 비밀번호 : %12s\n", jsonObject.getString("pwd"));
		System.out.printf(" 나   이 : %12s\n", jsonObject.getString("age"));
		System.out.printf(" 전화번호 : %12s\n", jsonObject.getString("phone"));
		System.out.printf(" 주   소 : %12s\n", jsonObject.getString("address"));
		System.out.printf(" 성   별 : %12s\n", jsonObject.getString("gender"));
	}
	
	
	public JSONObject getJSONObject() {
		JSONObject jsonMember = new JSONObject();
		
		jsonMember.put("uid",uid);
		jsonMember.put("name",name);
		jsonMember.put("pwd",pwd);
		jsonMember.put("age",age);
		jsonMember.put("phone",phone);
		jsonMember.put("address",address);
		jsonMember.put("gender",gender);
		
		return jsonMember;
		
	}
}