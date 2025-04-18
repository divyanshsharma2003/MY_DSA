package MY_DSA;
import java.util.*;

class nqueens_problem{
    int size;
    // Constructor
    nqueens_problem(int size){
        this.size = size;
        char [][] board = new char[size][size];
        for (int i=0;i<size;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = 'x';
            }
        }
        nqueen(board, 0);
    }
    // Nqueen Function
    static void nqueen(char [][]board, int row){
        int l = board.length;
        int k = 0;
        // Base Condition
        if(row == l){
            System.out.println("Configuration Without Any Queen Under Attack : ");
            for (int i=0;i<l;i++){
                for(int j=0;j<board[i].length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j =0;j<l;j++){
            if(isSafe(board, row, j)){
                board [row][j] = 'Q';
                nqueen(board, row+1);
                // Backtracking
                board [row][j] = 'x';
            }
        }
    }

    // isSafe Helper Fucntion
    static boolean isSafe(char board[][], int row, int col){
        // Checking The Entire Row
        int l = board.length;
        for (int j =0;j<=col;j++){
            if(board[row][j] == 'Q') return false;
        }
        // Checking The Entire Column
        for(int i=0;i<=row;i++){
            if(board[i][col] == 'Q')return false;
        }
        // Checking the North-East
        int i=row;
        int j = col;
        while(i>=0 && j<l){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        // Checking the South-East
        i = row;
        j = col;
        while(i<l && j<l){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        // Checking the North-West
        i = row;
        j = col;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        // Checking the South-West
        i = row;
        j = col;
        while(i<l && j>=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Dimension Of The Chess Board To Get All The Correct Config : ");
        int size = sc.nextInt();
        nqueens_problem q = new nqueens_problem(size);
    }
}