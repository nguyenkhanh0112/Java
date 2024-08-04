package JavaSwing.BTVN.Bai9;

import JavaSwing._ConnectDB_;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class QuanLySanPham extends JFrame {
    private Category category;
    private JList<Category> jListDanhMucSanPham;
    private JButton btnNewDMSP,btnUpdateDMSP,btnRemoveDMSP;
    private JButton btnNewSP,btnSaveSP,btnRemoveSP;
    private DefaultListModel<Category> listModel;
    private DefaultTableModel tableModel;
    private JTextField jTextFieldID,jTextFieldName ,jTextFieldPrice,jTextFieldQuantity,jTextFieldDescription;
    private ListSelectionModel selectionModel;
    private JTable jTable;
    private JMenuBar jMenuBar;
    private JMenu menuFile;
    private DefaultComboBoxModel<Category> defaultComboBoxModel;
    private MyFile fileModel;
    private JComboBox<Category> comboBox;
    private JMenuItem menuItemGhiFile,menuItemDocFile,menuItemExit;
    private _ConnectDB_ connectDB;

    public ListSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public QuanLySanPham(){
        category = new Category();
        fileModel = new MyFile();
        init();
        control();
        setVisible(true);
    }

    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle("Quản lý sản phẩm");

        Font font = new Font("Aria",Font.BOLD,14);
        Font font1 = new Font("Aria",Font.BOLD,20);

        JLabel jLabel = new JLabel("QUẢN LÝ SẢN PHẨM",JLabel.CENTER);
        jLabel.setFont(font1);
        add(jLabel,BorderLayout.NORTH);
        jLabel.setForeground(Color.blue);

        jMenuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuItemGhiFile = new JMenuItem("Write Data to disk");
        menuItemDocFile = new JMenuItem("Qpen Data from disk");
        menuItemExit = new JMenuItem("Exit");

        menuFile.add(menuItemGhiFile);
        menuFile.add(menuItemDocFile);
        menuFile.add(menuItemExit);
        jMenuBar.add(menuFile);
        setJMenuBar(jMenuBar);
        ArrayList<Product> products = new ArrayList<>();


        listModel = new DefaultListModel();


        jListDanhMucSanPham = new JList(listModel);
        selectionModel =  jListDanhMucSanPham.getSelectionModel();
        btnNewDMSP = new JButton("New");
        btnRemoveDMSP = new JButton("Remove");
        btnUpdateDMSP = new JButton("Update");

        JPanel jPanelWest = new JPanel(new BorderLayout());
        JPanel jPanelWestbtn = new JPanel();
        jPanelWestbtn.add(btnNewDMSP);
        jPanelWestbtn.add(btnUpdateDMSP);
        jPanelWestbtn.add(btnRemoveDMSP);
        jPanelWest.add(new JScrollPane(jListDanhMucSanPham),BorderLayout.CENTER);
        jPanelWest.add(jPanelWestbtn,BorderLayout.SOUTH);
        add(jPanelWest,BorderLayout.WEST);

        Border border = BorderFactory.createLineBorder(Color.red);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Danh mục Sản phẩm");
        jListDanhMucSanPham.setBorder(titledBorder);

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new BoxLayout(jPanelCenter,BoxLayout.Y_AXIS));
        String[] column = {"ProductID","Product Name","UnitPrice","Quantity","Description"};
        tableModel = new DefaultTableModel(column,0);
        jTable = new JTable(tableModel);

        jPanelCenter.add(new JScrollPane(jTable));

        JLabel jLabel1 = new JLabel("Category:");
        JLabel jLabel2 = new JLabel("ProductID:");
        JLabel jLabel3 = new JLabel("Product Name:");
        JLabel jLabel4 = new JLabel("Unit Price:");
        JLabel jLabel5 = new JLabel("Quantity:");
        JLabel jLabel6 = new JLabel("Description:");

        defaultComboBoxModel = new DefaultComboBoxModel();
        for (int i =0 ;i<listModel.getSize();i++){
            defaultComboBoxModel.addElement(listModel.get(i));
        }
        comboBox = new JComboBox(defaultComboBoxModel);

        jTextFieldID = new JTextField(20);
        jTextFieldName = new JTextField(20);
        jTextFieldPrice = new JTextField(20);
        jTextFieldQuantity = new JTextField(20);
        jTextFieldDescription = new JTextField(20);
        JPanel jPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        jPanel1.add(jLabel1,gbc);
        gbc.gridx++;
        jPanel1.add(comboBox,gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        jPanel1.add(jLabel2,gbc);
        gbc.gridx++;
        jPanel1.add(jTextFieldID,gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        jPanel1.add(jLabel3,gbc);
        gbc.gridx++;
        jPanel1.add(jTextFieldName,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanel1.add(jLabel4,gbc);
        gbc.gridx++;
        jPanel1.add(jTextFieldPrice,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanel1.add(jLabel5,gbc);
        gbc.gridx++;
        jPanel1.add(jTextFieldQuantity,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanel1.add(jLabel6,gbc);
        gbc.gridx++;
        jPanel1.add(jTextFieldDescription,gbc);

        btnNewSP = new JButton("New");
        btnSaveSP = new JButton("Save");
        btnRemoveSP = new JButton("Remove");

        JPanel jPanel2 = new JPanel();
        jPanel2.add(btnNewSP);
        jPanel2.add(btnSaveSP);
        jPanel2.add(btnRemoveSP);
        jPanelCenter.add(jPanel1);
        jPanelCenter.add(jPanel2);
        add(jPanelCenter,BorderLayout.CENTER);
        pack();
    }
    public void docfile(){
        Category category = fileModel.DocFile();
        System.out.println(category.getCategoryName());
        System.out.println(category.getProducts().toString());
    }
    public void ghifile(){
        fileModel.LuuFile(listModel.get(getSelectedIndex()));
    }
    public void control(){
        ActionListener actionListener = new ListenerControllerCategory(this);
        ActionListener actionListener1 = new ListenerControllerProduct(this);
        btnNewDMSP.addActionListener(actionListener);
        btnUpdateDMSP.addActionListener(actionListener);
        btnRemoveDMSP.addActionListener(actionListener);
        jListDanhMucSanPham.addListSelectionListener((ListSelectionListener) actionListener);
        jTable.getSelectionModel().addListSelectionListener((ListSelectionListener) actionListener1);
        btnNewSP.addActionListener(actionListener1);
        btnSaveSP.addActionListener(actionListener1);
        btnRemoveSP.addActionListener(actionListener1);
        menuItemDocFile.addActionListener(actionListener1);
        menuItemGhiFile.addActionListener(actionListener1);
        menuItemExit.addActionListener(actionListener1);
    }
    public int getSelectedRow(){
        return jTable.getSelectedRow();
    }
    public int getCombobox(){
        return comboBox.getSelectedIndex();
    }
    public void ShowDetail(){
        int index  = getSelectedRow();
        if(index!=-1){
            Product product = category.getProducts().get(index);
            jTextFieldID.setText(product.getId());
            jTextFieldName.setText(product.getName());
            jTextFieldPrice.setText(String.valueOf(product.getPrice()));
            jTextFieldQuantity.setText(String.valueOf(product.getQuantity()));
            jTextFieldDescription.setText(product.getDescription());
        }
    }
    public void newProduct(){
//        selectionModel.clearSelection();
        jTextFieldID.setText("");
        jTextFieldName.setText("");
        jTextFieldPrice.setText("");
        jTextFieldQuantity.setText("");
        jTextFieldDescription.setText("");
    }
    public void saveProduct(){
      if(!jTextFieldPrice.getText().isEmpty()&&!jTextFieldDescription.getText().isEmpty()&&!jTextFieldID.getText().isEmpty()&&!jTextFieldName.getText().isEmpty()&!jTextFieldQuantity.getText().isEmpty()){
          selectionModel.clearSelection();
          selectionModel.addSelectionInterval(getCombobox(),getCombobox());
          category = defaultComboBoxModel.getElementAt(getCombobox());
          System.out.println(category);
          Product product1 = new Product();
          product1.setId(jTextFieldID.getText().toString());
          product1.setName(jTextFieldName.getText().toString());
          product1.setPrice(Double.parseDouble(jTextFieldPrice.getText().toString()));
          product1.setQuantity(Integer.parseInt(jTextFieldQuantity.getText().toString()));
          product1.setDescription(jTextFieldDescription.getText().toString());
          category.addProduct(product1);
//          tableModel.setRowCount(0);
          if (category != null) {
              ArrayList<Product> products = category.getProducts();
              for (Product product : products) {
                  Object[] rowData = {
                          product.getId(),
                          product.getName(),
                          product.getPrice(),
                          product.getQuantity(),
                          product.getDescription()
                  };
                  tableModel.addRow(rowData);
              }
          }
          newProduct();
      }else
          JOptionPane.showMessageDialog(null,"hãy nhập dữ liệu đầy đủ!");
    }
    public void removeProduct(){
        category.removeProduct(category.getProducts().get(getSelectedRow()));
        tableModel.removeRow(getSelectedRow());
        jTextFieldID.setText("");
        jTextFieldName.setText("");
        jTextFieldPrice.setText("");
        jTextFieldQuantity.setText("");
        jTextFieldDescription.setText("");
    }
    public void addCategory(String name){
        Category category = new Category(name);
        listModel.addElement(category);
        defaultComboBoxModel.addElement(category);
        int selectedIndex = jListDanhMucSanPham.getSelectedIndex();
        defaultComboBoxModel.setSelectedItem(category);
        newProduct();
//        selectionModel.clearSelection();
        selectionModel.addSelectionInterval(selectedIndex,selectedIndex);
    }
    public void updateCategory(String name,int index){
            category = listModel.getElementAt(index);
            category.setCategoryName(name);
            listModel.setElementAt(category, index);
            defaultComboBoxModel.removeElementAt(index);
            defaultComboBoxModel.insertElementAt(listModel.get(index),index);
            newProduct();
            selectionModel.clearSelection();
    }
    public void removeCategory(int index){
        listModel.removeElementAt(index);
        defaultComboBoxModel.removeElementAt(index);
        selectionModel.clearSelection();
        jTextFieldID.setText("");
        jTextFieldName.setText("");
        jTextFieldPrice.setText("");
        jTextFieldQuantity.setText("");
        jTextFieldDescription.setText("");
        tableModel.setRowCount(0);
    }
    public int getSelectedIndex(){
        return jListDanhMucSanPham.getSelectedIndex();
    }
    public void listSanPham() {
        tableModel.setRowCount(0);
        int selectedIndex = getSelectedIndex();
        if (selectedIndex != -1) {
            category = listModel.getElementAt(selectedIndex);
            defaultComboBoxModel.setSelectedItem(category);
            if (category != null) {
                ArrayList<Product> products = category.getProducts();
                for (Product product : products) {
                    Object[] rowData = {
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            product.getQuantity(),
                            product.getDescription()
                    };
                    tableModel.addRow(rowData);
                }
            }
        }
    }
}
