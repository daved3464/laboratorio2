package laboratorio2.cartera;
import laboratorio2.productos.Inventario;
import laboratorio2.proveedores.Proveedor;
import java.util.List;

public class Compra extends Transaccion {

    private Proveedor proveedor;

    @Override
    public int calcularValor() {
        return 0;
    }

    public void registrarProductoInventario(Inventario inventario){}
}
