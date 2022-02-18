package Practical_20;


public class SierpinskiCarpet {
    public static void main(String[] args) {
        int dimension = 27;
        char[][] board = new char[dimension][dimension];
        //sets up board
        setUpBoard(board, dimension);
        remove(board,dimension,0 ,0);
        printBoard(board, dimension);
    }
    public static void remove(char[][] board, int dimension, int row, int column){
        for(int y = dimension/3; y < (dimension/3)*2; y++){
            for(int x = dimension/3; x < (dimension/3)*2; x++){
                board[y+row][x+column] = ' ';//gets mid
            }
        }
        if(dimension >1){
            for(int y = 0; y < dimension; y = y + dimension/3 ){
                for(int x = 0; x < dimension; x = x + dimension/3){
                    remove(board, dimension/3,y,x);//get everything around mid
                }
            }
        }
    }

    public static void setUpBoard(char[][] board, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = '*';
            }
        }
    }

    public static void printBoard(char[][] board, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
