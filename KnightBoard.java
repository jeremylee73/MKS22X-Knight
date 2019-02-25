import java.util.ArrayList;
public class KnightBoard{
  int[][] board;
  int maxRows;
  int maxCols;
  int numSolutions;

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
    clear();
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

  private ArrayList<int[]> storeMoves(int row, int col, int level){
    ArrayList<int[]> blocks = new ArrayList<int[]>();
    int index = 0;
    if (row < maxRows - 2 && col > 0 && board[row+2][col-1] == 0){
      int[] move = new int[2];
      move[0] = row+2;
      move[1] = col-1;
      blocks.add(move);
      index++;
    }
    if (row < maxRows - 2 && col < maxCols - 1 && board[row+2][col+1] == 0){
      int[] move = new int[2];
      move[0] = row+2;
      move[1] = col+1;
      blocks.add(move);
      index++;
    }
    if (row < maxRows - 1 && col < maxCols - 2 && board[row+1][col+2] == 0){
      int[] move = new int[2];
      move[0] = row+1;
      move[1] = col+2;
      blocks.add(move);
      index++;
    }
    if (row > 0 && col < maxCols - 2 && board[row-1][col+2] == 0){
      int[] move = new int[2];
      move[0] = row-1;
      move[1] = col+2;
      blocks.add(move);
      index++;
    }
    if (row > 1 && col > 0 && board[row-2][col-1] == 0){
      int[] move = new int[2];
      move[0] = row-2;
      move[1] = col-1;
      blocks.add(move);
      index++;
    }
    if (row > 1 && col < maxCols - 1 && board[row-2][col+1] == 0){
      int[] move = new int[2];
      move[0] = row-2;
      move[1] = col+1;
      blocks.add(move);
      index++;
    }
    if (row > 0 && col > 1 && board[row-1][col-2] == 0){
      int[] move = new int[2];
      move[0] = row-1;
      move[1] = col-2;
      blocks.add(move);
      index++;
    }
    if (row < maxRows - 1 && col > 1 && board[row+1][col-2] == 0){
      int[] move = new int[2];
      move[0] = row+1;
      move[1] = col-2;
      blocks.add(move);
      index++;
    }
    return blocks;
  }

  private boolean solveH(int row ,int col, int level){
    if (level == maxCols * maxRows){
      board[row][col] = level;
      return true;
    }
    if (board[row][col] != 0){
      return false;
    }
    ArrayList<int[]> blocks = storeMoves(row, col, level);
    for (int i=0; i<blocks.size(); i++){
      board[row][col] = level;
      if (solveH(blocks.get(i)[0], blocks.get(i)[1], level+1)){
        return true;
      }
      board[row][col] = 0;
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    clear();
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
    numSolutions = 0;
    cSH(startingRow, startingCol, 1);
    return numSolutions;
  }

  public void cSH(int row, int col, int level){
    if (level == maxCols * maxRows){
      numSolutions++;
    }
    ArrayList<int[]> blocks = storeMoves(row, col, level);
    for (int i=0; i<blocks.size(); i++){
      board[row][col] = level;
      cSH(blocks.get(i)[0], blocks.get(i)[1], level+1);
      board[row][col] = 0;
    }
  }
}
