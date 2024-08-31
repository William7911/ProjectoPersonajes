package Personajes;

public class Personajes {
    private String nombre;
    private int salud;
    private int daño;
    private String habilidades;
    private String imagenRuta;

    public Personajes(String nombre, int salud, int daño, String habilidades, String imagenRuta) {
        this.nombre = nombre;
        this.salud = salud;
        this.daño = daño;
        this.habilidades = habilidades;
        this.imagenRuta = imagenRuta;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getDaño() { return daño; }
    public String getHabilidades() { return habilidades; }
    public String getImagenRuta() { return imagenRuta; }

    @Override
    public String toString() {
        return nombre;
    }
}
