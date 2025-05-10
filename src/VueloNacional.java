import java.util.List;
import java.util.ArrayList;

public class VueloNacional extends Vuelo {
    private String ciudadOrigen;
    private String ciudadDestino;

    public VueloNacional(String numeroVuelo, String aerolinea, String horaSalida, int filas, int columnas, String ciudadOrigen, String ciudadDestino) {
        super(numeroVuelo, aerolinea, horaSalida, filas, columnas);
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }
}
