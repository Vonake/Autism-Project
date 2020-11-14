
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.filechooser.FileSystemView;

/**
 * ALTER TABLE `tasks` CHANGE `Graphic` `Graphic` VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;
 * 
 * ALTER TABLE `student_log` ADD `timestamp` VARCHAR(10) NOT NULL AFTER `year`;
ALTER TABLE `student_task` ADD `timestamp` VARCHAR(10) NOT NULL AFTER `year`;
 * 
 * ALTER TABLE `student_task` CHANGE `date` `date` VARCHAR(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;

ALTER TABLE `tasks` CHANGE `Description` `Description` VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;
 * @author kario
 */

public class TT extends JFrame implements ActionListener {

    JPanel top = new JPanel(new FlowLayout());
    JButton btn = new JButton("Random");
    DefaultListModel<String> dlm = new DefaultListModel<String>();
    JList<String> list = new JList<>(dlm);
    JScrollPane jsp = new JScrollPane(list);

    public TT() {
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(top, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        top.add(btn);

        btn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String e = event.getActionCommand();

        if (e.equalsIgnoreCase("Random")) {
            random();
        }

    }

    public void random() {
        String n = Math.random() + "";
        System.out.println(n);
        dlm.addElement(n);

    }

    public static void main(String[] args) {
//        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//
//        int returnValue = jfc.showOpenDialog(null);
//        // int returnValue = jfc.showSaveDialog(null);
//
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = jfc.getSelectedFile();
//            System.out.println(selectedFile.getAbsolutePath());
//        }
        int w = 280;
        int h = 400;
        BufferedImage image = null;
        File f = null;
        
        //this is the read image try
        try {
            //where to read the image
            f = new File("/home/kario/NetBeansProjects/bank/src/bank/img/Account.png");
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(f);
            System.out.println("Read Complete"+image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this is the write image try
        try{
            //where to write the image
            f = new File("//var//www//html//"+new Timestamp(System.currentTimeMillis())+".png");
            ImageIO.write(image, "png", f);
            System.out.println("writing complete");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
//            File file = new File("/home/kario/NetBeansProjects/bank/src/bank/img/Account.png");
    }
/**
 * SELECT tasks.Task_ID, tasks.Task_Name, tasks.Description FROM tasks INNER JOIN student_task ON student_task.task_id = tasks.Task_ID INNER JOIN student ON student.Student_ID = student_task.student_id WHERE student_task.timestamp = ''
 */
  
}
