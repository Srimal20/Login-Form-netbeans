
package inf;

import Codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Main_Frame extends javax.swing.JFrame {

   Connection conn=null;
   PreparedStatement pst=null;
   ResultSet rs = null;
  
    public Main_Frame() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
    
        try {
            String sql = "SELECT id AS ID,sname AS Name,sage AS Age,sgrade AS Grade FROM student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); 
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e);
            
        }
       
    }
    
    public void tabledata(){
    
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r,0).toString();
        String name = table1.getValueAt(r,1).toString();
        String age = table1.getValueAt(r,2).toString();
        String grade = table1.getValueAt(r,3).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
        
    
    }
    
    public void search(){
    
    String srch = searchbox.getText();
    
        try {
            String sql = "SELECT * FROM student where sname LIKE '%"+srch+"%' OR id LIKE'%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public void update(){
    
        String id = idbox.getText();
        String name = namebox.getText();
        String age = agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try {
            String sql = "UPDATE student SET sname='"+name+"', sage='"+age+"', sgrade='"+grade+"' WHERE id='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error");
        }
    
    }
    
    public void clear(){
    
        searchbox.setText("");
        idbox.setText("ID");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedIndex(0);
        
        
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gradebox = new javax.swing.JComboBox<>();
        agebox = new javax.swing.JTextField();
        namebox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        updatebtn = new javax.swing.JButton();
        insertbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn1 = new javax.swing.JButton();
        idbox = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 370, 90));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Grade");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Name");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        gradebox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 180, 40));

        agebox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        agebox.setToolTipText("Enter Your age");
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, -1));

        namebox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        namebox.setToolTipText("Enter your name");
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 180, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 370, 200));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel5.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        clearbtn1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clearbtn1.setText("Clear");
        clearbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn1ActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 370, 200));

        idbox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        idbox.setText("ID");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 50, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 40, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        table1.setBackground(new java.awt.Color(204, 204, 255));
        table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 0, 590, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 650));

        setSize(new java.awt.Dimension(1035, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        String name;
        int age;
        int grade;
        
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        
        try {
        String sql = "INSERT INTO student(sname,sage,sgrade)VALUES ('"+name+"','"+age+"','"+grade+"')";   
        pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Insert Succesfuly!!");
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
         tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
       
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
       
    }//GEN-LAST:event_jPanel1KeyReleased

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
         tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
         tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
       update();
       tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"DO you want to delete!!");
        
        if(check==0){
        String id = idbox.getText();
            try {
                String sql = "DELETE From student WHERE id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Delete Successfully!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error!!");
            }
        
        }
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn1ActionPerformed
        clear();
    }//GEN-LAST:event_clearbtn1ActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    public static void main(String args[]) {
       
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn1;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
