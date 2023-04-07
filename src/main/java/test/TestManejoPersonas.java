package test;

import datos.*;
import domainEntity.Persona;
import java.sql.*;
public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            Persona actualizaPersona = new Persona(2, "Julian", "Jimenez", "jjimenez@hotmail.com", "254123333333333333333333333333333333333333333");
            personaJDBC.actualizar(actualizaPersona);
            
            conexion.commit();
            
        } catch (SQLException ex) {                  
                ex.printStackTrace(System.out);
                System.out.println("INGRESANDO AL ROLLBACK");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
