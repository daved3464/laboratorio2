package laboratorio2.productos;

import java.util.List;
import laboratorio2.productos.Producto;
import laboratorio2.excepciones.*;
import laboratorio2.productos.Producto.TipoProducto;

public class Inventario {
  private List<Producto> Productos;

  public Inventario() {
  }

  // Create
  public void registrarProducto(String nombre, int valor, int cantidad, TipoProducto tipo)
          throws Exception {

    // Excepción de limitación de Java
    if (this.Productos.size() == Integer.MAX_VALUE)
      throw new ListMaxIndexOutOfBoundsException();

    // Añadir Producto
    this.Productos.add(new Producto(this.Productos.size(), nombre, valor, cantidad, tipo));
  }

  // Read one, search by index
  public Producto obtenerProducto(int index) {
    return this.Productos.get(index);
  }

  // Read many, filter by name
  public Producto[] obtenerProductosPorNombre(String nombre) {
    return (Producto[]) this.Productos.stream().filter(p -> p.getNombre() == nombre).toArray();
  }

  // Read all
  public Producto[] obtenerProductos() {
    return (Producto[]) this.Productos.toArray();
  }

  // Update
  public void actualizarProducto(int index, String nombre) throws EmptyStringException {
    Producto Producto = this.obtenerProducto(index);
    Producto.setNombre(nombre);

    this.Productos.set(index, Producto);
  }

  // Delete
  public void eliminarProducto(int index) {
    this.Productos.remove(index);
  }
}
