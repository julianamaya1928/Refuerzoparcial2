import java.util.List;
import java.util.ArrayList;

public class Vuelo {
    protected String numeroVuelo;
    protected String aerolinea;
    protected String horaSalida;
    protected List<Puesto> puestos;

    public Vuelo(String numeroVuelo, String aerolinea, String horaSalida, int filas, int columnas) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.horaSalida = horaSalida;
        this.puestos = new ArrayList<>();
        generarPuestos(filas, columnas);
    }

    private void generarPuestos(int filas, int columnas) {
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                String id = "F" + i + "C" + j;
                boolean primeraClase = false;
                puestos.add(new Puesto(i, j, id, "", true, primeraClase));
            }
        }
    }

    public boolean reservarPuesto(String idPuesto, String idPasajero) {
        for (Puesto p : puestos) {
            if (p.getIdPuesto().equals(idPuesto) && p.isLibre()) {
                p.setIdPasajero(idPasajero);
                p.setLibre(false);
                return true;
            }
        }
        return false;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }
    public List<Puesto> getPuestos() {
        return puestos;
    }
    
}

