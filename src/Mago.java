
/*

DESCRIPCION:
Clase hija que representa a un mago.

*/

public class Mago extends  Personaje{

    public Mago(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String mostrarAccion() {
        return getNombre() + " lanza un hechizo mágico ✨";
    }

}
