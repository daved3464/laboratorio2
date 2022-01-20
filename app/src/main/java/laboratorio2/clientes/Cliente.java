package laboratorio2.clientes;

import laboratorio2.excepciones.EmptyStringException;
import lombok.Getter;

public class Cliente {
    @Getter
    private int index;

    @Getter
    private String nombre;

    public Cliente (String nombre) throws EmptyStringException {
        this.setNombre(nombre);
    }
    
    public Cliente(int index, String nombre)
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
            throw new EmptyStringException("El nombre del cliente no puede estar vacío");

        this.nombre = nombre;
    }
}
