package chap8;

public class Job extends Human {
	int jobNo;

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public void goToCompany() {
		System.out.println("출근");
	}
	
	public void sleep() {
		super.sleep();
		System.out.println("직장인 잔자"
				+ "");
	}


}
