package com.example.demo.models.repository;

import com.example.demo.models.entity.Auto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AutoDAO {

    private final String URL = "jdbc:mysql://localhost:3306/db_auto?useUnicode=true&serverTimezone=America/Lima&useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "sasa";

    public List<Auto> getAll() {
        List<Auto> autos = new ArrayList<>();
        String sql = "SELECT * FROM autos";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                Auto auto = new Auto();
                auto.setId(rs.getInt("id"));
                auto.setMarca(rs.getString("marca"));
                auto.setModelo(rs.getString("modelo"));
                auto.setAnio(rs.getString("anio"));
                auto.setKm(rs.getString("km"));
                autos.add(auto);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }

    public List<Auto> getByMarca(String marca) {
        List<Auto> autos = new ArrayList<>();
        String sql = "{CALL marca_procedure(?)}";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, marca);
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    Auto auto = new Auto();
                    auto.setId(rs.getInt("id"));
                    auto.setMarca(rs.getString("marca"));
                    auto.setModelo(rs.getString("modelo"));
                    auto.setAnio(rs.getString("anio"));
                    auto.setKm(rs.getString("km"));
                    autos.add(auto);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }
}