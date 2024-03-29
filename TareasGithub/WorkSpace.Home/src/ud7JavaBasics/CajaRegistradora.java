package ud7JavaBasics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class CajaRegistradora {

    private static final String ADMIN_PASSWORD = "CajaR";

    protected static Map<String, Map<String, Object>> stockProductos = new HashMap<>();
    protected static Map<String, Integer> carrito = new HashMap<>();
    protected static Map<String, Integer> ventas = new HashMap<>();
    protected static double ivaPorDefecto = 0.21; // IVA por defecto (21%)
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
    
    protected static void inicializarBaseDeDatos() {
        agregarProducto("Manzanas", 20, 2.5, ivaPorDefecto);
        agregarProducto("Plátanos", 15, 1.8, ivaPorDefecto);
        agregarProducto("Leche", 30, 1.2, ivaPorDefecto);
        agregarProducto("Pan", 25, 0.9, ivaPorDefecto);
        agregarProducto("Huevos", 40, 3.0, ivaPorDefecto);
        agregarProducto("Arroz", 50, 1.5, ivaPorDefecto);
        agregarProducto("Aceite", 35, 2.8, ivaPorDefecto);
        agregarProducto("Azúcar", 45, 1.0, ivaPorDefecto);
        agregarProducto("Sal", 40, 0.8, ivaPorDefecto);
        agregarProducto("Café", 20, 4.0, ivaPorDefecto);
        // Añade más productos aquí si es necesario
    }

    protected static void agregarProducto(String nombre, int cantidad, double precio, double ivaProducto) {
        Map<String, Object> productoInfo = new HashMap<>();
        productoInfo.put("cantidad", cantidad);
        productoInfo.put("precio", precio);
        productoInfo.put("iva", ivaProducto);
        stockProductos.put(nombre, productoInfo);
    }

    protected static void listarProductosConIVA() {
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("--- Productos Disponibles ---\n");
        for (Map.Entry<String, Map<String, Object>> entry : stockProductos.entrySet()) {
            String nombreProducto = entry.getKey();
            Map<String, Object> productoInfo = entry.getValue();
            int cantidad = (int) productoInfo.get("cantidad");
            double precio = (double) productoInfo.get("precio");
            double ivaProducto = (double) productoInfo.get("iva");
            double precioIVA = precio * (1 + ivaProducto); // Calcular precio con IVA
            listaProductos.append(nombreProducto).append(" - Cantidad: ").append(cantidad)
                    .append(", Precio con IVA: €").append(String.format("%.2f", precioIVA)).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProductos.toString());
    }

    protected static void comprarProducto() {
    	 String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto que desea comprar:");
         if (nombreProducto == null) {
             return;
         }

         if (!stockProductos.containsKey(nombreProducto)) {
             JOptionPane.showMessageDialog(null, "Producto no encontrado.");
             return;
         }

         Map<String, Object> productoInfo = stockProductos.get(nombreProducto);
         int cantidadDisponible = (int) productoInfo.get("cantidad");

         String cantidadCompraStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad que desea comprar:");
         if (cantidadCompraStr == null) {
             return;
         }
         int cantidadCompra;
         try {
             cantidadCompra = Integer.parseInt(cantidadCompraStr);
         } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Cantidad no válida.");
             return;
         }

         if (cantidadCompra <= 0 || cantidadCompra > cantidadDisponible) {
             JOptionPane.showMessageDialog(null, "Cantidad no válida o insuficiente stock.");
             return;
         }

         carrito.put(nombreProducto, carrito.getOrDefault(nombreProducto, 0) + cantidadCompra);
         JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
     }

     protected static void realizarVenta() {
         if (carrito.isEmpty()) {
             JOptionPane.showMessageDialog(null, "El carrito está vacío. No se puede realizar la venta.");
             return;
         }

         double totalVenta = 0.0;
         for (Map.Entry<String, Integer> entry : carrito.entrySet()) {
             String nombreProducto = entry.getKey();
             int cantidadCompra = entry.getValue();
             Map<String, Object> productoInfo = stockProductos.get(nombreProducto);
             double precio = (double) productoInfo.get("precio");
             totalVenta += precio * cantidadCompra;
             int cantidadDisponible = (int) productoInfo.get("cantidad");
             productoInfo.put("cantidad", cantidadDisponible - cantidadCompra); // Descuenta el stock

             // Registrar la venta
             ventas.put(nombreProducto, ventas.getOrDefault(nombreProducto, 0) + cantidadCompra);
         }

         JOptionPane.showMessageDialog(null, "Total a pagar: €" + totalVenta);

         String cantidadPagadaStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad pagada por el cliente:");
         if (cantidadPagadaStr == null) {
             return;
         }
         double cantidadPagada;
         try {
             cantidadPagada = Double.parseDouble(cantidadPagadaStr);
         } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Cantidad no válida.");
             return;
         }

         double cambio = cantidadPagada - totalVenta;
         if (cambio >= 0) {
             JOptionPane.showMessageDialog(null, "Cambio a devolver: €" + cambio);
             carrito.clear(); // Vaciar el carrito después de la venta exitosa
         } else {
             JOptionPane.showMessageDialog(null, "Cantidad insuficiente. Venta cancelada.");
         }
     }

    protected static void modoAdmin() {
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña de administrador:");
        if (password == null || !password.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No tiene acceso al modo administrador.");
            return;
        }

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "---- Modo Administrador ----\n" +
                            "1. Ver total de ventas\n" +
                            "2. Editar lista de productos\n" +
                            "3. Ver/Modificar IVA aplicado a los productos\n" +
                            "4. Salir del modo administrador\n" +
                            "Seleccione una opción:");
            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    verTotalVentas();
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

    protected static void verModificarIVA() {
        String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:");
        if (nombreProducto == null || !stockProductos.containsKey(nombreProducto)) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        String opcion = JOptionPane.showInputDialog(null,
                "---- IVA Aplicado al Producto ----\n" +
                        "1. Ver IVA aplicado\n" +
                        "2. Modificar IVA\n" +
                        "Seleccione una opción:");

        if (opcion == null) {
            return;
        }

        switch (opcion) {
            case "1":
                double ivaProducto = (double) stockProductos.get(nombreProducto).get("iva");
                JOptionPane.showMessageDialog(null, "El IVA aplicado al producto " + nombreProducto + " es: " + (ivaProducto * 100) + "%");
                break;
            case "2":
                modificarIVAProducto(nombreProducto);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }

    protected static void modificarIVAProducto(String nombreProducto) {
        String nuevoIVA = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor del IVA (en decimal):");
        if (nuevoIVA == null) {
            return;
        }
        try {
            double nuevoValorIVA = Double.parseDouble(nuevoIVA);
            stockProductos.get(nombreProducto).put("iva", nuevoValorIVA);
            JOptionPane.showMessageDialog(null, "IVA del producto " + nombreProducto + " modificado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor de IVA no válido.");
        }
    }

    protected static void editarProductos() {
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
    
    protected static void agregarProductoAdmin() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo producto:");
        if (nombre == null) {
            return; // Cancelar la operación si se cierra la ventana
        }
        String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad del nuevo producto:");
        if (cantidadStr == null) {
            return; // Cancelar la operación si se cierra la ventana
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }
        String precioStr = JOptionPane.showInputDialog(null, "Ingrese el precio del nuevo producto:");
        if (precioStr == null) {
            return; // Cancelar la operación si se cierra la ventana
        }
        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio no válido.");
            return;
        }
        agregarProducto(nombre, cantidad, precio, ivaPorDefecto);
        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
    }
    protected static void eliminarProductoAdmin() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto que desea eliminar:");
        if (nombre == null) {
            return;
        }
        if (stockProductos.containsKey(nombre)) {
            stockProductos.remove(nombre);
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe en la lista.");
        }
    }

    protected static void verificarStockBajo() {
        for (Map.Entry<String, Map<String, Object>> entry : stockProductos.entrySet()) {
            String producto = entry.getKey();
            int cantidad = (int) entry.getValue().get("cantidad");
            if (cantidad <= 3) {
                JOptionPane.showMessageDialog(null, "¡Stock bajo de " + producto + "! La cantidad es " + cantidad + ".");
            }
        }
    }
    protected static void listarProductos() {
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("--- Productos Disponibles ---\n");
        for (Map.Entry<String, Map<String, Object>> entry : stockProductos.entrySet()) {
            String nombreProducto = entry.getKey();
            Map<String, Object> productoInfo = entry.getValue();
            int cantidad = (int) productoInfo.get("cantidad");
            double precio = (double) productoInfo.get("precio");
            listaProductos.append(nombreProducto).append(" - Cantidad: ").append(cantidad).append(", Precio: €").append(precio).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProductos.toString());
    }  
    protected static void verTotalVentas() {
        StringBuilder totalVentas = new StringBuilder();
        totalVentas.append("--- Total de Ventas ---\n");
        for (Map.Entry<String, Integer> entry : ventas.entrySet()) {
            String producto = entry.getKey();
            int cantidadVendida = entry.getValue();
            totalVentas.append(producto).append(": ").append(cantidadVendida).append(" unidades\n");
        }
        JOptionPane.showMessageDialog(null, totalVentas.toString());
    }
}