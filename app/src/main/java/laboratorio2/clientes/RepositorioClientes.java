package laboratorio2.clientes;

import laboratorio2.excepciones.EmptyStringException;
import laboratorio2.excepciones.ListMaxIndexOutOfBoundsException;
import lombok.Getter;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RepositorioClientes {
    @Getter
    private LinkedList<Cliente> Clientes;

    public RepositorioClientes() {
        this.Clientes = new LinkedList<Cliente>();
    }

    // Create
    public void registrarCliente(String nombre)
            throws EmptyStringException,
            ListMaxIndexOutOfBoundsException {

        // Excepción de limitación de Java
        if (this.Clientes.size() == Integer.MAX_VALUE)
            throw new ListMaxIndexOutOfBoundsException();

        // Añadir cliente
        this.Clientes.add(new Cliente(this.Clientes.size(), nombre));
    }

    // Read one, search by index
    public Cliente obtenerCliente(int index) {
        return this.Clientes.stream()
                .filter(c -> c.getIndex() == index)
                .findFirst()
                .orElseThrow();
    }

    public int obtenerIndiceCliente(int index) {
        return this.Clientes.indexOf(this.obtenerCliente(index));
    }

    // Read many, filter by name
    public Cliente[] obtenerClientesPorNombre(String nombre) {
        return (Cliente[]) this.Clientes
                .stream()
                .filter(c -> c.getNombre() == nombre)
                .toArray();
    }

    // Read all
    public Cliente[] obtenerClientes() {
        return (Cliente[]) this.Clientes.toArray();
    }

    // Update
    public void actualizarCliente(int index, String nombre)
            throws EmptyStringException {
        Cliente cliente = this.obtenerCliente(index);
        cliente.setNombre(nombre);

        this.Clientes.set(this.obtenerIndiceCliente(index), cliente);
    }

    // Delete
    public void eliminarCliente(int index) throws NoSuchElementException {
        this.Clientes.remove(this.obtenerIndiceCliente(index));
    }

}
