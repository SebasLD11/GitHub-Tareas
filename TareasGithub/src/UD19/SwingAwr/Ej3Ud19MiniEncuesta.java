package UD19.SwingAwr;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class Ej3Ud19MiniEncuesta extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JRadioButton windowsRadio, linuxRadio, macRadio;
	    private JCheckBox programacionCheck, disenoCheck, administracionCheck;
	    private JSlider horasSlider;
	    private JButton submitButton;

	    public Ej3Ud19MiniEncuesta() {
	        setTitle("Mini Encuesta");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(5, 1));

	        // Panel para los sistemas operativos
	        JPanel sistemaOperativoPanel = new JPanel();
	        sistemaOperativoPanel.setBorder(BorderFactory.createTitledBorder("Elige un sistema operativo"));
	        windowsRadio = new JRadioButton("Windows");
	        linuxRadio = new JRadioButton("Linux");
	        macRadio = new JRadioButton("Mac");
	        ButtonGroup sistemaOperativoGroup = new ButtonGroup();
	        sistemaOperativoGroup.add(windowsRadio);
	        sistemaOperativoGroup.add(linuxRadio);
	        sistemaOperativoGroup.add(macRadio);
	        sistemaOperativoPanel.add(windowsRadio);
	        sistemaOperativoPanel.add(linuxRadio);
	        sistemaOperativoPanel.add(macRadio);
	        add(sistemaOperativoPanel);

	        // Panel para las especialidades
	        JPanel especialidadesPanel = new JPanel();
	        especialidadesPanel.setBorder(BorderFactory.createTitledBorder("Elige tu especialidad"));
	        programacionCheck = new JCheckBox("Programación");
	        disenoCheck = new JCheckBox("Diseño gráfico");
	        administracionCheck = new JCheckBox("Administración");
	        especialidadesPanel.add(programacionCheck);
	        especialidadesPanel.add(disenoCheck);
	        especialidadesPanel.add(administracionCheck);
	        add(especialidadesPanel);

	        // Panel para las horas dedicadas
	        JPanel horasPanel = new JPanel();
	        horasPanel.setBorder(BorderFactory.createTitledBorder("Horas dedicadas en el ordenador"));
	        horasSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
	        horasSlider.setMajorTickSpacing(1);
	        horasSlider.setPaintTicks(true);
	        horasSlider.setPaintLabels(true);
	        horasPanel.add(horasSlider);
	        add(horasPanel);

	        // Botón para enviar
	        submitButton = new JButton("Enviar");
	        submitButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	                mostrarResultado();
	            }
	        });
	        add(submitButton);

	        setVisible(true);
	    }

	   private void mostrarResultado() {
	        StringBuilder resultado = new StringBuilder();
	        resultado.append("Sistema operativo elegido: ");
	        if (windowsRadio.isSelected()) {
	            resultado.append("Windows");
	        } else if (linuxRadio.isSelected()) {
	            resultado.append("Linux");
	        } else if (macRadio.isSelected()) {
	            resultado.append("Mac");
	        } else {
	            resultado.append("Ninguno");
	        }
	        resultado.append("\nEspecialidades elegidas: ");
	        if (programacionCheck.isSelected()) {
	            resultado.append("Programación ");
	        }
	        if (disenoCheck.isSelected()) {
	            resultado.append("Diseño gráfico ");
	        }
	        if (administracionCheck.isSelected()) {
	            resultado.append("Administración ");
	        }
	        resultado.append("\nHoras dedicadas en el ordenador: ");
	        resultado.append(horasSlider.getValue());

	        JOptionPane.showMessageDialog(this, resultado.toString(), "Resultado de la encuesta", JOptionPane.INFORMATION_MESSAGE);
	    }

	   public static void main(String[] args) {
	    	 // Crear una instancia de la ventana
		   Ej3Ud19MiniEncuesta ventana = new Ej3Ud19MiniEncuesta();
	        // Hacer visible la ventana
	        ventana.setVisible(true);
	    }
	}
