package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class Bai6 extends JFrame {
    private JList jList1,jList2;
    private  JButton jButton;
    private String s1;

    public Bai6() throws FileNotFoundException {
        init();
        control();
    }
    public void Ghidulieu(ArrayList<String> arrayList){
        try{
            FileWriter fileWriter =new FileWriter("D:\\java advanced\\data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<arrayList.size();i++){
                bufferedWriter.write(arrayList.get(i).toString());
                bufferedWriter.newLine();
            }
//            for (String line : arrayList) {
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<String> DocDuLieu(){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            FileReader fileReader =new FileReader("D:\\java advanced\\data.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while((line=(reader.readLine()))!=null){
                arrayList.add(line);
            }
            fileReader.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }
    public void init() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        setLocationRelativeTo(null);
        setTitle("Multiple Selection Lists");
    }

    public void control() {
        DefaultListModel<String> defaultListModel =new DefaultListModel<>();
        DefaultListModel<String> defaultListModel1 = new DefaultListModel<>();
        try{
            FileReader fileReader =new FileReader("D:\\java advanced\\data.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while((line=(reader.readLine()))!=null){
                defaultListModel.addElement(line);
            }
            fileReader.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        jList1 = new JList<>(defaultListModel);
        jButton = new JButton("Copy>>>");
        jList2 = new JList<>(defaultListModel1);

        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                 s1 = jList1.getSelectedValue().toString();
            }
        });
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultListModel1.addElement(s1);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    try {
                        FileWriter fileWriter = new FileWriter("D:\\Java advanced\\dataJlist2.txt");
                        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
                        for (int i=0;i<defaultListModel1.size();i++){
                            bufferedWriter.write(defaultListModel1.get(i).toString());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        fileWriter.close();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    dispose();
            }
        });
        add(new JScrollPane(jList1));
        add(jButton);
        add(new JScrollPane(jList2));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bai6 bai6 =new Bai6();
//        ArrayList<String> stringArrayList = new ArrayList<>();
//        String[] s = {"Black","Blue","Cyan","Gray"};
//        for (int i=0;i<s.length;i++){
//            stringArrayList.add(s[i].toString());
//        }
//        bai6.Ghidulieu(stringArrayList);

    }
}