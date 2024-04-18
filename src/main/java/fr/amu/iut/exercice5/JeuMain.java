package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();

        Obstacle obstacles = new Obstacle(40,40,20,20);

        obstacles.setX(40);
        obstacles.setY(40);

        obstacles.setWidth(20);
        obstacles.setHeight(20);

        fantome.setLayoutX(620);
        fantome.setLayoutY(460);
        // on positionne le fantôme 20 positions vers la droite

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacles);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacles);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle obstacles) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    if (j1.estEnCollisionObstacle(obstacles)) {
                        j1.deplacerADroite(scene.getWidth());
                    }
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    if (j1.estEnCollisionObstacle(obstacles)) {
                        j1.deplacerAGauche();
                    }
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    if (j1.estEnCollisionObstacle(obstacles)) {
                        j1.deplacerEnHaut();
                    }
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    if (j1.estEnCollisionObstacle(obstacles)) {
                        j1.deplacerEnBas(scene.getHeight());
                    }
                    break;
                case Q:
                    j2.deplacerAGauche();
                    if (j2.estEnCollisionObstacle(obstacles)) {
                        j2.deplacerADroite(scene.getWidth());
                    }
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    if (j2.estEnCollisionObstacle(obstacles)) {
                        j2.deplacerAGauche();
                    }
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    if (j2.estEnCollisionObstacle(obstacles)) {
                        j2.deplacerEnHaut();
                    }
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    if (j2.estEnCollisionObstacle(obstacles)) {
                        j2.deplacerEnBas(scene.getHeight());
                    }
                    break;

            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                Platform.exit();
            }

        });
    }


}
