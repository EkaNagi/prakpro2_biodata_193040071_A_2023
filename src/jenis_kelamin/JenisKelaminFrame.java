/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_kelamin;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisKelaminDao;

/**
 *
 * @author ACER-PC
 */
public class JenisKelaminFrame extends JFrame{
    private List<JenisKelamin> jenisKelaminList;
    private JTextField textFieldNama;
    private JenisKelaminTableModel tableModel;
    private JenisKelaminDao jenisKelaminDao;
    
    public JenisKelaminFrame(JenisKelaminDao jenisKelaminDao){
        this.jenisKelaminDao = jenisKelaminDao;
        this.jenisKelaminList = jenisKelaminDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 100, 100, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);
        
        tableModel = new JenisKelaminTableModel(jenisKelaminList);
        table.setModel(tableModel);
        
        JenisKelaminButtonSimpanActionListener actionListener = new JenisKelaminButtonSimpanActionListener(this, jenisKelaminDao);
        
        button.addActionListener(actionListener);
        
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    public String getNama(){
        return textFieldNama.getText();
    }
    
    public void addJenisKelamin(JenisKelamin jenisKelamin){
        tableModel.add(jenisKelamin);
        textFieldNama.setText("");
    }
}
