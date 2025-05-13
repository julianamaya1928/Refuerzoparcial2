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

    public void contarPuestosPorVuelo() {
        for (Vuelo vuelo : vuelos) {
            System.out.println("Vuelo: " + vuelo.getNumeroVuelo());
            for (Puesto p : vuelo.getPuestos()) {
                String estado = p.isLibre() ? "Libre" : "Ocupado";
                System.out.println("Puesto " + p.getIdPuesto() + " - " + estado);
            }
            System.out.println();
        }
    }
    
    public void crearVueloInteractivo(java.util.Scanner scanner) {
        System.out.println("¿Es un vuelo Nacional o Internacional? (N/I): ");
        String tipo = scanner.nextLine().trim().toUpperCase();
    
        System.out.print("Número de vuelo: ");
        String numeroVuelo = scanner.nextLine();
    
        System.out.print("Aerolínea: ");
        String aerolinea = scanner.nextLine();
    
        System.out.print("Hora de salida: ");
        String hora = scanner.nextLine();
    
        System.out.print("Filas (mínimo 10): ");
        int filas = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Columnas (entre 4 y 12): ");
        int columnas = Integer.parseInt(scanner.nextLine());
    
        if (tipo.equals("N")) {
            System.out.print("Ciudad Origen: ");
            String origen = scanner.nextLine();
            System.out.print("Ciudad Destino: ");
            String destino = scanner.nextLine();
            crearVueloNacional(numeroVuelo, aerolinea, hora, filas, columnas, origen, destino);
        } else {
            System.out.print("País Origen: ");
            String pais = scanner.nextLine();
            System.out.print("¿Requiere visa? (true/false): ");
            boolean visa = Boolean.parseBoolean(scanner.nextLine());
            crearVueloInternacional(numeroVuelo, aerolinea, hora, filas, columnas, pais, visa);
        }
    
        System.out.println("Vuelo creado exitosamente.");
    }
    
    public void comprarAsientos(java.util.Scanner scanner) {
        System.out.print("Número de vuelo: ");
        String numeroVuelo = scanner.nextLine();
    
        while (true) {
            System.out.print("ID del puesto a reservar (ej. F1C2 o 'salir' para terminar): ");
            String idPuesto = scanner.nextLine();
            if (idPuesto.equalsIgnoreCase("salir")) break;
    
            System.out.print("ID del pasajero: ");
            String idPasajero = scanner.nextLine();
    
            boolean exito = reservarPuesto(numeroVuelo, idPuesto, idPasajero);
            System.out.println(exito ? "Reserva exitosa." : "Puesto no disponible o no existe.");
        }
    }
    
}
