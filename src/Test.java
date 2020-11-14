
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kario
 */
public class Test {

    public static void main(String[] args) throws IOException {

        /*JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//
        int returnValue = jfc.showOpenDialog(null);
        BufferedImage image = null;
        File f = null;
        // int returnValue = jfc.showSaveDialog(null);

       /* if (returnValue == JFileChooser.APPROVE_OPTION) {
            //read image
            f = jfc.getSelectedFile();
            System.out.println("File : " + f.getAbsolutePath());
            image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(new File(f.getAbsolutePath()));

            try {
                //write image
                String extension = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf(".") + 1);
                InputStream input = new FileInputStream(f.getAbsolutePath());
                OutputStream output = new FileOutputStream("/var/www/html/java/" + new Timestamp(System.currentTimeMillis()) + "." + extension);
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buf)) > 0) {
                    output.write(buf, 0, bytesRead);
                }
                input.close();
                output.close();
                System.out.println("writing complete");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Date d1 = new Date();
                    Thread.sleep(2010);
                    Date d2 = new Date();
                    System.out.println(new Test().timeTaken(d1, d2)); //gives the time difference in milliseconds.
                    System.out.println( (d2.getTime() - d1.getTime()) / 1000 );
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t.start();

    }
    
     public String timeTaken(Date d1, Date d2) {
        long time = (d2.getTime() - d1.getTime()) / 1000;
        return time + "";
    }

}
