package chap4;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		배열 : 자료형이 같은 자료들이 연속으로 나열된 자료 구조
//		배열의 선언과 초기화 
//		자료형 [ ] 배열 이름 = new 자료형 [갯수];
//		자료형 배열 이름 [ ] = new 자료형 [갯수];
//		자료형 [ ] 배열 이름 = {};
		
		
		int [] num = new int [] {1,2,3,4,5};
		// i가 num 길이만큼 갖고 있고 모든 배열을 순환해서 가져오기
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		double[] date = new double[5];
		
		date[0] = 10.0;
		date[1] = 20.0;
		date[2] = 30.0;
		date[3] = 40.0;
		
		for (int i = 0; i<date.length; i++) {
			System.out.println(date[i]);
		}
		System.out.println("--------------------------");
		// size에 값을 더해서 해당 값만큼만 루프를 돌린다
		// 근데 굳이./?
		double [] base = new double [5];
		int size = 0;
		
		base [0] = 10.0; size ++;
		base [1] = 12.0; size ++;
		base [3] = 14.0; size ++;
		base [4] = 17.0; size ++;
		size ++;
		for(int i=0; i<size; i++) {
			System.out.println(base[i]);
		}
		System.out.println("--------------------------");
		
		char[] alphabets = new char[26];
		char ch = 'A';
		
		for (int i=0; i<alphabets.length; i++, ch++) {
			alphabets[i] = ch;
		}
		
		for (int i=0; i<alphabets.length; i++) {
			System.out.println(alphabets[i] + ":"+ (int)alphabets[i]);
		}
		
	}

}
