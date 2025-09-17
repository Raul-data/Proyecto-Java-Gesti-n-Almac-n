// Complejidad de 0(1) en todos sus metodos
public class Producto {
    private String codigoProducto;
    private String nombreProducto;
    private double precio;
    private Categoria categoria;
    private int stockActual;

    //Constructor
    public Producto(String codigoProducto, String nombreProducto, double precio, Categoria categoria, int stockActual) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.stockActual = stockActual;
    }

    //Getters
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getStockActual() {
        return stockActual;
    }

    //Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    //Valor total del stock
    public double valorTotalStock(){
        return precio*stockActual;
    }

    //toString
    @Override
    public String toString() {
        return "Producto{" +
                "Codigo ='" + codigoProducto + '\'' +
                ", nombre='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", stock=" + stockActual +
                '}';
    }
}
