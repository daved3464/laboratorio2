package laboratorio2.productos;

import laboratorio2.excepciones.EmptyStringException;
import lombok.Getter;
import lombok.Setter;

public class Producto {

  public static enum TipoProducto {
    NACIONAL, INTERNACIONAL
  }

  @Getter
  private int index;

  @Getter
  private String nombre;

  @Getter
  private int valor;

  @Getter
  private int cantidad;

  @Getter
  @Setter
  private TipoProducto tipo;

  public Producto(int index, String nombre, int valor, int cantidad, TipoProducto tipo)
      throws EmptyStringException, IndexOutOfBoundsException, Exception {
    this.setIndex(index);
    this.setNombre(nombre);
    this.setValor(valor);
    this.setCantidad(cantidad);
    this.setTipo(tipo);


  }

  public void setIndex(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();

    this.index = index;
  }

  public void setNombre(String nombre) throws EmptyStringException {
    if (nombre.isEmpty() || nombre == null)
      throw new EmptyStringException("El nombre del producto no puede estar vacío");

    this.nombre = nombre;
  }

  public void setValor(int valor) throws Exception {
    if (valor <= 0)
      throw new Exception("El valor debe ser mayor a 0");

    this.valor = valor;
  }

  public void setCantidad(int cantidad) throws Exception {
    if (cantidad <= 0)
      throw new Exception("La cantidad debe ser mayor a 0");

    this.cantidad = cantidad;
  }

}
