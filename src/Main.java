   
    import java.util.Scanner;
    import java.util.Arrays;


public class Main {
	
	
	
	
	public static void drawBoard(char[] gameBoardArr) {
	       
	        //Prints board
	        System.out.println("---------");
	        System.out.println("| "+gameBoardArr[0]+" "+gameBoardArr[1]+" "+gameBoardArr[2]+" |");
	        System.out.println("| "+gameBoardArr[3]+" "+gameBoardArr[4]+" "+gameBoardArr[5]+" |");
	        System.out.println("| "+gameBoardArr[6]+" "+gameBoardArr[7]+" "+gameBoardArr[8]+" |");
	        System.out.println("---------");
	    }

public static void main(String[] args) {
	
	
	//vars
	boolean isGameDone = false;
    boolean isDraw = false;
    boolean isImpossible = false;
    boolean isONext = false;
    boolean isCoordinatesValid = false;
    char winner =' ';
    int a;
    int b;
    int c;
    int squaresFilled = 0;
    int numOfX = 0;
    int numOfO = 0;
    int numOfWinners = 0;
    int indexOfCoordinates = 0;
    int turns = 0;
	

    // Takes input and creates an array with all user input values
    Scanner scanner = new Scanner(System.in);
    char[] boardArr = new char[9];
    	Arrays.fill(boardArr, '_');
       
    	
    	
       //Prints board
       drawBoard(boardArr);
       
       
       while(!isGameDone && turns<9) {
    	   
    	   while(!isCoordinatesValid) {
    		   
	 			int column = 0;
	 			int row = 0;
	 			
	 			try {

		 			System.out.println("Enter coordinates: ");
	 				 column = scanner.nextInt();
			    	 row = scanner.nextInt();
	 			}catch(Exception e) {
	 				 scanner.nextLine();
	 				 System.out.println("Coordinates must be numbers!");
	 				 continue;
	 			}
		    	

		 
		    	indexOfCoordinates = ((column -1) + 6 )-((row -1)*3);
		    	if(row<=3&&column<=3) {
		    		if(boardArr[indexOfCoordinates] != 'O' && boardArr[indexOfCoordinates] != 'X') {
			    		boardArr[indexOfCoordinates] =  isONext ? 'O' : 'X';
			    		isONext = !isONext;
			    		turns++;
				        drawBoard(boardArr);
				        isCoordinatesValid = true;
			    	}else {
			    		System.out.println("This cell is occupied! Choose another one!");
			    	}
		    	}else {
		    		System.out.println("Coordinates should be from 1 to 3!");
		    	}
		    	
	    	 }//end while

		    	isCoordinatesValid = false;
		        
		        
		        //Array of index values for win combos
		 	   int[][] winCombos=  {
		 	                    {0,1,2},
		 	                    {3,4,5},
		 	                    {6,7,8},
		 	                    {0,3,6},
		 	                    {1,4,7},
		 	                    {2,5,8},
		 	                    {0,4,8},
		 	                    {2,4,6}
		 	   					};
		 	   
		         
		 		
		         for(int i=0; i < winCombos.length; i++) {
		 				a= winCombos[i][0];
		 				b= winCombos[i][1];
		 				c= winCombos[i][2];
		 				
		 			 if(boardArr[a]==boardArr[b]&&boardArr[a]==boardArr[c] && boardArr[a] != '_'){
		 				 isGameDone = true;
		 				 winner = boardArr[a];
		 				 numOfWinners++;
		                }
		 			}
    	   
       }//end game while loop
       
       
	      
	     //Checks for draw cases
	         if(numOfWinners == 0 )
			 {
				 isDraw = true;
			 }
       
	         //prints outcome of game
	     if(!isImpossible) {
	    	 
		    	 if(isGameDone) {
			         System.out.println( isDraw ? "Draw" : winner + " wins");	    	 
			     }
		    	 
	     }else {
	    	 System.out.println("Impossible");
	     }
	     
	     
     }//end Main
}//end Class
