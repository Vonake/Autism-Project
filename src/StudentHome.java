
import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StudentHome extends javax.swing.JFrame {

    int w = 1350;
    int h = 800;

    Database db = new Database();
    Validator v = new Validator();
    Helper helper = new Helper();
    DefaultListModel<String> model = new DefaultListModel<>();
    ArrayList<String> task_graphic = new ArrayList<>();
    ArrayList<String> task_id = new ArrayList<>();
    ArrayList<String> task_name = new ArrayList<>();
    ArrayList<String> task_description = new ArrayList<>();

    ArrayList<String> available_task_graphic = new ArrayList<>();
    ArrayList<String> available_task_id = new ArrayList<>();
    ArrayList<String> available_task_name = new ArrayList<>();
    ArrayList<String> available_task_description = new ArrayList<>();

    String name = null;
    String student_id = null;

    public StudentHome() {
        initComponents();
        setDefaults();
    }

    public StudentHome(String name, String student_id) {
        this.name = name;
        this.student_id = student_id;
        initComponents();
        setDefaults();
    }

    private void setDefaults() {
        this.setSize(w, h);
        this.setTitle("Welcome");
        this.setLocationRelativeTo(null);
        this.setMaximizedBounds(null);
        this.lblTitle1.setText("Welcome back " + name + "!");
        this.loadTasks();
        this.lblDay.setText("Today is : " + helper.getDay());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        lblTime.setText("The time is : " + helper.getTime());
                        Thread.sleep(60000);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
        t.start();

    }

    /**
     * This method loads all the tasks from the database. SELECT tasks.Task_ID,
     * tasks.Task_Name, tasks.Description FROM tasks INNER JOIN student_task ON
     * student_task.task_id = tasks.Task_ID INNER JOIN student ON
     * student.Student_ID = student_task.student_id WHERE student_task.timestamp
     * => ''
     *
     * SELECT tasks.* ,student_task.* FROM `student_task` inner join tasks on
     * tasks.Task_ID = student_task.id WHERE 1
     *
     */
    public void loadTasks() {
        String sql_getTasks = "select * from tasks";
        int timestamp = helper.getTimeStamp();
        String sql_tasks_done = "SELECT `task_id` FROM `student_task` "
                + "WHERE student_id='" + student_id + "' and timestamp='" + timestamp + "' or timestamp > '" + timestamp + "';";
        listTasks.setModel(model);
        // model.removeAllElements();
        boolean tasks_present = db.checkDuplicate(sql_getTasks);

        if (tasks_present == true) {
            ResultSet rs = db.executeSelect(sql_getTasks);
            ResultSet rs_done = db.executeSelect(sql_tasks_done);
            String task_id, task_name, task_description, task_graphic = null;
            ArrayList<String> tasks_done = new ArrayList<>();
            int t = 1;
            try {
                while (rs.next() == true) {
                    task_id = rs.getString("Task_ID");
                    task_name = rs.getString("Task_Name");
                    task_description = rs.getString("Description");
                    task_graphic = rs.getString("Graphic");
//                    model.addElement(t + ". " + task_name);

                    this.task_id.add(task_id);
                    this.task_name.add(task_name);
                    this.task_description.add(task_description);
                    this.task_graphic.add(task_graphic);

                    task_id = task_name = task_description = task_graphic = null;

                }

                while (rs_done.next() == true) {
                    tasks_done.add(rs_done.getString("task_id"));
                    t++;
                }

                int a = 0;
                for (int i = 0; i < tasks_done.size(); i++) {
                    if (this.task_id.contains(tasks_done.get(i))) {
                        a = this.task_id.indexOf(tasks_done.get(i));
                        this.task_id.remove(a);
                        this.task_name.remove(a);
                        this.task_description.remove(a);
                        this.task_graphic.remove(a);
                    }
                }

                if (this.task_name.isEmpty()) {
                    noMessages();
                    lblTaskLeft.setText("Tasks to do : 0");
                } else {
                    int x = this.task_name.size();
                    for (int i = 0; i < x; i++) {
                        model.addElement((i + 1) + ". " + this.task_name.get(i));
                    }
                    lblTaskLeft.setText("Tasks to do : " + x);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            //disable some contents here,
            noMessages();
            //display some no tasks message
        }

    }

    public void noMessages() {
        lblTaskTitle.setText("You have no more tasks today!");
        lblGraphic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/garfield.gif")));
        txtDescription.setText("            Congratulations!\n \nYou have no more tasks today!");
    }

    private void loadSelectedTask(int id) {
        this.lblTaskTitle.setText("Selected Task : " + task_name.get(id));
        ImageIcon format = new ImageIcon(new ImageIcon(Database.path + task_graphic.get(id)).getImage().getScaledInstance(lblGraphic.getWidth(), lblGraphic.getHeight(), Image.SCALE_DEFAULT));
        lblGraphic.setIcon(format);
        txtDescription.setText(task_description.get(id));
        btnStartTask.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. **
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        sideMenuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        stats = new javax.swing.JPanel();
        lblDay = new javax.swing.JLabel();
        lblTaskLeft = new javax.swing.JLabel();
        lblTasksDone = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        titlepanelTop = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        lblCopyright = new javax.swing.JLabel();
        btnLeave = new javax.swing.JButton();
        panelListPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTasks = new javax.swing.JList<>();
        taskDescriptionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnStartTask = new javax.swing.JButton();
        taskNamePanel = new javax.swing.JPanel();
        lblTaskTitle = new javax.swing.JLabel();
        panelTaskPane = new javax.swing.JPanel();
        lblGraphic = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(320);

        sideMenuPanel.setBackground(new java.awt.Color(129, 255, 255));
        sideMenuPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        sideMenuPanel.setPreferredSize(new java.awt.Dimension(200, 591));
        sideMenuPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users/Mickey_V2.png"))); // NOI18N
        sideMenuPanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        lblTitle.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 102, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ATMM-Software");
        jPanel1.add(lblTitle);

        sideMenuPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        stats.setFont(new java.awt.Font("Alessia", 0, 24)); // NOI18N
        stats.setPreferredSize(new java.awt.Dimension(319, 150));
        stats.setLayout(new java.awt.GridLayout(4, 1, 1, 10));

        lblDay.setFont(new java.awt.Font("Chilanka", 0, 10)); // NOI18N
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDay.setText("Today is : Monday");
        stats.add(lblDay);

        lblTaskLeft.setFont(new java.awt.Font("Chilanka", 0, 10)); // NOI18N
        lblTaskLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTaskLeft.setText("Tasks to do : 2");
        stats.add(lblTaskLeft);

        lblTasksDone.setFont(new java.awt.Font("Chilanka", 0, 10)); // NOI18N
        lblTasksDone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stats.add(lblTasksDone);

        lblTime.setFont(new java.awt.Font("Chilanka", 0, 10)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("The time is : ");
        stats.add(lblTime);

        sideMenuPanel.add(stats, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setLeftComponent(sideMenuPanel);

        rightPanel.setLayout(new java.awt.BorderLayout());

        titlepanelTop.setLayout(new java.awt.BorderLayout());

        lblTitle1.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 102, 102));
        lblTitle1.setText("Welcome back Brian!");
        titlepanelTop.add(lblTitle1, java.awt.BorderLayout.SOUTH);

        lblTitle2.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        lblTitle2.setText("We missed you !");
        titlepanelTop.add(lblTitle2, java.awt.BorderLayout.CENTER);

        rightPanel.add(titlepanelTop, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        bottomPanel.setLayout(new java.awt.BorderLayout());

        lblCopyright.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        lblCopyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCopyright.setText("COPYRIGHT: KKAMAU@2020  ");
        lblCopyright.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bottomPanel.add(lblCopyright, java.awt.BorderLayout.CENTER);

        btnLeave.setFont(new java.awt.Font("Chilanka", 0, 8)); // NOI18N
        btnLeave.setText("Leave us");
        btnLeave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeave.setPreferredSize(new java.awt.Dimension(130, 50));
        btnLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveActionPerformed(evt);
            }
        });
        bottomPanel.add(btnLeave, java.awt.BorderLayout.WEST);

        rightPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        panelListPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Tasks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        panelListPanel.setMinimumSize(new java.awt.Dimension(200, 20));
        panelListPanel.setPreferredSize(new java.awt.Dimension(250, 391));
        panelListPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 131));

        listTasks.setFont(new java.awt.Font("Chilanka", 1, 10)); // NOI18N
        listTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listTasks.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTasksValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listTasks);

        panelListPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        rightPanel.add(panelListPanel, java.awt.BorderLayout.LINE_START);

        taskDescriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Task to do", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        taskDescriptionPanel.setLayout(new java.awt.BorderLayout());

        btnStartTask.setFont(new java.awt.Font("Chilanka", 0, 10)); // NOI18N
        btnStartTask.setText("Start");
        btnStartTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStartTask.setEnabled(false);
        btnStartTask.setPreferredSize(new java.awt.Dimension(100, 50));
        btnStartTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTaskActionPerformed(evt);
            }
        });
        jPanel3.add(btnStartTask);

        taskDescriptionPanel.add(jPanel3, java.awt.BorderLayout.SOUTH);

        lblTaskTitle.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        lblTaskTitle.setText("Selected Task : none");
        taskNamePanel.add(lblTaskTitle);

        taskDescriptionPanel.add(taskNamePanel, java.awt.BorderLayout.NORTH);

        panelTaskPane.setLayout(new java.awt.BorderLayout());

        lblGraphic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGraphic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelTaskPane.add(lblGraphic, java.awt.BorderLayout.CENTER);

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setLayout(new java.awt.BorderLayout());

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Chilanka", 0, 12)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelTaskPane.add(jPanel4, java.awt.BorderLayout.EAST);

        taskDescriptionPanel.add(panelTaskPane, java.awt.BorderLayout.CENTER);

        rightPanel.add(taskDescriptionPanel, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(rightPanel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTaskActionPerformed
        int id = listTasks.getSelectedIndex();
        String[] task = {task_id.get(id), task_name.get(id), task_description.get(id), task_graphic.get(id)};
        StudentTask t = new StudentTask(null, true, task, student_id, name);
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStartTaskActionPerformed

    private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveActionPerformed
        int x = JOptionPane.showConfirmDialog(this, new NoTasks(), "Do you want to leave?", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null);
        
        if(x == 0){
            this.dispose();
            new StudentLogin().setVisible(true);
        }
    }//GEN-LAST:event_btnLeaveActionPerformed
    public void removeElementFromList(String element) {
        this.model.removeElement("3. wash hands");
    }
    private void listTasksValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTasksValueChanged
        // TODO add your handling code here:
        int id = listTasks.getSelectedIndex();

        loadSelectedTask(id);

    }//GEN-LAST:event_listTasksValueChanged

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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome("Kario tester", "7").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnLeave;
    private javax.swing.JButton btnStartTask;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblGraphic;
    private javax.swing.JLabel lblTaskLeft;
    private javax.swing.JLabel lblTaskTitle;
    private javax.swing.JLabel lblTasksDone;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JList<String> listTasks;
    private javax.swing.JPanel panelListPanel;
    private javax.swing.JPanel panelTaskPane;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel sideMenuPanel;
    private javax.swing.JPanel stats;
    private javax.swing.JPanel taskDescriptionPanel;
    private javax.swing.JPanel taskNamePanel;
    private javax.swing.JPanel titlepanelTop;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
