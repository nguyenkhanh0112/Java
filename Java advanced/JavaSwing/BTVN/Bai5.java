package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Bai5 extends JFrame {
    private JLabel label;
    private JList jList;
    public Bai5(){
        init();
        control();
    }
    public void init(){
        setDefaultCloseOperation(3);
        setSize(200,150);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);

    }
    public void control(){
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Font font = new Font("Arial",Font.PLAIN,16);
        label = new JLabel("",JLabel.CENTER);
        label.setBackground(Color.LIGHT_GRAY);
        label.setFont(font);
        label.setForeground(Color.BLUE);
        label.setBorder(border);
        String[] data = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday"};
        jList =new JList<>(data);
        jList.setFont(font);
        jList.setSelectedIndex(0);
        label.setText((String) jList.getSelectedValue());
        add(label);
        add(new JScrollPane(jList));
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectValue = jList.getSelectedValue().toString();
                label.setText(selectValue);
            }
        });
     //   pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->new Bai5());
    }

}
