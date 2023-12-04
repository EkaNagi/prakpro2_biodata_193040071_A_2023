/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import jenis_kelamin.JenisKelaminFrame;
import biodata.BiodataFrame;
import dao.*;

/**
 *
 * @author ACER-PC
 */
public class MainFrame extends JFrame{
    private JenisKelaminFrame jenisKelaminFrame;
    private BiodataFrame biodataFrame;
    private JButton buttonJenisKelamin;
    private JButton buttonBiodata;
    private JenisKelaminDao jenisKelaminDao;
    private BiodataDao biodataDao;
    
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.setSize(400, 500);
        
        this.jenisKelaminDao = new JenisKelaminDao();
        this.biodataDao = new BiodataDao();
        
        this.jenisKelaminFrame = new JenisKelaminFrame(jenisKelaminDao);
        this.biodataFrame = new BiodataFrame(biodataDao, jenisKelaminDao);
        
        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);
        
        this.buttonJenisKelamin = new JButton("Jenis Kelamin");
        this.buttonBiodata = new JButton("Biodata");
        
        this.buttonJenisKelamin.addActionListener(actionListener);
        this.buttonBiodata.addActionListener(actionListener);
        
        this.add(buttonBiodata);
        
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               int confirmation2 = JOptionPane.showConfirmDialog(null, "Apakah anda yaking ingin keluar dari program?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
               if(confirmation2 == JOptionPane.YES_OPTION){
                   System.exit(0);
               }
           } 
        });
    }
    
    public JButton getButtonJenisKelamin(){
        return buttonJenisKelamin;
    }
    
    public JButton getButtonBiodata(){
        return buttonBiodata;
    }
    
    public void showJenisKelaminFrame(){
        if(jenisKelaminFrame == null){
            jenisKelaminFrame = new JenisKelaminFrame(jenisKelaminDao);
        }
        jenisKelaminFrame.setVisible(true);
    }
    
    public void showBiodataFrame(){
        if(biodataFrame == null){
            biodataFrame = new BiodataFrame(biodataDao, jenisKelaminDao);
        }
        biodataFrame.populateComboJenis();
        biodataFrame.setVisible(true);
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}
