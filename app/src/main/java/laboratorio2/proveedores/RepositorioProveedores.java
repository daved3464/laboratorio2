package laboratorio2.proveedores;


import laboratorio2.excepciones.EmptyStringException;
import laboratorio2.excepciones.ListMaxIndexOutOfBoundsException;
import lombok.Getter;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RepositorioProveedores {
    @Getter
    private LinkedList<Proveedor> Proveedores;

    public RepositorioProveedores() {
        this.Proveedores = new LinkedList<Proveedor>();
    }

    // Create
    public void registrarProveedor(String nombre)
            throws EmptyStringException,
            ListMaxIndexOutOfBoundsException {

        // Excepción de limitación de Java
        if (this.Proveedores.size() == Integer.MAX_VALUE)
            throw new ListMaxIndexOutOfBoundsException();

        // Añadir proveedor
        this.Proveedores.add(new Proveedor(this.Proveedores.size(), nombre));
    }

    // Read one, search by index
    public Proveedor obtenerProveedor(int index) throws NoSuchElementException {
        return this.Proveedores.stream()
                .filter(p -> p.getIndex() == index)
                .findFirst()
                .orElseThrow();
    }

    // Search index in List
    private int obtenerIndiceProveedor(int index){
        return this.Proveedores.indexOf(this.obtenerProveedor(index));
    }

    // Read many, filter by name
    public Proveedor[] obtenerProveedoresPorNombre(String nombre) {
        return (Proveedor[]) this.Proveedores.stream().filter(c -> c.getNombre() == nombre).toArray();
    }

    // Read all
    public Proveedor[] obtenerProveedores() {
        return (Proveedor[]) this.Proveedores.toArray();
    }

    // Update
    public void actualizarProveedor(int index, String nombre) throws EmptyStringException {
        Proveedor proveedor = this.obtenerProveedor(index);
        proveedor.setNombre(nombre);

        this.Proveedores.set(index, proveedor);
    }

    // Delete
    public void eliminarProveedor(int index) {
        this.Proveedores.remove(index);
    }

}
