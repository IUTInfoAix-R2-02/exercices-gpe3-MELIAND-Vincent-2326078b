package fr.amu.iut.exercice7;


import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class  CounterController implements Initializable {

    int counter = 0;

    public void increment() {
        ++counter;
    }

    public void decrement() {
        --counter;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
