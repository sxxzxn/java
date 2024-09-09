package chap14;


public class Num {
	int nums;



	  public void checkNum(int nums) throws MinusException, OverException {
	        if (nums > 100) {
	            throw new OverException("입력하신 " + nums + " 점수가 100을 초과하여 입력이 불가합니다.");
	        } else if (nums <= 0) {
	            throw new MinusException("입력하신 " + nums + " 점수는 지정 범위 이하로 입력 불가합니다.");
	        } else {
	            System.out.println(nums + "은 유효한 점수입니다.");
	        }
	        this.nums = nums; // 클래스 필드 nums에 값 저장
	    }




}
