/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_kelamin;

import java.awt.event.*;
import java.util.UUID;
import dao.JenisKelaminDao;

/**
 *
 * @author ACER-PC
 */
public class JenisKelaminButtonSimpanActionListener implements ActionListener{
    private JenisKelaminFrame jenisKelaminFrame;
    private JenisKelaminDao jenisKelaminDao;
    
    public JenisKelaminButtonSimpanActionListener(JenisKelaminFrame jenisKelaminFrame, JenisKelaminDao jenisKelaminDao){
        this.jenisKelaminFrame = jenisKelaminFrame;
        this.jenisKelaminDao = jenisKelaminDao;
    }
    
    public void actionPerformed(ActionEvent e){
        String nama= this.jenisKelaminFrame.getNama();
        JenisKelamin jenisKelamin = new JenisKelamin();
        jenisKelamin.setId(UUID.randomUUID().toString());
        jenisKelamin.setNama(nama);
        
        this.jenisKelaminFrame.addJenisKelamin(jenisKelamin);
        this.jenisKelaminDao.insert(jenisKelamin);
    }
}
