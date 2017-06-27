import java.io.*;
import java.util.*;
public class palin
{
	Queue<Character> queue;
	Stack<Character> stack;
	palin(){
		queue = new LinkedList<Character>();
		stack = new Stack<Character>();

	}
	void push(char ch){
		stack.push(ch);
	}
	void enqueue(char ch){
		queue.add(ch);
	}

	char pop(){
		return stack.pop();
	}
	char dequeue(){
		return queue.remove();
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		char[] s = str.toCharArray();
		palin p = new palin();
		for(char ch : s){
			p.push(ch);
			p.enqueue(ch);
		}
		Boolean isPal=true;
		for(int i=0; i<s.length/2;i++){
			if(p.pop()!=p.dequeue()){
				isPal = false;
				break;
			}
		}
		if(isPal)
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");
	}
}
