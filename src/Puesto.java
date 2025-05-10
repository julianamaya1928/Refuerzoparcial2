import java.util.List;
import java.util.ArrayList; 

public class Puesto {
    private int fila;
    private int columna;
    private String idPuesto;
    private String idPasajero;
    private boolean libre;
    private boolean primeraClase;

    public Puesto(int fila, int columna, String idPuesto, String idPasajero, boolean libre, boolean primeraClase) {
        this.fila = fila;
        this.columna = columna;
        this.idPuesto = idPuesto;
        this.idPasajero = idPasajero;
        this.libre = libre;
        this.primeraClase = primeraClase;
    }

    public String getIdPuesto() {
        return idPuesto;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }
}