/*Stock Buy Sell to Maximize Profit



The cost of a stock on each day is given in an array, 

find the max profit that you can make by buying and selling in those days. 



For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, 

the maximum profit can earned by buying on day 0, selling on day 3. 

Again buy on day 4 and sell on day 6. 

If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.



Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.

a. Find the local minima and store it as starting index. If not exists, return.

b. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.

c. Update the solution (Increment count of buy sell pairs)

d. Repeat the above steps if end is not reached.

Think about the data structure that you will use to store local minima and local maxima.*/

import java.util.*;
class StockBuyAndSell  {
	int[] arr;
	Queue<Pair> queue;
	StockBuyAndSell(int[] arr){
		this.arr=arr;
		queue=new LinkedList<Pair>();
	}
	public void findOptimum(){
		int currmax;
		int currmin;
		currmin=0;
		currmax=0;
		for (int i=1; i<arr.length; i++) {
			if(arr[i]<arr[currmax]){
				queue.add(new Pair(currmin,currmax));
				currmin=i;
				currmax=i;
			}
			else if(arr[i]<arr[currmin]){
				currmin=i;
				currmax=i;
			}
			else if(arr[i]>arr[currmax]){
				currmax=i;
				if(currmax==arr.length-1){						//if it reaches the end of the array
					queue.add(new Pair(currmin,currmax));
				}
			}
			
		}
	}
	public static void main(String[] args) {
		int[] arr={100,120,40,150,40,100,40};

		StockBuyAndSell stock=new StockBuyAndSell(arr);
		stock.findOptimum();

		if(stock.queue.isEmpty()){
			System.out.println("The array is in descending order");
		}
		else{
			Pair pair;
			int profit=0;
			while(!stock.queue.isEmpty()) {
				pair=stock.queue.remove();
				profit+=arr[pair.getSellDate()]-arr[pair.getBuyDate()];
				System.out.println("buy on: "+pair.getBuyDate()+" for "+arr[pair.getBuyDate()]+" ,sell on: "+pair.getSellDate()+" for "+arr[pair.getSellDate()]);
			}
			System.out.println("profit:"+profit);
		}
	}
}
class Pair{
	int buy;
	int sell;

	Pair(int buy,int sell){
		this.buy=buy;
		this.sell=sell;
	}
	public int getBuyDate(){
		return this.buy;
	}
	public int getSellDate(){
		return this.sell;
	}
}