package chap4;

import java.util.Scanner;

public class exWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int num = 1;
//		int sum = 0;
//		while (num <= 10) {
//
//			sum += num;
//			num++;
//
//		}
//		System.out.println(sum);
//
//		// 1~100 사이 3의 배수 함
//
//		int a = 1;
//		int b = 0;
//		while (a <= 100) {
//			if (a % 3 == 0) {
//				b += a;
//			}
//			a++;
//		}
//		System.out.println("1~100 사이 3의 배수 합 :" + b);
//		// 1~100 사이 3의 배수 함 for
//
//		int forb = 0;
//		for (int i = 1; i <= 100; i++) {
//			if (i % 3 == 0) {
//				forb += i;
//			}
//		}
//		System.out.println("1~100 사이 3의 배수 합 :" + forb);
//
//		// 1~100 사이의 4의배수
//		int aa = 1;
//		int bb = 0;
//		while (aa <= 100) {
//			if (aa % 4 == 0) {
//				bb += aa;
//			}
//			aa++;
//		}
//		System.out.println("1~100 사이 4의 배수 합 while :" + bb);
//
//		// 1~100 사이의 4의배수 for
//		int forbb = 0;
//		for (int fi = 1; fi <= 100; fi++) {
//			if (fi % 4 == 0) {
//				forbb = forbb + fi;
//			}
//		}
//		System.out.println("1~100 사이 4의 배수 합 for:" + forbb);

		// 중첩 for
//		int tot = 0;
//		for (int i = 2; i < 10; i++) {
//			System.out.println(i + "단");
//			for (int n = 1; n < 10; n++) {
//				tot = i * n;
//				System.out.print(i + "X" + n + "=" + tot);
//				System.out.print ("    ");
//			}
//			System.out.println( );
//		}
		int tot = 0;
		for (int i = 2; i < 6; i++) {
			System.out.print("  " + i + "단");
			System.out.print("\t");
		}
		System.out.println();

		for (int n = 1; n < 10; n++) {
			for (int i = 2; i < 6; i++) {

				tot = i * n;
				System.out.print(i + "X" + n + "=" + tot);
				System.out.print("\t");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 6; i < 10; i++) {
			System.out.print("  " + i + "단");
			System.out.print("\t");
		}
		System.out.println();
		for (int n = 1; n < 10; n++) {
			for (int i = 6; i < 10; i++) {
				tot = i * n;
				System.out.print(i + "X" + n + "=" + tot);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("----------------------------");

		
		
		System.out.println("  2단\t  3단\t  4단\t  5단\t  6단\t  7단\t  8단\t  9단");

		for (int n = 1; n < 10; n++) {
			switch (n) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				for (int i = 2; i < 10; i++) {
					tot = i * n;
					System.out.print(i + "X" + n + "=" + tot);
					System.out.print("\t");
				}
				break;
			}
			System.out.println();
		}
		


	}
}
