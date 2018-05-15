import java.util.*;
import java.io.*;
/*
logic is to use the compareTo function to insert the elements

for searchin the element:
find the first matched element then traverse the leaf nodes of that element for all the matching elements*/

class PhoneBook {
	Btnode root;
	public static void main(String[] args) {
		PhoneBook pb=new PhoneBook();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int input=0;
		do{
			System.out.println("--------------------------------");
			System.out.println("Select anyone of the following:");
			System.out.println("1.Insert a contact");
			System.out.println("2.Search a contact");
			System.out.println("3.Display all the records");
			System.out.println("4.exit");
			System.out.println("--------------------------------");
			try{
			input=Integer.parseInt(reader.readLine());
			switch(input){
				case 1:{
					System.out.println("Enter a name");
					String name=reader.readLine();
					System.out.println("Enter a number");
					String number=reader.readLine();
					Person p=new Person(name,number);
					if(pb.root==null){
						pb.root=new Btnode(p);
					}
					else
					{
						pb.root.insert(p);
					}
					break;
				}
				case 2:{
					//searching through tree
					System.out.println("Enter a name to search");
					String search=reader.readLine();
					pb.root.find(search.toLowerCase());
					if(Btnode.listp.isEmpty()){
						System.out.println("--------------------------------");
						System.out.println("no records");

					}
					else{
							System.out.println("found "+Btnode.listp.size()+" records:");
							for (Person person:Btnode.listp ) {
								System.out.println(person.getName()+" "+person.getNumber());
						}	
					}
					Btnode.listp.clear();
					break;
				}
				case 3:{
					//inorder traversal
					if(pb.root!=null){
					pb.root.inorder();	
					}
					break;
				}
				case 4:{
					System.out.println("exiting..");
					break;
				}
				default :{
					System.out.println("invalid input");
					break;
				}
			}	

			}catch(IOException e){e.printStackTrace();}
			catch(NumberFormatException n){System.out.println("enter only digits");}
			
		}while(input!=4);
	}
	
}
class Btnode{
	Person p;
	Btnode left;
	Btnode right;
	static List<Person> listp=new LinkedList<Person>();	//storing the records found during find function
	Btnode(Person data){
		this.p=data;
		left=null;
		right=null;
	}
	public void insert(Person data){
		if(data.getName().compareTo(p.getName())==0){
			System.out.println("Contact already exist.");
		}
		else if(data.getName().compareTo(p.getName())<=0){
			System.out.println();
			if(left==null)
				left=new Btnode(data);
			else
				left.insert(data);
		}
		else{
			if(right==null)
				right=new Btnode(data);
			else
				right.insert(data);
		}
	}
	public void find(String name){
		if(p.getName().contains(name)){
			
			inorder(this,name);				//once the first matched node is found traverse the remaining nodes using inorder
			return;
		}
		if(name.compareTo(p.getName())<0){
			if(left==null){
				return;
			}
			else{
				left.find(name);
			}
		}
		else
		{
			if(right==null){
				return;
			}
			else{
				right.find(name);
			}
		}
	}
	static public void inorder(Btnode root,String name){		//this static method is used to traverse the nodes given a root node
		if(root.left!=null){									//purpose of this is to traverse the remaining nodes once u have found the first matched node
			inorder(root.left,name);
		}
		if(root.p.getName().contains(name)){
			listp.add(root.p);
		}
			
		if(root.right!=null){
			inorder(root.right,name);
		}
	}
	public void inorder(){
		if(left!=null){
			left.inorder();
		}
		System.out.println(p.getName()+" "+p.getNumber());
		if(right!=null){
			right.inorder();
		}
	}
}
class Person{
	String name;
	String number;
	Person(String name,String number){
		this.name=name.toLowerCase();
		this.number=number;
	}
	public String getName(){
		return this.name;
	}
	public String getNumber(){
		return this.number;
	}
	public void setName(String name){
		this.name=name.toLowerCase();
	}
	public void setNumber(String number){
		this.number=number;
	}

}