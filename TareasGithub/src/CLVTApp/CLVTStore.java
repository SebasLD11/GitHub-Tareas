package CLVTApp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CLVTStore {
    private static final String CONTRASEÑA = "admin123";

    public static void main(String[] args) {
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Camiseta Asociad@", 19.99, 35, 21));
        catalogo.add(new Producto("Gorra Green Olive", 14.99, 10, 21));
        catalogo.add(new Producto("Gorra Gris", 14.99, 10, 21));
        catalogo.add(new Producto("Sudadera Gris", 39.99, 15, 21));
        catalogo.add(new Producto("Sudadera Negro", 39.99, 15, 21));
        catalogo.add(new Producto("Sudadera Navy",  39.99, 10, 21));
        catalogo.add(new Producto("Loto Candle: modelo 'Fire'", 14.99, 25, 21));
        catalogo.add(new Producto("Loto Candle: modelo 'Purple'", 54.99, 25, 21));
        catalogo.add(new Producto("Tabla de Skate CLVT ONE", 54.99, 25, 21));
        catalogo.add(new Producto("Brain Pocket Wax (para Skate/Scooter)", 6.95, 20, 21));

        List<Producto> carrito = new ArrayList<>();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null, "~~~ CLVT STORE ~~~\n" + "1. Catalogo \n"
                    + "2. Comprar producto\n" + "3. Modo Admin\n" + "4. Salir\n" + "Seleccione una opción:");

            if (opcion == null) {
                return;
            }

            switch (opcion) {
                case "1":
                    mostrarProductos(catalogo);
                    break;
                case "2":
                    comprarProductos(catalogo, carrito);
                    break;
                case "3":
                    String password = JOptionPane.showInputDialog("Ingrese la contraseña de administrador:");
                    if (password != null && password.equals(CONTRASEÑA)) {
                        modoAdmin(catalogo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Inténtelo de nuevo.");
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarProductos(List<Producto> catalogo) {
        StringBuilder productosInfo = new StringBuilder();
        productosInfo.append("Lista de productos:\n");
        productosInfo.append("---Catálogo del Supermercado---\n");
        productosInfo.append("----------------------------------------------\n");
        for (Producto producto : catalogo) {
            if (producto.getCantidadDisponible() > 0) {
                productosInfo.append(producto.getNombre()).append("   ").append(formatoDosDecimales(producto.getPrecio())).append("€  ")
                        .append("IVA del ").append(producto.getIva()).append("% aplicado").append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, productosInfo.toString());
    }

    private static void comprarProductos(List<Producto> catalogo, List<Producto> carrito) {
        while (true) {
            String opcion2 = JOptionPane.showInputDialog(null,
                    "---- Cesta Compra ----\n" + "1. Añadir Producto \n" + "2. Eliminar producto del carrito\n"
                            + "3. Ver Cesta\n" + "4. Realizar Compra\n" + "5. Volver al Menú Principal\n"
                            + "Seleccione una opción:");

            if (opcion2 == null) {
                return;
            }

            switch (opcion2) {
                case "1":
                    añadirProductoAlCarrito(catalogo, carrito);
                    break;
                case "2":
                    eliminarProductoDelCarrito(carrito);
                    break;
                case "3":
                    mostrarCarrito(carrito);
                    break;
                case "4":
                    realizarCompra(carrito);
                    break;
                case "5":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void añadirProductoAlCarrito(List<Producto> catalogo, List<Producto> carrito) {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a agregar al carrito:");

        Producto productoEnCatalogo = null;
        for (Producto producto : catalogo) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEnCatalogo = producto;
                break;
            }
        }

        if (productoEnCatalogo != null) {
            int cantidadAgregar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a agregar:"));

            if (productoEnCatalogo.getCantidadDisponible() >= cantidadAgregar) {
                carrito.add(new Producto(productoEnCatalogo.getNombre(), productoEnCatalogo.getPrecio(),
                        cantidadAgregar, productoEnCatalogo.getIva()));
                productoEnCatalogo.setCantidadDisponible(productoEnCatalogo.getCantidadDisponible() - cantidadAgregar);
                JOptionPane.showMessageDialog(null,
                        "Se han añadido " + cantidadAgregar + " unidades de " + nombreProducto + " al carrito.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "No hay suficiente cantidad disponible de " + nombreProducto + " en el catálogo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto ingresado no existe en el catálogo.");
        }
        for (Producto producto : catalogo) {
            if (producto.stockBajo()) {
                JOptionPane.showMessageDialog(null, "¡Atención! El producto '" + producto.getNombre() + "' tiene un stock bajo: 5 unidades restantes.");
            }
}
}

    private static void eliminarProducto(List<Producto> catalogo) {
        if (catalogo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El catálogo está vacío.");
            return;
        }

        StringBuilder opcionesProductos = new StringBuilder();
        opcionesProductos.append("Seleccione el producto que desea eliminar:\n");
        for (int i = 0; i < catalogo.size(); i++) {
            opcionesProductos.append(i + 1).append(". ").append(catalogo.get(i).getNombre()).append("\n");
        }

        String input = JOptionPane.showInputDialog(null,
                opcionesProductos.toString() + "Ingrese el número del producto que desea eliminar:");
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        int indiceEliminar = Integer.parseInt(input.trim()) - 1;

        if (indiceEliminar < 0 || indiceEliminar >= catalogo.size()) {
            JOptionPane.showMessageDialog(null, "Número de producto no válido.");
            return;
        }

        Producto producto = catalogo.get(indiceEliminar);
        int cantidadEliminar = Integer.parseInt(JOptionPane
                .showInputDialog("Ingrese la cantidad que desea eliminar del producto " + producto.getNombre() + ":"));

        if (cantidadEliminar <= 0 || cantidadEliminar > producto.getCantidadDisponible()) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }

        if (cantidadEliminar == producto.getCantidadDisponible()) {
            catalogo.remove(indiceEliminar);
            JOptionPane.showMessageDialog(null,
                    "Se ha eliminado el producto " + producto.getNombre() + " del catálogo.");
        } else {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidadEliminar);
            JOptionPane.showMessageDialog(null,
                    "Se han eliminado " + cantidadEliminar + " unidades del producto " + producto.getNombre() + ".");
        }
    }

    private static void modoAdmin(List<Producto> catalogo) {
        while (true) {
            String opcion3 = JOptionPane.showInputDialog(null,
                    "---- Modo Administrador ----\n" + "1. Ver total productos \n" + "2. Agregar productos\n"
                            + "3. Eliminar productos\n" + "4. Modificar IVA del producto\n" + "5. Ver total de ventas\n"
                            + "6. Salir modo administrador\n" + "Seleccione una opción:");

            if (opcion3 == null) {
                return;
            }
            switch (opcion3) {
                case "1":
                    vertotalProductos(catalogo);
                    break;
                case "2":
                    agregarProductos(catalogo);
                    break;
                case "3":
                    eliminarProducto(catalogo);
                    break;
                case "4":
                    modificarIvaProducto(catalogo);
                    break;
                case "5":
                    verTotalVentas();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void vertotalProductos(List<Producto> catalogo) {
        StringBuilder totalProductos = new StringBuilder();
        totalProductos.append("Total de productos disponibles:\n");
        totalProductos.append("---Catálogo del Supermercado---\n");
        totalProductos.append("----------------------------------------------\n");
        for (Producto producto : catalogo) {
            totalProductos.append(producto.getNombre()).append("   ").append(formatoDosDecimales(producto.getPrecio())).append("€  ")
                    .append("Cantidad: ").append(producto.getCantidadDisponible()).append("  ").append("IVA del ")
                    .append(producto.getIva()).append("% aplicado").append("\n");
        }
        JOptionPane.showMessageDialog(null, totalProductos.toString());
        for (Producto producto : catalogo) {
            if (producto.stockBajo()) {
                JOptionPane.showMessageDialog(null, "¡Atención! El producto '" + producto.getNombre() + "' tiene un stock bajo: 5 unidades restantes.");
            }
        }
    }

    private static void agregarProductos(List<Producto> catalogo) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del nuevo producto:"));
        int cantidad = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del nuevo producto:"));
        int iva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del IVA del nuevo producto:"));

        Producto nuevoProducto = new Producto(nombre, precio, cantidad, iva);
        catalogo.add(nuevoProducto);

        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
    }

    private static void modificarIvaProducto(List<Producto> catalogo) {
        if (catalogo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El catálogo está vacío.");
            return;
        }

        StringBuilder opcionesProductos = new StringBuilder();
        opcionesProductos.append("Seleccione el producto al que desea modificar el IVA:\n");
        for (int i = 0; i < catalogo.size(); i++) {
            opcionesProductos.append(i + 1).append(". ").append(catalogo.get(i).getNombre()).append("\n");
        }

        String input = JOptionPane.showInputDialog(null, opcionesProductos.toString()
                + "Ingrese el número del producto al que desea modificar el IVA:");
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        int indiceModificar = Integer.parseInt(input.trim()) - 1;

        if (indiceModificar < 0 || indiceModificar >= catalogo.size()) {
            JOptionPane.showMessageDialog(null, "Número de producto no válido.");
            return;
        }

        Producto producto = catalogo.get(indiceModificar);
        int nuevoIva = Integer.parseInt(JOptionPane
                .showInputDialog("Ingrese el nuevo valor del IVA para el producto " + producto.getNombre() + ":"));

        producto.setmodificarIva(nuevoIva);
    }

    private static void verTotalVentas() {
        StringBuilder ventasInfo = new StringBuilder();
        ventasInfo.append("Total de ventas realizadas:\n");
        ventasInfo.append("----------------------------------------------\n");
        double totalVentas = Producto.getTotalVentas(); // Accedemos al campo estático de Producto
        for (String informacionVenta : Producto.getInformacionVentas()) {
            ventasInfo.append(informacionVenta).append("\n");
        }
        ventasInfo.append("----------------------------------------------\n");
        ventasInfo.append("Total en ventas: ").append(formatoDosDecimales(totalVentas)).append("€");
        JOptionPane.showMessageDialog(null, ventasInfo.toString());
    }

    private static double calcularPrecioTotal(List<Producto> carrito) {
        double precioTotal = 0;
        for (Producto producto : carrito) {
            precioTotal += producto.getPrecio() * producto.getCantidadDisponible();
        }
        return precioTotal;
    }

    private static double formatoDosDecimales(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    private static void eliminarProductoDelCarrito(List<Producto> carrito) {
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío.");
            return;
        }

        StringBuilder productosEnCarrito = new StringBuilder("Productos en el carrito:\n");
        for (int i = 0; i < carrito.size(); i++) {
            Producto producto = carrito.get(i);
            productosEnCarrito.append(i + 1).append(". ").append(producto.getNombre()).append(" - Cantidad: ")
                    .append(producto.getCantidadDisponible()).append("\n");
        }

        int numeroProductoEliminar = Integer.parseInt(JOptionPane
                .showInputDialog(productosEnCarrito.toString() + "Ingrese el número del producto que desea eliminar:"));

        if (numeroProductoEliminar >= 1 && numeroProductoEliminar <= carrito.size()) {
            Producto productoEliminado = carrito.remove(numeroProductoEliminar - 1);
            JOptionPane.showMessageDialog(null, "Se ha eliminado " + productoEliminado.getNombre() + " del carrito.");
        } else {
            JOptionPane.showMessageDialog(null, "Número de producto no válido.");
        }
    }

    private static void mostrarCarrito(List<Producto> carrito) {
        StringBuilder carritoInfo = new StringBuilder();
        carritoInfo.append("Contenido de la cesta:\n");
        carritoInfo.append("----------------------------------------------\n");
        for (Producto producto : carrito) {
            carritoInfo.append(producto.getNombre()).append("   ").append(formatoDosDecimales(producto.getPrecio())).append("€  ")
                    .append("Cantidad: ").append(producto.getCantidadDisponible()).append("\n");
        }
        JOptionPane.showMessageDialog(null, carritoInfo.toString());
}

    private static void realizarCompra(List<Producto> carrito) {
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío. No se puede realizar la compra.");
            return;
        }

        String metodoPago = JOptionPane.showInputDialog(null, "Seleccione el método de pago (tarjeta/efectivo):");

        if (metodoPago != null) {
            metodoPago = metodoPago.toLowerCase();

            if (metodoPago.equals("tarjeta")) {
                JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito.");
                for (Producto producto : carrito) {
                    Producto.registrarVenta(producto.getPrecio() * producto.getCantidadDisponible(), producto, producto.getCantidadDisponible());
                }
                carrito.clear();
            } else if (metodoPago.equals("efectivo")) {
                double precioTotal = calcularPrecioTotal(carrito);
                JOptionPane.showMessageDialog(null, "El precio total del carrito es: " + formatoDosDecimales(precioTotal) + "€");

                double cantidadPagada = Double
                        .parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad con la que desea pagar:"));
                double cambio = cantidadPagada - precioTotal;
                if (cambio >= 0) {
                    JOptionPane.showMessageDialog(null, "Gracias por su compra. Su cambio es: " + formatoDosDecimales(cambio) + "€");
                    for (Producto producto : carrito) {
                        Producto.registrarVenta(producto.getPrecio() * producto.getCantidadDisponible(), producto, producto.getCantidadDisponible());
                    }
                    carrito.clear();
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad insuficiente para pagar.");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Método de pago no válido. Por favor, seleccione 'tarjeta' o 'efectivo'.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún método de pago. La compra se canceló.");
        } 
    }
}