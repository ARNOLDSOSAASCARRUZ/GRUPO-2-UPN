package model;

import java.time.LocalDate;

public class Material {

    private int id;
    private String tipoMaterial;
    private double pesoKg;
    private LocalDate fechaIngreso;
    private String dniUsuario;

    // Constructor vacío
    public Material() {}

    // Constructor completo
    public Material(int id, String tipoMaterial, double pesoKg, LocalDate fechaIngreso, String dniUsuario) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
        this.pesoKg = pesoKg;
        this.fechaIngreso = fechaIngreso;
        this.dniUsuario = dniUsuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }
}