package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.EstadoAsistencia;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 200)
    private String observacion;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoAsistencia estado;

    //Relacionandome con 1 estudiante
    private Estudiante estudiante;

    public Asistencia() {
    }

    public Asistencia(Integer id, LocalDate fecha, String observacion, EstadoAsistencia estado) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }
}
