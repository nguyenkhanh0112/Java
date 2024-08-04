package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class mainview extends JFrame {
    private JMenu menu,submenu;
    private JMenuItem i1,i2,i3,i4,i5;
    private JMenuBar mb = new JMenuBar();
    private JButton jButton;
    private JLabel jLabel;

    public mainview()  {
        this.setTitle("Adonis Feed");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        URL urlIcon = mainview.class.getResource("278599581_1681121008890062_9006682130719859060_n.jpg");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
        this.setIconImage(img);

        menu = new JMenu("Menu");
        submenu = new JMenu("Sub menu");
        i1 = new JMenuItem("New");
        i1.setIcon(new ImageIcon(mainview.class.getResource("179452.png")));
        i2 = new JMenuItem("Save");
        i2.setIcon(new ImageIcon(mainview.class.getResource("images.png")));
        i3 = new JMenuItem("Save As");
        i3.setIcon(new ImageIcon(mainview.class.getResource("images.png")));
        i4 = new JMenuItem("Exit");
        i4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(mainview.class.getResource("exit-icon-vector-22391092.jpg"))));
        i5 = new JMenuItem("Test");
        i5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(urlIcon)));
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);
        //Jbutton
        jButton = new JButton("Text Button");
        jButton.setFont((new Font("Time New Roman",Font.BOLD,20)));
        jButton.setSize(30,30);

        // jlabel
        jLabel = new JLabel("Adonis Feed");
        jLabel.setFont((new Font("Time New Roman",Font.BOLD,20)));
        this.setJMenuBar(mb);
        this.add(jLabel,BorderLayout.CENTER);
        this.add(jButton,BorderLayout.SOUTH);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new mainview();
    }
}
