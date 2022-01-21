package laboratorio2.cartera;

import lombok.Getter;

import java.util.HashSet;

public class Cartera {
    @Getter
    private int Saldo;

    private HashSet<Transaccion> transacciones;


}
