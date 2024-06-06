/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;


 
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author cotad
 */
import java.util.concurrent.TimeUnit;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Splash2 extends JFrame {

    JProgressBar progressBar;

     Splash2() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third2.jpg"));
        java.awt.Image i2 = i1.getImage().getScaledInstance(650, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBounds(400, 550, 300, 20);
        add(progressBar);

        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        // Simulate loading task
        loadTask();
    }

    private void loadTask() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    publish(i);
                    TimeUnit.MILLISECONDS.sleep(50); // Simulate loading time
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int progress = chunks.get(chunks.size() - 1);
                progressBar.setValue(progress);
            }

            @Override
            protected void done() {
                try {
                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        new Splash2();
    }
}
