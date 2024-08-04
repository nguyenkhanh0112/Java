package view;

import controller.SreachListener;
import model.SreachModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SreachView extends JFrame {
    private SreachModel sreachModel;
    private JLabel jLabel_text;
    private JTextArea jTextArea_Text;
    private JLabel jLabel_keyWords;
    private JTextField jTextField_keyWords;
    private JLabel jLabel_Result;

    public SreachView() throws HeadlessException {
        this.sreachModel = new SreachModel();
        this.init();
    }
    public void init(){
        this.setTitle("Sreach");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        Font font = new Font("Time New Roman",Font.BOLD,22);

        jLabel_text = new JLabel("Văn Bản");
        jLabel_text.setFont(font);
        jTextArea_Text = new JTextArea(100,100);
        jTextArea_Text.setFont(font);

       // JScrollPane jScrollPane = new JScrollPane(jTextArea_Text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane jScrollPane = new JScrollPane(jTextArea_Text);



        //Footer
        ActionListener sreachListener = new SreachListener(this);
        jLabel_keyWords = new JLabel("Từ Khóa");
        jLabel_keyWords.setFont(font);
        jTextField_keyWords = new JTextField();
        jTextField_keyWords.setFont(font);

        JButton jButton_Thongke = new JButton("Thống Kê");
        jButton_Thongke.setFont(font);
        jButton_Thongke.addActionListener(sreachListener);
        jButton_Thongke.setBackground(Color.GREEN);

        jLabel_Result = new JLabel();
        jLabel_Result.setBackground(Color.YELLOW);
        jLabel_Result.setFont(font);
        jLabel_Result.setOpaque(true);

        JPanel jPanel_Footer= new JPanel();
        jPanel_Footer.setLayout(new GridLayout(2,2,20,20));
        jPanel_Footer.add(jLabel_keyWords);
        jPanel_Footer.add(jTextField_keyWords);
        jPanel_Footer.add(jButton_Thongke);
        jPanel_Footer.add(jLabel_Result);


        this.setLayout(new BorderLayout());
        this.add(jLabel_text,BorderLayout.NORTH);
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(jPanel_Footer,BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public void sreach(){
        this.sreachModel.setText((jTextArea_Text.getText()));
        this.sreachModel.setWordsKey(jTextField_keyWords.getText());
        this.sreachModel.sreach();
        this.jLabel_Result.setText(this.sreachModel.getResult());
    }
}
