package ui;

import ui.custom.CasillaPanel;

import java.awt.*;
import java.awt.Color;
import java.util.Objects;


import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Monopoly");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
        add(createToolBar(), BorderLayout.NORTH);
        add(createBoardPanel(), BorderLayout.CENTER);
        add(createSidePanel(), BorderLayout.EAST);
        add(createBottomPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevo = new JMenuItem("Nuevo Juego");
        JMenuItem guardar = new JMenuItem("Guardar Partida");
        JMenuItem cargar = new JMenuItem("Cargar Partida");
        JMenuItem salir = new JMenuItem("Salir");

        menuArchivo.add(nuevo);
        menuArchivo.add(guardar);
        menuArchivo.add(cargar);
        menuArchivo.addSeparator();
        menuArchivo.add(salir);

        JMenu menuJuego = new JMenu("Juego");
        JMenuItem lanzarDado = new JMenuItem("Lanzar Dado");
        JCheckBoxMenuItem modoRapido = new JCheckBoxMenuItem("Modo rápido");

        menuJuego.add(lanzarDado);
        menuJuego.add(modoRapido);

        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem manual = new JMenuItem("Manual");
        JMenuItem acercaDe = new JMenuItem("Acerca de...");
        menuAyuda.add(manual);
        menuAyuda.add(acercaDe);
        menuBar.add(menuArchivo);
        menuBar.add(menuJuego);
        menuBar.add(menuAyuda);

        return menuBar;
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        int iconWidth = 32;
        int iconHeight = 32;

        JButton btnNuevo = new JButton(resizeIcon("/assets/icons/nuevo.png", iconWidth, iconHeight));
        btnNuevo.setToolTipText("Nuevo Juego (Ctrl+N)");
        toolBar.add(btnNuevo);

        toolBar.addSeparator();

        JButton btnDado = new JButton(resizeIcon("/assets/icons/dado.png", iconWidth, iconHeight));
        btnDado.setToolTipText("Lanzar dado");
        toolBar.add(btnDado);

        JButton btnGuardar = new JButton(resizeIcon("/assets/icons/guardar.png", iconWidth, iconHeight));
        btnGuardar.setToolTipText("Guardar partida");
        toolBar.add(btnGuardar);

        JButton btnCargar = new JButton(resizeIcon("/assets/icons/cargar.png", iconWidth, iconHeight));
        btnCargar.setToolTipText("Cargar partida");
        toolBar.add(btnCargar);

        toolBar.addSeparator();

        JButton btnAyuda = new JButton(resizeIcon("/assets/icons/ayuda.png", iconWidth, iconHeight));
        btnAyuda.setToolTipText("Abrir ayuda");
        toolBar.add(btnAyuda);

        btnNuevo.addActionListener(e -> openNewGameDialog());
        btnDado.addActionListener(e -> rollDice());
        btnGuardar.addActionListener(e -> saveGame());
        btnCargar.addActionListener(e -> loadGame());
        btnAyuda.addActionListener(e -> showHelp());


        return toolBar;
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } else {
            System.err.println("No se encuentra el icono: " + path);
            return null;
        }
    }


    private JPanel createBoardPanel() {
        JPanel board = new JPanel();
        board.setBackground(new Color(0, 120, 0));
        board.setBorder(BorderFactory.createTitledBorder("Tablero"));

        board.setLayout(new GridLayout(5, 4, 5, 5));

        for (int i = 1; i <= 20; i++) {
            CasillaPanel casilla = new CasillaPanel("Casilla " + i, Color.BLUE);
            board.add(casilla);
        }

        return board;
    }


    private JPanel createSidePanel() {
        JPanel side = new JPanel();
        side.setLayout(new java.awt.BorderLayout());
        side.setPreferredSize(new java.awt.Dimension(150, 0));
        side.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugadores"));
        String[] jugadoresDemo = {
                "Jugador 1 ($1500)",
                "Jugador 2 ($1500)",
                "Jugador 3 ($1500)"
        };

        JList<String> listaJugadores = new JList<>(jugadoresDemo);
        side.add(new JScrollPane(listaJugadores), java.awt.BorderLayout.CENTER);

        return side;
    }

    private JPanel createBottomPanel() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new java.awt.BorderLayout());
        bottom.setPreferredSize(new java.awt.Dimension(0, 150));
        bottom.setBorder(javax.swing.BorderFactory.createTitledBorder("Eventos del juego"));

        JTextArea log = new JTextArea();
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);

        bottom.add(new JScrollPane(log), java.awt.BorderLayout.CENTER);

        return bottom;
    }

    private void openNewGameDialog() {
        JOptionPane.showMessageDialog(this, "Abrir diálogo de nuevo juego");
    }

    private void rollDice() {
        int dado = (int)(Math.random() * 6) + 1;
        JOptionPane.showMessageDialog(this, "Has sacado un " + dado);
    }

    private void saveGame() {
        JOptionPane.showMessageDialog(this, "Guardar partida (pendiente)");
    }

    private void loadGame() {
        JOptionPane.showMessageDialog(this, "Cargar partida (pendiente)");
    }

    private void showHelp() {
        JOptionPane.showMessageDialog(this, "Abrir ayuda (JavaHelp pendiente)");
    }

}
