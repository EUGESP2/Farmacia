package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;

import com.example.demo.model.Producto;

public class ProductoDAO {
 
    public List<Producto> listar() {
        try {
            
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from producto");
            

            // recorro todas las peliculas
            // creo un objeto Pelicula x cada peli o fila
            List<Producto> listProd=new ArrayList<Producto>();
            while (rs.next()) {
                // orm: mapeo relacional objeto, lo hacen framework hibernate, jpa
                Producto prod=new Producto(rs.getInt("id"), rs.getString("nombre"),rs.getString("descripcion"),rs.getString("imagen"),rs.getDouble("precio"));
                listProd.add(prod);
            }         
            
            return listProd;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        
    }

       public Boolean add(Producto prod) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantInsert=st.executeUpdate("INSERT INTO producto (nombre, descripcion,imagen, precio) VALUES ('"+prod.getNombre()+"', "+prod.getDescripcion()+","+prod.getImagen()+
            ","+prod.getPrecio()+"')");
            
            Boolean insertOk=(cantInsert==1);

            return insertOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean del(Producto prod) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantDel=st.executeUpdate("DELETE FROM producto WHERE id="+prod.getId());
            
            Boolean delOk=(cantDel==1);

            return delOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
