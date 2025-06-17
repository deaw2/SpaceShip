/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author daryo
 */
public class FXMLDocumentController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML private AnchorPane anchorPane;
    @FXML private GridPane GridPaneN1;
    
    Random r = new Random();
    ArrayList<Pianeta> pianeti = new ArrayList();
    Astronave pg;
    
    //grafica 1
    @FXML private Label newPgX;
    @FXML private Label newPgY;
    @FXML private Label newPgZ;
    @FXML private TextField newPgXF;
    @FXML private TextField newPgYF;
    @FXML private TextField newPgZF;
    @FXML private Button newCoo;
    @FXML private Button newPg;
    @FXML private Button newAb;
    
    //grafica 2
    @FXML private Label lvl1;
    @FXML private Label lvl2;
    @FXML private Label lvl3;
    @FXML private Label lvlSens;
    @FXML private Label lvlScudi;
    @FXML private Label lvlCom;
    @FXML private Button meno1;
    @FXML private Button piu1;
    @FXML private Button meno2;
    @FXML private Button piu2;
    @FXML private Button meno3;
    @FXML private Button piu3;
    @FXML private Button back1; 
    @FXML private Button conf1; 
    
    @FXML
    private void nuovoPg(ActionEvent event) {
        //System.out.println("cia");
        newPg.setVisible(false);
        newPgX.setVisible(true);
        newPgY.setVisible(true);
        newPgZ.setVisible(true);
        newPgXF.setVisible(true);
        newPgYF.setVisible(true);
        newPgZF.setVisible(true);
        newCoo.setVisible(true);
        newCoo.setFocusTraversable(true);
        newAb.setVisible(true);
        //test
        /*try {
            Stage2(event);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    @FXML
    private void newCoo(ActionEvent event) {
        //System.out.println("cia");
        newPgXF.setText(""+r.nextInt(100));
        newPgYF.setText(""+r.nextInt(100));
        newPgZF.setText(""+r.nextInt(100));
        newAb.setDisable(false);
    }
    @FXML
    private void newAbilita(ActionEvent event) {
        lvl1.setVisible(true);
        lvl2.setVisible(true);
        lvl3.setVisible(true);
        lvlScudi.setVisible(true);
        lvlSens.setVisible(true);
        lvlCom.setVisible(true);
        piu1.setVisible(true);
        meno1.setVisible(true);
        piu2.setVisible(true);
        meno2.setVisible(true);
        piu3.setVisible(true);
        meno3.setVisible(true);
        
        newPgX.setVisible(false);
        newPgY.setVisible(false);
        newPgZ.setVisible(false);
        newPgXF.setVisible(false);
        newPgYF.setVisible(false);
        newPgZF.setVisible(false);
        newCoo.setVisible(false);
        newCoo.setFocusTraversable(false);
        newAb.setVisible(false);
        
        back1.setVisible(true);
        back1.setFocusTraversable(true);
        conf1.setVisible(true);
        conf1.setFocusTraversable(true);
    }
    @FXML
    private void back1(ActionEvent event){
        lvl1.setVisible(false);
        lvl2.setVisible(false);
        lvl3.setVisible(false);
        lvlScudi.setVisible(false);
        lvlSens.setVisible(false);
        lvlCom.setVisible(false);
        piu1.setVisible(false);
        meno1.setVisible(false);
        piu2.setVisible(false);
        meno2.setVisible(false);
        piu3.setVisible(false);
        meno3.setVisible(false);
        
        newPgX.setVisible(true);
        newPgY.setVisible(true);
        newPgZ.setVisible(true);
        newPgXF.setVisible(true);
        newPgYF.setVisible(true);
        newPgZF.setVisible(true);
        newCoo.setVisible(true);
        newCoo.setFocusTraversable(true);
        newAb.setVisible(true);
        
        back1.setVisible(false);
        back1.setFocusTraversable(false);
        conf1.setVisible(false);
        conf1.setFocusTraversable(false);
    }
    @FXML
    private void conferma1(ActionEvent event) throws IOException{
        if((Integer.parseInt(lvlSens.getText())+Integer.parseInt(lvlScudi.getText())+Integer.parseInt(lvlCom.getText()))!=7)JOptionPane.showMessageDialog(null, "Imppossibile creare una nuova Astronave con meno punti dati (7)", "ERRORE", JOptionPane.ERROR_MESSAGE);
        else{
            pg = new Astronave(new Posizione(Integer.parseInt(newPgXF.getText()), Integer.parseInt(newPgYF.getText()), Integer.parseInt(newPgZF.getText())), Integer.parseInt(lvlScudi.getText()), Integer.parseInt(lvlSens.getText()), Integer.parseInt(lvlCom.getText()));
            System.out.println(pg.toString());
            finestra.setAstronave(pg);
            finestra.setPianeti(pianeti);
            
            //-----------------reset------------------
            newPg.setVisible(true);
            newPg.setDisable(true);
            
            newPgX.setVisible(false);
            newPgY.setVisible(false);
            newPgZ.setVisible(false);
            newPgXF.setVisible(false);
            newPgYF.setVisible(false);
            newPgZF.setVisible(false);
            newCoo.setVisible(false);
            newAb.setVisible(false);
            lvl1.setVisible(false);
            lvl2.setVisible(false);
            lvl3.setVisible(false);
            lvlSens.setVisible(false);
            lvlScudi.setVisible(false);
            lvlCom.setVisible(false);
            meno1.setVisible(false);
            piu1.setVisible(false);
            meno2.setVisible(false);
            piu2.setVisible(false);
            meno3.setVisible(false);
            piu3.setVisible(false);
            back1.setVisible(false); 
            conf1.setVisible(false);
            
            //**nuova finestra
            Stage2(event);
            
        }
        
    }
    
    @FXML
    private void piu1(ActionEvent event){
        if(Integer.parseInt(lvlSens.getText())<3 && (Integer.parseInt(lvlSens.getText())+Integer.parseInt(lvlScudi.getText())+Integer.parseInt(lvlCom.getText()))<7)lvlSens.setText(""+(Integer.parseInt(lvlSens.getText())+1));
        else if(Integer.parseInt(lvlSens.getText())==3) JOptionPane.showMessageDialog(null, "Il livelllo dei Sensori non può superare 3", "ERRORE", JOptionPane.ERROR_MESSAGE);
        else JOptionPane.showMessageDialog(null, "Il livelllo Totale supera il Massimo (7)", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    @FXML
    private void piu2(ActionEvent event){
        if(Integer.parseInt(lvlScudi.getText())<4 && (Integer.parseInt(lvlSens.getText())+Integer.parseInt(lvlScudi.getText())+Integer.parseInt(lvlCom.getText()))<7)lvlScudi.setText(""+(Integer.parseInt(lvlScudi.getText())+1));
        else if(Integer.parseInt(lvlScudi.getText())==4) JOptionPane.showMessageDialog(null, "Il livelllo degli Scudi non può superare 4", "ERRORE", JOptionPane.ERROR_MESSAGE);
        else JOptionPane.showMessageDialog(null, "Il livelllo Totale supera il Massimo (7)", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    @FXML
    private void piu3(ActionEvent event){
        if(Integer.parseInt(lvlCom.getText())<3 && (Integer.parseInt(lvlSens.getText())+Integer.parseInt(lvlScudi.getText())+Integer.parseInt(lvlCom.getText()))<7)lvlCom.setText(""+(Integer.parseInt(lvlCom.getText())+1));
        else if(Integer.parseInt(lvlCom.getText())==3) JOptionPane.showMessageDialog(null, "Il livelllo di Commercioi non può superare 3", "ERRORE", JOptionPane.ERROR_MESSAGE);
        else JOptionPane.showMessageDialog(null, "Il livelllo Totale supera il Massimo (7)", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    @FXML
    private void meno1(ActionEvent event){
        if(Integer.parseInt(lvlSens.getText())>0)lvlSens.setText(""+(Integer.parseInt(lvlSens.getText())-1));
        else JOptionPane.showMessageDialog(null, "Il livelllo dei sensori non può scendero sotto 0", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    @FXML
    private void meno2(ActionEvent event){
        if(Integer.parseInt(lvlScudi.getText())>0)lvlScudi.setText(""+(Integer.parseInt(lvlScudi.getText())-1));
        else JOptionPane.showMessageDialog(null, "Il livelllo degli scudi non può scendero sotto 0", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    @FXML
    private void meno3(ActionEvent event){
        if(Integer.parseInt(lvlCom.getText())>0)lvlCom.setText(""+(Integer.parseInt(lvlCom.getText())-1));
        else JOptionPane.showMessageDialog(null, "Il livelllo di Commercio non può scendero sotto 0", "ERRORE", JOptionPane.ERROR_MESSAGE);
    }
    
    
    private void Stage2(ActionEvent event) throws IOException{
        /*GridPaneN1.setVisible(false);
        **GridPaneN1.setDisable(true);
        //anchorPane.setMinSize(800, 360);*/
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(60);
        stage.setY(30);
        stage.show();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //newPg.focusedProperty();
        /*Posizione test = new Posizione(r.nextInt(100),r.nextInt(100),r.nextInt(100));
        System.out.println(test.toString());
        Posizione test2 = new Posizione(r.nextInt(100),r.nextInt(100),r.nextInt(100));
        System.out.println(test2.toString());
        System.out.println(test.calcDist(test2));*/
        
        //---------------------------creazione pianeti-------------------------
        for(int i=0; i<30; i++){
            pianeti.add(new Pianeta(new Posizione(r.nextInt(100),r.nextInt(100),r.nextInt(100)), r.nextInt(3)+1));
            System.out.println(pianeti.get(i).toString());
        }
        
        //controllo
        /*int c1=0, c2=0, c3=0;
        for(Pianeta x: pianeti){
            if(x.gettCiv()==1)c1++;
            if(x.gettCiv()==2)c2++;
            if(x.gettCiv()==3)c3++;
        }
        System.out.println("tipo 1: "+c1);
        System.out.println("tipo 2: "+c2);
        System.out.println("tipo 3: "+c3);*/
    }    
    
}