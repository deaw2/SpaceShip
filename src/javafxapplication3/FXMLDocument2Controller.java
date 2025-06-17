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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daryo
 */
public class FXMLDocument2Controller implements Initializable {
    @FXML GridPane main;
    @FXML private Label Pos;
    @FXML private TextField ComFatti;
    @FXML private TextField ScudiR;
    @FXML private TextField CapC;
    @FXML private TextField CapS;
    @FXML private TextField PianetiR;
    
    @FXML private TextArea pianetiInc;
    
    ArrayList<Pianeta> pianeti = finestra.getPianeti();
    Astronave pg = new Astronave(finestra.getAstronave().getPos(), finestra.getAstronave().getScudi(), finestra.getAstronave().getSensori(), finestra.getAstronave().getCap());
    String[] temp ={"1","2","3","4","5"};
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void Exit(ActionEvent event){
        main.setDisable(true);
    }
    @FXML
    private void indizio(ActionEvent event){
        //Pianeta vicino = new Pianeta(new Posizione(900,900,900),1);
        int indice=35;
        for(int i=0; i<pianeti.size();i++){
            if(indice==35 && !pianeti.get(i).isFound())indice=i;//forse inutile non ho voglia di capirlo
            if(pg.getPos().calcDist(pianeti.get(i).getPos())<pg.getPos().calcDist(pianeti.get(indice).getPos()) && !pianeti.get(i).isFound() && indice!=35)indice = i;
        }
        
        JOptionPane.showMessageDialog(null, "Il pianeta più vicino si trova a: "+pianeti.get(indice).getPos().toString(), "CONSIGLIO PIANETA VICINO", JOptionPane.WARNING_MESSAGE);
    }
    
    @FXML
    private void su(ActionEvent event){
        //String[] temp ={"1","2","3","4","5"};
        /*String x="9";
       JOptionPane.showOptionDialog(null, "testo", "titolo",0,0,null,temp,x);
       System.out.println("x:"+x); */
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.su(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                c=num;
            }
            num++;
        }while(!b && num<pianeti.size());
        pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        //pianeti.get(c).setFound(true);
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
    }
    @FXML
    private void giu(ActionEvent event){
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.giu(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                c=num;
            }
            num++;
        }while(!b && num<pianeti.size());
        pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
    }
    @FXML
    private void destra(ActionEvent event){
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.destra(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                c=num;
            }
            num++;
        }while(!b && num<pianeti.size());
        pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
    }
    @FXML
    private void sinistra(ActionEvent event){
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.sinistra(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                c=num;
            }
            num++;
        }while(!b && num<pianeti.size());
        pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
    }
    @FXML
    private void avanti(ActionEvent event){
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.avanti(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                c=num;
            }
            num++;
        }while(!b && num<pianeti.size());
        pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
    }
    @FXML
    private void dietro(ActionEvent event){
        int x = JOptionPane.showOptionDialog(null, "Di quanto vuoi muoverti?", "Seleziona una distanza",0, 3, null, temp, null);
        System.out.println(x);
        pg.dietro(x+1);
        System.out.println("nuova posizione:"+pg.getPos().toString()); 
        
        boolean b=false;
        int num = 0;
        //int c = 0;
        
        do{
            if(!pianeti.get(num).getFound()){
                ricerca(pianeti.get(num));
                if(pg.getPos().equals(pianeti.get(num)))pianeti.get(num).setFound(true);
            }
            num++;
        }while(!b && num<pianeti.size());
        //pianeti.get(c).setFound(controlloPos(pianeti.get(c)));
        //if(b)incontro(pianeti.get(num).getPos());
        //num=0;
        
        /*for(int num=0; num<pianeti.size(); num++){
            b = ricerca(pianeti.get(num));
        }*/
        
        Pos.setText(pg.getPos().toString());
        int cont=0;
        for(Pianeta qualcosa : pianeti){
            if(!qualcosa.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
        /*
        boolean b = true;
        for(int i=0; i<pg.getSensori() && b; i++){
            for(int j=0; j<pg.getSensori() && b; j++){
                for(int y=0; y<pg.getSensori() && b; y++){
                    for(Pianeta temp:pianeti){
                        if(temp.getPos().equals(new Posizione(pg.getPos().getX()+i,pg.getPos().getY()+j,pg.getPos().getZ()+y))){
                            incontro(1,j,y);
                            b=false;
                        }
                    }
                    //if(pg.getPos())
                }
            }
        }*/
    }
    
    private void incontro(Posizione pos){
        JOptionPane.showMessageDialog(null, "PIANETA : "+"X: "+(pos.getX())+" Y: "+ (pos.getY()) +" Z: "+ (pos.getZ()), "PIANETA NELLE VICINANZE", JOptionPane.WARNING_MESSAGE);
    }
    
    private void ricerca(Pianeta p1){
        boolean found=false;
        if(controlloPos(p1))atterraggio(p1);
        else{
            int i=0;
            int j=0;
            int k=0;
            do{
                //System.out.println("e-1");
                if((pg.getPos().getX()+i)==p1.getPos().getX()){
                    //System.out.println("e-2");
                    do{
                        //System.out.println("e-3");
                        if((pg.getPos().getY()+j)==p1.getPos().getY()){
                            //System.out.println("e-4");
                            do{
                                //System.out.println("e-5");
                                if((pg.getPos().getZ()+k)==p1.getPos().getZ()){
                                    System.out.println("TROVATO");
                                    incontro(p1.getPos());
                                    
                                    found=true;//break;
                                }
                                k++;
                            }while(!found && k<pg.getSensori()+1);
                        }
                        j++;
                    }while(!found && j<pg.getSensori()+1);
                }
                i++;
            }while(!found && i<pg.getSensori()+1);
        }
    }
    public boolean controlloPos(Pianeta p){
        boolean trovato = false;
        if(pg.getPos().equals(p.getPos())){
            JOptionPane.showMessageDialog(null, "STAI APPROCCIANDO IL PIANETA", "ATTERRAGGIO", JOptionPane.INFORMATION_MESSAGE);
            trovato=true;
        }
        return trovato;
    }
    //aterraggio
    private void atterraggio(Pianeta pian){
        int cont=0;
        int b = JOptionPane.showConfirmDialog(null, "Vuoi commerciare?", "Commercio", JOptionPane.INFORMATION_MESSAGE);
        for(Pianeta x : pianeti){
            if(!x.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
        /*do{
            b = JOptionPane.showConfirmDialog(null, "Vuoi commerciare?", "Commercio", JOptionPane.INFORMATION_MESSAGE);
        }while(b==2);*/
        
        if(b==0){
            
            //non lo fa in ordine.
            //test molto bbrutto esplode tutto
            /*boolean var = true;
            creaFin();
            do{
                if(finestra.getLvlPericolo()!=-1)var=false;
            }while(var);
            commercio();*/
            finestra.setAstronave(pg);
            creaFin();
            //commercio();
            
            /*if(!pianetiInc.getText().equals(""))pianetiInc.setText(pianetiInc.getText()+"/n"+pian.getPos().toString());
            else pianetiInc.setText(""+pian.getPos().toString());*/
        }
    }
    
    /*private void commercio(){
        //aggiungere finestra con zone da cliccare
        int temp = finestra.getLvlPericolo();
        Random r = new Random();
        if (/*(r.nextInt(4)+temp)>(pg.getCap()*2)r.nextInt(4)>pg.getCap()){
            JOptionPane.showMessageDialog(null, "Il commercio è anadato male. Il villaggio ha deciso di attaccare!", "COMMERCIO FALLITO", JOptionPane.ERROR_MESSAGE);
            //attacco();
        }else{
            JOptionPane.showMessageDialog(null, "Commercio effettuato con Successo", "Commercio", JOptionPane.INFORMATION_MESSAGE);
            pg.incComF();
            ComFatti.setText("Commerci Fatti: "+pg.getComF());
        }
        
    }*/
    
    /*private void attacco(){
        //da fare
        //nuova finestra con battagli navale
        //creaFin();
        Stage attaccoF = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocument2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        attaccoF.setTitle("ATTACCO");
        attaccoF.setScene(scene);
        attaccoF.show();
        
    }*/
    public void creaFin(){
        Stage fin = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocument2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        fin.setScene(scene);
        fin.setResizable(false);
        fin.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //main.setVisible(false);
        //ret.setVisible(false);
        //System.out.println("secondo controller: "+pg.toString());
        //System.out.println("secondo controller: "+pianeti.get(0).toString());
        Pos.setText(pg.getPos().toString());
        ComFatti.setText("Commerci Fatti: "+pg.getComF());
        ScudiR.setText("Scudi Rimaneti: "+pg.getScudi());
        CapC.setText("Lvl Commercio: "+pg.getCap());
        CapS.setText("Lvl Sensori: "+pg.getSensori());
        int cont=0;
        for(Pianeta x : pianeti){
            if(!x.isFound())cont++;
        }
        PianetiR.setText("Pianeti rimanenti: "+cont);
        
        //atterraggio(pianeti.get(1));
        
    }    
    
}
