/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.*;

/**
 *
 * @author ACER-PC
 */
public class MainButtonActionListener implements ActionListener {
//    deklarasi variable
    private MainFrame mainFrame;
    
//    deklarasi kelas
    public MainButtonActionListener(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    
//    deklarasi aksi tombol main
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mainFrame.getButtonBiodata()){
            mainFrame.showBiodataFrame();
        }
    }
}
