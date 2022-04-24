package ec.com.us.peliculas.domain;

import java.io.Serializable;

public class Pelicula implements Serializable{
    private String nombre;
    
    public Pelicula(){}
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        return sb.toString();
    }
    
    
}
