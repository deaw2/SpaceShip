/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daryo
 */
public class FXMLController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Astronave pg = finestra.getAstronave();
    
    static int size = 20;
    int t = 0;
    //mappa
    private final Button[][] mappa = new Button[size][size];
    
    private Background red = new Background(new BackgroundFill(javafx.scene.paint.Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY));
    private Background brown = new Background(new BackgroundFill(javafx.scene.paint.Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY));
    private Background orange = new Background(new BackgroundFill(javafx.scene.paint.Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY));
    private Background green = new Background(new BackgroundFill(javafx.scene.paint.Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY));
    private Background grey = new Background(new BackgroundFill(javafx.scene.paint.Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
    private ArrayList<Background> colori = new ArrayList();
    
    //tipo di civilta
    private final Civilta[][] civ = new Civilta[size][size];
    
    Random r = new Random();
    
    @FXML GridPane grid = new GridPane();
    
    /*private void clic(){
        JOptionPane.showMessageDialog(null, "hai cliccato un bottone", "clic", JOptionPane.INFORMATION_MESSAGE);
        evoluzione(mappa, civ);
    }*/
    private void clic(Button b, ActionEvent event) throws IOException{
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(mappa[i][j].equals(b)){
                    //JOptionPane.showMessageDialog(null, "hai cliccato il bottone in posizione: "+i+", "+j, "clic", JOptionPane.INFORMATION_MESSAGE);
                    commercio(civ[i][j].getPericolo());
                    //non so come chiudere la finestra
                    //grid.setVisible(false);
                    /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
                    Scene scene = new Scene(root);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setX(60);
                    stage.setY(30);
                    stage.show();*/
                }
            }
        }
        //evoluzione(mappa, civ);
    }
    private void evoluzione(Button[][] fisico, Civilta[][] teorico){
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i-1>0 && !(fisico[i][j]==fisico[i-1][j])){
                    if(teorico[i][j].getPericolo()>teorico[i-1][j].getPericolo()){
                        if((r.nextInt(5)+1)>teorico[i-1][j].getPericolo()) fisico[i-1][j].setBackground(teorico[i][j].getC());
                    }
                }
                if(i+1<size && !(fisico[i][j]==fisico[i+1][j])){
                    if(teorico[i][j].getPericolo()>teorico[i+1][j].getPericolo()){
                        if((r.nextInt(5)+1)>teorico[i+1][j].getPericolo())fisico[i+1][j].setBackground(teorico[i][j].getC());
                    }
                }
                if(j-1>0 && !(fisico[i][j]==fisico[i][j-1])){
                    if(teorico[i][j].getPericolo()>teorico[i][j-1].getPericolo()){
                        if((r.nextInt(5)+1)>teorico[i][j-1].getPericolo())fisico[i][j-1].setBackground(teorico[i][j].getC());
                    }
                }
                if(j+1<size && !(fisico[i][j]==fisico[i][j+1])){
                    if(teorico[i][j].getPericolo()>teorico[i][j+1].getPericolo()){
                        if((r.nextInt(5)+1)>teorico[i][j+1].getPericolo())fisico[i][j+1].setBackground(teorico[i][j].getC());
                    }
                }
            }
        }
        //devo trovare un modo più efficiente
        /*int p = 6;
        int p1 = 6;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(!grafica[i][j].getBackground().equals(grafica[i+1][j].getBackground())){
                    for(int temp1=0;temp1<tipiCiv.size();temp1++){
                        if(grafica[i][j].getBackground().equals(tipiCiv.get(temp1).getC())){
                            p = tipiCiv.get(temp1).getPericolo();
                        }
                    }
                    for(int temp2=0;temp2<tipiCiv.size();temp2++){
                        if(grafica[i][j].getBackground().equals(tipiCiv.get(temp2).getC())){
                            p1 = tipiCiv.get(temp2).getPericolo();
                        }
                    }
                }
                if(!grafica[i][j].getBackground().equals(grafica[i-1][j].getBackground()));
                if(!grafica[i][j].getBackground().equals(grafica[i][j+1].getBackground()));
                if(!grafica[i][j].getBackground().equals(grafica[i][j-1].getBackground()));
            }
        }*/
    }
    
    private void commercio(int lvlPer){
        //aggiungere finestra con zone da cliccare
        Random r = new Random();
        if ((r.nextInt(4)+lvlPer)>(pg.getCap()*2)){
            JOptionPane.showMessageDialog(null, "Il commercio è anadato male. Il villaggio ha deciso di attaccare!", "COMMERCIO FALLITO", JOptionPane.ERROR_MESSAGE);
            //attacco();
        }else{
            JOptionPane.showMessageDialog(null, "Commercio effettuato con Successo", "Commercio", JOptionPane.INFORMATION_MESSAGE);
            pg.incComF();
            //ComFatti.setText("Commerci Fatti: "+pg.getComF());
        }
        
    }
    
    public void animation(){
        new AnimationTimer(){
            
            private long v = 0;
            //int x;
            
            @Override
            public void handle(long now) {
                if((now-v )> 1000000000  /*i!=0 &&*/){
                    evoluzione(mappa, civ);
                    v=now; 
                    //i--;
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }.start();
    }
    
    public void creaFin(){
        Stage fin = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocument2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        fin.setScene(scene);
        fin.setResizable(false);
        fin.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ArrayList<RowConstraints> x = new ArrayList(grid.getRowConstraints());
        //ArrayList<ColumnConstraints> y = new ArrayList(grid.getColumnConstraints());
        colori.add(red);
        colori.add(brown);
        colori.add(orange);
        colori.add(green);
        colori.add(grey);
        
        /*for(int i=0; i<colori.size(); i++){
            civ.add(new Civilta(colori.get(i),i));
        }*/
        int p = 0;
        
        for (int i = 0; i < size; i++) {
            for(int j=0; j<size; j++){
                Button button = new Button("");
                button.setPrefSize(30, 30);

                button.setBackground(colori.get(r.nextInt(5)));
                if(button.getBackground().equals(red))p=5;
                else if(button.getBackground().equals(brown))p=4;
                else if(button.getBackground().equals(orange))p=3;
                else if(button.getBackground().equals(green))p=2;
                else if(button.getBackground().equals(grey))p=1;
                
                button.setOnMouseClicked(event -> clic(button, event));
                    //aggiunta del bottone
                mappa[i][j] = button;
                civ[i][j] = new Civilta(button.getBackground(),p);
                //int column = i % size;
                //int row = i / size;
                grid.add(button, i, j); 
            }   
        }
        
        /*for(int i=0; i<50000; i++){
            evoluzione(mappa, civ);
        }*/
        
        /*Node result = null;
        ObservableList<Node> childrens = grid.getChildren();

        for (Node node : childrens) {
          if(grid.getRowIndex(node) == size && grid.getColumnIndex(node) == size) {
            result = node;
            break;
          }
        }*/
        
        
        
        //idea possibile
        /*MyThread.setFisico(mappa);
        MyThread.setTeorico(civ);
        MyThread thread2 = new MyThread();
        thread2.start();*/
        
        
        
        //idea possibile
        animation();
        
        /*new AnimationTimer(){
            
            private long v = 0;
            //int x;
            
            @Override
            public void handle(long now) {
                if((now-v )> 1000 && /*i!=0 &&*//* t>0){
                    evoluzione(mappa, civ);
                    v=now; 
                    //i--;
                    t--;
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }.start();*/
        
    }    

    private void clic(Button button, MouseEvent event) {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(mappa[i][j].equals(button)){
                    //JOptionPane.showMessageDialog(null, "hai cliccato il bottone in posizione: "+i+", "+j, "clic", JOptionPane.INFORMATION_MESSAGE);
                    commercio(civ[i][j].getPericolo());
                    creaFin();
                    //non so come chiudere la finestra
                    grid.setDisable(true);
                    /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
                    Scene scene = new Scene(root);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setX(60);
                    stage.setY(30);
                    stage.show();*/
                }
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
