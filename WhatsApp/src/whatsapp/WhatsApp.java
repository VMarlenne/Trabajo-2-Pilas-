package whatsapp;
import java.util.Stack;
import java.util.Scanner;

public class WhatsApp {
    private Stack<String> mensajes;

    public WhatsApp() {
        mensajes = new Stack<>();
    }

    public void enviarMensaje(String mensaje) {
        mensajes.push(mensaje);
        System.out.println("Mensaje enviado: " + mensaje);
    }

    public void mostrarMensajes() {
        if (!mensajes.isEmpty()) {
            System.out.println("Mensajes enviados:");
            int index = 1;
            for (String mensaje : mensajes) {
                System.out.println(index + ". " + mensaje);
                index++;
            }
        } else {
            System.out.println("No hay mensajes enviados.");
        }
    }

    public void eliminarMensaje(int posicion) {
        if (posicion > 0 && posicion <= mensajes.size()) {
            Stack<String> temporal = new Stack<>();
            for (int i = 0; i < posicion - 1; i++) {
                temporal.push(mensajes.pop());
            }
            String mensajeEliminado = mensajes.pop();
            System.out.println("Mensaje eliminado: " + mensajeEliminado);

            while (!temporal.isEmpty()) {
                mensajes.push(temporal.pop());
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public static void main(String[] args) {
        WhatsApp whatsapp = new WhatsApp();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Enviar mensaje");
            System.out.println("2. Ver mensajes enviados");
            System.out.println("3. Eliminar un mensaje");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  

            switch (opcion) {
                case 1 -> {
                    System.out.print("Escriba el mensaje a enviar: ");
                    String mensaje = sc.nextLine();
                    whatsapp.enviarMensaje(mensaje);
                }
                case 2 -> whatsapp.mostrarMensajes();
                case 3 -> {
                    whatsapp.mostrarMensajes();
                    System.out.print("Ingrese el numero del mensaje que desea eliminar: ");
                    int posicion = sc.nextInt();
                    whatsapp.eliminarMensaje(posicion);
                }
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
