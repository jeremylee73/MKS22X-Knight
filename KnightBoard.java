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
            ans += "_ ";
          } else if (board[row][col] > 9){
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
    return true;
  }

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

  private boolean solveH(int row ,int col, int level){
    return true;
  }
  // level is the # of the knight
}
