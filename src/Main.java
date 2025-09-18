public class Main {
    public static void main(String[] args) {
    Inventario tienda = new Inventario("COMPONENT");

    //Agregamos productos
        Producto p1 = new Producto("P001", "Laptop Dell", 800.0, Categoria.LAPTOP, 5);
        Producto p2 = new Producto("P002", "iPhone", 1200.0, Categoria.SMARTPHONE, 10);
        Producto p3 = new Producto("P003", "PS5", 600.0, Categoria.GAME, 3);


        tienda.agregarProducto(p1);
        tienda.agregarProducto(p2);
        tienda.agregarProducto(p3);

        //Agregar productos duplicado(Que lo sobrescribe)
        tienda.agregarProducto(new Producto("P001", "Laptop HP", 900.0, Categoria.LAPTOP, 4));

        //Consultar precio que no existe
        System.out.println(tienda.consultarProducto("P999"));

        //Añadir stock de producto inexistente
        tienda.actualizarStock("P999", 5);

        //Venta normal
        tienda.venderProducto("P003", 10);

        //Venta de stock insuficiente
        tienda.venderProducto("P003", 10);

        //Buscar por categoria
        System.out.println("Productos en categoria LAPTOP: " + tienda.productosPorCategoria(Categoria.LAPTOP));

        //inventario completo
        tienda.mostrarInventario();
    }
}