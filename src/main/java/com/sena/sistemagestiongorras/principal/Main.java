package com.sena.sistemagestiongorras.principal;

import java.util.Scanner;
import com.sena.sistemagestiongorras.dao.GorraDAO;
import com.sena.sistemagestiongorras.modelo.Gorra;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static GorraDAO dao = new GorraDAO();

    public static void main(String[] args) {

        mostrarMenu();
        
    }

    public static void mostrarMenu() {
        
        int opcion;

do {

    System.out.println("\n=================================");
    System.out.println(" SISTEMA DE GESTIÓN DE GORRAS");
    System.out.println("=================================");
    System.out.println("1. Registrar gorra");
    System.out.println("2. Consultar gorras");
    System.out.println("3. Actualizar gorra");
    System.out.println("4. Eliminar gorra");
    System.out.println("5. Salir");
    System.out.print("Seleccione una opción: ");

    opcion = teclado.nextInt();

    switch (opcion) {

        case 1:
            registrarGorra();
            break;

        case 2:
            consultarGorras();
            break;

        case 3:
            actualizarGorra();
            break;

        case 4:
            eliminarGorra();
            break;

        case 5:
            System.out.println("Gracias por utilizar el sistema.");
            break;

        default:
            System.out.println("Opción inválida.");

    }

} while (opcion != 5);

    }

    public static void registrarGorra() {
        
        System.out.println("\n===== REGISTRAR GORRA =====");

        Gorra gorra = new Gorra();
        
        teclado.nextLine();

        System.out.print("Nombre: ");
        gorra.setNombre(teclado.nextLine());

        System.out.print("Marca: ");
        gorra.setMarca(teclado.nextLine());

        System.out.print("Color: ");
        gorra.setColor(teclado.nextLine());

        System.out.print("Talla: ");
        gorra.setTalla(teclado.nextLine());

        System.out.print("Precio: ");
        gorra.setPrecio(teclado.nextDouble());

        System.out.print("Stock: ");
        gorra.setStock(teclado.nextInt());
        
        dao.insertarGorra(gorra);

    }

    public static void consultarGorras() {
        
        System.out.println("\n===== INVENTARIO DE GORRAS =====");
        
        dao.consultarGorras();
    }

    public static void actualizarGorra() {
        
        System.out.println("\n===== ACTUALIZAR GORRA =====");

        dao.consultarGorras();
        
        Gorra gorra = new Gorra();
        System.out.print("\nIngrese el ID de la gorra: ");
        gorra.setIdgorra(teclado.nextInt());

teclado.nextLine();

    System.out.print("Nuevo nombre: ");
    gorra.setNombre(teclado.nextLine());

    System.out.print("Nueva marca: ");
    gorra.setMarca(teclado.nextLine());

    System.out.print("Nuevo color: ");
    gorra.setColor(teclado.nextLine());

    System.out.print("Nueva talla: ");
    gorra.setTalla(teclado.nextLine());

    System.out.print("Nuevo precio: ");
    gorra.setPrecio(teclado.nextDouble());

    System.out.print("Nuevo stock: ");
    gorra.setStock(teclado.nextInt());
    
    dao.actualizarGorra(gorra);
    
        
    }

    public static void eliminarGorra() {
        
        System.out.println("\n===== ELIMINAR GORRA =====");

        dao.consultarGorras();
        System.out.print("\nIngrese el ID de la gorra que desea eliminar: ");
        int id = teclado.nextInt();
        System.out.print("¿Está seguro de eliminar esta gorra? (S/N): ");
        teclado.nextLine(); // Limpiar el Enter pendiente
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {

             dao.eliminarGorra(id);

        } else {

            System.out.println("Operación cancelada.");
            System.out.println("\nInventario actualizado:");
            dao.consultarGorras();

}
    }

}