import java.util.HashMap;

public class ShoppingCart {
    //Amacenar nombre de producto y cantidad
    private HashMap<String, Integer> cart;
    //Almacenar nombre de producto y precio
    private HashMap<String, Double> prices;

    //Constructor
    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.prices = new HashMap<>();

        //inicializamos algunos productos y sus precios
        this.prices.put("manzana" , 0.50);
        this.prices.put("platano", 0.30);
        this.prices.put("naranja", 0.60);
        this.prices.put("leche", 2.50);
        this.prices.put("pan", 1.50);
    }

    //----------Metodos a implementar----------
    //Añadir producto al carrito
    public void addProduct(String product, int quantity){
        if(!prices.containsKey(product)){
            System.out.println("Producto no disponible en la tienda");
            return;
        }
        if(quantity <= 0){
            System.out.println("Erro: La cantidad debe ser mayor a 0");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0)+quantity);
        System.out.println("Añadido: " + quantity + " cantidad de " + product );
    }

    //Eliminar producto del carrito
    public void removeProduct(String product){
        if(!cart.containsKey(product)){
            System.out.println("el producto '" + product + "' no esta en el carrito");
            return;
        }
        cart.remove(product);
        System.out.println("Eliminado: " +  product + " del carrito");
    }

    //Actualizar cantidad del producto
    public void updateQuantity(String product, int newQuantity){
        if(!cart.containsKey(product)){
            System.out.println("Error: El producto " + product + " no esta en el carrito");
            return;
        }
        if(newQuantity <= 0){
            cart.remove(product);
            System.out.println("Eliminado: " +  product + " del carrito porque la cantidad es <= 0");
            return;
        }
        cart.put(product, newQuantity);
        System.out.println("Actualizado: " +  product + " a " + newQuantity + " unidad(es)");
    }

    //mostrar carrito
    public void displayCart(){
        if(cart.isEmpty()){
            System.out.println("El carrito esta vacio");
            return;
        }

        System.out.println("\nContenido del carrito");
        for(String product : cart.keySet()){
            int quantity = cart.get(product);
            double unitPrice = prices.get(product);
            double totalPrice = unitPrice * quantity;
            System.out.printf("%s: %d unidad(es) x %.2f€ = %.2f€\n", product, quantity, unitPrice, totalPrice);
        }
        double total = calculateTotal();
        System.out.printf("Total: %.2f€\n", total);
    }

    //calcular total del carrito(con descuento si > 20%)
    private double calculateTotal(){
        double total = 0.0;
        for(String product : cart.keySet()){
            int quantity = cart.get(product);
            double unitPrice = prices.get(product);
            total += unitPrice * quantity;
        }
        //aplicar 10% de descuento si el total es mayor a 20€
        if(total > 20.0){
            total *= 0.9; //10% de descuento
            System.out.println("Descuento del 10% aplicado (total > 20€");
        }
        //redondear a 2 decimales
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }
}
