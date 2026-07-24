
package com.sena.sistemagestiongorras.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Datos de conexión a MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/tiendagorras";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "123456";

    // Método para obtener la conexión
    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa con MySQL.");

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos.");
            System.out.println(e.getMessage());

        }

        return conexion;

    }
}