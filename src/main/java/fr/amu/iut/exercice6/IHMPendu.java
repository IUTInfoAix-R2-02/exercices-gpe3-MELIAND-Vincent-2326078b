package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class IHMPendu extends Application {

    private String mot;
    private String motCache;
    private int vies;
    private ArrayList<Character> lettresProposees;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        Dico dico = new Dico();
        mot = dico.getMot().toUpperCase();
        motCache = hiddenWord(mot);
        vies = 7; // Nombre de vies initial
        lettresProposees = new ArrayList<>();

        VBox contenant = new VBox();
        contenant.setAlignment(Pos.CENTER);

        Label labelMot = new Label("Mot à deviner : ");
        Label afficheMot = new Label(motCache);
        afficheMot.getStyleClass().add("mot");

        HBox propositionBox = new HBox();
        propositionBox.setAlignment(Pos.CENTER);

        GridPane clavier = createKeyboard();
        Button propositionButton = new Button("Proposer");
        propositionButton.setOnAction(event -> {
            String lettreProposee = clavier.getChildren().stream()
                    .filter(node -> node instanceof Button)
                    .map(node -> (Button) node)
                    .filter(Button::isDisabled)
                    .findFirst()
                    .map(Button::getText)
                    .orElse(null);
            if (lettreProposee != null) {
                handleLetter(lettreProposee.charAt(0));
            }
        });

        propositionBox.getChildren().addAll(clavier, propositionButton);

        Label labelVies = new Label("Vies : " + vies);

        contenant.getChildren().addAll(labelMot, afficheMot, propositionBox, labelVies);

        Scene scene = new Scene(contenant);
        scene.getStylesheets().add("/exercice6/stylePendu.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String hiddenWord(String word) {
        return "_ ".repeat(word.length());
    }

    private GridPane createKeyboard() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int col = 0;
        int row = 0;

        for (char letter : alphabet) {
            Button button = new Button(String.valueOf(letter));
            button.setOnAction(event -> handleLetter(letter));
            gridPane.add(button, col, row);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }

        return gridPane;
    }

    private void handleLetter(char letter) {
        if (!lettresProposees.contains(letter)) {
            lettresProposees.add(letter);
            ArrayList<Integer> positions = new Dico().getPositions(letter, mot);
            if (!positions.isEmpty()) {
                StringBuilder motCacheBuilder = new StringBuilder(motCache);
                for (int position : positions) {
                    motCacheBuilder.replace(position * 2, position * 2 + 1, String.valueOf(letter));
                }
                motCache = motCacheBuilder.toString();
            } else {
                vies--;
            }
            updateUI();
        }
    }

    private void updateUI() {
        Label labelMot = (Label) ((VBox) ((Scene) ((Stage) Stage.getWindows().get(0)).getScene()).getRoot()).getChildren().get(1);
        labelMot.setText(motCache);

        Label labelVies = (Label) ((VBox) ((Scene) ((Stage) Stage.getWindows().get(0)).getScene()).getRoot()).getChildren().get(3);
        labelVies.setText("Vies : " + vies);

        if (vies == 0 || !motCache.contains("_")) {
            disableButtons();
        }
    }

    private void disableButtons() {
        GridPane clavier = (GridPane) ((HBox) ((VBox) ((Scene) ((Stage) Stage.getWindows().get(0)).getScene()).getRoot()).getChildren().get(2)).getChildren().get(0);
        for (int i = 0; i < clavier.getChildren().size(); i++) {
            Button button = (Button) clavier.getChildren().get(i);
            button.setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}