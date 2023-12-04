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
import biodata.Biodata;
import jenis_kelamin.JenisKelamin;

/**
 *
 * @author ACER-PC
 */
public class BiodataDao {
    public int insert(Biodata biodata){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Insert into biodata (id, nama, jenis_kelamin_id, nomor_hp, alamat) values (?, ?, ?, ?, ?)");
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getJenisKelamin().getId());
            statement.setString(4, biodata.getNomorHp());
            statement.setString(5, biodata.getAlamat());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int update(Biodata biodata){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Update biodata set nama = ?, jenis_kelamin = ?, nomor_hp = ?, alamat = ? where id = ?");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getJenisKelamin().getId());
            statement.setString(3, biodata.getNomorHp());
            statement.setString(4, biodata.getAlamat());
            statement.setString(5, biodata.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int delete(Biodata biodata){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");
            statement.setString(1, biodata.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Biodata> findAll(){
        List<Biodata> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();){
            try(ResultSet resultSet = statement.executeQuery("select biodata.id, biodata.nama, biodata.nomor_hp, biodata.alamat, jenis_kelamin.id jenis_kelamin_id, jenis_kelamin.nama " + 
                    "jenis_kelamin_nama from biodata join jenis_kelamin on jenis_kelamin.id = biodata.jenis_kelamin_id");){
                while(resultSet.next()){
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    
                    JenisKelamin jenisKelamin = new JenisKelamin();
                    jenisKelamin.setId(resultSet.getString("jenis_kelamin_id"));
                    jenisKelamin.setNama(resultSet.getString("jenis_kelamin_nama"));
                    
                    biodata.setJenisKelamin(jenisKelamin);
                    
                    biodata.setNomorHp(resultSet.getString("nomor_hp"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                    list.add(biodata);
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
