/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeavenue;

import java.awt.CardLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import javax.persistence.Query;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class Logs extends javax.swing.JFrame {

    /**
     * Creates new form Logs
     */
    public Logs() {
        initComponents();
        showPanel("card2");
        loadTable1();
        table1text();
//        loadTable2();
//        table2text();
    }
    void showPanel(String cname){
        CardLayout cl = (CardLayout)jPanel3.getLayout();
        cl.show(jPanel3, cname);
    }
    
     void loadTable1(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            PreparedStatement pst = con.prepareStatement("select * from loginlog");
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel)jTable4.getModel();
            tblmodel.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("loginID"));
                v.add(rs.getString("date"));
                v.add(rs.getString("time"));
                v.add(rs.getString("user_"));
                v.add(rs.getString("userrole"));
                v.add(rs.getString("activity"));
                tblmodel.addRow(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
     
     void table1text(){
         jTextArea1.setText(jTextArea1.getText()+ "Login ID \t Date \t Time \t User \t\t\t\t User Role \t Activity \n" );
     
         
            for(int i =0;i<jTable4.getRowCount();i++){
                
                 DefaultTableModel tblmodell = (DefaultTableModel) jTable4.getModel();
         
        String logid = tblmodell.getValueAt(i, 0).toString();
        String date = tblmodell.getValueAt(i, 1).toString();
        String time = tblmodell.getValueAt(i, 2).toString();
        String user_ = tblmodell.getValueAt(i, 3).toString();
        String userrole = tblmodell.getValueAt(i, 4).toString();
        String activity = tblmodell.getValueAt(i, 5).toString();
       
        jTextArea1.setText(jTextArea1.getText()+ logid + "\t " +date + "\t "+time + "\t "+user_ + "\t\t\t "+userrole + "\t "+activity +"\n");  
            }
     }
     
       void loadTable2(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            PreparedStatement pst = con.prepareStatement("select * from orderlog");
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel)jTable1.getModel();
            tblmodel.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("orderID"));
                v.add(rs.getString("date"));
                v.add(rs.getString("time"));
                v.add(rs.getString("customer"));
                v.add(rs.getString("employee"));
                v.add(rs.getString("pointsdiscountsclaimed"));
                v.add(rs.getString("total"));
                tblmodel.addRow(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
     
     void table2text(){
         jTextArea2.setText(jTextArea2.getText()+ "Order ID \t Date \t Time \t Customer \t\t\t\t Employee \t\t\t\t Points Deducted \t Total \n" );
     
         
            for(int i =0;i<jTable1.getRowCount();i++){
                
                 DefaultTableModel tblmodell = (DefaultTableModel) jTable1.getModel();
         
        String orderid = tblmodell.getValueAt(i, 0).toString();
        String date = tblmodell.getValueAt(i, 1).toString();
        String time = tblmodell.getValueAt(i, 2).toString();
        String customer = tblmodell.getValueAt(i, 3).toString();
        String employee = tblmodell.getValueAt(i, 4).toString();
        String points = tblmodell.getValueAt(i, 5).toString();
        String total = tblmodell.getValueAt(i, 6).toString();
        jTextArea2.setText(jTextArea2.getText()+ orderid + "\t " +date + "\t "+time + "\t "+ customer + "\t\t\t "+ employee + "\t\t\t "+points +"\t"+ total + "\n");  
            }
     }
     
     void loadTable3(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CoffeeAvenue", "Coffee", "Avenue");
            PreparedStatement pst = con.prepareStatement("select * from userlog");
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tblmodel = (DefaultTableModel)jTable2.getModel();
            tblmodel.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt("userlogID"));
                v.add(rs.getString("date"));
                v.add(rs.getString("time"));
                v.add(rs.getString("updateduserid"));
                v.add(rs.getString("updatedby"));
                v.add(rs.getString("activity"));
                tblmodel.addRow(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
     
     void table3text(){
         jTextArea3.setText(jTextArea3.getText()+ "User Log ID \t Date \t Time \t Updated User \t\t\t\t Updated By \t\t\t\t Activity \n" );
     
         
            for(int i =0;i<jTable2.getRowCount();i++){
                
                 DefaultTableModel tblmodell = (DefaultTableModel) jTable2.getModel();
         
        String orderid = tblmodell.getValueAt(i, 0).toString();
        String date = tblmodell.getValueAt(i, 1).toString();
        String time = tblmodell.getValueAt(i, 2).toString();
        String customer = tblmodell.getValueAt(i, 3).toString();
        String employee = tblmodell.getValueAt(i, 4).toString();
        String points = tblmodell.getValueAt(i, 5).toString();
        jTextArea3.setText(jTextArea3.getText()+ orderid + "\t " +date + "\t "+time + "\t "+ customer + "\t\t\t "+ employee + "\t\t\t "+points + "\n");  
            }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("coffeeavenue/Bundle"); // NOI18N
        CoffeeAvenuePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(bundle.getString("Logs.CoffeeAvenuePUEntityManager.persistenceUnit")).createEntityManager(); // NOI18N
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(216, 100, 17));

        jButton4.setBackground(new java.awt.Color(216, 100, 17));
        jButton4.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(206, 179, 122));
        jButton4.setText(bundle.getString("Logs.jButton4.text")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(216, 100, 17));
        jButton5.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(206, 179, 122));
        jButton5.setText(bundle.getString("Logs.jButton5.text")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(216, 100, 17));
        jButton6.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton6.setForeground(new java.awt.Color(206, 179, 122));
        jButton6.setText(bundle.getString("Logs.jButton6.text")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(216, 100, 17));
        jButton7.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(206, 179, 122));
        jButton7.setText(bundle.getString("Logs.jButton7.text")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(206, 179, 122));
        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(206, 179, 122));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Log In ID", "Date", "Time", "User", "User Role", "Activity"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title0")); // NOI18N
            jTable4.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title1")); // NOI18N
            jTable4.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title2")); // NOI18N
            jTable4.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title3")); // NOI18N
            jTable4.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title4")); // NOI18N
            jTable4.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("Logs.jTable4.columnModel.title5")); // NOI18N
        }

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton8.setBackground(new java.awt.Color(206, 179, 122));
        jButton8.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(216, 100, 17));
        jButton8.setText(bundle.getString("Logs.jButton8.text")); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        jPanel3.add(jPanel1, "card2");

        jPanel5.setBackground(new java.awt.Color(206, 179, 122));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User Log ID", "Date", "Time", "Updated User", "Updated By", "Activity"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title0")); // NOI18N
            jTable2.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title1")); // NOI18N
            jTable2.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title2")); // NOI18N
            jTable2.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title3")); // NOI18N
            jTable2.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title4")); // NOI18N
            jTable2.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("Logs.jTable2.columnModel.title5")); // NOI18N
        }

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        jButton10.setBackground(new java.awt.Color(206, 179, 122));
        jButton10.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(216, 100, 17));
        jButton10.setText(bundle.getString("Logs.jButton10.text")); // NOI18N
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(48, 48, 48))))
        );

        jPanel3.add(jPanel5, "card4");

        jPanel4.setBackground(new java.awt.Color(206, 179, 122));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Date", "Time", "Customer", "Employee", "Points Deducted", "Total"
            }
        ));
        jScrollPane5.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title3")); // NOI18N
            jTable1.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title4")); // NOI18N
            jTable1.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title5")); // NOI18N
            jTable1.getColumnModel().getColumn(6).setHeaderValue(bundle.getString("Logs.jTable1.columnModel.title7")); // NOI18N
        }

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jButton9.setBackground(new java.awt.Color(206, 179, 122));
        jButton9.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(216, 100, 17));
        jButton9.setText(bundle.getString("Logs.jButton9.text")); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(43, 43, 43))))
        );

        jPanel3.add(jPanel4, "card3");

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showPanel("card2");
          jTextArea1.setText("");
          loadTable1();
        table1text();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          showPanel("card4");
            jTextArea3.setText("");
          loadTable3();
        table3text();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          showPanel("card3");
          jTextArea2.setText("");
          loadTable2();
        table2text();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
         
//          jTextArea1.setText(jTextArea1.getText()+ "Login ID \t Date \t Time \t User \t\t\t\t User Role \t Activity \n" );
//        for(int i =0;i<jTable4.getRowCount();i++){
//
//        TableModel tblmodel = (DefaultTableModel)jTable4.getModel();
//        String logid = tblmodel.getValueAt(i, 0).toString();
//        String date = tblmodel.getValueAt(i, 1).toString();
//        String time = tblmodel.getValueAt(i, 2).toString();
//        String user_ = tblmodel.getValueAt(i, 3).toString();
//        String userrole = tblmodel.getValueAt(i, 4).toString();
//        String activity = tblmodel.getValueAt(i, 5).toString();
//        jTextArea1.setText(jTextArea1.getText()+ logid + "\t " +date + "\t "+time + "\t "+user_ + "\t\t\t "+userrole + "\t "+activity +"\n");
//        
//        }
//       
   
        
      
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        final JFileChooser SaveAs = new JFileChooser();
      SaveAs.setApproveButtonText("Save");
      int actionDialog = SaveAs.showOpenDialog(this);
      if (actionDialog != JFileChooser.APPROVE_OPTION) {
         return;
      }

      File fileName = new File(SaveAs.getSelectedFile() + ".txt");
      BufferedWriter outFile = null;
      try {
         outFile = new BufferedWriter(new FileWriter(fileName));

         jTextArea1.write(outFile);   

      } catch (IOException e) {
          System.out.println(e.getMessage());
      } finally {
         if (outFile != null) {
            try {
               outFile.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         }
      }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        final JFileChooser SaveAs = new JFileChooser();
      SaveAs.setApproveButtonText("Save");
      int actionDialog = SaveAs.showOpenDialog(this);
      if (actionDialog != JFileChooser.APPROVE_OPTION) {
         return;
      }

      File fileName = new File(SaveAs.getSelectedFile() + ".txt");
      BufferedWriter outFile = null;
      try {
         outFile = new BufferedWriter(new FileWriter(fileName));

         jTextArea2.write(outFile);   

      } catch (IOException e) {
          System.out.println(e.getMessage());
      } finally {
         if (outFile != null) {
            try {
               outFile.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         }
      }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       final JFileChooser SaveAs = new JFileChooser();
      SaveAs.setApproveButtonText("Save");
      int actionDialog = SaveAs.showOpenDialog(this);
      if (actionDialog != JFileChooser.APPROVE_OPTION) {
         return;
      }

      File fileName = new File(SaveAs.getSelectedFile() + ".txt");
      BufferedWriter outFile = null;
      try {
         outFile = new BufferedWriter(new FileWriter(fileName));

         jTextArea3.write(outFile);   

      } catch (IOException e) {
          System.out.println(e.getMessage());
      } finally {
         if (outFile != null) {
            try {
               outFile.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         }
      }
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CoffeeAvenuePUEntityManager;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
