import javax.swing.*;

/*

 0 | 1 | 2
--- --- ---
 3 | 4 | 5
--- --- ---
 6 | 7 | 8

*/
public class gameBoard {
    protected cell[] listOfCells;
    String spacesText[];
    String currentPlayer = "X";

    public gameBoard(){
        listOfCells = new cell[]{
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
                cell.empty,
        };
    }

    public void placeOnBoard(cell pieceToPlace, int locationToPlace){
        if (listOfCells[locationToPlace] == cell.empty){
            listOfCells[locationToPlace] = pieceToPlace;
            if (pieceToPlace == cell.x){
                spacesText[locationToPlace] = "X";
            } else {
                spacesText[locationToPlace] = "O";
            }
        }
    }

    public void draw(){
        System.out.println("");
        System.out.println(" " + spacesText[0] + " | " + spacesText[1] + " | " + spacesText[2]);
        System.out.println("--- --- ---");
        System.out.println(" " + spacesText[3] + " | " + spacesText[4] + " | " + spacesText[5]);
        System.out.println("--- --- ---");
        System.out.println(" " + spacesText[6] + " | " + spacesText[7] + " | " + spacesText[8]);
    }

    public void placeO(int cellNum, cell cellSpace){
        if (listOfCells[cellNum] == cell.empty){
            listOfCells[cellNum] = cell.o;
            currentPlayer = "X";
        } else {
            JOptionPane.showMessageDialog(null, "You can't move there!");
        }
    }

    public void placeX(int cellNum, cell cellSpace){
        if (listOfCells[cellNum] == cell.empty){
            listOfCells[cellNum] = cell.x;
            currentPlayer = "O";
        } else {
            JOptionPane.showMessageDialog(null, "You can't move there!");
        }
    }

    public boolean gameOver(){
        if (listOfCells[0] == listOfCells[1] && listOfCells[1] == listOfCells[2] //Top win
                ||listOfCells[3] == listOfCells[4] && listOfCells[4] == listOfCells[5] //Middle horiz win
                ||listOfCells[6] == listOfCells[7] && listOfCells[7] == listOfCells[8] //Bottom win
                ||listOfCells[0] == listOfCells[3] && listOfCells[3] == listOfCells[6] //Left win
                ||listOfCells[1] == listOfCells[4] && listOfCells[4] == listOfCells[7] //Middle vert win
                ||listOfCells[2] == listOfCells[5] && listOfCells[5] == listOfCells[8] //Right win
                ||listOfCells[0] == listOfCells[4] && listOfCells[4] == listOfCells[8] //Top Left to Bottom Right win
                ||listOfCells[2] == listOfCells[4] && listOfCells[4] == listOfCells[6] //Top Right to Bottom Left win
        ){ return true;}
        else if (listOfCells[0] != cell.empty &&
                listOfCells[1] != cell.empty &&
                listOfCells[2] != cell.empty &&
                listOfCells[3] != cell.empty &&
                listOfCells[4] != cell.empty &&
                listOfCells[5] != cell.empty &&
                listOfCells[6] != cell.empty &&
                listOfCells[7] != cell.empty &&
                listOfCells[8] != cell.empty){return true;}
        else {
            return false;
        }
    }
}
