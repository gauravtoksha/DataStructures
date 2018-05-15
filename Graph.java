import java.util.*;
class Graph {

	//socialNetwork

	//adjacency list for undirected graph
	//username will be used to identify the linkedlist of friends id

	HashMap<String,LinkedList<String>> graph;
	Graph(){
		graph=new HashMap<String,LinkedList<String>>();
	}

	public void addVertex(String username){
		if(graph.containsKey(username)){
			System.out.println("user already exists");
		}
		else{
			graph.put(username,new LinkedList<String>());
		}
	}
	public void addEdge(String srcUsername,String desUsername){
		LinkedList<String> friends=graph.get(srcUsername);

		//since the dummy data is generated randomly edges are getting added twice or thrice between the same vertexs
		//and hence a checking is required to see if the friend is already in the friend list before adding
		//this is not needed but for my convenience for not creating a dummy data manually
		
		LinkedList<String> friends1 = graph.get(srcUsername);
		Iterator iterator1 = friends1.listIterator(0);
		String person1;
		while(iterator1.hasNext()){
			person1=(String)iterator1.next();
			if(person1.equals(desUsername))
					return;
		}
		friends.add(desUsername);
	}
	public void getSuggestions(String username,int k){
		HashMap<String,Integer> hmsuggestion= new HashMap<String,Integer>();
		
		
		
	/*		for (int i=0; i<dist && iterator.hasNext(); i++) {
			
			//till 'k' levels for each given person in dist
			String person=(String)iterator.next();
			LinkedList<String> suggestions=graph.get(person);
			Iterator fiterator = suggestions.listIterator(0);
			for (int a=0; a<dist && fiterator.hasNext();a++ ) {
				String name=(String)fiterator.next();
				
				//if the suggested friend is already in the friendlist ignore it
				if(friends.contains(name) || name==username){
					continue;
				}
				
				//otherwise print it
				if(hmsuggestion.containsKey(name)){
					hmsuggestion.put(name,hmsuggestion.get(name)+1);	
				}

				else{
					hmsuggestion.put(name,1);
				}
			}
		}
	*/
		LinkedList<String> friends=graph.get(username);

		Deque<String> stack = new ArrayDeque<String>();

		stack.push(username);
		int level=0;
		HashMap<String,Integer> visited= new HashMap<String,Integer>();
		while(!stack.isEmpty() || level<k ){
			String current = stack.pop();
			visited.put(current,1);
			if(current!=username && !friends.contains(current))
				hmsuggestion.put(current,1);

			Iterator iterator= graph.get(current).listIterator(0);
			while(iterator.hasNext()){
				String next = (String)iterator.next();
				if(!visited.containsKey(next))
					stack.push(next);
			}
			level++;
		}
		
		System.out.println("Suggested friends");
		Set<String> keys = hmsuggestion.keySet();
     	Iterator<String> iter = keys.iterator();
     	while(iter.hasNext()){
        String key = iter.next();
        System.out.println(""+key);
     	}
	}
	public void display(){
		for(String username : graph.keySet()){
			LinkedList<String> list=graph.get(username);
			System.out.println(username+":"+list);
		}
	}
	public static void main(String[] args) {
		Graph social = new Graph();
		//dummy data
		String[] list={"Georgiann","Soon","Victor","Roselyn",
						"Alaina","Delcie","Shanel","Annalisa","Corrinne"};

		for (String username:list ) {
			social.addVertex(username);
		}
				
		//dummy social network
		for (String username:list ) {
			ArrayList<String> randomlist=randomlistgen(Arrays.asList(list),username);
			for (String friend:randomlist ) {
				social.addEdge(username,friend);
				social.addEdge(friend,username);				
			}
		}

			//Uncomment to print the social network 
		social.display();
		

		//suggestions
		System.out.println();
		System.out.println("Suggestions for Soon");
		System.out.println();
		social.getSuggestions("Soon",4);
		System.out.println();
		System.out.println();
		System.out.println("Note:Friend lists are generated randomly for each person and are different for each run / try running more than once");

	}
	public static ArrayList<String> randomlistgen(List<String> list,String username){
		Random random=new Random();
		int r=random.nextInt((5 - 1) + 1) + 1;
		ArrayList<String> listr= new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			if(i%r==0 && list.get(i)!=username){
				listr.add(list.get(i));
			}
		}
		return listr;
	}
}