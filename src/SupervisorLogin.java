
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class SupervisorLogin extends javax.swing.JFrame {

    /**
     * null Creates new form SupervisorLogin
     */
    public SupervisorLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Supervisor Login");
        setResizable(false);
        setSize(650, 350);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        usernamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pwd_password = new javax.swing.JPasswordField();
        iconPanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Autism Management Software.");
        titlePanel.add(jLabel3);

        mainPanel.add(titlePanel, java.awt.BorderLayout.PAGE_START);

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Credentials"));
        contentPanel.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        usernamePanel.add(jLabel1);

        txt_username.setColumns(20);
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        usernamePanel.add(txt_username);

        contentPanel.add(usernamePanel);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password ");
        jLabel2.setMaximumSize(new java.awt.Dimension(80, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(80, 17));
        passwordPanel.add(jLabel2);

        pwd_password.setColumns(20);
        pwd_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordPanel.add(pwd_password);

        contentPanel.add(passwordPanel);

        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        iconPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrator"));
        iconPanel.setLayout(new java.awt.BorderLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/Administrator_Icon_128.png"))); // NOI18N
        iconPanel.add(icon, java.awt.BorderLayout.CENTER);

        mainPanel.add(iconPanel, java.awt.BorderLayout.WEST);

        buttonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Click an Option"));
        buttonPanel.setInheritsPopupMenu(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("EXIT");
        buttonPanel.add(jButton2);

        mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        //         Home mdi = new Home();
        //         mdi.setVisible(true);
        //         this.dispose();
        String uname = txt_username.getText().trim();
        String pword = pwd_password.getText().trim();

        Validator v = new Validator();
        String[] uname_valid = v.nameValidator(uname, "username");
        String[] pword_valid = v.passwordValidator(pword);

        if (uname_valid[0] == "true" && pword_valid[0] == "true") {
            //step 1 : get access to Database class
            Database db = new Database();
            
            //step 2 : use Database login with uname and password
            boolean attemptLogin = db.Login(uname, pword);
            
            //step 3 : check value of return
            if (attemptLogin == true) {
                //login success, open home page
                Home mdi = new Home();
                mdi.setVisible(true);
                this.dispose();
            } else {
                //error ? display error message
                v.popup("Username/Pasword incorrect");
//                JOptionPane.showMessageDialog(null, "Username/Pasword incorrect\n un " + uname + "\npw " + pword);
            }
        } else {
            if (uname_valid[0] == "false") {
                v.popup(uname_valid[1]);
            }
            if (pword_valid[0] == "false") {
                v.popup(pword_valid[1]);
            }
        }

        /* if (uname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input Username");
        } else if (pword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input Password");
        } else {*/
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(SupervisorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupervisorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupervisorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupervisorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupervisorLogin().setVisible(true);
            }
        });
        try {
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
//                    new SupervisorLogin().setVisible(true);
                }
            });
        } catch (Exception e) {
            System.err.print(e);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SupervisorLogin().setVisible(true);
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField pwd_password;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField txt_username;
    private javax.swing.JPanel usernamePanel;
    // End of variables declaration//GEN-END:variables
}
