package Personajes;

public class Jugador extends Personaje {
    private String equipo;

    public Jugador(String nombre, int salud, int daño, String habilidades, String imagenRuta, String equipo) {
        super(nombre, salud, daño, habilidades, imagenRuta);
        this.equipo = equipo;
    }

    public String getEquipo() { return equipo; }
}
