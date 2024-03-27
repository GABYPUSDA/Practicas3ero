/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DiuVista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static ArrayList<Flete> obtenerFletesDelUsuario(String correoUsuario) {
        ArrayList<Flete> fletes = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM fletes WHERE correo_conductor = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, correoUsuario);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String lugarRecogida = resultSet.getString("lugar_recogida");
                        String destino = resultSet.getString("destino");
                        // Aquí debes continuar extrayendo los otros campos según tu esquema de base de datos
                        // y crear objetos Flete con esos datos
                        Flete flete = new Flete(id, lugarRecogida, destino);
                        fletes.add(flete);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return fletes;
    }
}