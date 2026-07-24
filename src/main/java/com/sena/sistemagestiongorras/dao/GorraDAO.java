package com.sena.sistemagestiongorras.dao;
    
import com.sena.sistemagestiongorras.conexion.ConexionBD;
import com.sena.sistemagestiongorras.modelo.Gorra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
1. Co

public class GorraDAO {

    public void consultarGorras() {
        
          String sql = "SELECT * FROM gorra";

    Connection conexion = ConexionBD.conectar();
    
   try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println("------------------------------");
            System.out.println("ID: " + rs.getInt("idgorra"));
            System.out.println("Nombre: " + rs.getString("nombre"));
            System.out.println("Marca: " + rs.getString("marca"));
            System.out.println("Color: " + rs.getString("color"));
            System.out.println("Talla: " + rs.getString("talla"));
            System.out.println("Precio: $" + rs.getDouble("precio"));
            System.out.println("Stock: " + rs.getInt("stock"));

        }

        rs.close();
        ps.close();
        conexion.close();

    } catch (SQLException e) {

        System.out.println("Error al consultar las gorras.");
        System.out.println(e.getMessage());

    }

}
    
public void actualizarGorra(Gorra gorra) {

    String sql = "UPDATE gorra SET nombre=?, marca=?, color=?, talla=?, precio=?, stock=? WHERE idgorra=?";

    Connection conexion = ConexionBD.conectar();

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, gorra.getNombre());
        ps.setString(2, gorra.getMarca());
        ps.setString(3, gorra.getColor());
        ps.setString(4, gorra.getTalla());
        ps.setDouble(5, gorra.getPrecio());
        ps.setInt(6, gorra.getStock());
        ps.setInt(7, gorra.getIdgorra());

        int filas = ps.executeUpdate();

        if (filas > 0) {
            System.out.println("Gorra actualizada correctamente.");
        } else {
            System.out.println("No se encontró una gorra con ese ID.");
        }

        ps.close();
        conexion.close();

    } catch (SQLException e) {

        System.out.println("Error al actualizar la gorra.");
        System.out.println(e.getMessage());

    }

}    
public void eliminarGorra(int idgorra) {

    String sql = "DELETE FROM gorra WHERE idgorra = ?";

    Connection conexion = ConexionBD.conectar();

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, idgorra);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            System.out.println("Gorra eliminada correctamente.");

        } else {

            System.out.println("No existe una gorra con ese ID.");

        }

        ps.close();
        conexion.close();

    } catch (SQLException e) {

        System.out.println("Error al eliminar la gorra.");
        System.out.println(e.getMessage());

    }

}    

    public void insertarGorra(Gorra gorra) {

        String sql = "INSERT INTO gorra (nombre, marca, color, talla, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection conexion = ConexionBD.conectar();
        
        PreparedStatement ps = null;
        try {
            
    ps = conexion.prepareStatement(sql);
    
    ps.setString(1, gorra.getNombre());
    ps.setString(2, gorra.getMarca());
    ps.setString(3, gorra.getColor());
    ps.setString(4, gorra.getTalla());
    ps.setDouble(5, gorra.getPrecio());
    ps.setInt(6, gorra.getStock());

    ps.executeUpdate();

    System.out.println("Gorra registrada correctamente.");


} catch (SQLException e) {
    
    System.out.println("Error al preparar la consulta.");
    System.out.println(e.getMessage());

}finally {

    try {

        if (ps != null) {
            ps.close();
        }

        if (conexion != null) {
            conexion.close();
        }

    } catch (SQLException e) {

        System.out.println("Error al cerrar la conexión.");
        System.out.println(e.getMessage());

    }

}
        
    }

}
