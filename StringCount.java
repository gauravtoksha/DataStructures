import java.util.*;
import java.io.*;
class StringCount {
	public static void main(String[] args) {


		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String input="";
		System.out.println("enter a string:");
		try{
			input=reader.readLine();
		}catch(Exception e){e.printStackTrace();}
		char[] inputarr=input.toCharArray();
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		for(char ch:inputarr){
			if(!hm.containsKey(ch)){
				hm.put(ch,1);
			}
			else
				hm.put(ch,hm.get(ch)+1);
		}
		
		System.out.println(hm);	
	}
}