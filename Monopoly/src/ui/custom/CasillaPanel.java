package ui.custom;

import javax.swing.*;
import java.awt.*;

public class CasillaPanel extends JPanel {

    private String nombre;
    private Color colorBase;
    private boolean ocupada;

    public CasillaPanel(String nombre, Color colorBase) {
        this.nombre = nombre;
        this.colorBase = colorBase;
        this.ocupada = false;

        setPreferredSize(new Dimension(80, 80));
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
        repaint();
    }

    public void setColorBase(Color color) {
        this.colorBase = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(colorBase);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (ocupada) {
            g.setColor(Color.RED);
            g.drawRect(2, 2, getWidth() - 4, getHeight() - 4);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(nombre);
        g.drawString(nombre, (getWidth() - textWidth) / 2, getHeight() / 2);
    }
}
