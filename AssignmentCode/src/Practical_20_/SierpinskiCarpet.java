package Practical_20_;

public class SierpinskiCarpet {
    public static void main(String[] args) {
        int dimension = 27;
        char[][] board = new char[dimension][dimension];
        setUpBoard(board, dimension);

        remove(board,dimension,dimension/3,dimension/3,dimension/3, 0);
        printBoard(board,dimension);
    }

    public static void remove(char[][] board, int totalSize, int removeSize,int row, int column, int passesMade){
        for(int y = row; y < (removeSize)*2; y++){
            for(int x = column; x < (removeSize)*2; x++){
                board[y][x] = ' ';//gets a square of a given size
            }
        }
        if(passesMade != passCounter(totalSize)){
            passesMade++;
            for(int y = removeSize/3; y < totalSize; y = y + y) {
                for (int x = removeSize / 3; x < totalSize; x = x + x) {
                    remove(board, totalSize, removeSize / 3, y, x, passesMade);
                }
            }
        }
    }


    public static int passCounter(int dimension){//will give how many recursions the loop will need to do
        int pass = 0;
        while (dimension!= 3){
            dimension = dimension/3;
            pass++;
        }
        return pass;
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
