import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Crear el aeropuerto
        Aeropuerto aeropuerto = new Aeropuerto("Aeropuerto Cielo Abierto");

        // Crear vuelos nacionales
        aeropuerto.crearVueloNacional("AV123", "Avianca", "08:30", 15, 6, "Bogotá", "Medellín");
        System.out.println("Vuelo Nacional Creado: AV123");

        // Crear vuelos internacionales
        aeropuerto.crearVueloInternacional("IB456", "Iberia", "15:45", 20, 10, "España", true);
        System.out.println("Vuelo Internacional Creado: IB456");

        // Reservar un puesto en un vuelo nacional
        boolean reservado1 = aeropuerto.reservarPuesto("AV123", "F2C3", "123456789");
        System.out.println("Reserva en AV123 F2C3: " + (reservado1 ? "Exitosa" : "Fallida"));

        // Reservar un puesto en un vuelo internacional
        boolean reservado2 = aeropuerto.reservarPuesto("IB456", "F5C4", "987654321");
        System.out.println("Reserva en IB456 F5C4: " + (reservado2 ? "Exitosa" : "Fallida"));

        // Intentar reservar el mismo puesto nuevamente
        boolean reservado3 = aeropuerto.reservarPuesto("IB456", "F5C4", "111111111");
        System.out.println("Reserva en IB456 F5C4 nuevamente: " + (reservado3 ? "Exitosa" : "Fallida"));
    }
}
