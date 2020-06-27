/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sownbanana.view;

import com.sownbanana.connection.CategoryDAO;
import com.sownbanana.connection.EntityManager;
import com.sownbanana.connection.SupplierDAO;
import com.sownbanana.model.Product;
import com.sownbanana.model.SupplierComboItem;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author son.ph173344
 */
public class ProductViewUI extends javax.swing.JDialog {

    /**
     * Creates new form ProductViewUI
     */
    public boolean isEdit = false;
    public Product product;
    public boolean isDataChange = false;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProductViewUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        //Combo box supplier
        List<String> supplierComboItems = EntityManager.supplierDAO.getSuppliersName();
        for (String item : supplierComboItems) {
            cboxSupplier.addItem(item);
        }
        //Combo box category
        List<String> categoryComboitems = EntityManager.categoryDAO.getCategoryName();
        for (String item : categoryComboitems) {
            cboxCategory.addItem(item);
        }
        cboxCategory.addItem("Thêm loại hàng mới...");
        
        //Combo box unit
        List<String> unitComboItems = EntityManager.unitDAO.getUnits();
        for (String item : unitComboItems) {
            cboxUnit.addItem(item);
        }
        cboxUnit.addItem("Thêm mới...");

        txtName.setForeground(Color.GRAY);
        txtType.setForeground(Color.GRAY);
        txtQuantity.setForeground(Color.GRAY);
        txtImportPrice.setForeground(Color.GRAY);
        txtRetailPrice.setForeground(Color.GRAY);

        txtImportDate.setText(LocalDate.now().format(formatter));

        lblNameRq.setVisible(false);
        lblCategoryRq.setVisible(false);
        lblQuantityRq.setVisible(false);
        lblSupplierRq.setVisible(false);
        lblPriceRq.setVisible(false);
        lblDate.setVisible(false);
        //Set key

        this.setVisible(true);
    }

    public ProductViewUI(java.awt.Frame parent, boolean modal, Product product) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        isEdit = true;
        this.product = product;
        lblNameRq.setVisible(false);
        lblCategoryRq.setVisible(false);
        lblQuantityRq.setVisible(false);
        lblSupplierRq.setVisible(false);
        lblPriceRq.setVisible(false);
        lblDate.setVisible(false);
        lblTit.setText("CHỈNH SỬA SẢN PHẨM");
        //Combo box supplier
        List<String> supplierComboItems = EntityManager.supplierDAO.getSuppliersName();
        for (String item : supplierComboItems) {
            cboxSupplier.addItem(item);
        }
        //Combo box category
        List<String> categoryComboitems = EntityManager.categoryDAO.getCategoryName();
        for (String item : categoryComboitems) {
            cboxCategory.addItem(item);
        }
        cboxCategory.addItem("Thêm loại hàng mới...");
        
        //Combo box unit
        List<String> unitComboItems = EntityManager.unitDAO.getUnits();
        for (String item : unitComboItems) {
            cboxUnit.addItem(item);
        }
        cboxUnit.addItem("Thêm mới...");

        btnAdd.setText("Lưu");
        txtId.setText(String.valueOf(product.getId()));
        txtName.setText(product.getName());
        cboxCategory.setSelectedItem(product.getCategory());
        txtType.setText(product.getType());
        txtQuantity.setText(String.valueOf(product.getQuantity()));
        cboxUnit.setSelectedItem(product.getUnit());
        cboxSupplier.setSelectedItem(EntityManager.supplierDAO.getSupplierNameById(product.getSupplierId()));
        txtImportPrice.setText(String.valueOf(product.getImportPrice()));
        txtRetailPrice.setText(String.valueOf(product.getRetailPrice()));
        txtImportDate.setText(new Date(product.getImportDate().getTime()).toLocalDate().format(formatter));

        //Set key
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        cboxSupplier = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtImportPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtRetailPrice = new javax.swing.JTextField();
        cboxCategory = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtImportDate = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        cboxUnit = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNameRq = new javax.swing.JLabel();
        lblCategoryRq = new javax.swing.JLabel();
        lblQuantityRq = new javax.swing.JLabel();
        lblSupplierRq = new javax.swing.JLabel();
        lblPriceRq = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancel.setText("Thoát");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cboxSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn nguồn hàng..." }));
        cboxSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboxSupplierFocusGained(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên:");

        jLabel6.setText("Giá nhập (đơn vị):");

        lblTit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        lblTit.setText("THÊM HÀNG VÀO KHO");

        jLabel3.setText("Loại:");

        txtImportPrice.setText("Nhập giá hàng nhập về...");
        txtImportPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImportPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImportPriceFocusLost(evt);
            }
        });

        jLabel10.setText("Thuộc tính:");

        jLabel4.setText("Số lượng:");

        jLabel7.setText("Giá bán (đơn vị):");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtName.setText("Nhập tên mặt hàng...");
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });

        txtRetailPrice.setText("Nhập giá bán dự định...");
        txtRetailPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRetailPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRetailPriceFocusLost(evt);
            }
        });

        cboxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại hàng..." }));
        cboxCategory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboxCategoryFocusGained(evt);
            }
        });
        cboxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoryActionPerformed(evt);
            }
        });
        cboxCategory.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboxCategoryPropertyChange(evt);
            }
        });

        jLabel8.setText("Ngày nhập hàng:");

        txtQuantity.setText("Nhập số lượng hàng trong kho...");
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });

        txtImportDate.setText("jTextField7");
        txtImportDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImportDateFocusGained(evt);
            }
        });

        txtType.setText("Nhập thuộc tính (VD:5m)...");
        txtType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypeFocusLost(evt);
            }
        });

        cboxUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn đơn vị..." }));
        cboxUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxUnitActionPerformed(evt);
            }
        });

        jLabel5.setText("Nguồn hàng:");

        jLabel1.setText("ID:");

        lblNameRq.setForeground(new java.awt.Color(255, 0, 0));
        lblNameRq.setText("* Nhập tên");

        lblCategoryRq.setForeground(new java.awt.Color(255, 0, 0));
        lblCategoryRq.setText("* Chọn loại");

        lblQuantityRq.setForeground(new java.awt.Color(255, 0, 0));
        lblQuantityRq.setText("* Nhập số lượng");

        lblSupplierRq.setForeground(new java.awt.Color(255, 0, 0));
        lblSupplierRq.setText("* Chọn nguồn hàng");

        lblPriceRq.setForeground(new java.awt.Color(255, 0, 0));
        lblPriceRq.setText("* Nhập giá nhập");

        lblDate.setForeground(new java.awt.Color(255, 0, 0));
        lblDate.setText("* dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(10, 10, 10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(176, 176, 176)
                                                .addComponent(cboxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtImportDate)
                                            .addComponent(txtRetailPrice)
                                            .addComponent(txtImportPrice)
                                            .addComponent(cboxSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                            .addComponent(txtName)
                                            .addComponent(cboxCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtType)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameRq)
                                    .addComponent(lblCategoryRq)
                                    .addComponent(lblQuantityRq)
                                    .addComponent(lblSupplierRq)
                                    .addComponent(lblPriceRq)
                                    .addComponent(lblDate)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(lblTit)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblTit)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameRq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryRq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantityRq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierRq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtImportPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPriceRq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRetailPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAdd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        String name = txtName.getText().trim();
        String category = (String) cboxCategory.getSelectedItem();
        String type = txtType.getText().trim();
        if (txtType.getForeground() == Color.GRAY) {
            type = null;
        }
        double quantity = -1;
        try {
            quantity = Double.parseDouble(txtQuantity.getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            if (!txtQuantity.getText().equals("Nhập số lượng hàng trong kho...")) {
                JOptionPane.showMessageDialog(rootPane, "Nhập số thực vào dòng số lượng");
            }
            txtQuantity.setText("");
            lblQuantityRq.setVisible(true);
            check = false;
        }
        String unit = (String) cboxUnit.getSelectedItem();
        int supplierId = EntityManager.supplierDAO.getSupplierIdbyName((String) cboxSupplier.getSelectedItem());
        double importPrice = -1;
        try {
            importPrice = Double.parseDouble(txtImportPrice.getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            if (!txtImportPrice.getText().equals("Nhập giá hàng nhập về...")) {
                JOptionPane.showMessageDialog(rootPane, "Nhập số thực vào dòng giá nhập về");
            }
            txtImportPrice.setText("");
            lblPriceRq.setVisible(true);
            check = false;
        }
        double retailprice = -1;
        try {
            retailprice = Double.parseDouble(txtRetailPrice.getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            if (!txtRetailPrice.getText().equals("Nhập giá bán dự định...")) {
                JOptionPane.showMessageDialog(rootPane, "Nhập số thực vào dòng giá bán");
            }
            txtRetailPrice.setText("");
        }
        LocalDate date = null;
        try {
            date = LocalDate.parse(txtImportDate.getText(), formatter);
        } catch (Exception e) {
            lblDate.setVisible(true);
            check = false;
        }

        if ("Nhập tên mặt hàng...".equals(name) || "".equals(name)) {
            check = false;
            lblNameRq.setVisible(true);
        }
        if ("Chọn loại hàng...".equals(category)) {
            check = false;
            lblCategoryRq.setVisible(true);
        }
        if ("Chọn đơn vị...".equals((String) cboxUnit.getSelectedItem())) {
            check = false;
            lblQuantityRq.setVisible(true);
        }
        if ("Chọn nguồn hàng...".equals((String) cboxSupplier.getSelectedItem())) {
            check = false;
            lblSupplierRq.setVisible(true);
        }

        if (check) {
            if (!isEdit) {
                if (EntityManager.productDAO.insertProduct(name, category, type, quantity, unit, null, supplierId, importPrice, retailprice, Date.valueOf(date)) > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm sản phẩm thành công!");
                    isDataChange = true;
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sự cố lưu dữ liệu!!!");
                }
            } else {
                if (EntityManager.productDAO.updateProduct(product.getId(), name, category, type, quantity, unit, null, supplierId, importPrice, retailprice, Date.valueOf(date)) > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa sản phẩm thành công!");
                    isDataChange = true;
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
        lblNameRq.setVisible(false);
        if (txtName.getForeground() == Color.GRAY) {
            txtName.setText("");
            txtName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
        if (txtName.getText().trim().equals("")) {
            txtName.setText("Nhập tên mặt hàng...");
            txtName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusGained
        // TODO add your handling code here:
        if (txtType.getForeground() == Color.GRAY) {
            txtType.setText("");
            txtType.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtTypeFocusGained

    private void txtTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusLost
        // TODO add your handling code here:
        if (txtType.getText().trim().equals("")) {
            txtType.setText("Nhập thuộc tính (VD:5m)...");
            txtType.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtTypeFocusLost

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        // TODO add your handling code here:
        lblQuantityRq.setVisible(false);
        if (txtQuantity.getForeground() == Color.GRAY) {
            txtQuantity.setText("");
            txtQuantity.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:
        if (txtQuantity.getText().trim().equals("")) {
            txtQuantity.setText("Nhập số lượng hàng trong kho...");
            txtQuantity.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtImportPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImportPriceFocusGained
        // TODO add your handling code here:
        lblPriceRq.setVisible(false);
        if (txtImportPrice.getForeground() == Color.GRAY) {
            txtImportPrice.setText("");
            txtImportPrice.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtImportPriceFocusGained

    private void txtImportPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImportPriceFocusLost
        // TODO add your handling code here:
        if (txtImportPrice.getText().trim().equals("")) {
            txtImportPrice.setText("Nhập giá hàng nhập về...");
            txtImportPrice.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtImportPriceFocusLost

    private void txtRetailPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetailPriceFocusGained
        // TODO add your handling code here:
        if (txtRetailPrice.getForeground() == Color.GRAY) {
            txtRetailPrice.setText("");
            txtRetailPrice.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtRetailPriceFocusGained

    private void txtRetailPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetailPriceFocusLost
        // TODO add your handling code here:
        if (txtRetailPrice.getText().trim().equals("")) {
            txtRetailPrice.setText("Nhập giá bán dự định...");
            txtRetailPrice.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtRetailPriceFocusLost

    private void cboxCategoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboxCategoryPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cboxCategoryPropertyChange

    private void cboxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoryActionPerformed
        // TODO add your handling code here:
        if (cboxCategory.getSelectedItem().equals("Thêm loại hàng mới...")) {
            String input = JOptionPane.showInputDialog(rootPane, "Nhập loại hàng mới");
            if (input != null && !input.equals("")) {
                EntityManager.categoryDAO.insertCategory(input);
                cboxCategory.removeItemAt(cboxCategory.getItemCount() - 1);
                cboxCategory.addItem(input);
                cboxCategory.addItem("Thêm loại hàng mới...");
                cboxCategory.setSelectedIndex(cboxCategory.getItemCount() - 2);
            }
        }
    }//GEN-LAST:event_cboxCategoryActionPerformed

    private void cboxUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxUnitActionPerformed
        // TODO add your handling code here:
        if (cboxUnit.getSelectedItem().equals("Thêm mới...")) {
            String input = JOptionPane.showInputDialog(rootPane, "Thêm đơn vị mới");
            if (input != null && !input.equals("")) {
                EntityManager.unitDAO.insertUnit(input);
                cboxUnit.removeItemAt(cboxUnit.getItemCount() - 1);
                cboxUnit.addItem(input);
                cboxUnit.addItem("Thêm mới...");
                cboxUnit.setSelectedIndex(cboxUnit.getItemCount() - 2);
            }
        }
    }//GEN-LAST:event_cboxUnitActionPerformed

    private void cboxCategoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboxCategoryFocusGained
        // TODO add your handling code here:
        lblCategoryRq.setVisible(false);
    }//GEN-LAST:event_cboxCategoryFocusGained

    private void cboxSupplierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboxSupplierFocusGained
        // TODO add your handling code here:
        lblSupplierRq.setVisible(false);
    }//GEN-LAST:event_cboxSupplierFocusGained

    private void txtImportDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImportDateFocusGained
        // TODO add your handling code here:
        lblDate.setVisible(false);
    }//GEN-LAST:event_txtImportDateFocusGained

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
            java.util.logging.Logger.getLogger(ProductViewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductViewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductViewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductViewUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductViewUI dialog = new ProductViewUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cboxCategory;
    private javax.swing.JComboBox<String> cboxSupplier;
    private javax.swing.JComboBox<String> cboxUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCategoryRq;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblNameRq;
    private javax.swing.JLabel lblPriceRq;
    private javax.swing.JLabel lblQuantityRq;
    private javax.swing.JLabel lblSupplierRq;
    private javax.swing.JLabel lblTit;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImportDate;
    private javax.swing.JTextField txtImportPrice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtRetailPrice;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
