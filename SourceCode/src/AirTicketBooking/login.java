/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirTicketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayushi Saxena
 */
public class login extends javax.swing.JFrame {
 static String username;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tf2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("LOGIN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 90, 160, 50);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("ENTER USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 170, 310, 50);

        tf1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 30)); // NOI18N
        getContentPane().add(tf1);
        tf1.setBounds(750, 170, 220, 40);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("ENTER PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 260, 320, 50);

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 45)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 51, 0));
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 380, 190, 60);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("NEW USER ? SIGN UP HERE ...");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 550, 260, 30);

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 25)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 204, 0));
        jButton2.setText("SIGN UP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(800, 540, 130, 40);

        tf2.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        getContentPane().add(tf2);
        tf2.setBounds(750, 260, 220, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AirTicketBooking/PicsArt_07-10-11.29.25.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -70, 2170, 1140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         username = tf1.getText();
        String password = tf2.getText();
        Connection c = null;
//        new login().setVisible(true);  // for new window
//        this.dispose();
       int  f=0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            PreparedStatement  pst = c.prepareStatement("select * from login where username = ? and password = ?");
            pst.setString(1, username); // name is the name of variable in code
            pst.setString(2, password);   // id is name of variable taken in code
            
         
             ResultSet a = pst.executeQuery();
             
             
              while(a.next()){
            //if(id.equals(a.getString(1))){                
                JOptionPane.showMessageDialog(this, "Successfully logged in");
                f=1;
               
               TicketBook ticket = new TicketBook();
               ticket.setVisible(true);
               this.dispose();
               ticket.setExtendedState(MAXIMIZED_BOTH);
               break;
            
              }
              if(username.isEmpty() || username == null){
                  
                    JOptionPane.showMessageDialog(this,"Username Field is Empty");
         }
             else if(password.isEmpty() || password == null){
             JOptionPane.showMessageDialog(this, "Please Enter Password");
                }
            
            else if(f ==0){
                   
                       JOptionPane.showMessageDialog(this,"Incorrect Username Or Password");
                   
               }
            }
        
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SignUp s = new SignUp();
        s.setVisible(true);
      
        s.setExtendedState(MAXIMIZED_BOTH);
          this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    // End of variables declaration//GEN-END:variables
}