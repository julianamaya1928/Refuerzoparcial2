import java.util.List;
import java.util.ArrayList;

public class VueloInternacional extends Vuelo {
    private String paisOrigen;
    private boolean visa;

    public VueloInternacional(String numeroVuelo, String aerolinea, String horaSalida, int filas, int columnas, String paisOrigen, boolean visa) {
        super(numeroVuelo, aerolinea, horaSalida, filas, columnas);
        this.paisOrigen = paisOrigen;
        this.visa = visa;
    }
}