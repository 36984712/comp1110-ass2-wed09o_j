package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.effect.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A very simple viewer for piece placements in the steps game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {
    char shapes;
    char orientations;
    char locations;


    /* board layout */
    private static final int SQUARE_SIZE = 60;
    private static final int PIECE_IMAGE_SIZE = (int) ((3*SQUARE_SIZE)*1.33);
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        this.shapes=placement.charAt(0);
        this.orientations=placement.charAt(1);
        this.locations=placement.charAt(2);

    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Rectangle rectangle=new Rectangle();
        ColorInput colorRectangle=new ColorInput();
        colorRectangle.setX(100);
        colorRectangle.setY(100);
        colorRectangle.setWidth(525);
        colorRectangle.setHeight(250);
        colorRectangle.setPaint(Color.LIGHTGRAY);
        rectangle.setEffect(colorRectangle);


        Circle circle1=new Circle();
        ColorInput colorCircle1=new ColorInput();
        circle1.setCenterX(125);
        circle1.setCenterY(125);
        circle1.setRadius(15);

        Circle circle2=new Circle();
        ColorInput colorCircle2=new ColorInput();
        circle2.setCenterX(225);
        circle2.setCenterY(125);
        circle2.setRadius(15);

        Circle circle3=new Circle();
        ColorInput colorCircle3=new ColorInput();
        circle3.setCenterX(325);
        circle3.setCenterY(125);
        circle3.setRadius(15);

        Circle circle4=new Circle();
        ColorInput colorCircle4=new ColorInput();
        circle4.setCenterX(425);
        circle4.setCenterY(125);
        circle4.setRadius(15);

        Circle circle5=new Circle();
        ColorInput colorCircle5=new ColorInput();
        circle5.setCenterX(525);
        circle5.setCenterY(125);
        circle5.setRadius(15);

        Circle circle6=new Circle();
        ColorInput colorCircle6=new ColorInput();
        circle6.setCenterX(175);
        circle6.setCenterY(175);
        circle6.setRadius(15);

        Circle circle7=new Circle();
        ColorInput colorCircle7=new ColorInput();
        circle7.setCenterX(275);
        circle7.setCenterY(175);
        circle7.setRadius(15);

        Circle circle8=new Circle();
        ColorInput colorCircle8=new ColorInput();
        circle8.setCenterX(375);
        circle8.setCenterY(175);
        circle8.setRadius(15);

        Circle circle9=new Circle();
        ColorInput colorCircle9=new ColorInput();
        circle9.setCenterX(475);
        circle9.setCenterY(175);
        circle9.setRadius(15);

        Circle circle10=new Circle();
        ColorInput colorCircle10=new ColorInput();
        circle10.setCenterX(575);
        circle10.setCenterY(175);
        circle10.setRadius(15);

        Circle circle11=new Circle();
        ColorInput colorCircle11=new ColorInput();
        circle11.setCenterX(125);
        circle11.setCenterY(225);
        circle11.setRadius(15);

        Circle circle12=new Circle();
        ColorInput colorCircle12=new ColorInput();
        circle12.setCenterX(225);
        circle12.setCenterY(225);
        circle12.setRadius(15);

        Circle circle13=new Circle();
        ColorInput colorCircle13=new ColorInput();
        circle13.setCenterX(325);
        circle13.setCenterY(225);
        circle13.setRadius(15);

        Circle circle14=new Circle();
        ColorInput colorCircle14=new ColorInput();
        circle14.setCenterX(425);
        circle14.setCenterY(225);
        circle14.setRadius(15);

        Circle circle15=new Circle();
        ColorInput colorCircle15=new ColorInput();
        circle15.setCenterX(525);
        circle15.setCenterY(225);
        circle15.setRadius(15);

        Circle circle16=new Circle();
        ColorInput colorCircle16=new ColorInput();
        circle16.setCenterX(175);
        circle16.setCenterY(275);
        circle16.setRadius(15);

        Circle circle17=new Circle();
        ColorInput colorCircle17=new ColorInput();
        circle17.setCenterX(275);
        circle17.setCenterY(275);
        circle17.setRadius(15);

        Circle circle18=new Circle();
        ColorInput colorCircle18=new ColorInput();
        circle18.setCenterX(375);
        circle18.setCenterY(275);
        circle18.setRadius(15);

        Circle circle19=new Circle();
        ColorInput colorCircle19=new ColorInput();
        circle19.setCenterX(475);
        circle19.setCenterY(275);
        circle19.setRadius(15);

        Circle circle20=new Circle();
        ColorInput colorCircle20=new ColorInput();
        circle20.setCenterX(575);
        circle20.setCenterY(275);
        circle20.setRadius(15);

        Circle circle21=new Circle();
        ColorInput colorCircle21=new ColorInput();
        circle21.setCenterX(125);
        circle21.setCenterY(325);
        circle21.setRadius(15);

        Circle circle22=new Circle();
        ColorInput colorCircle22=new ColorInput();
        circle22.setCenterX(225);
        circle22.setCenterY(325);
        circle22.setRadius(15);

        Circle circle23=new Circle();
        ColorInput colorCircle23=new ColorInput();
        circle23.setCenterX(325);
        circle23.setCenterY(325);
        circle23.setRadius(15);

        Circle circle24=new Circle();
        ColorInput colorCircle24=new ColorInput();
        circle24.setCenterX(425);
        circle24.setCenterY(325);
        circle24.setRadius(15);

        Circle circle25=new Circle();
        ColorInput colorCircle25=new ColorInput();
        circle25.setCenterX(525);
        circle25.setCenterY(325);
        circle25.setRadius(15);

        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);





        root.getChildren().add(controls);
        root.getChildren().add(rectangle);
        root.getChildren().add(circle1);
        root.getChildren().add(circle2);
        root.getChildren().add(circle3);
        root.getChildren().add(circle4);
        root.getChildren().add(circle5);
        root.getChildren().add(circle6);
        root.getChildren().add(circle7);
        root.getChildren().add(circle8);
        root.getChildren().add(circle9);
        root.getChildren().add(circle10);
        root.getChildren().add(circle11);
        root.getChildren().add(circle12);
        root.getChildren().add(circle13);
        root.getChildren().add(circle14);
        root.getChildren().add(circle15);
        root.getChildren().add(circle16);
        root.getChildren().add(circle17);
        root.getChildren().add(circle18);
        root.getChildren().add(circle19);
        root.getChildren().add(circle20);
        root.getChildren().add(circle21);
        root.getChildren().add(circle22);
        root.getChildren().add(circle23);
        root.getChildren().add(circle24);
        root.getChildren().add(circle25);


        makeControls();
        primaryStage.setScene(scene);



        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.ENTER){
                    System.out.println(textField.getText());
                    makePlacement(textField.getText());
                    if(shapes=='A'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/AA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/AE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='B'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/BA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/BE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='C'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/CA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/CE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='D'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/DA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/DE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='E'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/EA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/EE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='F'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/FA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/FE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='G'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/GA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/GE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }else if(shapes=='H'){
                        if((int)orientations>=65&&(int)orientations<=68){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121){
                                Image image=new Image("comp1110/ass2/gui/assets/HA.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-112)*50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }

                        }else if((int)orientations>=69&&(int)orientations<=72){
                            if((int)locations>=65&&(int)locations<=74){
                                Image image=new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-65)*50);
                                imageView.setY(25);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=75&&(int)locations<=84){
                                Image image=new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-75)*50);
                                imageView.setY(75);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=85&&(int)locations<=89){
                                Image image=new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-85)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=97&&(int)locations<=101){
                                Image image=new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(275+((int)locations-97)*50);
                                imageView.setY(125);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=102&&(int)locations<=111){
                                Image image=new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView=new ImageView(image);
                                imageView.setRotate((((int)orientations)-65)*90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25+((int)locations-102)*50);
                                imageView.setY(175);
                                root.getChildren().add(imageView);
                            }else if((int)locations>=112&&(int)locations<=121) {
                                Image image = new Image("comp1110/ass2/gui/assets/HE.png");
                                ImageView imageView = new ImageView(image);
                                imageView.setRotate((((int) orientations) - 65) * 90);
                                imageView.setFitHeight(200);
                                imageView.setFitWidth(200);
                                imageView.setX(25 + ((int) locations - 112) * 50);
                                imageView.setY(225);
                                root.getChildren().add(imageView);
                            }
                        }
                    }
                }
            }
        });


        primaryStage.show();
    }

}
