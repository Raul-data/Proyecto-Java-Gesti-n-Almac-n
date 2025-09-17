import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventario {
    private String nombreTienda;
    private HashMap<String, Producto> productos;

    public Inventario(String nombreTienda) {
        this.nombreTienda = nombreTienda;
        this.productos = new HashMap<String, Producto>();
    }

    //Agregar producto
    public void agregarProducto(Producto producto) {
        productos.put(producto.getCodigoProducto(), producto);
    }

    //Actualizar o añadir stock
    public void actualizarStock(String codigoProducto, int cantidad) {
        Producto producto = productos.get(codigoProducto);
        if(producto != null) {
            producto.setStockActual(producto.getStockActual() + cantidad);
            System.out.println("Stock Actual: " + producto.getStockActual() + "Con el codigo " + codigoProducto);
        }else{
            System.out.println("No existe el producto con el codigo "+codigoProducto);
        }
    }

    //Vender producto
    public void venderProducto(String codigoProducto, int cantidad) {
        Producto producto = productos.get(codigoProducto);
        if(producto != null) {
            if(producto.getStockActual() >= cantidad) {
                producto.setStockActual(producto.getStockActual() - cantidad);
                System.out.println("Venta de " + cantidad + " unidades de " + producto.getNombreProducto());
            }else {
                System.out.println("No hay suficiente stock de" + producto.getNombreProducto());
            }
        }else {
            System.out.println("Producto no encontrado");
        }
    }

    //Consulta de producto
    public Producto consultarProducto(String codigoProducto) {
        return productos.get(codigoProducto);
    }

    //Lista de producto por categoria
    public List<Producto> productosPorCategoria(Categoria categoria) {
        List<Producto> lista = new ArrayList<>();
        for (Producto producto : productos.values()) {
            if (producto.getCategoria() ==  categoria) {
                lista.add(producto);
            }
        }
        return lista;
    }

    //Valor total de inventario
    public double valorTotalInventario(){
        double total = 0;
        for (Producto producto : productos.values()) {
            total += producto.valorTotalStock();
        }
        return total;
    }

    //Mostrar inventario
    public void mostrarInventario(){
        System.out.println("Inventario de " + nombreTienda);
        double totalGeneral = 0;
        int totalProductos = 0;

        HashMap<Categoria, Double> valorPorCategoria = new HashMap<>();
        HashMap<Categoria, Integer> cantidadPorCategoria = new HashMap<>();

        for(Producto producto : productos.values()){
            totalGeneral += producto.valorTotalStock();
            totalProductos += producto.getStockActual();

            valorPorCategoria.put(producto.getCategoria(),
                    valorPorCategoria.getOrDefault(producto.getCategoria(), 0.0) +  producto.valorTotalStock());

            cantidadPorCategoria.put(producto.getCategoria(),
                    cantidadPorCategoria.getOrDefault(producto.getCategoria(), 0) +  producto.getStockActual());
        }

        for (Categoria categoria : Categoria.values()) {
            System.out.println("Categoria: " + categoria);
            System.out.println(" Stock total: " + cantidadPorCategoria.getOrDefault(categoria, 0));
            System.out.println(" Valor actual: " + valorPorCategoria.getOrDefault(categoria, 0.0));
        }

        System.out.println("Total de productos: " + totalProductos);
        System.out.println("Total valor inventario: " + totalGeneral);
    }
}
