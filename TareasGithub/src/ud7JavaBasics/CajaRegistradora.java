package ud7JavaBasics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class CajaRegistradora {

    private static Map<String, Map<String, Object>> productosMap = new HashMap<>();
    private static Map<String, Integer> ventasMap = new HashMap<>();

    public static void main(String[] args) {
        baseDeDatos(); // Cargamos la base de datos de productos al iniciar la aplicación

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "---- Menú Principal ----\n\n"
                            + "1. Consultar Stock\n"
                            + "2. Registro de Ventas\n"
                            + "3. Añadir venta\n"
                            + "4. Añadir producto\n"
                            + "5. Salir\n\n"
                            + "Seleccione una opción:");

            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    mostrarControlStock();
                    break;
                case "2":
                    mostrarRegistroVentas();
                    break;
                case "3":
                    registrarVenta();
                    break;
                case "4":
                    anadirProductos();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }

            // Verificar si el stock es bajo
            verificarStockBajo();
        }
    }

    public static void mostrarControlStock() {
        StringBuilder controlStock = new StringBuilder("Control de stock:\n");
        for (Map.Entry<String, Map<String, Object>> entry : productosMap.entrySet()) {
            String producto = entry.getKey();
            Map<String, Object> datos = entry.getValue();
            int cantidad = (int) datos.get("cantidad");
            controlStock.append("Producto: ").append(producto).append(", Cantidad en stock: ").append(cantidad).append("\n");
        }
        JOptionPane.showMessageDialog(null, controlStock.toString());
    }

    public static void mostrarRegistroVentas() {
        StringBuilder registroVentas = new StringBuilder("Registro de ventas:\n");
        for (Map.Entry<String, Integer> entry : ventasMap.entrySet()) {
            String producto = entry.getKey();
            int cantidadVendida = entry.getValue();
            double precio = (double) productosMap.get(producto).get("precio");
            double precioConIVA = precio * 1.21; // Suponiendo un IVA del 21%
            double totalVenta = precioConIVA * cantidadVendida;
            registroVentas.append("Producto: ").append(producto).append(", Cantidad vendida: ").append(cantidadVendida)
                    .append(", Precio con IVA: ").append(precioConIVA).append(", Total: ").append(totalVenta).append("\n");
        }
        JOptionPane.showMessageDialog(null, registroVentas.toString());
    }

    private static void registrarVenta() {
        String nombreProducto = JOptionPane.showInputDialog("Introduzca el nombre del producto vendido:");
        if (productosMap.containsKey(nombreProducto)) {
            Map<String, Object> datosProducto = productosMap.get(nombreProducto);
            int cantidad = (int) datosProducto.get("cantidad");

            String cantidadStr = JOptionPane.showInputDialog("Introduzca la cantidad vendida:");
            int cantidadVendida = Integer.parseInt(cantidadStr);

            if (cantidadVendida <= cantidad) {
                datosProducto.put("cantidad", cantidad - cantidadVendida); // Actualizar la cantidad en stock

                String ivaStr = JOptionPane.showInputDialog("Introduzca el IVA aplicable:");
                double iva = Double.parseDouble(ivaStr);

                double precio = (double) datosProducto.get("precio");
                double precioConIVA = precio * (1 + (iva / 100)); // Calculamos el precio con el IVA aplicado

                if (!ventasMap.containsKey(nombreProducto)) {
                    ventasMap.put(nombreProducto, cantidadVendida);
                } else {
                    int ventas = ventasMap.get(nombreProducto);
                    ventasMap.put(nombreProducto, ventas + cantidadVendida);
                }
                productosMap.put(nombreProducto, datosProducto);

                JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar esta venta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe en la base de datos.");
        }
    }

    private static void anadirProductos() {
        String nombreProducto = JOptionPane.showInputDialog("Introduzca el nombre del nuevo producto:");
        if (productosMap.containsKey(nombreProducto)) {
            JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos.");
            return;
        }

        String cantidadStr = JOptionPane.showInputDialog("Introduzca la cantidad del producto:");
        int cantidad = Integer.parseInt(cantidadStr);

        String precioStr = JOptionPane.showInputDialog("Introduzca el precio del producto:");
        double precio = Double.parseDouble(precioStr);

        String ivaStr = JOptionPane.showInputDialog("Introduzca el IVA aplicable:");
        double iva = Double.parseDouble(ivaStr);

        Map<String, Object> datosProducto = new HashMap<>();
        datosProducto.put("cantidad", cantidad);
        datosProducto.put("precio", precio);
        datosProducto.put("iva", iva);

        productosMap.put(nombreProducto, datosProducto);

        JOptionPane.showMessageDialog(null, "Producto añadido correctamente.");
    }

    private static void verificarStockBajo() {
        for (Map.Entry<String, Map<String, Object>> entry : productosMap.entrySet()) {
            String producto = entry.getKey();
            int cantidad = (int) entry.getValue().get("cantidad");
            if (cantidad <= 3) {
                JOptionPane.showMessageDialog(null, "¡Stock bajo de " + producto + "! La cantidad es " + cantidad + ".");
            }
        }
    }

    public static void baseDeDatos() {
        // Aquí se cargan los datos de productos iniciales en la base de datos
        agregarProducto("Camiseta AS", 50, 18.00, 21);
        agregarProducto("Gorras", 20, 16.00, 21);
    }

    private static void agregarProducto(String nombre, int cantidad, double precio, double iva) {
        Map<String, Object> datosProducto = new HashMap<>();
        datosProducto.put("cantidad", cantidad);
        datosProducto.put("precio", precio);
        datosProducto.put("iva", iva);
        productosMap.put(nombre, datosProducto);
    }
}
