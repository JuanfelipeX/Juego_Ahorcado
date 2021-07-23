/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author pipesex
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);// centra el programa
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMenuPrinci = new javax.swing.JLabel();
        jButtonCredits = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonHowPlay = new javax.swing.JButton();
        imagenMunieco = new javax.swing.JLabel();
        FondoMenuPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenuPrinci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/txtMenuPri.png"))); // NOI18N
        getContentPane().add(txtMenuPrinci, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jButtonCredits.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Credits.png"))); // NOI18N
        jButtonCredits.setBorderPainted(false);
        jButtonCredits.setContentAreaFilled(false);
        jButtonCredits.setFocusPainted(false);
        jButtonCredits.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CreditsFade.png"))); // NOI18N
        jButtonCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreditsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 140, 50));

        jButtonPlay.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Play.png"))); // NOI18N
        jButtonPlay.setBorderPainted(false);
        jButtonPlay.setContentAreaFilled(false);
        jButtonPlay.setFocusPainted(false);
        jButtonPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PlayFade.png"))); // NOI18N
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 50));

        jButtonExit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        jButtonExit.setBorderPainted(false);
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.setFocusPainted(false);
        jButtonExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ExitFade.png"))); // NOI18N
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 50));

        jButtonHowPlay.setBackground(new java.awt.Color(255, 255, 255));
        jButtonHowPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/howToPlay.png"))); // NOI18N
        jButtonHowPlay.setBorderPainted(false);
        jButtonHowPlay.setContentAreaFilled(false);
        jButtonHowPlay.setFocusPainted(false);
        jButtonHowPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/howToPlayFade.png"))); // NOI18N
        jButtonHowPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHowPlayActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHowPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 160, 50));

        imagenMunieco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maniquiahordcado-original (1).png"))); // NOI18N
        getContentPane().add(imagenMunieco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 170, 230));

        FondoMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/terror.jpg"))); // NOI18N
        getContentPane().add(FondoMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHowPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHowPlayActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "1. Using a row of hyphens, the word to be guessed is represented, giving the number of letters"
                + "\n" + "2. if the word is guessed, the word will be displayed in its correct positions"
                + "\n" + "3. If the letter is not guessed, one begins to place elements parts of the body, until completing the body and here the game would end", "How to Play",ICONIFIED);  //HEIGTH TRIANGULO PRECAUCION
    }//GEN-LAST:event_jButtonHowPlayActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
         if (JOptionPane.showConfirmDialog(rootPane, "Are you sure?",
                "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
        {System.exit(0);
        }
        else{
                setDefaultCloseOperation(0);
        }
            
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreditsActionPerformed
        // TODO add your handling code here:
          JOptionPane.showMessageDialog(rootPane, "Game made By: Juan Felipe Jimenez Pacheco", "Credits",ICONIFIED); 
    }//GEN-LAST:event_jButtonCreditsActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        // TODO add your handling code here:
        Juego juego = new Juego();
        juego.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonPlayActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoMenuPrincipal;
    private javax.swing.JLabel imagenMunieco;
    private javax.swing.JButton jButtonCredits;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonHowPlay;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel txtMenuPrinci;
    // End of variables declaration//GEN-END:variables
}
