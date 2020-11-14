
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kario
 */
public class StudentTask extends javax.swing.JFrame {

    /**
     * Creates new form Task
     */
    String[] task = new String[4];
    Date time_start = null;
    Date time_stop = null;

    Helper helper = new Helper();
    Thread t = helper.Timer(this.lblTimer);
    String student_id = null;
    String student_name = null;

    public StudentTask(Frame parent, boolean modal) {
//        super(parent, modal);
        initComponents();
        init();
    }

    public StudentTask(Frame parent, boolean modal, String[] task, String student_id, String student_name) {
//        super(parent, modal);
        initComponents();
        this.task = task;
        this.student_id = student_id;
        this.student_name = student_name;
        init();
    }

    private void init() {
        this.setSize(850, 550);
        this.setLocationRelativeTo(null);
        this.setTitle("Perform Task");
        this.setAlwaysOnTop(true);
        this.lblTitle.setText("Task : " + task[1]);
        ImageIcon format = new ImageIcon(new ImageIcon(Database.path + task[3]).getImage().getScaledInstance(lblGraphic.getWidth(), lblGraphic.getHeight(), Image.SCALE_DEFAULT));
        this.lblGraphic.setIcon(format);
        this.txtDescription.setText(" \n" + task[2]);
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpanelTimeLogoPanel = new javax.swing.JPanel();
        lbltimer1 = new javax.swing.JLabel();
        lblTimer2 = new javax.swing.JLabel();
        jpanelTimeInfoPanel = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpanelTaskDescriptionPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jpanelTaskDetails = new javax.swing.JPanel();
        jpanelTaskGraphic = new javax.swing.JPanel();
        lblGraphic = new javax.swing.JLabel();
        jpanelTaskDescription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jpanelOptionPanel = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setMinimumSize(new java.awt.Dimension(250, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 474));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jpanelTimeLogoPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        jpanelTimeLogoPanel.setOpaque(false);
        jpanelTimeLogoPanel.setPreferredSize(new java.awt.Dimension(250, 100));
        jpanelTimeLogoPanel.setLayout(new java.awt.CardLayout());

        lbltimer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltimer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/picture.png"))); // NOI18N
        lbltimer1.setToolTipText("");
        jpanelTimeLogoPanel.add(lbltimer1, "card2");

        lblTimer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/picture.gif"))); // NOI18N
        lblTimer2.setToolTipText("");
        jpanelTimeLogoPanel.add(lblTimer2, "card2");

        jPanel1.add(jpanelTimeLogoPanel);

        jpanelTimeInfoPanel.setMinimumSize(new java.awt.Dimension(200, 100));

        lblTimer.setFont(new java.awt.Font("Chilanka", 1, 14)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00.00.00");

        javax.swing.GroupLayout jpanelTimeInfoPanelLayout = new javax.swing.GroupLayout(jpanelTimeInfoPanel);
        jpanelTimeInfoPanel.setLayout(jpanelTimeInfoPanelLayout);
        jpanelTimeInfoPanelLayout.setHorizontalGroup(
            jpanelTimeInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelTimeInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        jpanelTimeInfoPanelLayout.setVerticalGroup(
            jpanelTimeInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelTimeInfoPanelLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel1.add(jpanelTimeInfoPanel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jpanelTaskDescriptionPanel.setMinimumSize(new java.awt.Dimension(52, 100));

        lblTitle.setFont(new java.awt.Font("Chilanka", 1, 14)); // NOI18N
        lblTitle.setText("Task :");
        jpanelTaskDescriptionPanel.add(lblTitle);

        jPanel2.add(jpanelTaskDescriptionPanel, java.awt.BorderLayout.PAGE_START);

        jpanelTaskDetails.setLayout(new java.awt.GridLayout(1, 0));

        jpanelTaskGraphic.setLayout(new java.awt.BorderLayout());
        jpanelTaskGraphic.add(lblGraphic, java.awt.BorderLayout.CENTER);

        jpanelTaskDetails.add(jpanelTaskGraphic);

        jpanelTaskDescription.setLayout(new java.awt.BorderLayout());

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Chilanka", 0, 8)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jpanelTaskDescription.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpanelTaskDetails.add(jpanelTaskDescription);

        jPanel2.add(jpanelTaskDetails, java.awt.BorderLayout.CENTER);

        btnStart.setFont(new java.awt.Font("Chilanka", 0, 12)); // NOI18N
        btnStart.setText("Start");
        btnStart.setPreferredSize(new java.awt.Dimension(130, 50));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jpanelOptionPanel.add(btnStart);

        btnStop.setFont(new java.awt.Font("Chilanka", 0, 12)); // NOI18N
        btnStop.setText("Finish");
        btnStop.setEnabled(false);
        btnStop.setPreferredSize(new java.awt.Dimension(130, 50));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jpanelOptionPanel.add(btnStop);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpanelOptionPanel.add(jButton1);

        jPanel2.add(jpanelOptionPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        t = helper.Timer(lblTimer);
        time_start = helper.requestDate();
        time_stop = null;

        lbltimer1.setVisible(false);
        lblTimer2.setVisible(true);

        t.start();
        btnStop.setEnabled(true);
        btnStart.setEnabled(false);

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        lbltimer1.setVisible(true);
        lblTimer2.setVisible(false);
        time_stop = helper.requestDate();
        t.stop();
        this.setAlwaysOnTop(false);
//       
        int res = JOptionPane.showConfirmDialog(null, "\tWell Done!\n"
                + "\n You have finished task " + task[1] + "\n Do you want "
                + "to repeat again?", "Well Done!", JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION);
        if (res == 0) {
            lblTimer.setText("00.00.00");
            btnStop.setEnabled(false);
            btnStart.setEnabled(true);
            this.setAlwaysOnTop(true);
        } else {
            String time_taken = helper.timeTaken(time_start, time_stop);
            String student_id = this.student_id;
            String task_id = this.task[0];
            String time = helper.getTime();
            String date = helper.getDate();
            String month = helper.getMonth();
            String year = helper.getYear();
            String timestamp = helper.getTimeStamp() + "";
            //insert data, call response
            String sql = "INSERT INTO `student_task`("
                    + "    `student_id`,"
                    + "    `task_id`,"
                    + "    `time_taken`,"
                    + "    `time`,"
                    + "    `date`,"
                    + "    `month`,"
                    + "    `year`,"
                    + "    `timestamp`"
                    + ")"
                    + "VALUES('" + student_id + "', '" + task_id + "', '" + time_taken + "', '" + time + "', '" + date + "', '" + month + "', '" + year + "', '" + timestamp + "')";
            Database d = new Database();
            boolean success = d.executeInsert(sql);
            if (success) {
                success();
            } else {
                new Validator().popup("There was a problem, Check Internet connection then try again");

            }
        }

    }//GEN-LAST:event_btnStopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new StudentHome().removeElementFromList("");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void success() {

        JLabel l = new JLabel();
        JLabel t = new JLabel("");

        t.setFont(new java.awt.Font("Chilanka", 1, 14)); // NOI18N
        t.setText("Congrats! Well Done!");

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(t, BorderLayout.NORTH);
        p.add(l, BorderLayout.CENTER);
        l.setPreferredSize(new Dimension(250, 250));
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/love-emoji.gif")));
        JOptionPane.showMessageDialog(null, p, "Well Done", JOptionPane.CLOSED_OPTION, null);
        new StudentHome(student_name,student_id).setVisible(true);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(StudentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentTask dialog = new StudentTask(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelOptionPanel;
    private javax.swing.JPanel jpanelTaskDescription;
    private javax.swing.JPanel jpanelTaskDescriptionPanel;
    private javax.swing.JPanel jpanelTaskDetails;
    private javax.swing.JPanel jpanelTaskGraphic;
    private javax.swing.JPanel jpanelTimeInfoPanel;
    private javax.swing.JPanel jpanelTimeLogoPanel;
    private javax.swing.JLabel lblGraphic;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTimer2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbltimer1;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
