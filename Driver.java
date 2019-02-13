public class Driver{
  public static void main(String[] args){
    KnightBoard board = new KnightBoard(5,5);
    System.out.println(board);
    board.solve(3,3);
    System.out.println(board);
  }
}
