package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0,0,0,0));


        Label label = new Label("Boutons :");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");

        vbox.getChildren().addAll(label, b1, b2, b3);
        vbox.setAlignment(Pos.CENTER);
        Separator sepa = new Separator(Orientation.VERTICAL);
        HBox hboxsepa = new HBox(vbox,sepa);

        VBox vboxbas = new VBox();

        Label labelbas = new Label("Ceci est un label de bas de page");

        vboxbas.getChildren().addAll(labelbas);
        vboxbas.setAlignment(Pos.CENTER);
        Separator sepabas = new Separator(Orientation.HORIZONTAL);
        HBox hboxsepa2 = new HBox(vboxbas,sepabas);

        Menu menuItem1 = new Menu("File");
        Menu menuItem2 = new Menu("Edit");
        Menu menuItem3 = new Menu("Help");

        MenuItem menub0 = new MenuItem("New");
        MenuItem menub1 = new MenuItem("Import file");
        MenuItem menub2 = new MenuItem("Export file");
        MenuItem menub3 = new MenuItem("Save file");

        MenuItem menub4 = new MenuItem("Undo");
        MenuItem menub5 = new MenuItem("Redo");
        MenuItem menub6 = new MenuItem("Load Image");

        MenuItem menub7 = new MenuItem("Web documentation");
        MenuItem menub8 = new MenuItem("FAQ");
        MenuItem menub9 = new MenuItem("Contact");

        menuItem1.getItems().addAll(menub0, menub1, menub2, menub3);
        menuItem2.getItems().addAll(menub4, menub5, menub6);
        menuItem3.getItems().addAll(menub7, menub8, menub9);

        MenuBar menuBar = new MenuBar(menuItem1, menuItem2, menuItem3);
/*
        HBox hbox = new HBox();
        hbox.getChildren().addAll(vbox, createSeparator());
*/
        border.setTop(menuBar);
        border.setLeft(hboxsepa);
        border.setBottom(hboxsepa2);
/*
        BorderStroke rightBorderStroke = new BorderStroke(
                javafx.scene.paint.Color.SILVER,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(0, 1, 0, 0)
        );

        Border rightBorder = new Border(rightBorderStroke);

        vbox.setBorder(rightBorder);
   */
        Scene scene = new Scene(border, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
    /*
    private Separator createSeparator() {
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #808080;"); // Couleur gris
        return separator;
    }
    */
}

