package mx.uam.Capstone.controllers;

import mx.uam.Capstone.models.Usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class BDController{

    public void registraUsuario(Usuario usuario) {
        System.out.println("Estoy entrando a la clase BDUTIL");
        String password = getMD5Hash(usuario.getPassword());
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/usuarios", "root", "secreto");
            if (conn != null) {
                Statement st = conn.createStatement();
                String query =  "insert into libros (nombreusuario, email, password, rol ) values('" + usuario.getNombreUsuario() + "', '" + usuario.getEmail() +  "', '" + usuario.getRol() + "', '" + password +"')";
                System.out.println(query);
                st.executeUpdate(query);
            }
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5Hash(String entradaH){
        String resultado = entradaH;
        if (entradaH != null) {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("SHA-1");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(entradaH.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            resultado = hash.toString(16);
            while (resultado.length() < 40) {
                resultado = "0" + resultado;
            }
        }
        return resultado;
    }
}
