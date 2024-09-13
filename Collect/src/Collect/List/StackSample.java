package Collect.List;

import java.util.Stack;

public class StackSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<Integer>();

		// #1. push(E)
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		
//		System.out.println(stack.firstElement());
		
		// #2. peek()
		System.out.println("stack.peek() : " +stack.peek());
		System.out.println("stack.size() : "+stack.size());
		System.out.println(stack.get(stack.size()-1));

		// #3. int search(Object)  없는값 조회시 0 RIFO 7이 1이된다
		System.out.println(stack);
		System.out.println("stack.search(1) : " +stack.search(1)); // -1
		System.out.println("stack.search(2) : " +stack.search(2)); //  4
		System.out.println("stack.search(5) : " +stack.search(5)); //  3
		System.out.println("stack.search(4) : " +stack.search(4)); // -1
		System.out.println("stack.search(3) : " +stack.search(3)); //  2
		System.out.println("stack.search(7) : " +stack.search(7)); //  1
		
		//  #4. pop()
		System.out.println(stack.pop() + " : " +stack);
		System.out.println(stack.pop() + " : " +stack);
		System.out.println(stack.pop() + " : " +stack);
		System.out.println(stack.pop() + " : " +stack);

		// #5.empty
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		
		stack.clear();
		System.out.println(stack.empty());   //비어있으면 true
		System.out.println(stack.isEmpty()); //비어있으면 true
	
	}

}
