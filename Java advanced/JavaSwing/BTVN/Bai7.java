package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Bai7 extends JFrame {
    private  JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6;
    private JButton jButton;
    private JTextField jTextField;
    private JCheckBox jCheckBox;
    private JList jList;
    private  JButton jButtonOut;
    private DefaultListModel<Integer> listModel = new DefaultListModel<>();

    public Bai7(){
        init();
        WeastBorder();
        CenterBorder();
        //pack();
        control();
        setVisible(true);
    }

    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle("Thao Tác Trên Jlist");
        Font font = new Font("Aria",Font.BOLD,20);
        JLabel jLabel = new JLabel("Thao Tác trên JList - CheckBox",JLabel.CENTER);
        jLabel.setFont(font);
        jLabel.setForeground(Color.blue);
        add(jLabel,BorderLayout.NORTH);


        JPanel jPanel = new JPanel();
        jButtonOut = new JButton("Đóng Chương trình");
        jPanel.setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.red);
        jPanel.setBorder(border);
        jPanel.add(jButtonOut);
        add(jPanel,BorderLayout.SOUTH);

    }
    public void CenterBorder(){
        Border border = BorderFactory.createLineBorder(Color.red);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Nhập thông tin");
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.red);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(titledBorder);

        JPanel jPanel1 = new JPanel(new FlowLayout());
        jButton = new JButton("Nhập");
        jTextField = new JTextField(10);
        jCheckBox = new JCheckBox("Cho nhập số âm");

        jPanel1.add(jButton);
        jPanel1.add(jTextField);
        jPanel1.add(jCheckBox);
        jList = new JList(listModel);
        jPanel.add(jPanel1,BorderLayout.NORTH);
        JPanel jPanel2 =new JPanel(new BorderLayout());
        jPanel2.add(new JScrollPane(jList),BorderLayout.CENTER);
        jPanel.add(jPanel2,BorderLayout.CENTER);
        add(jPanel, BorderLayout.CENTER);
    }
    public void WeastBorder(){
        Border border = BorderFactory.createLineBorder(Color.red);
        TitledBorder titledBorder =BorderFactory.createTitledBorder(border,"Chọn tác vụ");
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.red);
        JPanel jPanel = new JPanel();
        jPanel.setBorder(titledBorder);
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        jButton1 = new JButton("Tô đen số chẵn");
        jButton2 = new JButton("Tô đen số lẻ");
        jButton3 = new JButton("Tô đen số nguyên tố");
        jButton4 = new JButton("Bỏ tô đen");
        jButton5 = new JButton("Xóa các giá trị đang tô đen");
        jButton6 = new JButton("Tổng giá trị trong JList");

        jPanel.add(jButton1);
        jPanel.add(Box.createVerticalStrut(10));
        jPanel.add(jButton2);
        jPanel.add(Box.createVerticalStrut(10));
        jPanel.add(jButton3);
        jPanel.add(Box.createVerticalStrut(10));
        jPanel.add(jButton4);
        jPanel.add(Box.createVerticalStrut(10));
        jPanel.add(jButton5);
        jPanel.add(Box.createVerticalStrut(10));
        jPanel.add(jButton6);
        JPanel jPanel1 = new JPanel(new BorderLayout());
        jPanel1.add(jPanel,BorderLayout.CENTER);
        add(jPanel1,BorderLayout.WEST);
    }
    public void control(){
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(jTextField.getText().toString());
                if((a<0)&&!jCheckBox.isSelected()){
                    JOptionPane.showMessageDialog(null,"Lỗi hãy nhập số dương hoặc chọn tích để nhập số âm!");
                    jTextField.setText("");
                    jTextField.setFocusable(true);
                }else if((a<0)&&jCheckBox.isSelected()){
                    listModel.addElement(a);
                    jTextField.setText("");
                }else if(a>0){
                    listModel.addElement(a);
                    jTextField.setText("");
                }
            }
        });
        int[] b = {1,2,3,10,11,8,4,6,9,22,14,15,16,21,27};
        for(int i=0;i<b.length;i++){
            listModel.addElement(b[i]);
        }
        ListSelectionModel selectionModel =  jList.getSelectionModel();
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ mục của các phần tử được chọn
                selectionModel.clearSelection();
                for(int i=0;i<listModel.getSize();i++){
                    int value = listModel.getElementAt(i);
                    if(value%2==0){
                        selectionModel.addSelectionInterval(i,i);
                    }
                }
            }
        });
        jButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionModel.clearSelection();
                for(int i=0;i<listModel.getSize();i++){
                    int value = listModel.getElementAt(i);
                    if(value%2==1){
                        selectionModel.addSelectionInterval(i,i);
                    }
                }
            }
        });
        jButton3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionModel.clearSelection();
                for (int i=0;i<listModel.getSize();i++){
                    int value = listModel.getElementAt(i);
                    if(primeNumber(value)){
                        selectionModel.addSelectionInterval(i,i);
                    }
                }
            }
        });
        jButton4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionModel.clearSelection();
            }
        });

        jButton5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int[] selectedIndices = jList.getSelectedIndices();
                for (int i=selectedIndices.length-1;i>=0;i--){
                    listModel.removeElementAt(selectedIndices[i]);
                }
            }
        });
        jButton6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    selectionModel.clearSelection();
                int a = 0;
                for(int i=0;i<listModel.getSize();i++){
                    int value = listModel.getElementAt(i);
                    a+=value;
                }
                JOptionPane.showMessageDialog(null,"Tổng giá trị trong jlist là: "+a);
            }
        });
        jButtonOut.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public boolean primeNumber(int n){
        if(n==0||n==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%2==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Bai7 bai7 = new Bai7();
    }
}
