/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import static javafxapplication3.FXMLController.size;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daryo
 */
public class FXML1Controller implements Initializable {
    private ArrayList<Nave> navi = new ArrayList();
    @FXML GridPane grid;
    private Background colore = new Background(new BackgroundFill(javafx.scene.paint.Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY));
    private Background colore2 = new Background(new BackgroundFill(javafx.scene.paint.Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY));
    private Background colore3 = new Background(new BackgroundFill(javafx.scene.paint.Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
    private Button[][] mappa = new Button[10][20];
    Random r = new Random();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        navi.add(new Nave(r.nextInt(10), 16+r.nextInt(3)));
        navi.add(new Nave(r.nextInt(10), 16+r.nextInt(3)));
        navi.add(new Nave(r.nextInt(10), 16+r.nextInt(3)));
        
        for (int i = 0; i < 10; i++) {
            for(int j=0; j<20; j++){
                Button button = new Button("");
                button.setPrefSize(40, 40);
                button.setStyle("-fx-border-color: lightseagreen;");
                button.setBackground(colore);
                button.setOnMouseClicked(event -> clic(button));
                button.setOnMouseEntered(event -> hover(button));
                button.setOnMouseExited(event -> exit(button));
                    //aggiunta del bottone
                mappa[i][j] = button;
                //int column = i % size;
                //int row = i / size;
                grid.add(button, j, i); 
            }   
        }
    }    

    private void move(){
        for(int i=0; i<navi.size(); i++){
            navi.get(i).setY(navi.get(i).getY()+1);
            if(navi.get(i).getY()<1){
                grid.setDisable(true);
                finestra.getAstronave().setScudi(finestra.getAstronave().getScudi()-1);
                if(finestra.getAstronave().getScudi()==0)morto();
            }
        }
    }
    private void clic(Button button) {
        for(int i=0;i<10;i++){
            for(int j=0;j<20;j++){
                if(mappa[i][j].equals(button)){
                    for(int t=0; t<navi.size(); t++){
                        if(navi.get(t).getX()==i && navi.get(t).getY()==j){
                            affondo(button);
                            JOptionPane.showMessageDialog(null, "Nave affondata", "Nave affondata", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            move();
                        }
                    }
                }
            }
        }
    }
    private void hover(Button button) {
        button.setBackground(colore2);
    }
    private void morto() {
        do{
            JOptionPane.showMessageDialog(null, "HAI PERSO", "HAI PERSO", JOptionPane.ERROR_MESSAGE);
        }while(true);
    }
    private void affondo(Button button) {
        button.setBackground(colore3);
    }
    private void exit(Button button) {
        if(!button.getBackground().equals(colore3))button.setBackground(colore);
    }
    
}
