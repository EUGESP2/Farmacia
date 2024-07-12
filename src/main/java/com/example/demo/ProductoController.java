package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.ProductoDAO;

import com.example.demo.model.Producto;

@RestController
public class ProductoController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarProductos")
    public List<Producto> listarProductos() {
        ProductoDAO productoDAO=new ProductoDAO();
        return productoDAO.listar();
    }

     @CrossOrigin(origins = "*")
    @PostMapping("/addProducto")
    public void addProducto(@RequestBody String nombre ,String descripcion,  String imagen , Double precio) {
        Producto prod=new Producto(nombre,descripcion, imagen, precio);

        
        ProductoDAO productoDAO=new ProductoDAO();
        productoDAO.add(prod);
        

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delProducto/{id}")
    public void delProducto(@PathVariable("id") Integer id) {
        Producto prod=new Producto(id);

       
        ProductoDAO productoDAO=new ProductoDAO();
        productoDAO.del(prod);

    }
    
}
