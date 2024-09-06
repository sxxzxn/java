package chap11;

public class ExecInterface implements C {

//	@Override
//	public void ccc() {
//
//	}

	@Override
	public String getConnenction(String ip, int port) {
		// TODO Auto-generated method stub
		System.out.println(C.ip);
		return "CONN";
	}

}
