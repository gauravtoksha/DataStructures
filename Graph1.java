
//Detecting Loop

import java.util.*;
class Graph1 {
	int v;
	LinkedList<Integer> adjlist[];
	Graph1(int v){
			this.adjlist=(LinkedList<Integer>[])new LinkedList[v];
			for (int i=0; i<v; i++) {
				this.adjlist[i]=new LinkedList<Integer>();
			}
	}
	public void addEdge(int srcNumber,int desNumber){
		adjlist[srcNumber].add(desNumber);
	}
	public Integer detectLoop(int v){
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(v);
		while(!stack.isEmpty()){
			int current = stack.pop();
			if(hm.containsKey(current))
				return current;
			else
				hm.put(current,1);

			Iterator<Integer> iterator = adjlist[current].listIterator(0);
			while(iterator.hasNext()){
				stack.push((int)iterator.next());
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Graph1 graph = new Graph1(5);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(2,0);
		graph.addEdge(2,3);
		graph.addEdge(1,2);

		System.out.println("loop at:"+graph.detectLoop(2));
	}

}