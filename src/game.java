import java.util.Scanner;

public class game {
    public game(){
        player pX = new player();
        player pO = new player();

        gameBoard board = new gameBoard();
    }

    public void play(){

        Scanner read = new Scanner(System.in);
        gameBoard.draw();

        System.out.println("Player 1: Enter a location:");
        int location = read.nextInt();
        gameBoard.placePiece();
    }
}
