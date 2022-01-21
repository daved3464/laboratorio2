package laboratorio2.cartera;

import laboratorio2.productos.Producto;

import java.util.List;

public abstract class Transaccion {

    protected int valor;
    protected int netopagar;
    protected List<Producto>productos;

    public void añadirproducto(Producto producto)
    {
        this.productos.add(producto);
    }
    public abstract int calcularValor();


}
