package ud7JavaBasics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class CajaRegistradora {

    private static final String ADMIN_PASSWORD = "CajaR";

    private static Map<String, Map<String, Object>> stockProductos = new HashMap<>();
    private static Map<String, Integer> carrito = new HashMap<>();
    private static Map<String, Integer> ventas = new HashMap<>();
    private static double iva = 0.21; // IVA por defecto (21%)

    public static void main(String[] args) {
        inicializarBaseDeDatos();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "---- Menú Principal ----\n" +
                            "1. Ver lista de productos (con IVA)\n" +
                            "2. Comprar producto\n" +
                            "3. Realizar venta\n" +
                            "4. Modo Administrador\n" +
                            "5. Salir\n" +
                            "Seleccione una opción:");

            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    listarProductosConIVA();
                    break;
                case "2":
                    comprarProducto();
                    break;
                case "3":
                    realizarVenta();
                    break;
                case "4":
                    modoAdmin();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }

            verificarStockBajo();
        }
    }

    private static void inicializarBaseDeDatos() {
        agregarProducto("Manzanas", 20, 2.5);
        agregarProducto("Plátanos", 15, 1.8);
        agregarProducto("Leche", 30, 1.2);
        agregarProducto("Pan", 25, 0.9);
        agregarProducto("Huevos", 40, 3.0);
        agregarProducto("Arroz", 50, 1.5);
        agregarProducto("Aceite", 35, 2.8);
        agregarProducto("Azúcar", 45, 1.0);
        agregarProducto("Sal", 40, 0.8);
        agregarProducto("Café", 20, 4.0);
    }

    private static void agregarProducto(String nombre, int cantidad, double precio) {
        Map<String, Object> productoInfo = new HashMap<>();
        productoInfo.put("cantidad", cantidad);
        productoInfo.put("precio", precio);
        stockProductos.put(nombre, productoInfo);
    }

    private static void listarProductosConIVA() {
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("--- Productos Disponibles ---\n");
        for (Map.Entry<String, Map<String, Object>> entry : stockProductos.entrySet()) {
            String nombreProducto = entry.getKey();
            Map<String, Object> productoInfo = entry.getValue();
            int cantidad = (int) productoInfo.get("cantidad");
            double precio = (double) productoInfo.get("precio");
            double precioIVA = precio * (1 + iva); // Calcular precio con IVA
            listaProductos.append(nombreProducto).append(" - Cantidad: ").append(cantidad)
                    .append(", Precio con IVA: €").append(String.format("%.2f", precioIVA)).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProductos.toString());
    }

    private static void comprarProducto() {
        // Función comprarProducto igual a la versión anterior
        // ...
    }

    private static void realizarVenta() {
        // Función realizarVenta igual a la versión anterior
        // ...
    }

    private static void modoAdmin() {
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña de administrador:");
        if (password == null || !password.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No tiene acceso al modo administrador.");
            return;
        }

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "---- Modo Administrador ----\n" +
                            "1. Ver total de productos\n" +
                            "2. Editar lista de productos\n" +
                            "3. Ver/Modificar IVA aplicado a los productos\n" +
                            "4. Salir del modo administrador\n" +
                            "Seleccione una opción:");
            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    listarProductosConIVA();
                    break;
                case "2":
                    editarProductos();
                    break;
                case "3":
                    verModificarIVA();
                    break;
                case "4":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void verModificarIVA() {
        String opcion = JOptionPane.showInputDialog(null,
                "---- IVA Aplicado ----\n" +
                        "1. Ver IVA aplicado\n" +
                        "2. Modificar IVA\n" +
                        "Seleccione una opción:");

        if (opcion == null) {
            return;
        }

        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, "El IVA aplicado a los productos es: " + (iva * 100) + "%");
                break;
            case "2":
                modificarIVA();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }

    private static void modificarIVA() {
        String nuevoIVA = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor del IVA (en decimal):");
        if (nuevoIVA == null) {
            return;
        }
        try {
            iva = Double.parseDouble(nuevoIVA);
            JOptionPane.showMessageDialog(null, "IVA modificado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor de IVA no válido.");
        }
    }

    private static void editarProductos() {
        String opcion = JOptionPane.showInputDialog(null,
                "--- Editar lista de productos ---\n" +
                        "1. Agregar producto\n" +
                        "2. Eliminar producto\n" +
                        "Seleccione una opción:");
        if (opcion == null) {
            return;
        }

        switch (opcion) {
            case "1":
                agregarProductoAdmin();
                break;
            case "2":
                eliminarProductoAdmin();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }

    private static void agregarProductoAdmin() {
        // Función agregarProductoAdmin igual a la versión anterior
        // ...
    }

    private static void eliminarProductoAdmin() {
        // Función eliminarProductoAdmin igual a la versión anterior
        // ...
    }

    private static void verificarStockBajo() {
        // Función verificarStockBajo igual a la versión anterior
        // ...
    }
}

