package com.iesemilidarder.restaurants.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;


    /* lee los restoranes guardados */

public class LeeBD {

    public static ArrayList<Restaurante> readRestaurants()
    {
        ArrayList <Restaurante> al = new ArrayList<Restaurante>();
        try {
                /* dráivers de la databeis */
            Class.forName("oracle.jdbc.driver.OracleDriver");
                /* conectar con la databeis */
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:", "usuari","usuari");
                /* SACAR los campos de la primera tabla */
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT RES_CODI, RES_NOM, RES_ADRECA, RES_WEB , RES_TELEFON, RES_TRS_CODI, RES_MITJANA, RES_URL_IMG FROM RESTAURANTS " +
                    "ORDER BY RES_MITJANA DESC");

            while (rs.next()) {
                String res_id = rs.getString("RES_CODI");
                String nombre = rs.getString("RES_NOM");
                String direcc = rs.getString("RES_ADRECA");
                String vveb = rs.getString("RES_WEB");
                String telef = rs.getString("RES_TELEFON");
                double media = Double.parseDouble(rs.getString("RES_MITJANA"));
                String img = rs.getString("RES_URL_IMG");

                    /* el tipo pertenece a otra tabla, se pone como string vacio para que funcione */
                String tipo = "";
                String codi = rs.getString("RES_TRS_CODI");


                    /* SACAR EL TIPO DE LA OTRA TABLA */
                Statement stmt2 = con.createStatement();
                ResultSet rs1 = stmt2.executeQuery("SELECT TRS_DESCRIPCIO FROM TRESTAURANTS WHERE TRS_CODI = '" + codi + "'");
                rs1.next();
                tipo = rs1.getString("TRS_DESCRIPCIO");
                stmt2.close();



                Opinion opt = new Opinion();

                /* SACAR LA OPINIÓN DE LA OTRA TABLA */
                Statement stmt3 = con.createStatement();
                ResultSet rs2 = stmt3.executeQuery("SELECT OPI_OBSERVACIO, OPI_PUNTUACIO, OPI_USU_CODI FROM OPINIONS WHERE OPI_RES_CODI = '" + res_id + "'");
                if (rs2.next()) {
                    String obs = rs2.getString("OPI_OBSERVACIO");
                    int puntuacio = Integer.parseInt(rs2.getString("OPI_PUNTUACIO"));
                    String usuario = rs2.getString("OPI_USU_CODI");
                    stmt3.close();

                    opt.setObservacio(obs);
                    opt.setPuntuacio(puntuacio);
                    opt.setUsuari(usuario);
                }

                    /* GUARDAR CAMPOS EN LA CLASE */
                Restaurante rest = new Restaurante();
                rest.setNombre(nombre);
                rest.setDirecc(direcc);
                rest.setVveb(vveb);
                rest.setTelef(telef);
                rest.setTipo(tipo);
                rest.setMedia(media);
                rest.setImg(img);
                rest.setOp(opt);

                al.add(rest);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }


}

