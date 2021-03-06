/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class EditSupervisor extends javax.swing.JFrame {

    /**
     * Creates new form EditSupervisor
     */
    public EditSupervisor() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Edit Supervisor Info");
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        populateSelect();
    }

    private void populateSelect() {
        String select_supID = "SELECT `Supervisor_ID` FROM `supervisor`";

        Database db = new Database();
        ResultSet rs = db.executeSelect(select_supID);

        try {
            while (rs.next()) {
                jComboBoxSupervisorID.addItem(rs.getString("Supervisor_ID"));
            }
        } catch (SQLException ex) {
            jComboBoxSupervisorID.removeAll();
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
        jComboBoxSupervisorID = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        txtStudentRship = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtUname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Supervisor ID");

        jComboBoxSupervisorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSupervisorIDActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supervisor Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gill Sans MT", 3, 11), new java.awt.Color(0, 204, 255))); // NOI18N

        jLabel8.setText("First Name");

        jLabel9.setText("Last Name");

        txtStudentRship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentRshipActionPerformed(evt);
            }
        });

        jLabel10.setText("Student Relationship");

        jLabel11.setText("Email");

        jLabel12.setText("Username");

        jLabel13.setText("Password");

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(65, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(65, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton6.setText("Exit");
        jButton6.setMaximumSize(new java.awt.Dimension(65, 25));
        jButton6.setMinimumSize(new java.awt.Dimension(65, 25));
        jButton6.setPreferredSize(new java.awt.Dimension(65, 25));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtStudentRship, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtStudentRship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxSupervisorID, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxSupervisorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String firstName = txtFName.getText().trim();
        String lastName = txtLName.getText().trim();
        String rship = txtStudentRship.getText().trim();
        String email = txtEmail.getText().trim();
        String uname = txtUname.getText().trim();
        String pword = txtPword.getText().trim();
        String Supervisor_ID = jComboBoxSupervisorID.getSelectedItem().toString();

        Validator v = new Validator();

        String[] fname_valid = v.nameValidator(firstName, "First Name");
        String[] lname_valid = v.nameValidator(lastName, "Last Name");
        String[] rship_valid = v.nameValidator(rship, "Student Relationship");
        String[] email_valid = v.emailValidator(email);
        String[] uname_valid = v.nameValidator(uname, "Username Name");
        String[] pword_valid = v.passwordValidator(pword);

        if (fname_valid[0] == "true" && lname_valid[0] == "true" && rship_valid[0] == "true" && email_valid[0] == "true"
                && uname_valid[0] == "true" && pword_valid[0] == "true") {
            Database db = new Database();
            String Update_sql = "UPDATE"
                    + "    `supervisor`"
                    + "SET"
                    + "    `First_Name` = '" + firstName + "',"
                    + "    `Last_Name` = '" + lastName + "',"
                    + "    `Student_Relationship` = '" + rship + "',"
                    + "    `Email` = '" + email + "',"
                    + "    `UserName` = '" + uname + "',"
                    + "    `Password` = '" + pword + "'"
                    + "WHERE"
                    + "    `Supervisor_ID` = '" + Supervisor_ID + "'";
            String supCheck_sql = "SELECT * FROM `supervisor` WHERE `Email`='" + email + "' and `Supervisor_ID` <> '" + Supervisor_ID + "'";
            boolean exists = db.checkDuplicate(supCheck_sql);
            System.out.println(supCheck_sql);
            if (exists == true) {
                v.popup("Id alraedy exists");
            } else {
                boolean update = db.executeInsert(Update_sql);
                if (update == true) {
                    v.popup("Updated successfully");
                } else {
                    v.popup("something went wrong!");
                }
            }

        } else {
            if (fname_valid[0] == "false") {
                v.popup(fname_valid[1]);
            }
            if (lname_valid[0] == "false") {
                v.popup(lname_valid[1]);
            }
            if (rship_valid[0] == "false") {
                v.popup(rship_valid[1]);
            }
            if (email_valid[0] == "false") {
                v.popup(email_valid[1]);
            }
            if (uname_valid[0] == "false") {
                v.popup(uname_valid[1]);
            }
            if (pword_valid[0] == "false") {
                v.popup(pword_valid[1]);
            }
        }
    
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtStudentRshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentRshipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentRshipActionPerformed

    private void jComboBoxSupervisorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSupervisorIDActionPerformed
        // TODO add your handling code here:
        Validator v = new Validator();

        int items = jComboBoxSupervisorID.getItemCount();

        if (items == 0) {
            txtFName.setText(null);
            txtLName.setText(null);
            txtStudentRship.setText(null);
            txtEmail.setText(null);
            txtUname.setText(null);
            txtPword.setText(null);

            v.popup("No Supervisors found");

            btnSave.disable();
            btnDelete.disable();
        } else {
            btnSave.enable();
            btnDelete.enable();
            String Supervisor_ID = jComboBoxSupervisorID.getSelectedItem().toString();
            String sup_details_sql = "SELECT * FROM `supervisor` WHERE `Supervisor_ID`='" + Supervisor_ID + "'";
            String fname = null;
            String lname = null;
            String rship = null;
            String email = null;
            String uname = null;
            String pword = null;
            Database db = new Database();
            ResultSet rs = db.executeSelect(sup_details_sql);
            try {
                while (rs.next()) {
                    fname = rs.getString("First_Name");
                    lname = rs.getString("Last_Name");
                    rship = rs.getString("Student_Relationship");
                    email = rs.getString("Email");
                    uname = rs.getString("UserName");
                    pword = rs.getString("Password");

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            txtFName.setText(fname);
            txtLName.setText(lname);
            txtStudentRship.setText(rship);
            txtEmail.setText(email);
            txtUname.setText(uname);
            txtPword.setText(pword);

        }
    }//GEN-LAST:event_jComboBoxSupervisorIDActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int delete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Supervisor?");
        if(delete == 0){
            String sup_id = jComboBoxSupervisorID.getSelectedItem().toString();
            String delete_sup_sql = "DELETE FROM `supervisor` WHERE `Supervisor_ID` = '"+sup_id+"'";
            
            Database db = new Database();
            boolean deleteSup = db.executeInsert(delete_sup_sql);
            if(deleteSup == true){
                if(jComboBoxSupervisorID.getItemCount() > 1){
                    jComboBoxSupervisorID.removeItemAt(jComboBoxSupervisorID.getSelectedIndex());
                }
                else{
                    jComboBoxSupervisorID.removeAllItems();
                }
            }else{
                Validator v = new Validator();
                v.popup("Something went wrong!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(EditSupervisor.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSupervisor.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSupervisor.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        



} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSupervisor.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSupervisor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxSupervisorID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtPword;
    private javax.swing.JTextField txtStudentRship;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
