package Personajes;

public class Enemigo extends Personaje {
    private String debilidad;

    public Enemigo(String nombre, int salud, int daño, String habilidades, String imagenRuta, String debilidad) {
        super(nombre, salud, daño, habilidades, imagenRuta);
        this.debilidad = debilidad;
    }

    public String getDebilidad() { return debilidad; }
}
