package view;

import Controller.MenuExampleController;
import Controller.MenuExampleMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MenuExampleView extends JFrame {
    private final JLabel jlabel;
    private final JToolBar jToolBar;
    public  JPopupMenu jPopupMenu;

    public MenuExampleView() {
        this.setTitle("Menu Example");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // taoj controller
        MenuExampleController menuExampleController = new MenuExampleController(this);

        // tao thanh menu
        JMenuBar jMenuBar = new JMenuBar();

        // tao 1 menu
        JMenu jMenu_file = new JMenu("File");

        // tap cac menu con
        JMenuItem jMenuItem_New = new JMenuItem("New", KeyEvent.VK_N);
        jMenuItem_New.addActionListener(menuExampleController);
        jMenuItem_New.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)));
        JMenuItem jMenuItem_open = new JMenuItem("Open",KeyEvent.VK_O);
        jMenuItem_open.addActionListener(menuExampleController);
        jMenuItem_open.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)));
        JMenuItem jMenuItem_exit = new JMenuItem("Exit",KeyEvent.VK_X);
        jMenuItem_exit.addActionListener(menuExampleController);
        jMenuItem_exit.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK)));
        jMenu_file.add(jMenuItem_New);
        jMenu_file.addSeparator();
        jMenu_file.add(jMenuItem_open);
        jMenu_file.addSeparator();
        jMenu_file.add(jMenuItem_exit);

        // menu view
        JMenu jMenu_view = new JMenu("View");
        JCheckBoxMenuItem jCheckBoxMenuItem_ToolBar = new JCheckBoxMenuItem("ToolBal");
        jCheckBoxMenuItem_ToolBar.addActionListener(menuExampleController);
        jMenu_view.add(jCheckBoxMenuItem_ToolBar);


        // menu help
        JMenu jMenu_help = new JMenu("Help");
        JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
        jMenuItem_welcome.addActionListener(menuExampleController);
        jMenu_help.add(jMenuItem_welcome);

        jMenuBar.add(jMenu_file);
        jMenuBar.add(jMenu_view);
        jMenuBar.add(jMenu_help);

        // them thanh menu vao chuong trinh
        this.setJMenuBar(jMenuBar);

        // tao toolBar (thanh cong cu)
        Font font = new Font("Time New Roman",Font.BOLD,18);
        jToolBar = new JToolBar();
        JButton jButton_undo = new JButton("Undo");
        jButton_undo.setToolTipText("nhan vao day de quuay lai");
        jButton_undo.addActionListener(menuExampleController);
        JButton jButton_Redo = new JButton("Redo");
        jButton_Redo.addActionListener(menuExampleController);
        JButton jButton_Copy = new JButton("Copy");
        jButton_Copy.addActionListener(menuExampleController);
        JButton jButton_cut= new JButton("Cut");
        jButton_cut.addActionListener(menuExampleController);
        JButton jButton_paste = new JButton("Patse");
        jButton_paste.addActionListener(menuExampleController);

        jToolBar.add(jButton_undo);
        jToolBar.add(jButton_Redo);
        jToolBar.add(jButton_Copy);
        jToolBar.add(jButton_cut);
        jToolBar.add(jButton_paste);

       // this.add(jToolBar,BorderLayout.NORTH);

        jPopupMenu= new JPopupMenu();
        JMenu jMenu_popFont = new JMenu("Font");
        JMenuItem jMenuItemType= new JMenuItem("Type");
        JMenuItem jMenuItemSize= new JMenuItem("Size");
        jMenu_popFont.add(jMenuItemType);
        jMenu_popFont.add(jMenuItemSize);

        JMenuItem jMenuItemCut = new JMenuItem("Cut");
        jMenuItemCut.addActionListener(menuExampleController);
        JMenuItem jMenuItemCopy = new JMenuItem("Copy");
        JMenuItem jMenuItemPatse = new JMenuItem("Patse");

        jPopupMenu.add(jMenu_popFont);
        jPopupMenu.addSeparator();
        jPopupMenu.add(jMenuItemCut);
        jPopupMenu.add(jMenuItemCopy);
        jPopupMenu.add(jMenuItemPatse);
        this.add(jPopupMenu);

        // them su kien phai chuot vao Jlabel
        MenuExampleMouseListener menuExampleMouseListener = new MenuExampleMouseListener(this);
        this.addMouseListener(menuExampleMouseListener);

        // taoj label hien thi
        jlabel = new JLabel();
        this.add(jlabel,BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    public void setTextJlapel(String s){
        this.jlabel.setText(s);
    }
    public void enableToolBal(){
        this.add(jToolBar,BorderLayout.NORTH);
        this.refresh();

    }
    public void disableToolBal(){
        this.remove(jToolBar);
        this.refresh();
    }
    public void refresh(){
        this.pack();
        this.setSize(500,500);
    }
}
