public class BacktrackingQueens {

    private final int[][] board;
    private final int boardSize;


    public BacktrackingQueens(int x) {
        assert x!= 0;

        this.board = new int[x][x];
        this.boardSize = x;

        backtracking();

        for(int i=0; i<board[0].length; i++){
            StringBuilder line = new StringBuilder();
            for(int j=0; j<board[0].length; j++){
                line.append(board[i][j]);
            }
            System.out.println(line);
        }
    }

    private boolean backtracking() {
        for(int i=0; i<boardSize; i++){
            if(!rowFilled(i)){
                for(int j=0; j<boardSize; j++){
                    if(isSafe(i, j)){
                        board[i][j] = 1;
                        if(backtracking()){
                           return true;
                        } else {
                            board[i][j] = 0;
                        }
                    }
                }
            }
        }
        return isComplete();
    }

    private boolean isSafe(int i, int j){
        if(rowFilled(i)){
            return false;
        }
        if(columnFilled(j)){
            return false;
        }
        if(diagonalsFilled(i,j)){
            return false;
        }
        return true;
    }


    private boolean rowFilled(int row){
        for(int cell=0; cell<boardSize; cell++){
            if(board[row][cell]==1){
                return true;
            }
        }
        return false;
    }

    private boolean columnFilled(int column){
        for(int row=0; row<boardSize; row++){
            if(board[row][column]==1){
                return true;
            }
        }
        return false;
    }

    private boolean diagonalsFilled(int row, int column){
        if(topLeftDiagonal(row, column)){
            return true;
        }
        if(topRightDiagonal(row, column)){
            return true;
        }
        if(bottomLeftDiagonal(row, column)){
            return true;
        }
        if(bottomRightDiagonal(row, column)){
            return true;
        }
        return false;
    }

    private boolean topLeftDiagonal(int row, int column) {
        while (row>=0 && column>=0){
            if(board[row][column]==1){
                return true;
            }
            row--;
            column--;
        }
        return false;
    }

    private boolean topRightDiagonal(int row, int column) {
        while (row>=0 && column<boardSize){
            if(board[row][column]==1){
                return true;
            }
            row--;
            column++;
        }
        return false;
    }

    private boolean bottomLeftDiagonal(int row, int column) {
        while (row<boardSize && column>=0){
            if(board[row][column]==1){
                return true;
            }
            row++;
            column--;
        }
        return false;
    }

    private boolean bottomRightDiagonal(int row, int column) {
        while (row<boardSize && column<boardSize){
            if(board[row][column]==1){
                return true;
            }
            row++;
            column++;
        }
        return false;
    }

    private boolean isComplete(){

        for(int i=0; i<boardSize; i++){
            if(!rowFilled(i)){
                return false;
            }
        }
        return true;
    }
}
