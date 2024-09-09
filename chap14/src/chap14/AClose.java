package chap14;

public class AClose implements AutoCloseable {

	String rsc;
	AClose() {
		
	}
	AClose(String rsc){
		this.rsc = rsc;
	}
	void abc() throws Exception
	{
		
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(rsc !=null ) {
			rsc = null;
			System.out.println("리소스해제");
		}
	}
	
	


}
