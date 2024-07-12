package com.example.demo.model;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String imagen;


    public String getImagen() {
        return imagen;

    }
    public Producto(Integer id, String nombre,  String descripcion,String imagen, Double precio) {
        this.id = id;
        this.nombre = nombre;       
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Producto( String nombre,  String descripcion,String imagen, Double precio) {
        
        this.nombre = nombre;        
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

  

    
    public Producto(int id){
        this.id = id;
    }
    public Producto(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
