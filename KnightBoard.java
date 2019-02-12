public class KnightBoard{
  int[][] board;

  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
  }

  public String toString(){
    return "";
  }

  public boolean solve(int startingRow, int startingCol){

    return true;
  }

  public int countSolutions(int startingRow, int startingCol){
    return 0;
  }

  private boolean solveH(int row ,int col, int level){
    return true;
  }
  // level is the # of the knight
}
