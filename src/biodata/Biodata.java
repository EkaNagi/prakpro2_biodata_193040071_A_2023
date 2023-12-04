/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import jenis_kelamin.JenisKelamin;

/**
 *
 * @author ACER-PC
 */
public class Biodata {
//    deklarasi variable
    private String id;
    private String nama;
    private JenisKelamin jenisKelamin;
    private String nomorHp;
    private String alamat;
    
//    setter getter
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setJenisKelamin(JenisKelamin jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    
    public JenisKelamin getJenisKelamin(){
        return jenisKelamin;
    }
    
    public void setNomorHp(String nomorHp){
        this.nomorHp = nomorHp;
    }
    
    public String getNomorHp(){
        return nomorHp;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getAlamat(){
        return alamat;
    }
}
