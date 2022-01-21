package laboratorio2.cartera;

import laboratorio2.productos.Inventario;

public class Venta extends Transaccion{

    int valorIVA;
    int valorDescuento;

    public static enum formaPago {

    };

    String cliente;

    @Override
    public int calcularValor() {
        return 0;
    }

    public void descontarproductos(Inventario inventario){

    }
}
