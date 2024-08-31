                        package Personajes;

import java.util.ArrayList;

public class Categoria {
    private String nombre;
    private ArrayList<Personaje> personajes;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public String getNombre() {
        return nombre;
    }
}
