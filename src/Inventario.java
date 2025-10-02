import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Complejidad general: la mayoría de métodos son O(n)

public class Inventario {
    private String nombreTienda;
    private ArrayList<Producto> productos;

    //Esto es con HashMap
//    private HashMap<String, Producto> productos;

    //Constructor -> 0(1)
    public Inventario(String nombreTienda) {
        this.nombreTienda = nombreTienda;

        //Esto es arrayList
        this.productos = new ArrayList<>();
        //Esto es con HashMap
//        this.productos = new HashMap<String, Producto>();
    }

    // Agregar producto -> O(1) promedio
    public void agregarProducto(Producto producto) {
        productos.add(producto);

        //Esto es con HashMap
//        productos.put(producto.getCodigoProducto(), producto);
    }

//esto es lo de javadoc
    /**
     *
     * @param codigoProducto
     * @param cantidad
     */
    // Actualizar o añadir stock -> O(n)
    public void actualizarStock(String codigoProducto, int cantidad) {

        //Esto es arrayList
        //cambiar este for con un while(como opcion)
        for (Producto producto : productos) {
            if (producto.getCodigoProducto().equals(codigoProducto)) {
                producto.setStockActual(producto.getStockActual() + cantidad);
                System.out.println("Stock Actual: " + producto.getStockActual() + " con el codigo: " + codigoProducto);
                return;
            }
        }
        System.out.println("No existe el producto con el codigo: " + codigoProducto);

        //Esto es con HashMap
//        Producto producto = productos.get(codigoProducto);
//        if(producto != null) {
//            producto.setStockActual(producto.getStockActual() + cantidad);
//            System.out.println("Stock Actual: " + producto.getStockActual() + "Con el codigo " + codigoProducto);
//        }else{
//            System.out.println("No existe el producto con el codigo "+codigoProducto);
//        }
    }

    // Vender producto -> O(n)
    public void venderProducto(String codigoProducto, int cantidad) {

        //Esto es arrayList
        for (Producto producto : productos) {
            if(producto.getCodigoProducto().equals(codigoProducto)) {
                if(producto.getStockActual() >= cantidad) {
                    producto.setStockActual(producto.getStockActual() - cantidad);
                    System.out.println("Venta de " + cantidad + " unidades de " + producto.getNombreProducto());
                }else {
                    System.out.println("No hay suficiente stock de " + producto.getNombreProducto());
                }
                return;
            }
        }
        System.out.println("Producto no encontrado");

        //Esto es con HashMap
//        Producto producto = productos.get(codigoProducto);
//        if(producto != null) {
//            if(producto.getStockActual() >= cantidad) {
//                producto.setStockActual(producto.getStockActual() - cantidad);
//                System.out.println("Venta de " + cantidad + " unidades de " + producto.getNombreProducto());
//            }else {
//                System.out.println("No hay suficiente stock de " + producto.getNombreProducto());
//            }
//        }else {
//            System.out.println("Producto no encontrado");
//        }
    }

    //Consulta de producto -> O(n)
    public Producto consultarProducto(String codigoProducto) {
        for(Producto producto : productos) {
            if(producto.getCodigoProducto().equals(codigoProducto)) {
                return producto;
            }
        }
        return null;

        //Esto es con HashMap
//        return productos.get(codigoProducto);
    }

    //Lista de producto por categoria -> O(n)
    public List<Producto> productosPorCategoria(Categoria categoria) {
        List<Producto> lista = new ArrayList<>();

        //Esto es arrayList
        for(Producto producto : productos) {
            if(producto.getCategoria() == categoria) {
                lista.add(producto);
            }
        }

        //Esto es con HashMap
//        for (Producto producto : productos.values()) {
//            if (producto.getCategoria().equals(categoria)) {
//                lista.add(producto);
//            }
//        }
        return lista;
    }

    //Valor total de inventario -> O(n)
    public double valorTotalInventario(){
        double total = 0.0;

        //Esto es arrayList
        for(Producto producto : productos) {
            total += producto.valorTotalStock();
        }

        //Esto es con HashMap
//        for (Producto producto : productos.values()) {
//            total += producto.valorTotalStock();
//        }
        return total;
    }

    //Mostrar inventario -> O(n)
    public void mostrarInventario(){
        System.out.println("Inventario de " + nombreTienda);
        double totalGeneral = 0.0;
        int totalProductos = 0;

        java.util.HashMap<Categoria, Double> valorPorCategoria = new java.util.HashMap<>();
        java.util.HashMap<Categoria, Integer> cantidadPorCategoria = new java.util.HashMap<>();

        //Esto es arrayList
        for (Producto producto : productos) {
            totalGeneral += producto.valorTotalStock();
            totalProductos += producto.getStockActual();

            valorPorCategoria.put(producto.getCategoria(),
                    valorPorCategoria.getOrDefault(producto.getCategoria(), 0.0)+producto.valorTotalStock());

            cantidadPorCategoria.put(producto.getCategoria(),
                    cantidadPorCategoria.getOrDefault(producto.getCategoria(), 0)+producto.getStockActual());
        }

        //Esto es con HashMap
//        HashMap<Categoria, Double> valorPorCategoria = new HashMap<>();
//        HashMap<Categoria, Integer> cantidadPorCategoria = new HashMap<>();
//
//        for(Producto producto : productos.values()){
//            totalGeneral += producto.valorTotalStock();
//            totalProductos += producto.getStockActual();
//
//            valorPorCategoria.put(producto.getCategoria(),
//                    valorPorCategoria.getOrDefault(producto.getCategoria(), 0.0) +  producto.valorTotalStock());
//
//            cantidadPorCategoria.put(producto.getCategoria(),
//                    cantidadPorCategoria.getOrDefault(producto.getCategoria(), 0) +  producto.getStockActual());
//        }

        for (Categoria categoria : Categoria.values()) {
            System.out.println("Categoria: " + categoria);
            System.out.println(" Stock total: " + cantidadPorCategoria.getOrDefault(categoria, 0));
            System.out.println(" Valor actual: " + valorPorCategoria.getOrDefault(categoria, 0.0));
        }

        System.out.println("Total de productos: " + totalProductos);
        System.out.println("Total valor inventario: " + totalGeneral);
    }
}
