/*Solution is implemented using two stacks ,one for data and one for storing the min values

*/
import java.io.*;
class StackWithMin {
	Node data_head;
	Node min_head;

	public void push(int data){
		Node newnode=new Node(data);			
		if(data_head==null){
			data_head=newnode;
		}
		else
		{
			newnode.next=data_head;
			data_head=newnode;
		}
		if(peekToMin()==null||data<peekToMin()||data==peekToMin()){
			pushToMin(data);
		}
	}
	public Integer pop(){
		if(data_head==null){
			System.out.println("no elements in stack");
			return null;
		}
		Node temp=data_head;
		data_head=temp.next;
		if(temp.data==peekToMin()){
			popFromMin();
		}
		return temp.data;
	}
	public Integer top(){
		if(data_head==null){
			System.out.println("no elements in stack");
			return null;
		}
		else{
			return data_head.data;
		}
	}
	public Integer getMin(){
		if(min_head==null){
			System.out.println("no elements in min stack");
			return null;
		}
		else
		{
			return peekToMin();
		}
	}

	//min stack
	public void pushToMin(int data){
		Node newnode=new Node(data);
		if(min_head==null){
			min_head=newnode;	
		}
		else{
			newnode.next=min_head;
			min_head=newnode;	
		}
	}
	public void popFromMin(){
		if(min_head==null){
			System.out.println("no elements in min stack");
		}
		min_head=min_head.next;
	}
	public Integer peekToMin(){
		if(min_head==null){
			return null;
		}
		return min_head.data;
	}
	public void printStack(){
		if(data_head==null){
			System.out.println("no elements in stack");
			return;
		}
		Node temp=data_head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		StackWithMin stack=new StackWithMin();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int menuinput;
		int input;
		try{
			do{
			System.out.println("select anyone of the following");
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.top");
			System.out.println("4.getMin");
			System.out.println("5.print stack");
			System.out.println("6.exit");
			menuinput=Integer.parseInt(br.readLine());
			switch(menuinput){
				case 1:{
					input=Integer.parseInt(br.readLine());
					stack.push(input);
					break;
				}
				case 2:{
					System.out.println("popped:"+stack.pop());
					break;
				}
				case 3:{
					System.out.println("top element:"+stack.top());
					break;
				}
				case 4:{
					System.out.println("Current min element:"+stack.getMin());
					break;
				}
				case 5:{
					stack.printStack();
					break;
				}
				case 6:{
					System.out.println("exiting...");
					break;
				}
				default:{
					System.out.println("invalid input");
					break;
				}
			}
		}while(menuinput!=6);	
		}
		catch(IOException e){e.printStackTrace();}
		catch(NumberFormatException n){n.printStackTrace();}
		
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}