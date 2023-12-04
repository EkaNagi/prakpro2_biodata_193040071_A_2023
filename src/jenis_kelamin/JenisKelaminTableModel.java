/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_kelamin;

import javax.swing.table.*;
import java.util.List;

/**
 *
 * @author ACER-PC
 */
public class JenisKelaminTableModel extends AbstractTableModel{
    private String[] columnNames = {"Nama"};
    private List<JenisKelamin> data;
    
    public JenisKelaminTableModel(List<JenisKelamin> data){
        this.data = data;
    }
    
    public int getColumnCount(){
        return columnNames.length;
    }
    
    public int getRowCount(){
        return data.size();
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col){
        JenisKelamin rowItem = data.get(row);
        String value = "";
        
        switch(col){
            case 0:
                value = rowItem.getNama();
                break;
        }
        return value;
    }
    
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void add(JenisKelamin value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
