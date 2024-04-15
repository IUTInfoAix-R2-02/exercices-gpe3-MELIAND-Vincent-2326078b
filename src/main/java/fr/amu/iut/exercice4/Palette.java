package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.root = new BorderPane();

        this.label = new Label("");
        this.label.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);
        this.label.setAlignment(Pos.CENTER);

        this.panneau = new Pane();
        this.panneau.setStyle("-fx-background-color: white;");
        this.panneau.setMaxSize(400, 200);

        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");

        this.bas = new HBox();
        this.bas.setSpacing(10.0d);
        this.bas.setAlignment(Pos.CENTER);
        this.bas.getChildren().addAll( this.vert, this.rouge, this.bleu );

        this.root.setTop(this.label);
        this.root.setCenter(this.panneau);
        this.root.setBottom(this.bas);

        this.vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbVert += 1;
            this.label.setText( "Vert choisi " + this.nbVert + " fois");
            this.panneau.setStyle("-fx-background-color: green;");
        });

        this.rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbRouge += 1;
            this.label.setText( "Rouge choisi " + this.nbRouge + " fois");
            this.panneau.setStyle("-fx-background-color: red;");
        });

        this.bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbBleu += 1;
            this.label.setText( "Bleu choisi " + this.nbBleu + " fois");
            this.panneau.setStyle("-fx-background-color: blue;");
        });
        


        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Scene scene = new Scene( root );

        primaryStage.setScene( scene );

        primaryStage.setTitle("Hello application");
        primaryStage.show();

        primaryStage.show();
    }
}

