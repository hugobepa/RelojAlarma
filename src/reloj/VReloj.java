/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://www.jc-mouse.net/java/minimizar-aplicacion-al-systemtraybandeja-del-sistema
https://www.youtube.com/watch?v=chi7H1P71aE
 */
package reloj;

//imports alarma
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import java.io.File;
//imports sonido
import java.io.File;
import static java.lang.Thread.sleep;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import Vreloj
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author hugo
 */
public class VReloj extends javax.swing.JFrame implements Runnable {
    private String m,s,h,e,a,b;
    private int H,M,S, HA,MA;
    MediaPlayer mediaPlayer;
     Avis avis = new Avis(new javax.swing.JFrame(), true);
     Cronometro cronometro = new Cronometro(new javax.swing.JFrame(), true);
     boolean cr,sc;
       
        
        
    
    Thread hilo=new Thread(this);
    Thread crono=new Thread(this);
    //VReloj v = new VReloj();
     
     
    public VReloj() {
        initComponents();
        iniciar();
        soloReloj();
        
        this.LBProba.setText(String.valueOf(this.CBOpciones.getSelectedItem().toString()));
    }

      public void iniciar ()
    {
       hilo=new Thread(this);
       hilo.setPriority(Thread.MIN_PRIORITY);
       hilo.start();
    }
    
            
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTStart = new javax.swing.JButton();
        BTStop = new javax.swing.JButton();
        LBReloj = new javax.swing.JLabel();
        BTSalir = new javax.swing.JButton();
        BTReset = new javax.swing.JButton();
        SPHoras = new javax.swing.JSpinner();
        LBHoras = new javax.swing.JLabel();
        LBMinutos = new javax.swing.JLabel();
        SPMinutos = new javax.swing.JSpinner();
        CBOpciones = new javax.swing.JComboBox();
        LBProba = new javax.swing.JLabel();
        TBTMute = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTStart.setText("Start");
        BTStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTStartActionPerformed(evt);
            }
        });

        BTStop.setText("Stop");
        BTStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTStopActionPerformed(evt);
            }
        });

        LBReloj.setFont(new java.awt.Font("Noto Sans", 0, 48)); // NOI18N
        LBReloj.setText("jLabel1");

        BTSalir.setText("Salir");
        BTSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalirActionPerformed(evt);
            }
        });

        BTReset.setText("Reset");
        BTReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTResetActionPerformed(evt);
            }
        });

        SPHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        SPHoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPHorasMouseClicked(evt);
            }
        });

        LBHoras.setText("Horas: ");

        LBMinutos.setText("minutos:");

        SPMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));
        SPMinutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPMinutosMouseClicked(evt);
            }
        });

        CBOpciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "reloj","alarma","crono" }));
        CBOpciones.setSelectedItem("reloj");
        CBOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBOpcionesActionPerformed(evt);
            }
        });

        LBProba.setText("jLabel1");

        TBTMute.setText("Mute");
        TBTMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBTMuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBHoras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(SPHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBMinutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addComponent(BTSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBProba)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TBTMute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTStart, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTStop, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BTSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBReloj)
                .addGap(27, 27, 27)
                .addComponent(LBProba, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTReset)
                    .addComponent(BTStop)
                    .addComponent(BTStart)
                    .addComponent(TBTMute))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SPHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBHoras)
                    .addComponent(LBMinutos)
                    .addComponent(SPMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTStartActionPerformed
         HA= Integer.parseInt(this.SPHoras.getValue().toString());
         MA= Integer.parseInt(this.SPMinutos.getValue().toString());
         System.out.println("alarma: "+HA+":"+MA);
         if(this.CBOpciones.getSelectedItem().toString()=="alarma")
         {  
             this.CBOpciones.setSelectedItem("reloj");        
             soloReloj();
             
         }    
         if(this.CBOpciones.getSelectedItem().toString()=="crono")
         {  
             this.hilo.stop();
             this.crono.start();
             this.LBReloj.setText("00:00:00");
             H=HA;
             M=MA;
             S=0;
             cr=true;
             sc=true;
             this.CBOpciones.setSelectedItem("crono");        
             soloReloj();
         }    
    }//GEN-LAST:event_BTStartActionPerformed

    private void BTStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTStopActionPerformed
       stop();
       HA=MA=0;
       if(this.CBOpciones.getSelectedItem().toString()=="crono")
       {
           H=M=S=0;
           crono.stop();
           this.CBOpciones.setSelectedItem("reloj"); 
            hilo.start();
             soloReloj();
       }
       cr=false;
    }//GEN-LAST:event_BTStopActionPerformed

    private void BTSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTSalirActionPerformed

    private void CBOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOpcionesActionPerformed
        soloReloj();
        JComboBox cb = (JComboBox)evt.getSource();
        String opcion = (String)this.CBOpciones.getSelectedItem();
        if(opcion=="crono")  cronometro.setVisible(true);
    }//GEN-LAST:event_CBOpcionesActionPerformed

    private void SPHorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPHorasMouseClicked
        
    }//GEN-LAST:event_SPHorasMouseClicked

    private void SPMinutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPMinutosMouseClicked
        
    }//GEN-LAST:event_SPMinutosMouseClicked

    private void TBTMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBTMuteActionPerformed
       
                
    }//GEN-LAST:event_TBTMuteActionPerformed

    private void BTResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTResetActionPerformed
        stop();
       HA=MA=0;
       
       if(this.CBOpciones.getSelectedItem().toString()=="crono")
       {
           H=M=S=0;
           cr=false;
       }
    }//GEN-LAST:event_BTResetActionPerformed

    
    public void  soloReloj()
    {
        this.LBProba.setText(String.valueOf(this.CBOpciones.getSelectedItem().toString()));
        if(this.CBOpciones.getSelectedItem().toString()=="reloj")
        {   
            this.BTStart.setVisible(false);
            this.BTReset.setVisible(false);
            this.SPHoras.setVisible(false);
            this.SPMinutos.setVisible(false);
            this.LBHoras.setVisible(false);
            this.LBMinutos.setVisible(false);    
            BTStop.setVisible(true);
            
        }else if(this.CBOpciones.getSelectedItem().toString()=="alarma"){
            this.BTStart.setVisible(true);
            this.BTReset.setVisible(true);
            this.SPHoras.setVisible(true);
            this.SPMinutos.setVisible(true);
            this.LBHoras.setVisible(true);
            this.LBMinutos.setVisible(true);
            BTStop.setVisible(false);
        }else if(this.CBOpciones.getSelectedItem().toString()=="crono"){
            
            this.BTStart.setVisible(true);
            this.BTReset.setVisible(true);
            this.SPHoras.setVisible(true);
            this.SPMinutos.setVisible(true);
            this.LBHoras.setVisible(true);
            this.LBMinutos.setVisible(true);
            BTStop.setVisible(true);
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTReset;
    private javax.swing.JButton BTSalir;
    private javax.swing.JButton BTStart;
    private javax.swing.JButton BTStop;
    private javax.swing.JComboBox CBOpciones;
    private javax.swing.JLabel LBHoras;
    private javax.swing.JLabel LBMinutos;
    private javax.swing.JLabel LBProba;
    private javax.swing.JLabel LBReloj;
    private javax.swing.JSpinner SPHoras;
    private javax.swing.JSpinner SPMinutos;
    private javax.swing.JToggleButton TBTMute;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
       

        
            
            e=this.CBOpciones.getSelectedItem().toString();
         if(e=="reloj") { 
/// 
             
          ///  
        while(e=="reloj"){
       LocalTime t=LocalTime.now();
       int H =t.getHour();
       int M=t.getMinute();
       int S=t.getSecond();
       
       h=String.valueOf(H);
       m=String.valueOf(M);
       s=String.valueOf(S);
       //pra hacer dos cifras
       if(H<10)  h="0"+h;
       if(M<10)  m="0"+m;
       if(S<10)  s="0"+s; 
       ////
       this.LBReloj.setText(h+" : "+m+" : "+s);
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VReloj.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////alarma
        
        if(HA==H && MA==M)
                    {
                       play();
                       if(this.TBTMute.isSelected()) this.mediaPlayer.setVolume(0);
                       avis.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
                       avis.setVisible(true);                      
                        break;
                    }
    }
         } ///
         else if(e=="alarma"){
          
              
               while(e=="alarma"){
       LocalTime t=LocalTime.now();
       int H =t.getHour();
       int M=t.getMinute();
       int S=t.getSecond();
       
       h=String.valueOf(H);
       m=String.valueOf(M);
       s=String.valueOf(S);
       //pra hacer dos cifras
       if(H<10)  h="0"+h;
       if(M<10)  m="0"+m;
       if(S<10)  s="0"+s; 
       ////
       this.LBReloj.setText(h+" : "+m+" : "+s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VReloj.class.getName()).log(Level.SEVERE, null, ex);
        }
            //
         }  
         }else if(e=="crono")
         {  
             

         } 
    }
  
    
    //sonido
    public void play(){
        JFXPanel fxPanel = new JFXPanel();
        String bip = "../Reproductor/src/reproductor/alarma.mp3";
        Media hit = new Media(new File(bip).toURI().toString());;
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    
    public void stop()
    {
       this.mediaPlayer.stop();
    }
    
    
    
}
