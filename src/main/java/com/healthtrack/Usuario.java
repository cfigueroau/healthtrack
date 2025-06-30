package com.healthtrack;
import java.util.logging.Logger;
import java.util.logging.Level;



public class Usuario {
    private static final Logger logger = Logger.getLogger(Usuario.class.getName());
    private String nombre;
    private double peso;

    public Usuario() {
        // Constructor por defecto requerido por el test
    }

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

     public void setPeso(double peso) {
        this.peso = peso;
    }

    

    @Override
    public String toString() {
        return "Usuario{" +
            "nombre='" + nombre + '\'' +
            ", peso=" + peso +
            '}';
    }

    public void actualizarPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }

    public void mostrarInformacion() {        
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Usuario: %s, Peso Actual: %.2f kg", nombre, peso));
        }
    }
    
}
