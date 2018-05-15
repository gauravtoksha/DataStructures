import java.util.*;
public class RottenTomato {
      int row;
      int col;
      Queue<Pair> queue;
      int[][] matrix;
      int timeframe;
      RottenTomato(int[][] matrix,int row,int col){
            this.row=row;
            this.col=col;
            this.matrix=matrix;
      }
      public int getTimeFrame(){return this.timeframe;}
      public int startRot(){
            queue=new LinkedList<Pair>();
            for (int i=0;i<row ;i++ ) {
                  for (int j=0; j<col; j++) {
                        if(matrix[i][j]==2){
                              queue.add(new Pair(i,j));
                        }
                  }              
            }
            queue.add(new Pair(-2,-2));
            Pair pair;
            while(queue.peek()!=null){
                  
                  
                  pair=queue.remove();

                  if(pair.getRow()==-2){
                        timeframe++;
                        if(checkAllRot(matrix,row,col)){
                              return 1;
                        }
                        if(queue.peek()!=null){
                              queue.add(new Pair(-2,-2));
                        }
                        continue;
                  }
                  if(pair.getRow()+1<row){
                        if(matrix[pair.getRow()+1][pair.getCol()]==1){
                              matrix[pair.getRow()+1][pair.getCol()]=2;
                              queue.add(new Pair(pair.getRow()+1,pair.getCol()));
                        }
                  }
                  if(pair.getRow()-1>=0){
                        if(matrix[pair.getRow()-1][pair.getCol()]==1){
                              matrix[pair.getRow()-1][pair.getCol()]=2;
                              queue.add(new Pair(pair.getRow()-1,pair.getCol()));
                        }
                  }
                  if(pair.getCol()+1<col){
                        if(matrix[pair.getRow()][pair.getCol()+1]==1){
                              matrix[pair.getRow()][pair.getCol()+1]=2;
                              queue.add(new Pair(pair.getRow(),pair.getCol()+1));
                        }
                  }
                  if(pair.getCol()-1>=0){
                        if(matrix[pair.getRow()][pair.getCol()-1]==1){
                              matrix[pair.getRow()][pair.getCol()-1]=2;
                              queue.add(new Pair(pair.getRow(),pair.getCol()-1));
                        }
                  }     
            }
            
            timeframe=0; //since if there isnt a solution of the problem,timeframe has changed to zero 		
            return -1;	
      }
      public void printBasket(){

            for (int i=0;i<row ;i++ ) {
                  for (int j=0; j<col; j++) {
                        System.out.print(matrix[i][j]+" ");
                  }
                  System.out.println();               
            }
      }
	public static void main(String[] args) {
		
			int row=3;
			int col=5;
			int[][] matrix=	 {{2, 1, 0, 2, 1},
                     		       {0, 0, 1, 2, 1},
                     		       {1, 0, 0, 2, 1}};
            
            RottenTomato rotTomato=new RottenTomato(matrix,row,col);
            
            if(rotTomato.startRot()==1){
                  rotTomato.printBasket();
                  System.out.println("timeframe took:"+rotTomato.getTimeFrame());
            }
            else
            {
                  rotTomato.printBasket();
                  System.out.println("All the tomato cannot be rotten");
            }
           
            }
            public boolean checkAllRot(int[][] matrix,int row,int col){
                  for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++) {
                              if(matrix[i][j]==1)
                                    return false;
                        }
                  }
                  return true;
            }

}
class Pair{
	int row;
	int col;
	Pair(int row,int col){
		this.row=row;
		this.col=col;
	}
	public int getRow(){return this.row;}
	public int getCol(){return this.col;}
}