import java.util.ArrayList;
import java.util.Scanner;

class Articulo {
    int id;
    String nombre;
    double precio;

    public Articulo(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio);
    }
}

public class MenuArticulos {

    static ArrayList<Articulo> lista = new ArrayList<>();

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n----- Menú de Artículos -----");
            System.out.println("1. Crear un artículo nuevo");
            System.out.println("2. Consultar un artículo");
            System.out.println("3. Listar artículos");
            System.out.println("4. Modificar un artículo");
            System.out.println("5. Borrar un artículo");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    crearArticulo();
                    break;
                case 2:
                    consultarArticulo();
                    break;
                case 3:
                    listarArticulos();
                    break;
                case 4:
                    modificarArticulo();
                    break;
                case 5:
                    borrarArticulo();
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        teclado.close();
    }

    public static void crearArticulo() {
        System.out.print("ID: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        for (Articulo art : lista) {
            if (art.id == id) {
                System.out.println("❌ Ya existe un artículo con ese ID.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Precio: ");
        double precio = teclado.nextDouble();
        if (precio < 0) {
            System.out.println("❌ El precio no puede ser negativo.");
            return;
        }

        Articulo nuevo = new Articulo(id, nombre, precio);
        lista.add(nuevo);
        System.out.println("✅ Artículo agregado correctamente.");
    }

    public static void consultarArticulo() {
        System.out.print("Ingrese el ID del artículo: ");
        int id = teclado.nextInt();

        for (Articulo art : lista) {
            if (art.id == id) {
                art.mostrar();
                return;
            }
        }
        System.out.println("❌ Artículo no encontrado.");
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("📭 No hay artículos registrados.");
        } else {
            System.out.println("📦 Lista de artículos:");
            for (Articulo art : lista) {
                art.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        System.out.print("Ingrese el ID del artículo a modificar: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        for (Articulo art : lista) {
            if (art.id == id) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = teclado.nextLine();

                System.out.print("Nuevo precio: ");
                double nuevoPrecio = teclado.nextDouble();
                if (nuevoPrecio < 0) {
                    System.out.println("❌ El precio no puede ser negativo.");
                    return;
                }

                art.nombre = nuevoNombre;
                art.precio = nuevoPrecio;
                System.out.println("✅ Artículo modificado correctamente.");
                return;
            }
        }
        System.out.println("❌ Artículo no encontrado.");
    }

    public static void borrarArticulo() {
        System.out.print("Ingrese el ID del artículo a borrar: ");
        int id = teclado.nextInt();

        for (Articulo art : lista) {
            if (art.id == id) {
                lista.remove(art);
                System.out.println("🗑️ Artículo eliminado.");
                return;
            }
        }
        System.out.println("❌ Artículo no encontrado.");
    }
}
