package view;

import controller.MouseExamleController;
import model.MouseExamleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MouseExamleView extends JFrame {
    private MouseExamleModel mouseExamleModel;
    private JPanel jPanel_Mouse;
    private JPanel jPanel_infor;
    private JLabel jLabel_position;
    private JLabel jLabel_x;
    private JLabel jLabel_y;
    private JLabel jLabel_count;
    private JLabel jLabel_count_value;
    private JLabel jLabel_checkIn;
    private JLabel jLabel_check_in_value;
    private JLabel jLabel_empty_1;
    private JLabel jLabel_empty_2;

    public MouseExamleView() throws HeadlessException {
        this.mouseExamleModel = new MouseExamleModel();
        this.init();
    }
    private void init(){
        this.setTitle("MOUSE EXAMPL");
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font font = new Font("Time New Roman",Font.BOLD,20);
        MouseExamleController mouseListener = new MouseExamleController(this);

        jPanel_Mouse = new JPanel();
        jPanel_Mouse.setBackground(Color.cyan);
        jPanel_Mouse.addMouseListener(mouseListener);
        jPanel_Mouse.addMouseMotionListener(mouseListener);


        jPanel_infor = new JPanel();
        jPanel_infor.setLayout(new GridLayout(3,3));

        jLabel_position = new JLabel("Position: ");
        jLabel_position.setFont(font);
        jLabel_x = new JLabel("x = ");
        jLabel_x.setFont(font);
        jLabel_y = new JLabel("y = ");
        jLabel_y.setFont(font);
        jLabel_count = new JLabel("Number of Click: ");
        jLabel_count.setFont(font);
        jLabel_count_value = new JLabel("n");
        jLabel_count_value.setFont(font);
        jLabel_checkIn = new JLabel("Mouse in componet ");
        jLabel_checkIn.setFont(font);
        jLabel_check_in_value = new JLabel();
        jLabel_check_in_value.setFont(font);
        jLabel_empty_1 = new JLabel();
        jLabel_empty_2 = new JLabel();
        jPanel_infor.add(jLabel_position);
        jPanel_infor.add(jLabel_x);
        jPanel_infor.add(jLabel_y);
        jPanel_infor.add(jLabel_count);
        jPanel_infor.add(jLabel_count_value);
        jPanel_infor.add(jLabel_empty_1);
        jPanel_infor.add(jLabel_checkIn);
        jPanel_infor.add(jLabel_check_in_value);
        jPanel_infor.add(jLabel_empty_2);


        this.setLayout(new BorderLayout());
        this.add(jPanel_Mouse,BorderLayout.CENTER);
        this.add(jPanel_infor,BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public void Click(){
        this.mouseExamleModel.addClick();
        this.jLabel_count_value.setText(this.mouseExamleModel.getCount()+"");
    }
    public void enter(){
        this.mouseExamleModel.enter();
    this.jLabel_check_in_value.setText(this.mouseExamleModel.getCheckIn());
    }
    public void exit(){
        this.mouseExamleModel.exit();
        this.jLabel_check_in_value.setText(this.mouseExamleModel.getCheckIn());

    }
    public void update(int x,int y){
        this.mouseExamleModel.setX(x);
        this.mouseExamleModel.setY(y);
        this.jLabel_x.setText(this.mouseExamleModel.getX()+"");
        this.jLabel_y.setText(this.mouseExamleModel.getY()+"");
    }
}
