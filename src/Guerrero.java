/*
DESCRIPCION:
Clase hija que representa a un guerrero.

*/


public class Guerrero extends Personaje {

    public Guerrero(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String mostrarAccion() {
        return getNombre() + " ataca con su espada ⚔️";
    }
}


