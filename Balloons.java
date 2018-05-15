// Consider that you are in a room filled with multiple colored balloons.

// Number of balloons: N, Number of colors : M

// write a solution to : count balloons w.r.t colors and finally the total number of balloons

// input to be given in array.



// Think about the data structure that you will use to store the count of a particular color.


import java.util.*;
class Balloons {

	public static void main(String[] args) {


		String[] arr={"G","R","B","R","Y","B","O","G","B"};
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		for (String balloon:arr ) {
			if(hm.containsKey(balloon)){
				hm.put(balloon,hm.get(balloon)+1);
			}
			else{
				hm.put(balloon,1);
			}		
		}
		System.out.println(hm);
		int total=0;
		for (Integer value :hm.values()) {
			total+=value;
		}
		System.out.println(total);
	}
}