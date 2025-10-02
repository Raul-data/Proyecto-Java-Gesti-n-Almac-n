public class Main {
    public static void main(String[] args) {
    Inventario tienda = new Inventario("COMPONENT");

    //Agregamos productos
        Producto p1 = new Producto("P001", "Laptop Dell", 800.0, Categoria.LAPTOP, 5);
        Producto p2 = new Producto("P002", "iPhone", 1200.0, Categoria.SMARTPHONE, 10);
        Producto p3 = new Producto("P003", "PS5", 600.0, Categoria.GAME, 3);
        Producto p4 = new Producto("P004", "HP Pavilion", 700.0, Categoria.LAPTOP, 6);
        Producto p5 = new Producto("P005", "Samsung Galaxy S23", 850.0, Categoria.SMARTPHONE, 9);
        Producto p6 = new Producto("P006", "Xbox Series X", 500.0, Categoria.GAME, 4);
        Producto p7 = new Producto("P007", "Lenovo ThinkPad", 1100.0, Categoria.LAPTOP, 3);
        Producto p8 = new Producto("P008", "OnePlus 12", 950.0, Categoria.SMARTPHONE, 8);
        Producto p9 = new Producto("P009", "Asus ROG", 1300.0, Categoria.LAPTOP, 5);
        Producto p10 = new Producto("P010", "PlayStation VR2", 550.0, Categoria.GAME, 7);


        tienda.agregarProducto(p1);
        tienda.agregarProducto(p2);
        tienda.agregarProducto(p3);

//        //Agregar productos duplicado(Que lo sobrescribe)
//        tienda.agregarProducto(new Producto("P001", "Laptop HP", 900.0, Categoria.LAPTOP, 4));

           //Consultar precio que no existe
//        System.out.println(tienda.consultarProducto("P999"));
//
////        //Añadir stock de producto inexistente
//        tienda.actualizarStock("P999", 5);
//
//        //Venta normal
//        tienda.venderProducto("P003", 10);
//
//        //Venta de stock insuficiente
//        tienda.venderProducto("P003", 10);
//
//        //Buscar por categoria
//        System.out.println("Productos en categoria LAPTOP: " + tienda.productosPorCategoria(Categoria.LAPTOP));
//
//        //inventario completo
//        tienda.mostrarInventario();
    }
}