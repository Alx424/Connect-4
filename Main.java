import java.util.Scanner;

class Main {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_RESET = "\u001B[0m";
  public static void main(String[] args) {
    int rowSelected;
    //intro
    System.out.println("Hello world!");
    Scanner obj = new Scanner(System.in);
    System.out.println("Please enter "+ ANSI_BLUE +"blue"+ ANSI_RESET +" player's username:");
    String b = obj.nextLine();
    System.out.println("Welcome " + ANSI_BLUE + b + ANSI_RESET + "!");
    System.out.println();
    System.out.println("Please enter "+ ANSI_RED +"red"+ ANSI_RESET +" player's username:");
    String r = obj.nextLine();
    System.out.println("Welcome " + ANSI_RED + r + ANSI_RESET + "!");
    System.out.println();
    System.out.println("Let's begin!");
    System.out.println("Please select a row to place your chip:");
    System.out.println();
    //board setup
    String[] l1 = {" ", " ", " ", " ", " ", " ", " "};
    String[] l2 = {" ", " ", " ", " ", " ", " ", " "};
    String[] l3 = {" ", " ", " ", " ", " ", " ", " "};
    String[] l4 = {" ", " ", " ", " ", " ", " ", " "};
    String[] l5 = {" ", " ", " ", " ", " ", " ", " "};
    String[] l6 = {" ", " ", " ", " ", " ", " ", " "};
    //board starting display
    String[][] board = {l1, l2, l3, l4, l5, l6};
    printBoard(board);
    //game starts
    boolean done = false;
    while (true) {
      System.out.println();
    System.out.print(ANSI_BLUE + b + ANSI_RESET +"'s turn: ");
    rowSelected = obj.nextInt();
    board = turn(ANSI_BLUE+"b"+ANSI_RESET, board, rowSelected);
    printBoard(board);
    done = check(board, b, r);
    if (done == true) {break;}
    
    System.out.println();
    System.out.print(ANSI_RED + r + ANSI_RESET +"'s turn: ");
    rowSelected = obj.nextInt();
    board = turn("\u001b[31mr\u001b[0m", board, rowSelected);
    printBoard(board);
    done = check(board, b, r);
    if (done == true) {break;}
    }
  }
  public static boolean check(String[][] board, String bluename, String redname) {
    boolean done = false;
    //horizontal lines
    for (int i = 1; i<6; i++) {
      if (board[i][0] == ANSI_RED+"r"+ANSI_RESET && board[i][1] == ANSI_RED+"r"+ANSI_RESET && board[i][2] == ANSI_RED+"r"+ANSI_RESET && board[i][3] == ANSI_RED+"r"+ANSI_RESET)  {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[i][1] == ANSI_RED+"r"+ANSI_RESET && board[i][2] == ANSI_RED+"r"+ANSI_RESET && board[i][3] == ANSI_RED+"r"+ANSI_RESET && board[i][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[i][2] == ANSI_RED+"r"+ANSI_RESET && board[i][3] == ANSI_RED+"r"+ANSI_RESET && board[i][4] == ANSI_RED+"r"+ANSI_RESET && board[i][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[i][3] == ANSI_RED+"r"+ANSI_RESET && board[i][4] == ANSI_RED+"r"+ANSI_RESET && board[i][5] == ANSI_RED+"r"+ANSI_RESET && board[i][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[i][0] == ANSI_BLUE+"b"+ANSI_RESET && board[i][1] == ANSI_BLUE+"b"+ANSI_RESET && board[i][2] == ANSI_BLUE+"b"+ANSI_RESET && board[i][3] == ANSI_BLUE+"b"+ANSI_RESET)  {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[i][1] == ANSI_BLUE+"b"+ANSI_RESET && board[i][2] == ANSI_BLUE+"b"+ANSI_RESET && board[i][3] == ANSI_BLUE+"b"+ANSI_RESET && board[i][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[i][2] == ANSI_BLUE+"b"+ANSI_RESET && board[i][3] == ANSI_BLUE+"b"+ANSI_RESET && board[i][4] == ANSI_BLUE+"b"+ANSI_RESET && board[i][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[i][3] == ANSI_BLUE+"b"+ANSI_RESET && board[i][4] == ANSI_BLUE+"b"+ANSI_RESET && board[i][5] == ANSI_BLUE+"b"+ANSI_RESET && board[i][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        }
    }
    //vertical lines
    for(int i = 0; i < 7; i++) {
      if (board[0][i] == ANSI_RED+"r"+ANSI_RESET && board[1][i] == ANSI_RED+"r"+ANSI_RESET && board[2][i] == ANSI_RED+"r"+ANSI_RESET && board[3][i] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[1][i] == ANSI_RED+"r"+ANSI_RESET && board[2][i] == ANSI_RED+"r"+ANSI_RESET && board[3][i] == ANSI_RED+"r"+ANSI_RESET && board[4][i] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[2][i] == "\u001b[31mr\u001b[0m" && board[3][i] == "\u001b[31mr\u001b[0m" && board[4][i] == "\u001b[31mr\u001b[0m" && board[5][i] == "\u001b[31mr\u001b[0m") {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[0][i] == ANSI_BLUE+"b"+ANSI_RESET && board[1][i] == ANSI_BLUE+"b"+ANSI_RESET && board[2][i] == ANSI_BLUE+"b"+ANSI_RESET && board[3][i] == ANSI_BLUE+"b"+ANSI_RESET) {
        System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
        done = true;
      } else if (board[1][i] == ANSI_BLUE+"b"+ANSI_RESET && board[2][i] == ANSI_BLUE+"b"+ANSI_RESET && board[3][i] =="b" && board[4][i] == ANSI_BLUE+"b"+ANSI_RESET) {
        System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
        done = true;
      } else if (board[2][i] == ANSI_BLUE+"b"+ANSI_RESET && board[3][i] == ANSI_BLUE+"b"+ANSI_RESET && board[4][i] == ANSI_BLUE+"b"+ANSI_RESET && board[5][i] == ANSI_BLUE+"b"+ANSI_RESET){
        System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
        done = true;
      }
    }
      //diagonal lines
      if (board[0][0] == ANSI_RED+"r"+ANSI_RESET && board[1][1] == ANSI_RED+"r"+ANSI_RESET && board[2][2] == ANSI_RED+"r"+ANSI_RESET && board[3][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[1][1] == ANSI_RED+"r"+ANSI_RESET && board[2][2] == ANSI_RED+"r"+ANSI_RESET && board[3][3] == ANSI_RED+"r"+ANSI_RESET && board[4][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[2][2] == ANSI_RED+"r"+ANSI_RESET && board[3][3] == ANSI_RED+"r"+ANSI_RESET && board[4][4] == ANSI_RED+"r"+ANSI_RESET && board[5][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[1][0] == ANSI_RED+"r"+ANSI_RESET && board[2][1] == ANSI_RED+"r"+ANSI_RESET && board[3][2] == ANSI_RED+"r"+ANSI_RESET && board[4][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[2][1] == ANSI_RED+"r"+ANSI_RESET && board[3][2] == ANSI_RED+"r"+ANSI_RESET && board[4][3] == ANSI_RED+"r"+ANSI_RESET && board[5][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[0][1] == ANSI_RED+"r"+ANSI_RESET && board[1][2] == ANSI_RED+"r"+ANSI_RESET && board[2][3] == ANSI_RED+"r"+ANSI_RESET && board[3][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[1][2] == ANSI_RED+"r"+ANSI_RESET && board[2][3] == ANSI_RED+"r"+ANSI_RESET && board[3][4] == ANSI_RED+"r"+ANSI_RESET && board[4][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[2][3] == ANSI_RED+"r"+ANSI_RESET && board[3][4] == ANSI_RED+"r"+ANSI_RESET && board[4][5] == ANSI_RED+"r"+ANSI_RESET && board[5][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[0][2] == ANSI_RED+"r"+ANSI_RESET && board[1][3] == ANSI_RED+"r"+ANSI_RESET && board[2][4] == ANSI_RED+"r"+ANSI_RESET && board[3][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[1][3] == ANSI_RED+"r"+ANSI_RESET && board[2][4] == ANSI_RED+"r"+ANSI_RESET && board[3][5] == ANSI_RED+"r"+ANSI_RESET && board[4][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[0][3] == ANSI_RED+"r"+ANSI_RESET && board[1][4] == ANSI_RED+"r"+ANSI_RESET && board[2][5] == ANSI_RED+"r"+ANSI_RESET && board[3][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[2][0] == ANSI_RED+"r"+ANSI_RESET && board[3][1] == ANSI_RED+"r"+ANSI_RESET && board[4][2] == ANSI_RED+"r"+ANSI_RESET && board[5][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[3][0] == ANSI_RED+"r"+ANSI_RESET && board[2][1] == ANSI_RED+"r"+ANSI_RESET && board[1][2] == ANSI_RED+"r"+ANSI_RESET && board[0][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[4][0] == ANSI_RED+"r"+ANSI_RESET && board[3][1] == ANSI_RED+"r"+ANSI_RESET && board[2][2] == ANSI_RED+"r"+ANSI_RESET && board[1][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[3][1] == ANSI_RED+"r"+ANSI_RESET && board[2][2] == ANSI_RED+"r"+ANSI_RESET && board[1][3] == ANSI_RED+"r"+ANSI_RESET && board[0][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[5][0] == ANSI_RED+"r"+ANSI_RESET && board[4][1] == ANSI_RED+"r"+ANSI_RESET && board[3][2] == ANSI_RED+"r"+ANSI_RESET && board[2][3] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[4][1] == ANSI_RED+"r"+ANSI_RESET && board[3][2] == ANSI_RED+"r"+ANSI_RESET && board[2][3] == ANSI_RED+"r"+ANSI_RESET && board[1][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[3][2] == ANSI_RED+"r"+ANSI_RESET && board[2][3] == ANSI_RED+"r"+ANSI_RESET && board[1][4] == ANSI_RED+"r"+ANSI_RESET && board[0][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[5][1] == ANSI_RED+"r"+ANSI_RESET && board[4][2] == ANSI_RED+"r"+ANSI_RESET && board[3][3] == ANSI_RED+"r"+ANSI_RESET && board[2][4] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[4][2] == ANSI_RED+"r"+ANSI_RESET && board[3][3] == ANSI_RED+"r"+ANSI_RESET && board[2][4] == ANSI_RED+"r"+ANSI_RESET && board[1][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[3][3] == ANSI_RED+"r"+ANSI_RESET && board[2][4] == ANSI_RED+"r"+ANSI_RESET && board[1][5] == ANSI_RED+"r"+ANSI_RESET && board[0][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[5][2] == ANSI_RED+"r"+ANSI_RESET && board[4][3] == ANSI_RED+"r"+ANSI_RESET && board[3][4] == ANSI_RED+"r"+ANSI_RESET && board[2][5] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[4][3] == ANSI_RED+"r"+ANSI_RESET && board[3][4] == ANSI_RED+"r"+ANSI_RESET && board[2][5] == ANSI_RED+"r"+ANSI_RESET && board[1][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[5][3] == ANSI_RED+"r"+ANSI_RESET && board[4][4] == ANSI_RED+"r"+ANSI_RESET && board[3][5] == ANSI_RED+"r"+ANSI_RESET && board[2][6] == ANSI_RED+"r"+ANSI_RESET) {
        System.out.println("\u001b[31m"+redname+"\u001b[0m wins!");
        done = true;
      } else if (board[0][0] == ANSI_BLUE+"b"+ANSI_RESET && board[1][1] == ANSI_BLUE+"b"+ANSI_RESET && board[2][2] == ANSI_BLUE+"b"+ANSI_RESET && board[3][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[1][1] == ANSI_BLUE+"b"+ANSI_RESET && board[2][2] == ANSI_BLUE+"b"+ANSI_RESET && board[3][3] == ANSI_BLUE+"b"+ANSI_RESET && board[4][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[2][2] == ANSI_BLUE+"b"+ANSI_RESET && board[3][3] == ANSI_BLUE+"b"+ANSI_RESET && board[4][4] == ANSI_BLUE+"b"+ANSI_RESET && board[5][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[1][0] == ANSI_BLUE+"b"+ANSI_RESET && board[2][1] == ANSI_BLUE+"b"+ANSI_RESET && board[3][2] == ANSI_BLUE+"b"+ANSI_RESET && board[4][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[2][1] == ANSI_BLUE+"b"+ANSI_RESET && board[3][2] == ANSI_BLUE+"b"+ANSI_RESET && board[4][3] == ANSI_BLUE+"b"+ANSI_RESET && board[5][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[0][1] == ANSI_BLUE+"b"+ANSI_RESET && board[1][2] == ANSI_BLUE+"b"+ANSI_RESET && board[2][3] == ANSI_BLUE+"b"+ANSI_RESET && board[3][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[1][2] == ANSI_BLUE+"b"+ANSI_RESET && board[2][3] == ANSI_BLUE+"b"+ANSI_RESET && board[3][4] == ANSI_BLUE+"b"+ANSI_RESET && board[4][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[2][3] == ANSI_BLUE+"b"+ANSI_RESET && board[3][4] == ANSI_BLUE+"b"+ANSI_RESET && board[4][5] == ANSI_BLUE+"b"+ANSI_RESET && board[5][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[0][2] == ANSI_BLUE+"b"+ANSI_RESET && board[1][3] == ANSI_BLUE+"b"+ANSI_RESET && board[2][4] == ANSI_BLUE+"b"+ANSI_RESET && board[3][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[1][3] == ANSI_BLUE+"b"+ANSI_RESET && board[2][4] == ANSI_BLUE+"b"+ANSI_RESET && board[3][5] == ANSI_BLUE+"b"+ANSI_RESET && board[4][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[0][3] == ANSI_BLUE+"b"+ANSI_RESET && board[1][4] == ANSI_BLUE+"b"+ANSI_RESET && board[2][5] == ANSI_BLUE+"b"+ANSI_RESET && board[3][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[2][0] == ANSI_BLUE+"b"+ANSI_RESET && board[3][1] == ANSI_BLUE+"b"+ANSI_RESET && board[4][2] == ANSI_BLUE+"b"+ANSI_RESET && board[5][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[3][0] == ANSI_BLUE+"b"+ANSI_RESET && board[2][1] == ANSI_BLUE+"b"+ANSI_RESET && board[1][2] == ANSI_BLUE+"b"+ANSI_RESET && board[0][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[4][0] == ANSI_BLUE+"b"+ANSI_RESET && board[3][1] == ANSI_BLUE+"b"+ANSI_RESET && board[2][2] == ANSI_BLUE+"b"+ANSI_RESET && board[1][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[3][1] == ANSI_BLUE+"b"+ANSI_RESET && board[2][2] == ANSI_BLUE+"b"+ANSI_RESET && board[1][3] == ANSI_BLUE+"b"+ANSI_RESET && board[0][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[5][0] == ANSI_BLUE+"b"+ANSI_RESET && board[4][1] == ANSI_BLUE+"b"+ANSI_RESET && board[3][2] == ANSI_BLUE+"b"+ANSI_RESET && board[2][3] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[4][1] == ANSI_BLUE+"b"+ANSI_RESET && board[3][2] == ANSI_BLUE+"b"+ANSI_RESET && board[2][3] == ANSI_BLUE+"b"+ANSI_RESET && board[1][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[3][2] == ANSI_BLUE+"b"+ANSI_RESET && board[2][3] == ANSI_BLUE+"b"+ANSI_RESET && board[1][4] == ANSI_BLUE+"b"+ANSI_RESET && board[0][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[5][1] == ANSI_BLUE+"b"+ANSI_RESET && board[4][2] == ANSI_BLUE+"b"+ANSI_RESET && board[3][3] == ANSI_BLUE+"b"+ANSI_RESET && board[2][4] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[4][2] == ANSI_BLUE+"b"+ANSI_RESET && board[3][3] == ANSI_BLUE+"b"+ANSI_RESET && board[2][4] == ANSI_BLUE+"b"+ANSI_RESET && board[1][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[3][3] == ANSI_BLUE+"b"+ANSI_RESET && board[2][4] == ANSI_BLUE+"b"+ANSI_RESET && board[1][5] == ANSI_BLUE+"b"+ANSI_RESET && board[0][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[5][2] == ANSI_BLUE+"b"+ANSI_RESET && board[4][3] == ANSI_BLUE+"b"+ANSI_RESET && board[3][4] == ANSI_BLUE+"b"+ANSI_RESET && board[2][5] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[4][3] == ANSI_BLUE+"b"+ANSI_RESET && board[3][4] == ANSI_BLUE+"b"+ANSI_RESET && board[2][5] == ANSI_BLUE+"b"+ANSI_RESET && board[1][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (board[5][3] == ANSI_BLUE+"b"+ANSI_RESET && board[4][4] == ANSI_BLUE+"b"+ANSI_RESET && board[3][5] == ANSI_BLUE+"b"+ANSI_RESET && board[2][6] == ANSI_BLUE+"b"+ANSI_RESET) {
          System.out.println("\u001B[34m"+bluename+"\u001b[0m wins!");
          done = true;
        } else if (!contains(board[0], " ")) {
          System.out.println("It's a tie!");
          done = true;
        }
      return done;
    }
  public static String[][] turn(String player, String[][] board, int row) {
    if (board[5][row-1] == " ") {
      board[5][row-1] = player;
    } else if (board[4][row-1] == " ") {
      board[4][row-1] = player;
    } else if (board[3][row-1] == " ") {
      board[3][row-1] = player;
    } else if (board[2][row-1] == " ") {
      board[2][row-1] = player;
    } else if (board[1][row-1] == " ") {
      board[1][row-1] = player;
    } else if (board[0][row-1] == " ") {
      board[0][row-1] = player;
    };
    return board;
  }

  public static void printBoard(String[][] board) {
    System.out.println("("+board[0][0]+") ("+board[0][1]+") ("+board[0][2]+") ("+board[0][3]+") ("+board[0][4]+") ("+board[0][5]+") ("+board[0][6]+")");
    System.out.println("("+board[1][0]+") ("+board[1][1]+") ("+board[1][2]+") ("+board[1][3]+") ("+board[1][4]+") ("+board[1][5]+") ("+board[1][6]+")");
    System.out.println("("+board[2][0]+") ("+board[2][1]+") ("+board[2][2]+") ("+board[2][3]+") ("+board[2][4]+") ("+board[2][5]+") ("+board[2][6]+")");
    System.out.println("("+board[3][0]+") ("+board[3][1]+") ("+board[3][2]+") ("+board[3][3]+") ("+board[3][4]+") ("+board[3][5]+") ("+board[3][6]+")");
    System.out.println("("+board[4][0]+") ("+board[4][1]+") ("+board[4][2]+") ("+board[4][3]+") ("+board[4][4]+") ("+board[4][5]+") ("+board[4][6]+")");
    System.out.println("("+board[5][0]+") ("+board[5][1]+") ("+board[5][2]+") ("+board[5][3]+") ("+board[5][4]+") ("+board[5][5]+") ("+board[5][6]+")");
    System.out.println(" 1   2   3   4   5   6   7");
  }
  
  public static boolean contains(String[] array, String key) {
    for (String element : array) {
      if (element.equals(key)) {
        return true;
      }
    }
    return false;
  }
}