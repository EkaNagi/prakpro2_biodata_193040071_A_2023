/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import javax.swing.table.*;
import java.util.List;

/**
 *
 * @author ACER-PC
 */
public class BiodataTableModel extends AbstractTableModel{
//    deklarasi array dan variable
    private String[] columnNames = {"Nama", "Jenis Kelamin", "Nomor Hp", "Alamat"};
    private List<Biodata> data;
    
//    deklarasi model data
    public BiodataTableModel(List<Biodata> data){
        this.data = data;
    }
    
//    deklarasi get jumlah kolom
    public int getColumnCount(){
        return columnNames.length;
    }
    
//    deklarasi get jumlah baris
    public int getRowCount(){
        return data.size();
    }
    
//    deklarasi get nama kolom
    public String getColumnName(int col){
        return columnNames[col];
    }
    
//    deklarasi get value
    public Object getValueAt(int row, int col){
        Biodata rowItem = data.get(row);
        String value = "";
        
        switch(col){
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisKelamin().getNama();
                break;
            case 2:
                value = rowItem.getNomorHp();
                break;
            case 3:
                value = rowItem.getAlamat();
                break;
        }
        return value;
    }
    
//    deklarasi ubah sel tabel
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
//    deklarasi tambah value biodata
    public void add(Biodata value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
