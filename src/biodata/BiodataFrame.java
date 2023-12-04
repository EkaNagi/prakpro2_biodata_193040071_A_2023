/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import jenis_kelamin.JenisKelamin;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.BiodataDao;
import dao.JenisKelaminDao;

/**
 *
 * @author ACER-PC
 */
public class BiodataFrame extends JFrame {
    private List<JenisKelamin> jenisKelaminList;
    private List<Biodata> biodataList;
    private JTextField textFieldNama;
    private JTextField textFieldNomorHp;
    private JTextArea textArea;
    private BiodataTableModel tableModel;
    private JComboBox comboJenis;
    private BiodataDao biodataDao;
    private JenisKelaminDao jenisKelaminDao;
    
    public BiodataFrame(BiodataDao biodataDao, JenisKelaminDao jenisKelaminDao){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.biodataDao = biodataDao;
        this.jenisKelaminDao = jenisKelaminDao;
        
        this.biodataList = biodataDao.findAll();
        this.jenisKelaminList = jenisKelaminDao.findAll();
        
        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        JLabel labelJenis = new JLabel("Jenis Kelamin: ");
        labelJenis.setBounds(15, 100, 350, 10);
        
        comboJenis = new JComboBox();
        comboJenis.setBounds(15, 120, 100, 40);
        
        JLabel labelNomorHp = new JLabel("Nomor Hp: ");
        labelNomorHp.setBounds(15, 160, 350, 10);
        
        textFieldNomorHp = new JTextField();
        textFieldNomorHp.setBounds(15, 180, 350, 30);
        
        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 220, 350, 10);
        
        textArea = new JTextArea();
        textArea.setBounds(15, 240, 350, 30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 280, 100, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 320, 350, 200);
        
        tableModel = new BiodataTableModel(biodataList);
        table.setModel(tableModel);
        
        BiodataButtonSimpanActionListener actionListener = new BiodataButtonSimpanActionListener(this, biodataDao);
        
        button.addActionListener(actionListener);
        
        this.add(button);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(labelNomorHp);
        this.add(textFieldNomorHp);
        this.add(labelAlamat);
        this.add(textArea);
        this.add(scrollableTable);
        
        this.setSize(400, 800);
        this.setLayout(null);
        
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               int confirmation2 = JOptionPane.showConfirmDialog(null, "Apakah anda yaking ingin keluar dari program?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
               if(confirmation2 == JOptionPane.YES_OPTION){
                   System.exit(0);
               }
           } 
        });
    }
    
    public void populateComboJenis(){
        this.jenisKelaminList = this.jenisKelaminDao.findAll();
        comboJenis.removeAllItems();
        for(JenisKelamin jenisKelamin : this.jenisKelaminList){
            comboJenis.addItem(jenisKelamin.getNama());
        }
    }
    
    public String getNama(){
        return textFieldNama.getText();
    }
    
    public JenisKelamin getJenisKelamin(){
        return jenisKelaminList.get(comboJenis.getSelectedIndex());
    }
    
    public String getNomorHp(){
        return textFieldNomorHp.getText();
    }
    
    public String getAlamat(){
        return textArea.getText();
    }
    
    public void addBiodata(Biodata biodata){
        tableModel.add(biodata);
        textFieldNama.setText("");
        textFieldNomorHp.setText("");
        textArea.setText("");
    }
    
    public void showAlert(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showSuccess(String message){
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
