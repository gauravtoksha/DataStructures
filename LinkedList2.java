
import java.util.*;
class LinkedList2 {
	Node head;

	public void detectLoop(){
		HashMap<Node,Integer> hm = new HashMap<Node,Integer>();
		Node temp=head;
		while(temp!=null){
			if(hm.containsKey(temp)){
				System.out.println("found loop at:"+temp.data);
				break;
			}
			else
				hm.put(temp,1);
			temp=temp.next;
		}
	}

	public void append(int value){
		
		Node node= new Node(value);

		if(head==null){
			head=node;
			return;
		}
		Node current=head;
		while(current.next!=null){
			current=current.next;
		}
		current.next=node;
	}
	public void printList(){
		Node current=head;
		while(current!=null){
			System.out.println(current.data);
			current=current.next;
		}

	}

	public void makeCycle(){		//for testing purpose
		Node first=head;
		while(first.next!=null){
			first=first.next;
		}
		first.next=head.next;
	}

	
	

	public static void main(String[] args) {
		LinkedList2 ll=new LinkedList2();
		for (int i=0; i<20; i++) {
			ll.append(i);
		}
		System.out.println("elements in the linkedlist");
		ll.printList();
		System.out.println();
		
		//making cycle of the second element and last element
		ll.makeCycle();
		//remove the below comment to see the loop before removing it
		//ll.printList();
		ll.detectLoop();
	//	ll.printList();
	}
}
class Node{
	int data;
	Node next;
	Node(int value){
		this.data=value;
		this.next=null;
	}
}