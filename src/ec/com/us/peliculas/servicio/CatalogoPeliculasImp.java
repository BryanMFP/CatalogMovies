package ec.com.us.peliculas.servicio;

import ec.com.us.peliculas.datos.AccesoDatosImp;
import ec.com.us.peliculas.datos.IAccesoDatos;
import ec.com.us.peliculas.domain.Pelicula;
import ec.com.us.peliculas.excepciones.AccesoDatosEx;
import ec.com.us.peliculas.excepciones.LecturaDatosEx;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculasImp implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImp(){
        this.datos = new AccesoDatosImp();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula: peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al listar peliculas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al buscar pelicula");
            ex.printStackTrace(System.out);
        }
        
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void inciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
        
        System.out.println("Se ha creado el archivo ");
    }
    
}
