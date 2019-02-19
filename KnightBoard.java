import java.util.ArrayList;
public class KnightBoard{
  int[][] board;
  int maxRows;
  int maxCols;
  int[] rMoves;
  int[] cMoves;

  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    maxRows = startingRows;
    maxCols = startingCols;
    rMoves = new int[] {-2, -2, -1, 1, 2, 2, -1, 1};
    cMoves = new int[] {-1, 1, 2, 2, 1, -1, -2, -2};
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
    if (level > board.length * board[0].length) {
      return true;
    }
    if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
      return false;
    }
    if (board[row][col] != 0) {
      return false;
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
