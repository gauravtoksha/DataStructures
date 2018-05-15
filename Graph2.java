
//MotherVertex
import java.util.*;
class Graph2 {
	int v;
	LinkedList<Integer> adjlist[];
	Graph2(int v){
		this.v=v;
			this.adjlist=(LinkedList<Integer>[])new LinkedList[v];
			for (int i=0; i<v; i++) {
				this.adjlist[i]=new LinkedList<Integer>();
			}
	}
	public void addEdge(int srcNumber,int desNumber){
		adjlist[srcNumber].add(desNumber);
	}
	public void motherVertices(){
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int vnum=0;
		while(vnum<this.v){
			hm.clear();
			stack.push(vnum);
			while(!stack.isEmpty()){
			int current = stack.pop();
			hm.put(current,1);
			Iterator<Integer> iterator = adjlist[current].listIterator(0);
			while(iterator.hasNext()){
				stack.push((int)iterator.next());
				}
			}
			if(hm.size()==this.v){
				System.out.println(vnum+" is the mother vertex");
			}
			vnum++;	
		}
		
		
	}
	public static void main(String[] args) {
		Graph2 graph = new Graph2(7);
		graph.addEdge(6,0);
		graph.addEdge(6,4);
		graph.addEdge(5,6);
		graph.addEdge(5,2);
		graph.addEdge(4,1);
		graph.addEdge(1,3);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		


		graph.motherVertices();
	}

}