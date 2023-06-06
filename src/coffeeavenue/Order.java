/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeavenue;

import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author DELL
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    InputStream input;
    FileOutputStream output;
    BufferedImage bufImg ;
    public Order() {
        initComponents();
        date();
        time();
        loadTable();
    }
    
    String name;
    String id;
    String comboo;
   

    Order(String username, String uid,String combo) {
        initComponents();
       this.name = username;
       this.id = uid;
       this.comboo = combo;
       jLabel24.setText(name);
       jLabel21.setText(id);
       jLabel10.setText(comboo);
        loadTable();
        date();
        time();
    }
    
     public void date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        jLabel2.setText(dtf.format(now));

    }
    Timer t;
    SimpleDateFormat st;

    public void time() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                jLabel1.setText(tt);

            }
        });
        t.start();

    }

    void clear() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jSpinner1.setValue(0);
    }

    void clear2() {

        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jSpinner1.setValue(0);
    }
    
    void clear3() {

        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("0");
        jTextField15.setText("");
    }
    
    
    void loadTable(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            pst = con.prepareStatement("select * from Customer_Details");
            rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel)jTable2.getModel();
            tblmodel.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("CustomerID"));
                v.add(rs.getString("CustomerName"));
                v.add(rs.getString("MobileNumber"));
                v.add(rs.getString("Points"));
                v.add(rs.getString("TotalPurchasesMade"));
                
                tblmodel.addRow(v);
            }
        } catch (Exception e) {
           // System.out.println(e.getMessage());
        }
    }
    
    void updateTable2(List itemsList){
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, itemsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("coffeeavenue/Bundle"); // NOI18N
        CoffeeAvenuePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(bundle.getString("Order.CoffeeAvenuePUEntityManager.persistenceUnit")).createEntityManager(); // NOI18N
        itemsQuery = java.beans.Beans.isDesignTime() ? null : CoffeeAvenuePUEntityManager.createQuery(bundle.getString("Order.itemsQuery.query")); // NOI18N
        itemsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : itemsQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jPanel2.setBackground(new java.awt.Color(206, 179, 122));

        jLabel16.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(216, 100, 17));
        jLabel16.setText(bundle.getString("Order.jLabel16.text")); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel22.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(216, 100, 17));
        jLabel22.setText(bundle.getString("Order.jLabel22.text")); // NOI18N

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(153, 102, 0));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(216, 100, 17));
        jLabel19.setText(bundle.getString("Order.jLabel19.text")); // NOI18N

        jTextField12.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(153, 102, 0));
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(216, 100, 17));
        jLabel20.setText(bundle.getString("Order.jLabel20.text")); // NOI18N

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(153, 102, 0));
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(206, 179, 122));
        jButton8.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(216, 100, 17));
        jButton8.setText(bundle.getString("Order.jButton8.text")); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(206, 179, 122));
        jButton10.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(216, 100, 17));
        jButton10.setText(bundle.getString("Order.jButton10.text")); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(216, 100, 17));

        jTable1.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, itemsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(206, 179, 122));
        jLabel9.setText(bundle.getString("Order.jLabel9.text")); // NOI18N

        jLabel11.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(206, 179, 122));
        jLabel11.setText(bundle.getString("Order.jLabel11.text")); // NOI18N

        jTextField6.setFont(new java.awt.Font("Bell MT", 0, 30)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(216, 100, 17));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(206, 179, 122));
        jRadioButton4.setText(bundle.getString("Order.jRadioButton4.text")); // NOI18N

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(206, 179, 122));
        jRadioButton3.setText(bundle.getString("Order.jRadioButton3.text")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(206, 179, 122));
        jLabel13.setText(bundle.getString("Order.jLabel13.text")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(206, 179, 122));
        jLabel12.setText(bundle.getString("Order.jLabel12.text")); // NOI18N

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(153, 102, 0));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemname}"), jTextField8, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(206, 179, 122));
        jLabel15.setText(bundle.getString("Order.jLabel15.text")); // NOI18N

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 102, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.price}"), jTextField11, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(206, 179, 122));
        jButton7.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(216, 100, 17));
        jButton7.setText(bundle.getString("Order.jButton7.text")); // NOI18N
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(206, 179, 122));
        jButton6.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(216, 100, 17));
        jButton6.setText(bundle.getString("Order.jButton6.text")); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSpinner1KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(206, 179, 122));
        jLabel17.setText(bundle.getString("Order.jLabel17.text")); // NOI18N

        jButton4.setBackground(new java.awt.Color(206, 179, 122));
        jButton4.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(216, 100, 17));
        jButton4.setText(bundle.getString("Order.jButton4.text")); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(206, 179, 122));
        jLabel14.setText(bundle.getString("Order.jLabel14.text")); // NOI18N

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 102, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.category}"), jTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(153, 102, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemid}"), jTextField7, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(206, 179, 122));
        jLabel18.setText(bundle.getString("Order.jLabel18.text")); // NOI18N

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Bell MT", 0, 30)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(153, 102, 0));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(206, 179, 122));
        jButton9.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(216, 100, 17));
        jButton9.setText(bundle.getString("Order.jButton9.text")); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jRadioButton4)
                                        .addGap(96, 96, 96)
                                        .addComponent(jRadioButton3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(60, 60, 60))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(79, 79, 79))
        );

        jLabel23.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(216, 100, 17));
        jLabel23.setText(bundle.getString("Order.jLabel23.text")); // NOI18N

        jTextField14.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(153, 102, 0));
        jTextField14.setText(bundle.getString("Order.jTextField14.text")); // NOI18N
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(206, 179, 122));
        jButton11.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(216, 100, 17));
        jButton11.setText(bundle.getString("Order.jButton11.text")); // NOI18N
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(216, 100, 17));

        jButton12.setBackground(new java.awt.Color(206, 179, 122));
        jButton12.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(216, 100, 17));
        jButton12.setText(bundle.getString("Order.jButton12.text")); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel23))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton10))))
                                            .addComponent(jLabel22)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12)))
                                .addContainerGap(220, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(206, 179, 122));
        jLabel5.setText(bundle.getString("Order.jLabel5.text")); // NOI18N

        jTextField1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(206, 179, 122));
        jLabel7.setText(bundle.getString("Order.jLabel7.text")); // NOI18N

        jTextField3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(206, 179, 122));
        jLabel6.setText(bundle.getString("Order.jLabel6.text")); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(206, 179, 122));
        jLabel8.setText(bundle.getString("Order.jLabel8.text")); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(206, 179, 122));
        jLabel1.setText(bundle.getString("Order.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(206, 179, 122));
        jLabel2.setText(bundle.getString("Order.jLabel2.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(206, 179, 122));
        jLabel4.setText(bundle.getString("Order.jLabel4.text")); // NOI18N

        jButton2.setBackground(new java.awt.Color(206, 179, 122));
        jButton2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 102, 0));
        jButton2.setText(bundle.getString("Order.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(206, 179, 122));
        jButton3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 102, 0));
        jButton3.setText(bundle.getString("Order.jButton3.text")); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(206, 179, 122));
        jLabel3.setText(bundle.getString("Order.jLabel3.text")); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Mobile Number", "Points"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel10.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(206, 179, 122));

        jLabel21.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(206, 179, 122));

        jLabel24.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(206, 179, 122));

        jButton5.setBackground(new java.awt.Color(206, 179, 122));
        jButton5.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 102, 0));
        jButton5.setText(bundle.getString("Order.jButton5.text")); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Bell MT", 1, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(206, 179, 122));
        jLabel25.setText(bundle.getString("Order.jLabel25.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(501, 501, 501))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       clear3();
        try {
            jTextArea1.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    int amountRecieved, balance, pointclaimed ,newtpm ;
    String  newallpurchases;
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
            int newgrandtotal = Integer.parseInt(jTextField15.getText());
            int newpoints = Integer.parseInt(jTextField14.getText());
            int newamoountrecieved =Integer.parseInt(jTextField12.getText());
        
        if (jTextField14.getText().isEmpty() || jTextField15.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
             
         
        if(((Integer.parseInt(jTextField14.getText())) > (Integer.parseInt(jTextField4.getText())))){
            JOptionPane.showMessageDialog(rootPane, "Not Enough Points");
        }
        else{
            if(((newgrandtotal-newpoints)- newamoountrecieved ) > 0 ){
                 JOptionPane.showMessageDialog(rootPane, "Amount Not Enough");
            }else{
         pointclaimed = Integer.parseInt(jTextField14.getText());
        newgrandtotal -= pointclaimed;
        
        
        newamoountrecieved = Integer.parseInt(jTextField12.getText());
        balance = newamoountrecieved - newgrandtotal;
        jTextField13.setText((String) String.valueOf(balance));
        jTextArea1.setText(jTextArea1.getText() + "\n\nTotal Amount :\t\t" + newgrandtotal + "\nPoints Claimed :\t" + newpoints+ "\nAmount Paid :\t\t" + newamoountrecieved + "\nBalance :\t\t" + balance  + "\n\n\n\t\t Thankyou For Coming !!\t\t\n");
        int point = (Integer.valueOf(jTextField4.getText())) + (((Integer.valueOf(jTextField15.getText()))/100) - newpoints);
        
       
        try{
            
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    Statement st = con.createStatement();
                    String qry = "SELECT * FROM COFFEE.Customer_DETAILS ";
                    ResultSet rs = st.executeQuery(qry);
                    String error = "";
                    while (rs.next()) {
                        String uid = rs.getString(1);
                        int tpm = rs.getInt(6);
                        String allpurchases = rs.getString(7);
                       newtpm = tpm + Integer.valueOf(jTextField15.getText());
                      newallpurchases = allpurchases + jTextArea1.getText();
                    }
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
           pst = con.prepareStatement( "update Customer_Details set Points=?, TotalPurchasesMade=?, AllPurchases=? where CustomerID=?");
            pst.setInt(4,Integer.parseInt(jTextField2.getText()));
            pst.setString(1, String.valueOf(point));
             pst.setString(2, String.valueOf(newtpm));
              pst.setString(3, newallpurchases);
            pst.executeUpdate();
            loadTable();
            try {
                                        Statement sta = con.createStatement();
                                        int c = sta.executeUpdate("INSERT INTO ORDERLOG"
                                            + " (DATE, TIME,CUSTOMER,EMPLOYEE,POINTSDISCOUNTSCLAIMED,BILL,TOTAL)"
                                            + " VALUES ('"+jLabel2.getText()+"','"+jLabel1.getText()+"','ID:"+jTextField2.getText()+" Username:"+jTextField3.getText()+"','ID:"+jLabel21.getText()+" Username:"+jLabel24.getText()+"','"+jTextField14.getText()+"','"+jTextArea1.getText()+"','"+jTextField15.getText()+"')");

                                        sta.close();
                                        con.close();
                                    } catch (Exception e) {
                                       // System.out.println(e.getMessage());
                                    }
          
            
           }catch(Exception e){
               //System.out.println(e.getMessage());
           
           }
        }       
         }
         
    
         }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

        if (jRadioButton4.isSelected()) {
            Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT i FROM Items i WHERE i.itemname like :itemname");
            y.setParameter("itemname", "%" + jTextField6.getText() + "%");
            itemsList.clear();
            itemsList = y.getResultList();
            updateTable2(itemsList);

        } else if (jRadioButton3.isSelected()) {
            Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT i FROM Items i WHERE i.category like :category");
            y.setParameter("category", "%" + jTextField6.getText() + "%");
            itemsList.clear();
            itemsList = y.getResultList();
            updateTable2(itemsList);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Select A Search Criteria", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked

    }//GEN-LAST:event_jButton7MouseClicked
     int i = 0;
     
    int price, quantity, total, grandtotal,newquantity,newamount;
   //String id;
   int quant,amount,quantt,amountt;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     updateTable2(itemsList);
       try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            Statement stq = con.createStatement();
            String qryq = "SELECT * FROM COFFEE.EMPLOYEESALES ";
            ResultSet rs = stq.executeQuery(qryq);
            String idd = jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText() ;
            while (rs.next()) 
            {
               String id = rs.getString(1);
               if(id.equalsIgnoreCase(idd)){
                   quantt = rs.getInt(2);
                amountt = rs.getInt(3); 
               }
            }
                }catch(Exception e){
               //System.out.println(e.getMessage());
           }
               try{
                    Connection connn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    PreparedStatement psttt;
                    String query = "insert into EmployeeSales (EmployeeITEm) values ('" +jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText() + "')";
                    psttt = connn.prepareStatement(query);
                    psttt.executeUpdate();
                }catch (Exception e) {
                    //System.out.println(e.getMessage());
                }
     
               
                try{
           
           Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
           PreparedStatement pstt;
           pstt = conn.prepareStatement("UPDATE EMPLOYEESALES SET QUANTITY = ?,AMOUNT =? WHERE EMPLOYEEITEM = ?");
           int newquantty = quantt + (Integer)jSpinner1.getValue();
           int newtotally = total + amountt;
            pstt.setString(1,Integer.toString(newquantty));
            pstt.setString(2,Integer.toString(newtotally));
            pstt.setString(3,jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText());
            pstt.executeUpdate();
            conn.commit();
   
           }catch(Exception e){
               //System.out.println(e.getMessage());
           }
           
     String idd = jLabel2.getText() +" "+ jTextField8.getText();
            try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            Statement st = con.createStatement();
            String qry = "SELECT * FROM COFFEE.SALES ";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                String id = rs.getString(1);
                if(idd.equalsIgnoreCase(id)){
                    quant = rs.getInt(2);
                    amount = rs.getInt(3);
                }
                try{

                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    PreparedStatement pstt;
                    pstt = conn.prepareStatement("UPDATE SALES SET QUANTITY = ?,AMOUNT =? WHERE DATEITEM = ?");
                    newquantity = quant + (Integer) jSpinner1.getValue();
                    pstt.setString(1,Integer.toString(newquantity ));
                    newamount = amount + Integer.parseInt(jTextField10.getText());
                    pstt.setString(2,Integer.toString(newamount));
                    pstt.setString(3,idd);
                    pstt.executeUpdate();
                    conn.commit();
                     }catch(Exception e){
                    //System.out.println(e.getMessage());
                }

            }
            
        }catch(Exception e){
            // System.out.println(e.getMessage());
        }
                try{
                    Connection connn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    PreparedStatement psttt;
                    String query = "insert into Sales (DateItem) values ('" +jLabel2.getText() +" "+ jTextField8.getText() + "')";
                    psttt = connn.prepareStatement(query);
                    psttt.executeUpdate();
                    
                    try{

                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    PreparedStatement pstt;
                    pstt = conn.prepareStatement("UPDATE SALES SET QUANTITY = ?,AMOUNT =? WHERE DATEITEM = ?");
                    //newquantity = quant + (Integer) jSpinner1.getValue();
                    pstt.setString(1,Integer.toString((Integer) jSpinner1.getValue() ));
                    //newamount = amount + Integer.parseInt(jTextField10.getText());
                    pstt.setString(2,jTextField10.getText());
                    pstt.setString(3,jLabel2.getText() +" "+ jTextField8.getText() );
                    pstt.executeUpdate();
                    conn.commit();
                     }catch(Exception e){
                    //System.out.println(e.getMessage());
                }
                }catch (Exception e) {
                    //System.out.println(e.getMessage());
                }
        
                  if (jTextField7.getText().isEmpty() || jTextField8.getText().isEmpty() || jTextField9.getText().isEmpty() || jTextField10.getText().isEmpty() || jTextField11.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            
            if (((Integer) jSpinner1.getValue()) < 0) {
                JOptionPane.showMessageDialog(rootPane, "Select A Quantity", "Warning", JOptionPane.INFORMATION_MESSAGE);
            
         } else {
            price = Integer.parseInt(jTextField11.getText());
            quantity = (Integer) jSpinner1.getValue();
            total = price * quantity;
            jTextField10.setText((String) String.valueOf(total));
            grandtotal += total;
        
            
            i++;
             
            
            
            if (i == 1) {
                jTextArea1.setText(jTextArea1.getText() + "\n \t \t ***Coffee Avenue*** \t \n" + "ItemID    ItemName \t\t Price \t Quantity \t Total \t \n" + jTextField7.getText() + "    " + jTextField8.getText() + " \t\t " + jTextField11.getText() + " \t " + jSpinner1.getValue() + " \t " + jTextField10.getText() + " \t \n");
                clear2();
                
            } else {
                jTextArea1.setText(jTextArea1.getText() + jTextField7.getText() + "    " + jTextField8.getText() + " \t\t " + jTextField11.getText() + " \t " + jSpinner1.getValue() + " \t " + jTextField10.getText() + " \t \n");
                clear2();
               }
            }
        }
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        updateTable2(itemsList);
        clear2();
        loadTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jSpinner1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyReleased
       
    }//GEN-LAST:event_jSpinner1KeyReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (((Integer) jSpinner1.getValue()) > 0) {
            price = Integer.parseInt(jTextField11.getText());
            quantity = (Integer) jSpinner1.getValue();
            total = price * quantity;
            jTextField10.setText((String) String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(rootPane, "Select A Quantity", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTextField15.setText((String) String.valueOf(grandtotal));   
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String sea = jTextField1.getText();
        try{
            TableModel tblmodel = (DefaultTableModel)jTable2.getModel();
            String search = jTextField1.getText();
            TableRowSorter<TableModel> tr = new TableRowSorter<TableModel>(tblmodel);
            jTable2.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
         }catch(Exception e){
          //System.out.println(e.getMessage());
    }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String log = jLabel10.getText();
        new Customer_Settings(name,id,log).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        loadTable();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         int rid = jTable2.getSelectedRow();
        TableModel tblmodel = (DefaultTableModel)jTable2.getModel();
        jTextField2.setText(tblmodel.getValueAt(rid, 0).toString());
        jTextField3.setText(tblmodel.getValueAt(rid, 1).toString());
        jTextField5.setText(tblmodel.getValueAt(rid, 2).toString());
        jTextField4.setText(tblmodel.getValueAt(rid, 3).toString());
        
     
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       clear3();
       clear();
       clear2();
       jTextArea1.setText("");
       jLabel26.setText("");
       loadTable();
       i=0;
        updateTable2(itemsList);
        grandtotal=0;
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                          try {
                                        Statement sta = con.createStatement();
                                        int c = sta.executeUpdate("INSERT INTO LOGINLOG"
                                            + " (DATE, TIME,USER_,USERROLE,ACTIVITY)"
                                            + " VALUES ('" + jLabel2.getText() + "','" + jLabel1.getText() + "','ID:"+jLabel21.getText()+" Username:"+jLabel24.getText()+"','Employee','Logged Out')");

                                        sta.close();
                                        con.close();
                                    } catch (Exception e) {
                                       // System.err.println("Exception: " + e.getMessage());  
                                    }
                          
                                    Login_User m = new Login_User();
                                    m.setTitle("Log In");
                                    m.setVisible(true);
                                    dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseClicked
int idi;
int q;
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       clear();
       clear2();
       clear3();
       int r = jFileChooser1.showDialog(this,"Select The Barcode");
        try{
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image img = tk.getImage(jFileChooser1.getSelectedFile().getAbsolutePath());
            InputStream barInputStream = new FileInputStream(jFileChooser1.getSelectedFile().getAbsolutePath());
            BufferedImage barBufferedImage = ImageIO.read(barInputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(barBufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            jLabel26.setText(result.getText());
            try{
                    Connection conep = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    Statement stp = conep.createStatement();
                    String qryp = "SELECT * FROM COFFEE.CUSTOMERORDER ";
                    ResultSet rssp = stp.executeQuery(qryp);
                   
                     while (rssp.next()) {
                         String bid = rssp.getString(1);
                         if(bid.equalsIgnoreCase(jLabel26.getText())){
                             String bill = rssp.getString(3);
                             String total = rssp.getString(4);
                             idi = rssp.getInt(6);
                             String name = rssp.getString(5);
                             q = Integer.parseInt(rssp.getString(7));
                              jTextArea1.setText(bill);
                        jTextField2.setText(idi+"");
                        jTextField3.setText(name);
                        jTextField15.setText(total);
                        
                        
                                 try{
                    Connection conet = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    Statement stm = conet.createStatement();
                    String qryy = "SELECT * FROM COFFEE.CUSTOMER_Details ";
                    ResultSet rsst = stm.executeQuery(qryy);
                   
                     while (rsst.next()) {
                        String idii = rsst.getString(1);
                        if(idii.equalsIgnoreCase(Integer.toString(idi))){
                           String mobin = rsst.getString(3);
                        String poi = rsst.getString(5);
                        
                        jTextField5.setText(mobin);
                        jTextField4.setText(poi);
                        
                        }
                     }
                        }catch(Exception e){
                            //System.out.println(e.getMessage());
                        }
                         }
                        
                        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            Statement stq = con.createStatement();
            String qryq = "SELECT * FROM COFFEE.EMPLOYEESALES ";
            ResultSet rs = stq.executeQuery(qryq);
            String idd = jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText() ;
            while (rs.next()) 
            {
               String id = rs.getString(1);
               if(id.equalsIgnoreCase(idd)){
                   quantt = rs.getInt(2);
                amountt = rs.getInt(3); 
               }
              
                  }
     }catch(Exception e){
              // System.out.println(e.getMessage());
           }
                            try{
                    Connection connn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
                    PreparedStatement psttt;
                    String query = "insert into EmployeeSales (EmployeeITEm) values ('" +jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText() + "')";
                    psttt = connn.prepareStatement(query);
                    psttt.executeUpdate();
                }catch (Exception e) {
                    //System.out.println(e.getMessage());
                }
            try{
           
           Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
           PreparedStatement pstt;
           pstt = conn.prepareStatement("UPDATE EMPLOYEESALES SET QUANTITY = ?,AMOUNT =? WHERE EMPLOYEEITEM = ?");
           int newquantt = quantt + q;
           int newtotall = Integer.parseInt(jTextField15.getText()) + amountt;
            pstt.setString(1,Integer.toString(newquantt));
            pstt.setString(2,Integer.toString(newtotall));
            pstt.setString(3,jLabel21.getText() +"-"+jLabel24.getText() +" "+jLabel2.getText());
            pstt.executeUpdate();
            conn.commit();
   
           }catch(Exception e){
              // System.out.println(e.getMessage());
           }
            }
                        
            }catch(Exception e){
            //System.out.println("ggg");
        }
            
            }catch(Exception e){
            //System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CoffeeAvenuePUEntityManager;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.util.List<coffeeavenue.Items> itemsList;
    private javax.persistence.Query itemsQuery;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
