package Collect.List;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Queue 부모 LinkedList 자식
		Queue<Integer> q1 = new LinkedList<Integer>();
//		if(q1.isEmpty() == false && q1 !=null) {
//		System.out.println(q1.element());
//		}else {
//			System.out.println("입력값이 없습니다");
//		}
		
		try {
			System.out.println(q1.element());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			
		}
		
		q1.add(1);
		q1.add(2);
		q1.add(3);
		System.out.println(q1.element());
//		System.out.println(q1.remove(q1));

		Queue<Integer> q2 = new LinkedList<Integer>();
//		q2.add(3);
//		q2.add(4);
//		q2.add(5);
//		q2.addAll(q1);
//		System.out.println(q2);
////		q2.remove(1); // 객체를 바로 삭제
//		System.out.println(q2);
//		q2.removeAll(q1);
//		System.out.println(q2);
		
		q2.offer(1);
		q2.offer(2);
		q2.offer(3);
		q2.offer(4);
		q2.offer(5);
		System.out.println(q2);
//		q2.clear();
		
		//peek()
		System.out.println(q2.peek());
		
		//poll
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
	}

}
