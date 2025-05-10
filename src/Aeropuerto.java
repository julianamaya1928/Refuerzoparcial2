import java.util.List;
import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private List<Vuelo> vuelos;

    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    public void crearVueloNacional(String numeroVuelo, String aerolinea, String horaSalida, int filas, int columnas, String ciudadOrigen, String ciudadDestino) {
        if (filas < 10 || columnas < 4 || columnas > 12) return;
        VueloNacional vuelo = new VueloNacional(numeroVuelo, aerolinea, horaSalida, filas, columnas, ciudadOrigen, ciudadDestino);
        vuelos.add(vuelo);
    }

    public void crearVueloInternacional(String numeroVuelo, String aerolinea, String horaSalida, int filas, int columnas, String paisOrigen, boolean visa) {
        if (filas < 10 || columnas < 4 || columnas > 12) return;
        VueloInternacional vuelo = new VueloInternacional(numeroVuelo, aerolinea, horaSalida, filas, columnas, paisOrigen, visa);
        vuelos.add(vuelo);
    }

    public boolean reservarPuesto(String numeroVuelo, String idPuesto, String idPasajero) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumeroVuelo().equals(numeroVuelo)) {
                return vuelo.reservarPuesto(idPuesto, idPasajero);
            }
        }
        return false;
    }
}