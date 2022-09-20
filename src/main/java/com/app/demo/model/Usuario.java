package com.app.demo.model;
import javax.persistence.Entity;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String contrasena;
    @Column
    private boolean admin;
    @Column
    private String correo;
    

    public Usuario(){}
    public Usuario(String nombre, String contrasena, String correo, boolean admin){
        this.admin=admin;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.correo = correo;
    }
  
    public long getId() {
        return id;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public boolean getAdmin() {
        return admin;
    }
    public String getContrasena() {
        return contrasena;
    }public String getNombre() {
        return nombre;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", contrasena='" + getContrasena() + "'" +
            ", admin='" + admin + "'" +
            ", correo='" + getCorreo() + "'" +
            ", compras='" + "Compras" + "'" +
            ", ventas='" + "ventas"+ "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(contrasena, usuario.contrasena) && admin == usuario.admin && Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contrasena, admin, correo);
    }

    
}
