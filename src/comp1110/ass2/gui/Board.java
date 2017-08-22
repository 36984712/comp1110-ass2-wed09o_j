package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    //initialize and store the placement
    public String placement = new String("");

    // FIXME Task 7: Implement a basic playable Steps Game in JavaFX that only allows pieces to be placed in valid places
    public String insertPiece(String placement, String piecePlacement){
        return null;
    }
    // FIXME Task 8: Implement starting placements
    public String basicStarting(double difficulty){
        if (difficulty<3){
            return null;
        }
        else if(difficulty<6){
            return null;
        }
        else
            return interestingStarting();
    }
    // FIXME Task 10: Implement hints

    public String getHints(String placement) {
        return null;
    }

    // FIXME Task 11: Generate interesting starting placements
    public String interestingStarting(){
        return null;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
