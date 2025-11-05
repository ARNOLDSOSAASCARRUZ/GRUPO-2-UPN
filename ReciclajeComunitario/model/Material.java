package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Material {
    private String tipo;
    private double peso;
    private LocalDate fecha;
    private Usuario usuario;

    // Constructor principal con LocalDate
    public Material(String tipo, double peso, LocalDate fecha, Usuario usuario) {
        this.tipo = tipo;
        this.peso = peso;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    // Constructor alternativo con fecha como String
    public Material(String tipo, double peso, String fechaTexto, Usuario usuario) {
        this.tipo = tipo;
        this.peso = peso;
        this.fecha = LocalDate.parse(fechaTexto, DateTimeFormatter.ISO_LOCAL_DATE);
        this.usuario = usuario;
    }

    // Getters y setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    // Devuelve la fecha como texto para exportación
    public String getFecha() {
        return fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    // Método auxiliar para trazabilidad
    public String resumen() {
        return tipo + " (" + peso + "kg) - " + getFecha() + " por " + usuario.resumen();
    }
}