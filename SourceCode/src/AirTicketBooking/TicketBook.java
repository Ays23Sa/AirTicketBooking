
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirTicketBooking;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayushi Saxena
 */
public class TicketBook extends javax.swing.JFrame implements Printable {
static int bseats,eseats,bseats1,eseats1;

@Override
public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    JFrame frame = null;
        if (page > 0) {
         return NO_SUCH_PAGE;
         }

        Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Print the entire visible contents of a
    // java.awt.Frame.
    frame.printAll(g);

    return PAGE_EXISTS;
}
    /**
     * Creates new form TicketBook
     */
    public TicketBook() {
        initComponents();
        if(Flight.domestic == 1){
            //
        l1.setText(login.username);
        l2.setText(TableOfDomestic.flightno);
        l0.setText(TableOfDomestic.airlines);
        l3.setText(Domestic.fromwhere);
       l4.setText(Domestic.to);
       l5.setText(Integer.toString(Domestic.adults));
        l6.setText(Integer.toString(Domestic.children));
        l7.setText(Domestic.when);
        l9.setText(TableOfDomestic.time);
       
            
         Connection c = null;
        try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            
            
            PreparedStatement pst = c.prepareStatement("update userdetails set username = ? where flightno = ?");
            pst.setString(1,login.username);
            pst.setString(2,TableOfDomestic.flightno);
           
            int a = pst.executeUpdate();
            if(a == 0){
                System.out.println("error");
            }
           
            
            //
            PreparedStatement pst1 = c.prepareStatement("select * from domestic_fares where flightno = ?");
            pst1.setString(1,TableOfDomestic.flightno);
            ResultSet b = pst1.executeQuery();
            while(b.next()){
                if(Domestic.business == 1)
                {
                    l8.setText(Integer.toString(b.getInt(2)*Domestic.adults + b.getInt(3)*Domestic.children));
                }
                else
                {
                    l8.setText(Integer.toString(b.getInt(4)*Domestic.adults + b.getInt(5)*Domestic.children));
                }
                
            }
          
            
           }
        
           catch(Exception e){
                   System.out.println(e.getMessage());
                   }
        }
        //international flights loop
        else{
            //
            l1.setText(login.username);
            l0.setText(TableOfInterntl.airlines);
            l2.setText(TableOfInterntl.flightno);
            l3.setText(International.fromwhere);
            l4.setText(International.to);
            l5.setText(Integer.toString(International.adults));
            l6.setText(Integer.toString(International.children));
            l7.setText(International.when);
            l9.setText(TableOfInterntl.time);
            Connection c = null;
        try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            
            
            PreparedStatement pst = c.prepareStatement("update userdetails set username = ? where flightno = ? ");
            pst.setString(1,login.username);
            pst.setString(2,TableOfInterntl.flightno);
           
            int a = pst.executeUpdate();
            if(a == 0){
                System.out.println("error");
            }
            
            PreparedStatement pst1 = c.prepareStatement("select * from internationalfares where flightno =? ");
            pst1.setString(1,  TableOfInterntl.flightno);
            ResultSet b = pst1.executeQuery();
            while(b.next()){
                if(International.business == 1)
                {
                    l8.setText(Integer.toString(b.getInt(2)*International.adults + b.getInt(3)*International.children));
                }
                else
                {
                    l8.setText(Integer.toString(b.getInt(4)*International.adults + b.getInt(5)*International.children));
                }
                
            }
              
            
            }
        
           catch(Exception e){
                   System.out.println(e.getMessage());
                   }
  }
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
        tf1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        l0 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USER ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 20, 123, 55);

        tf1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        tf1.setForeground(new java.awt.Color(0, 0, 0));
        tf1.setText("NAME :");
        getContentPane().add(tf1);
        tf1.setBounds(440, 90, 110, 34);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("BOOKING DETAILS :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(440, 170, 420, 55);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204)));
        jSeparator1.setMinimumSize(new java.awt.Dimension(1333, 30));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 140, 1350, 10);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FLIGHT NO :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 240, 158, 34);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("AIRLINES :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(710, 240, 158, 34);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("SEATS :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 390, 96, 34);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ADULTS : ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 390, 125, 34);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CHILDREN : ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(710, 390, 135, 34);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DATE OF TRAVEL :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 460, 231, 34);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TOTAL FARE: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 530, 180, 34);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("FROM :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(300, 320, 110, 34);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("TO :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(720, 320, 70, 34);

        l1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l1.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l1);
        l1.setBounds(700, 80, 160, 40);

        l2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l2.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l2);
        l2.setBounds(480, 240, 141, 34);

        l3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l3.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l3);
        l3.setBounds(440, 320, 170, 35);

        l4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l4.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l4);
        l4.setBounds(800, 320, 160, 35);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1001, 505, 243, 0);

        l5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l5.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l5);
        l5.setBounds(570, 390, 40, 30);

        l6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l6.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l6);
        l6.setBounds(860, 390, 40, 30);

        l7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l7.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l7);
        l7.setBounds(530, 460, 140, 40);

        l8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l8.setForeground(new java.awt.Color(0, 0, 153));
        l8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AirTicketBooking/rs.png"))); // NOI18N
        getContentPane().add(l8);
        l8.setBounds(490, 530, 170, 40);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1003, 380, 0, 0);

        l0.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 30)); // NOI18N
        l0.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l0);
        l0.setBounds(880, 240, 200, 29);

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 25)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 204));
        jButton2.setText("CONFIRM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(550, 630, 190, 40);

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("TIME OF FLIGHT :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(700, 450, 230, 50);

        l9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        l9.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(l9);
        l9.setBounds(940, 450, 160, 40);

        jButton1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 20)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1220, 10, 120, 34);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AirTicketBooking/clouds3.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(-10, -100, 1840, 970);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     if(Flight.domestic == 1){   
        Connection c = null;
         
        
        try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            
           
            
            
            if(Domestic.business == 1){
//                 
            PreparedStatement pst1 = c.prepareStatement("update domestic set business_seats = business_seats - ? where flightno = ? ");
            pst1.setInt(1,Domestic.total);
            pst1.setString(2, TableOfDomestic.flightno);
            int a = pst1.executeUpdate();
           }
            else {
                     
            PreparedStatement pst1 = c.prepareStatement("update domestic set economy_seats = economy_seats - ? where flightno = ? ");
            pst1.setInt(1,Domestic.total);
            pst1.setString(2, TableOfDomestic.flightno);
            int a = pst1.executeUpdate();
//                    
            
            
            }
            
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
     }
     else{
          Connection c = null;
        try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ays","mydbms123");
            
           

            if(International.business == 1){
            PreparedStatement pst1 = c.prepareStatement("update international set business_seats = business_seats - ? where flightno = ? ");
            pst1.setInt(1,International.total);
            pst1.setString(2, TableOfInterntl.flightno);
            int a = pst1.executeUpdate();
            }
            else{
            PreparedStatement pst2 = c.prepareStatement("update international set economy_seats = economy_seats - ? where flightno = ? ");
            pst2.setInt(1,International.total);
            pst2.setString(2, TableOfInterntl.flightno);
            int e = pst2.executeUpdate();
            }    
           
                    }
            
        
       
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
     }
     
     
    

        thanks t = new thanks();
        this.dispose();
        t.setVisible(true);
        t.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             }
             catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TicketBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l0;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel tf1;
    // End of variables declaration//GEN-END:variables
}
