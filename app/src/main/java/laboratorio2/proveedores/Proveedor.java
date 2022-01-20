package laboratorio2.proveedores;

import laboratorio2.excepciones.EmptyStringException;
import lombok.Getter;

public class Proveedor {
    @Getter
    private int index;

    @Getter
    private String Nombre;


    public Proveedor(String nombre) throws EmptyStringException {
        this.setNombre(nombre);
    }

    public Proveedor(int index, String nombre)
            throws EmptyStringException,
            IndexOutOfBoundsException {
        this.setIndex(index);
        this.setNombre(nombre);
    }

    public void setIndex(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        this.index = index;
    }

    public void setNombre(String nombre) throws EmptyStringException {
        if (nombre.isEmpty() || nombre == null)
            throw new EmptyStringException("El nombre del proveedor no puede estar vacío");

        this.Nombre = nombre;
    }
}
