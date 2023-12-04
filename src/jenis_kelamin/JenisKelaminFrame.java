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
//    deklarasi variable
    private List<JenisKelamin> jenisKelaminList;
    private JTextField textFieldNama;
    private JenisKelaminTableModel tableModel;
    private JenisKelaminDao jenisKelaminDao;
    
    public JenisKelaminFrame(JenisKelaminDao jenisKelaminDao){
//        deklarasi kelas
        this.jenisKelaminDao = jenisKelaminDao;
        this.jenisKelaminList = jenisKelaminDao.findAll();
//        deklarasi fungsi aplikasi tidak melakukan apapun ketika ditutup
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
//        deklarasi label, text field dan button
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 100, 100, 40);
        
//        deklarasi table
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);
        
//        deklarasi pemanggilan model
        tableModel = new JenisKelaminTableModel(jenisKelaminList);
        table.setModel(tableModel);
        
//        deklarasi pemanggilan method simpan
        JenisKelaminButtonSimpanActionListener actionListener = new JenisKelaminButtonSimpanActionListener(this, jenisKelaminDao);
        
//        deklarasi aksi button
        button.addActionListener(actionListener);
        
//        penambahan komponen aplikasi
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        
//        penyesuaian ukuran aplikasi
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
//    method get nama
    public String getNama(){
        return textFieldNama.getText();
    }
    
//    method tambah jenis kelamin
    public void addJenisKelamin(JenisKelamin jenisKelamin){
        tableModel.add(jenisKelamin);
        textFieldNama.setText("");
    }
}
