public class KnightBoard{
  int[][] board;
  int maxRows;
  int maxCols;

  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    maxRows = startingRows;
    maxCols = startingCols;
  }

  public String toString(){
    String ans = "";
    for (int row=0; row<maxRows; row++){
      for (int col=0; col<maxCols; col++){
        if (maxRows*maxCols > 9){
          if (board[row][col] == 0){
            ans += " _ ";
          } else if (board[row][col] < 10){
            ans += " "+ board[row][col] + " ";
          } else {
            ans += board[row][col] + " ";
          }
        } else {
          if (board[row][col] == 0){
            ans += "_ ";
          } else {
            ans += board[row][col] + " ";
          }
        }
      }
      ans += "\n";
    }
    return ans;
  }

  private void clear(){
    for (int row=0; row<maxRows; row++){
      for (int col=0; col<maxCols; col++){
        board[row][col] = 0;
      }
    }
  }

  public boolean solve(int startingRow, int startingCol){
    if (startingRow < 0 || startingCol < 0 || startingRow > maxRows || startingCol > maxCols){
      throw new IllegalArgumentException();
    }
    for (int row=0; row<maxRows; row++){
      for (int col=0; col<maxCols; col++){
        if (board[row][col] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveH(startingRow, startingCol, 1);
  }

  private boolean solveH(int row ,int col, int level){
    if (level == maxCols * maxRows){
      return true;
    }
    int[][] blocks = new int[8][2];
    int index = 0;
    if (row < maxRows - 2 && col > 0 && board[row+2][col-1] == 0){
      board[row+2][col-1] = level;
      blocks[index][0] = row+2;
      blocks[index][1] = col-1;
      index++;
    } else if (row < maxRows - 2 && col < maxCols - 1 && board[row+2][col+1] == 0){
      board[row+2][col+1] = level;
      blocks[index][0] = row+2;
      blocks[index][1] = col+1;
      index++;
    } else if (row < maxRows - 1 && col < maxCols - 2 && board[row+1][col+2] == 0){
      board[row+1][col+2] = level;
      blocks[index][0] = row+1;
      blocks[index][1] = col+2;
      index++;
    } else if (row > 0 && col < maxCols - 2 && board[row-1][col+2] == 0){
      board[row-1][col+2] = level;
      blocks[index][0] = row-1;
      blocks[index][1] = col+2;
      index++;
    } else if (row > 1 && col > 0 && board[row-2][col-1] == 0){
      board[row-2][col-1] = level;
      blocks[index][0] = row-2;
      blocks[index][1] = col-1;
      index++;
    } else if (row > 1 && col < maxCols - 1 && board[row-2][col+1] == 0){
      board[row-2][col+1] = level;
      blocks[index][0] = row-2;
      blocks[index][1] = col+1;
      index++;
    } else if (row > 0 && col > 1 && board[row-1][col-2] == 0){
      board[row-1][col-2] = level;
      blocks[index][0] = row-1;
      blocks[index][1] = col-2;
      index++;
    } else if (row < maxRows - 1 && col > 1 && board[row+1][col-2] == 0){
      board[row+1][col-2] = level;
      blocks[index][0] = row+1;
      blocks[index][1] = col-2;
      index++;
    } else {
      clear();
      return false;
    }
    for (int i=0; i<8; i++){
      if (solveH(blocks[i][0], blocks[i][1], level+1)){
        return true;
      }
    }
    return false;
  }
  // level is the # of the knight

  public int countSolutions(int startingRow, int startingCol){
    if (startingRow < 0 || startingCol < 0 || startingRow > maxRows || startingCol > maxCols){
      throw new IllegalArgumentException();
    }
    for (int row=0; row<maxRows; row++){
      for (int col=0; col<maxCols; col++){
        if (board[row][col] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return 0;
  }
}
