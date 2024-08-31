package Personajes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

 class Personaje {
    private String nombre;
    private int salud;
    private int daño;
    private String habilidades;
    private String imagenRuta;

    public Personaje(String nombre, int salud, int daño, String habilidades, String imagenRuta) {
        this.nombre = nombre;
        this.salud = salud;
        this.daño = daño;
        this.habilidades = habilidades;
        this.imagenRuta = imagenRuta;
    }

   
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

 class VentanaPrincipal extends JFrame {
    private JTabbedPane categoriasPane;
    private JLabel nombreLabel, saludLabel, dañoLabel, habilidadesLabel, imagenLabel;

    public VentanaPrincipal() {
        setTitle("Personajes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/resources/Icon/Smash.png");
        setIconImage(icon.getImage());
        

        
        categoriasPane = new JTabbedPane();
        categoriasPane.setBackground(Color.WHITE);
        agregarCategorias();

        JPanel detallePanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        nombreLabel = new JLabel("Nombre: ");
        saludLabel = new JLabel("Salud: ");
        dañoLabel = new JLabel("Daño: ");
        habilidadesLabel = new JLabel("Habilidades: ");
        imagenLabel = new JLabel();

        infoPanel.add(nombreLabel);
        infoPanel.add(saludLabel);
        infoPanel.add(dañoLabel);
        infoPanel.add(habilidadesLabel);
        detallePanel.add(imagenLabel, BorderLayout.CENTER);
        detallePanel.add(infoPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, categoriasPane, detallePanel);
        splitPane.setBackground(Color.LIGHT_GRAY); // Cambia a tu color preferido
        detallePanel.setBackground(Color.LIGHT_GRAY);
        infoPanel.setBackground(Color.LIGHT_GRAY);
        imagenLabel.setOpaque(true); // Necesario si quieres cambiar el fondo de una JLabel
        imagenLabel.setBackground(Color.LIGHT_GRAY);


        splitPane.setDividerLocation(400);
        add(splitPane);
    }

    private void agregarCategorias() {
        Categoria Amigos = new Categoria("Amigos");
        Categoria enemigos = new Categoria("Enemigos");

        Amigos.agregarPersonaje(new Jugador("Kirby", 100, 40, "Copia Habilidades", "src/resources/imagenes/Kirby.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Link", 100, 50, "Espadachin", "src/resources/imagenes/Link.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Luigi", 90, 45, "Lanzar bolas de fuego(verde)", "src/resources/imagenes/Luigi.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Mario", 90, 50, "Lanzar bolas de fuego(rojas)", "src/resources/imagenes/Mario.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Ness", 90, 50, "Psquicos", "src/resources/imagenes/Ness.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Pikachu", 80, 40, "Electricidad", "src/resources/imagenes/Pikachu.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Zelda", 90, 40, "Espiritus", "src/resources/imagenes/Zelda.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Pacman", 80, 40, "Bolas de Poder", "src/resources/imagenes/Pac.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Sonic", 90, 60, "Velocidad", "src/resources/imagenes/Sonic.png", "Equipo1"));
        Amigos.agregarPersonaje(new Jugador("Steve", 100, 50, "Construccion", "src/resources/imagenes/Steve.png", "Equipo1"));


        
        enemigos.agregarPersonaje(new Enemigo("Donkey kong", 100, 80, "Fuerza", "src/resources/imagenes/Donkey.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Bowser", 100, 80, "Fuego", "src/resources/imagenes/Bowser.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Ganandorf", 100, 80, "Fuerza", "src/resources/imagenes/Ganandorf.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Wolf", 100, 80, "Reflector", "src/resources/imagenes/Wolf.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Bowsy", 100, 80, "Volar", "src/resources/imagenes/Bowsy.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Ridlye", 100, 100, "Fuerza", "src/resources/imagenes/Ridley.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("king K. Rool", 100, 100, "Fuerza", "src/resources/imagenes/King.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Mewto", 100, 80, "Fuerza", "src/resources/imagenes/Mewto.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Dark Pit", 100, 80, "Fuerza", "src/resources/imagenes/DarkPit.png", "Fuego"));
        enemigos.agregarPersonaje(new Enemigo("Meta knight", 100, 80, "Fuerza", "src/resources/imagenes/MetaKnight.png", "Fuego"));

        JPanel panelJugadores = crearPanelCategoria(Amigos);
        JPanel panelEnemigos = crearPanelCategoria(enemigos);

        categoriasPane.addTab(Amigos.getNombre(), panelJugadores);
        categoriasPane.addTab(enemigos.getNombre(), panelEnemigos);
    }

 private JPanel crearPanelCategoria(Categoria categoria) {
    JPanel panel = new JPanel(new BorderLayout());

    JList<Personaje> listaPersonajes = new JList<>(categoria.getPersonajes().toArray(new Personaje[0]));
    
    listaPersonajes.addListSelectionListener(e -> { 
        if (!e.getValueIsAdjusting()) { //segurarde que responder solo cuando la selección ha terminado
            Personaje seleccionado = listaPersonajes.getSelectedValue();
            mostrarDetalles(seleccionado); //actualizar el panel de detalles con la información del personaje.
        }
    });

    panel.add(new JScrollPane(listaPersonajes), BorderLayout.CENTER);

    return panel;
}



    private void mostrarDetalles(Personaje personaje) {
        if (personaje != null) {
            nombreLabel.setText("Nombre: " + personaje.getNombre());
            saludLabel.setText("Salud: " + personaje.getSalud());
            dañoLabel.setText("Daño: " + personaje.getDaño());
            habilidadesLabel.setText("Habilidades: " + personaje.getHabilidades());
            imagenLabel.setIcon(new ImageIcon(personaje.getImagenRuta()));
            
            ImageIcon icon = new ImageIcon(personaje.getImagenRuta());
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH); 
            imagenLabel.setIcon(new ImageIcon(scaledImage));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}