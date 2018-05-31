/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirTicketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayushi Saxena
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        tf2 = new javax.swing.JPasswordField();
        tf3 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("SIGN UP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(593, 153, 182, 55);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("ENTER YOUR USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(252, 253, 455, 50);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("ENTER YOUR PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(252, 343, 456, 50);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 45)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("RECONFIRM PASSWORD");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 430, 456, 50);

        tf1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 30)); // NOI18N
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(780, 250, 300, 50);

        btn1.setBackground(new java.awt.Color(255, 204, 0));
        btn1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 45)); // NOI18N
        btn1.setForeground(new java.awt.Color(204, 51, 0));
        btn1.setText("SUBMIT");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(591, 571, 190, 60);

        tf2.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        getContentPane().add(tf2);
        tf2.setBounds(780, 330, 300, 50);

        tf3.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        getContentPane().add(tf3);
        tf3.setBounds(780, 429, 300, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AirTicketBooking/PicsArt_07-10-11.29.25.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1470, 1060);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
       String  username = tf1.getText();
        String password = tf2.getText();
        String passwrd = tf3.getText();
        if(!passwrd.equals(password)){
            JOptionPane.showMessageDialog(this,"PASSWORD MISMATCHED !!");
        }
        else{
        Connection c = null;
        //        new login().setVisible(true);  // for new window
        //        this.dispose();
        int  f=0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            PreparedStatement  pst = c.prepareStatement("insert into login(username,password) values(?,?)");
            pst.setString(1, username); // name is the name of variable in code
            pst.setString(2, password);   // id is name of variable taken in code

            int a = pst.executeUpdate();

            if(a!=0){
                //if(id.equals(a.getString(1))){
                    JOptionPane.showMessageDialog(this, "Successfully Signed Up");
                    f=1;
                    login l = new login();
                   
                    l.setVisible(true);
                    l.setExtendedState(MAXIMIZED_BOTH);
                    this.dispose(); 
//                    TicketBook ticket = new TicketBook();
//                    ticket.setVisible(true);
//                    this.dispose();
//                    ticket.setExtendedState(MAXIMIZED_BOTH);
                    

                }
                else{
                    JOptionPane.showMessageDialog(this, "Incorrect password");
                    this.dispose();
                }
            }

            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    private javax.swing.JPasswordField tf3;
    // End of variables declaration//GEN-END:variables
}
