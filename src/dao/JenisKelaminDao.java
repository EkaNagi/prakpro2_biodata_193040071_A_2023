/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList; 
import jenis_kelamin.JenisKelamin;

/**
 *
 * @author ACER-PC
 */
public class JenisKelaminDao {
//    method insert ke database
    public int insert(JenisKelamin jenisKelamin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Insert into jenis_kelamin (id, nama) values (?, ?)");
            statement.setString(1, jenisKelamin.getId());
            statement.setString(2, jenisKelamin.getNama());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method ubah ke database
    public int update(JenisKelamin jenisKelamin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Update jenis_kelamin set nama = ? where id = ?");
            statement.setString(1, jenisKelamin.getNama());
            statement.setString(2, jenisKelamin.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method hapus ke database
    public int delete(JenisKelamin jenisKelamin){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("delete from jenis_kelamin where id = ?");
            statement.setString(1, jenisKelamin.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method cari data yang ada di database
    public List<JenisKelamin> findAll(){
        List<JenisKelamin> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();){
            try(ResultSet resultSet = statement.executeQuery("select * from jenis_kelamin");){
                while(resultSet.next()){
                    JenisKelamin jenisKelamin = new JenisKelamin();
                    jenisKelamin.setId(resultSet.getString("id"));
                    jenisKelamin.setNama(resultSet.getString("nama"));
                    list.add(jenisKelamin);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
