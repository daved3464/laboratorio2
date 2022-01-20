package laboratorio2.excepciones;

public class ListMaxIndexOutOfBoundsException extends Exception{

    public ListMaxIndexOutOfBoundsException () {
        super ("Esta es una limitación de la estructura de datos, la lista superó el máximo de elementos posibles");
    }
}
