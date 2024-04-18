package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        Dico dico = new Dico();
        String mot = dico.getMot();

        System.out.println(mot);

        VBox contenant = new VBox();
        contenant.setAlignment(Pos.CENTER);

        Label afficheMot = new Label(mot);
        afficheMot.getStyleClass().add("mot");
        contenant.getChildren().add( afficheMot );


        // A completer
        Scene scene = new Scene( contenant );
        scene.getStylesheets().add("/exercice6/stylePendu.css");
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
