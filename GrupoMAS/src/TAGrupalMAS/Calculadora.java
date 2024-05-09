package TAGrupalMAS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;

public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JTextPane pantalla = new JTextPane();
        pantalla.setBorder(new LineBorder(new Color(160, 80, 190), 4));
        pantalla.setMaximumSize(new Dimension(340, 75));
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        pantalla.setEditable(false);
        pantalla.setText("0");

        panel.add(pantalla);

        JPanel botones = new JPanel();
        botones.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        int indice_op = 0;
        int indice_nu = 0;
        int num_cel = 0;
        boolean doble = false;

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 4; i++) {
                if (num_cel == 13 || num_cel == 15 || num_cel == 16) {
                    c.gridwidth = 2;
                    doble = true;
                } else {
                    c.gridwidth = 1;
                    doble = false;
                }
                if (!(i % 4 == 0) && !(num_cel == 12) && !(j == 5)) {
                    RoundedButton boton = new RoundedButton(String.valueOf(indice_nu), 25, "numeros");
                    botones.add(boton, c);
                    indice_nu++;

                    if (doble) {
                        i++;
                    }
                } else {
                    String[] operadores = {"/","*","-", ",", "+", "C", "="};
                    RoundedButton boton = new RoundedButton(operadores[indice_op], 25, "operadores");
                    botones.add(boton, c);
                    indice_op++;

                    if (doble) {
                        i++;
                    }
                }
                num_cel++;
            }
        }

        panel.add(botones);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}

class RoundedButton extends JButton {

    private static final long serialVersionUID = 1L;

    private int arco = 0;
    private Color colorPredeterminado = new Color(ABORT);
    private Color colorBorde = new Color(ABORT);
    private Color colorHover = new Color(ABORT);

    private Color col_numeros = new Color(189, 207, 213);
    private Color col_strings = new Color(33, 184, 236);
    private Color col_cancelar = new Color(255, 59, 59);
    private Color col_resultado = new Color(34, 135, 216);

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    public RoundedButton(String text, int arco) {
        super(text);
        this.arco = arco;
        setContentAreaFilled(false);
    }

    public RoundedButton(String text, int arco, String tipo) {
        super(text);
        this.arco = arco;

        int rojo = 0;
        int verde = 0;
        int azul = 0;

        switch (tipo) {
            case "numeros":
                rojo = (int) (col_numeros.getRed() * 0.6);
                verde = (int) (col_numeros.getGreen() * 0.6);
                azul = (int) (col_numeros.getBlue() * 0.6);
                colorHover = new Color(rojo, verde, azul);

                rojo = (int) (col_numeros.getRed() * 0.8);
                verde = (int) (col_numeros.getGreen() * 0.8);
                azul = (int) (col_numeros.getBlue() * 0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_numeros.getRGB());

                break;

            case "cancelar":
                rojo = (int) (col_cancelar.getRed() * 0.6);
                verde = (int) (col_cancelar.getGreen() * 0.6);
                azul = (int) (col_cancelar.getBlue() * 0.6);
                colorHover = new Color(rojo, verde, azul);

                rojo = (int) (col_cancelar.getRed() * 0.8);
                verde = (int) (col_cancelar.getGreen() * 0.8);
                azul = (int) (col_cancelar.getBlue() * 0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_cancelar.getRGB());

                break;

            case "resultado":
                rojo = (int) (col_resultado.getRed() * 0.6);
                verde = (int) (col_resultado.getGreen() * 0.6);
                azul = (int) (col_resultado.getBlue() * 0.6);
                colorHover = new Color(rojo, verde, azul);

                rojo = (int) (col_resultado.getRed() * 0.8);
                verde = (int) (col_resultado.getGreen() * 0.8);
                azul = (int) (col_resultado.getBlue() * 0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_resultado.getRGB());

                break;

            case "string":
                rojo = (int) (col_strings.getRed() * 0.6);
                verde = (int) (col_strings.getGreen() * 0.6);
                azul = (int) (col_strings.getBlue() * 0.6);
                colorHover = new Color(rojo, verde, azul);

                rojo = (int) (col_strings.getRed() * 0.6);
                verde = (int) (col_strings.getGreen() * 0.6);
                azul = (int) (col_strings.getBlue() * 0.6);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_strings.getRGB());

                break;

            default:
                colorHover = new Color(Color.black.getRGB());
                break;
        }
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(colorHover);
        } else {
            g.setColor(colorPredeterminado);
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(3));
        g2.setColor(colorBorde);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arco, arco));
        g2.dispose();
    }
}
