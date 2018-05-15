/*Cycle/Loop in linked list

a.	Write an algorithm to detect a cycle in loop

b.	Write an algorithm to remove the cycle

*/

class LinkedList1 {
	Node head;

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
	public void deleteWithValue(int value){
		Node current=head;
		while(current!=null && current.next!=null){
			if(current.next.data==value){ 
				current.next=current.next.next;
			}
			current=current.next;
		}
	}
	public void prepend(int value){
		Node node=new Node(value);

		if(head==null){
			head=node;
			return;
		}
		node.next=head;
		head=node;
	}
	public void printList(){
		Node current=head;
		while(current!=null){
			System.out.println(current.data);
			current=current.next;
		}

	}
	public void makeItReverse(){
		Node current=head;
		Node next=null;
		Node previous=null;
		while(current!=null){
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
		while(previous.next!=null){
			System.out.println(previous.data);
			previous=previous.next;
		}
	}
	public void nthElementFromLast(int n){
		Node first=head;
		Node second=head;
		for (int i=0; i<n; i++) {
			first=first.next;
			if(first==null){
				System.out.println("n is too large");
				return;
			}
		}
		while(first.next!=null){
			first=first.next;
			second=second.next;
		}
		System.out.println(n+" from last:"+second.data);
	}

	public void oddOrEvenList(){
		Node first=head;
		Node second=head;

		int i=0,k=0;
		while(second!=null && second.next!=null){
			first=first.next;
			k++;
			second=second.next.next;
			i+=2;
		}
		System.out.println("length of the first half:"+k);
		System.out.println("length of the second half:"+(i-k));
	}	
	

	public void makeCycle(){		//for testing purpose
		Node first=head;
		while(first.next!=null){
			first=first.next;
		}
		first.next=head.next;
	}

	public Node findCycle(){
		Node slow=head;
		Node fast=head;
		int i=0;
		while(fast!=null||fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow){
				System.out.println("LinkedList has a cycle");
				return fast;
			}
		}
		return null;
	}
	public void removeCycle(Node meet){
		//move a pointer from 'meet' and move a pointer from the head
		//move both the pointer at same speed
		//for every move from the head, loop with fast pointer till it reaches the pointer starting from head
		Node slow=head;
		Node fast=meet;
		while(slow.next!=null){
			fast=fast.next;
			while(fast.next!=meet){
				if(fast.next.next==slow){
					fast.next.next=null;
					return;
				}
				if(fast.next==slow){
					fast.next=null;
					return ;
				}
				fast=fast.next;
			}
			slow=slow.next;	
		}
	}



	public static void main(String[] args) {
		LinkedList1 ll=new LinkedList1();
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

		Node meet=ll.findCycle();
		if(meet==null)
		{
			System.out.println("no cycle");
		}
		else
		{
			ll.removeCycle(meet);
			System.out.println("removed");
		}

		ll.printList();
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