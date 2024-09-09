package chap14;

public class B {
	void abc() throws InterruptedException {
		bcd();
	//	try {
	//		
	//	}
	//	catch (Exception e)
	//	{
	//		
	//	}
	}

	void bcd() throws InterruptedException {
		Thread.sleep(1000);
	}

}
