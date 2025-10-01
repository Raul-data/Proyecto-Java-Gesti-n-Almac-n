//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        //Creamos el carrito
        ShoppingCart cart = new ShoppingCart();

        //añadimos productos validos
        cart.addProduct("manzana" , 3);
        cart.addProduct("leche", 2);
        cart.addProduct("pan" , 1);
        cart.displayCart();

        //Actualizamos cantidad
        cart.updateQuantity("manzana" , 5);

        //Eliminamos el producto
        cart.removeProduct("pan");
        cart.displayCart();

        //Intentamos añadir un producto que no está en la tienda
        cart.addProduct("chocolate", 1);

        //Añadimos otro producto valido
        cart.addProduct("naranja", 10);
        cart.displayCart();
    }
}