/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import jenis_kelamin.JenisKelamin;
import java.awt.event.*;
import java.util.UUID;
import dao.BiodataDao;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER-PC
 */
public class BiodataButtonSimpanActionListener implements ActionListener{
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;
    
    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao){
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }
    
    public void actionPerformed(ActionEvent e){
        int confirmation1 = JOptionPane.showConfirmDialog(this.biodataFrame,
                        "Apakah yakin anda ingin menambahkan data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirmation1 == JOptionPane.YES_OPTION){
            String nama = this.biodataFrame.getNama();
            String nomorHp = this.biodataFrame.getNomorHp();
            String alamat = this.biodataFrame.getAlamat();
            if(nama.isEmpty()){
                this.biodataFrame.showAlert("Nama Tidak Boleh Kosong");
            } else if(nomorHp.isEmpty()) {
                this.biodataFrame.showAlert("Nomor Hp Tidak Boleh Kosong");
            } else if(alamat.isEmpty()){
                this.biodataFrame.showAlert("Alamat Tidak Boleh Kosong");
            } else {
                JenisKelamin jenisKelamin = this.biodataFrame.getJenisKelamin();
                Biodata biodata = new Biodata();
                biodata.setId(UUID.randomUUID().toString());
                biodata.setNama(nama);
                biodata.setJenisKelamin(jenisKelamin);
                biodata.setNomorHp(nomorHp);
                biodata.setAlamat(alamat);
            
                this.biodataFrame.addBiodata(biodata);
                this.biodataDao.insert(biodata);
                this.biodataFrame.showSuccess("Data Berhasil Ditambahkan!");
            }
        }
    }
}
