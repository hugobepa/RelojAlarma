/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author hugo
 */
public class Cronometro extends javax.swing.JDialog implements Runnable{
    
    MediaPlayer mediaPlayer;
     private String m,s,h,e,a,b;
    private int H,M,S,HA,MA,dia,mes,año;
    
    /**
     * Creates new form Cronometro
     */
    Thread hilo = new Thread();
    public Cronometro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        this.LBTime=new JLabel("", SwingConstants.CENTER);
        this.setTitle("CRONOMETRO");
        hilo.start();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBTime = new javax.swing.JLabel();
        TBTCrono = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        SPMinuto = new javax.swing.JSpinner();
        SPHora = new javax.swing.JSpinner();
        TBTMute = new javax.swing.JToggleButton();
        BTCrono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        setMinimumSize(null);

        LBTime.setFont(new java.awt.Font("Noto Sans", 0, 100)); // NOI18N
        LBTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBTime.setText("00:00:00");
        LBTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TBTCrono.setText("Cronometro");

        jButton1.setText("Sortir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SPMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));

        SPHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        TBTMute.setText("Mute");
        TBTMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBTMuteActionPerformed(evt);
            }
        });

        BTCrono.setText("crono");
        BTCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCronoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBTime)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TBTCrono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TBTMute)
                        .addGap(18, 18, 18)
                        .addComponent(SPHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SPMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTCrono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(LBTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBTCrono)
                    .addComponent(jButton1)
                    .addComponent(SPMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SPHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBTMute)
                    .addComponent(BTCrono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stop();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TBTMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBTMuteActionPerformed
         if(this.TBTMute.isSelected()) this.mediaPlayer.setVolume(0);
    }//GEN-LAST:event_TBTMuteActionPerformed

    private void BTCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCronoActionPerformed
       if(this.TBTCrono.isSelected())
       {
           HA= Integer.parseInt(this.SPHora.getValue().toString());
           MA= Integer.parseInt(this.SPMinuto.getValue().toString());
           hilo.start();
       }
           
    }//GEN-LAST:event_BTCronoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cronometro dialog = new Cronometro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                dialog.setVisible(true);
            }
        });
    
        }
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCrono;
    private javax.swing.JLabel LBTime;
    private javax.swing.JSpinner SPHora;
    private javax.swing.JSpinner SPMinuto;
    private javax.swing.JToggleButton TBTCrono;
    private javax.swing.JToggleButton TBTMute;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

@Override
    public void run() {
        //private String m,s,h,e,a,b;
    //private int H,M,S, HA,MA;
        
         if(this.TBTCrono.isSelected()==true)   
         {
             
             HA= Integer.parseInt(this.SPHora.getValue().toString());
              MA= Integer.parseInt(this.SPMinuto.getValue().toString());
              
              LocalDate hoy =LocalDate.now();
              
                dia=hoy.getDayOfMonth();
                mes=hoy.getMonthValue();
                año=hoy.getYear();
              
             
           LocalDateTime timePoint = LocalDateTime.now();
            LocalDateTime inicio = LocalDateTime.of(año,mes,dia,HA,MA,00);
            ZoneId id = ZoneId.of("UTC+2"); 
             
          ZonedDateTime zdtInicio = ZonedDateTime.of(inicio,id);
         ZonedDateTime zdtFinal = ZonedDateTime.of(timePoint, id);
        
        //Duration d=Duration.between(zdtInicio, zdtFinal);
        Duration d=Duration.between(zdtFinal,zdtInicio);
        H =  (int) d.toHours();
        M=   (int) d.toMinutes();
        S=   ((int) d.toMillis())*1000  ;
       
             
       
       
       h=String.valueOf(H);
       m=String.valueOf(M);
       s=String.valueOf(S);
       //pra hacer dos cifras
       if(H<10)  h="0"+h;
       if(M<10)  m="0"+m;
       if(S<10)  s="0"+s; 
       ////
       System.out.println(h+" : "+m+" : "+s);
       this.LBTime.setText(h+" : "+m+" : "+s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         ///    
         }else{
         HA=MA=0;
         this.LBTime.setText("00:00:00");
         }
        
        
        
        
        
    }

/*
     private String m,s,h,e,a,b;
    private int H,M,S, HA,MA;
    HA= Integer.parseInt(this.SPHoras.getValue().toString());
         MA= Integer.parseInt(this.SPMinutos.getValue().toString());
    
    
        LocalDateTime inicio= LocalDateTime.of(2015,9,16,22,30,45);
        ZoneId id = ZoneId.of("UTC+2");
        
        ZonedDateTime zdtInicio = ZonedDateTime.of(inicio,id);
        ZonedDateTime zdtFinal = ZonedDateTime.of(timePoint, id);
        
        Duration d=Duration.between(zdtInicio, zdtFinal);
        System.out.println("Duracion\n");
        System.out.println("Duracion Dias: "+d.toDays());
        System.out.println("Duracion Horas: "+d.toHours());
        System.out.println("Duration en String: "+d.toString());
        System.out.println("\n\n");
    
    
          HA= Integer.parseInt(this.SPHoras.getValue().toString());
         MA= Integer.parseInt(this.SPMinutos.getValue().toString());
    
         this.setVisible(false);
    
    
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
    
                         if(HA==H && MA==M)
                        {
                        play();
                       if(this.TBTMute.isSelected()) this.mediaPlayer.setVolume(0);
                        }
    */

    

   
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
