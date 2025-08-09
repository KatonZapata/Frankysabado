package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.Estados;
import com.example.FrankySabado.ayudas.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//las anotaciones simpre van ensima de lo que yo quiero volver especial
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false,unique = true)
    private String correo;
    @Column(length = 12, nullable = false)
    private String contraseña;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles rol;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estados estado;

    //relacionandome con 1 estudiante
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "relacion_estudiante_usuario")
    private Estudiante estudiante;

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String correo, String contraseña, Roles rol, Estados estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estado = estado;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
