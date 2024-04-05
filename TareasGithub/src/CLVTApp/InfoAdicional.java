package CLVTApp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InfoAdicional extends MenuControlador {
    private double apoyoDonativo;
    private String avisoLegal;
    private String politicaPrivacidad;
    private List<Donativo> donativosRegistrados;

    public InfoAdicional() {
        this.apoyoDonativo = 0.0;
        this.avisoLegal = "";
        this.politicaPrivacidad = "";
        this.donativosRegistrados = new ArrayList<>();
    }

    public InfoAdicional(String avisoLegal, String politicaPrivacidad) {
        this.avisoLegal = "AVISO LEGAL\nEncargado:\r\n"
        		+ "\r\n"
        		+ "Nombre de la entidad: ASOCIACIÓN CULTIVATE.\r\n"
        		+ "\r\n"
        		+ "Nombre y apellidos, Presidente: SERGIO MORALES SEGURA.\r\n"
        		+ "\r\n"
        		+ "Dirección: Av./ Vidal i Barraquer, 8, 3-3.\r\n"
        		+ "\r\n"
        		+ " \r\n"
        		+ "\r\n"
        		+ "Contacto:\r\n"
        		+ "\r\n"
        		+ "Teléfono: 616 16 57 26 / 722 199 574\r\n"
        		+ "\r\n"
        		+ "E-mail: aso.cultivate.22@gmail.com\r\n"
        		+ "\r\n"
        		+ " \r\n"
        		+ "\r\n"
        		+ "Registro:\r\n"
        		+ "\r\n"
        		+ "Inscripción en el registro mercantil Tribunal de registro: Registre d’associacions de la Generalitat de Catalunya.\r\n"
        		+ "\r\n"
        		+ "Número de registro: 9015-427919/2022 \r\n"
        		+ "\r\n"
        		+ " \r\n"
        		+ "\r\n"
        		+ "Número de identificación fiscal:\r\n"
        		+ "\r\n"
        		+ "Número de identificación fiscal: G10596393.";
        this.politicaPrivacidad = "POLÍTICA DE PRIVACIDAD\nControlador de datos\r\n"
        		+ "\r\n"
        		+ "Asociación Cultivate\r\n"
        		+ "\r\n"
        		+ "Delegado de protección: Sebastián López\r\n"
        		+ "\r\n"
        		+ " \r\n"
        		+ "\r\n"
        		+ "Datos personales recogidos\r\n"
        		+ "\r\n"
        		+ "Av./ Vidal i Barraquer, 8\r\n"
        		+ "\r\n"
        		+ " \r\n"
        		+ "\r\n"
        		+ "Propósito de la recolección de datos\r\n"
        		+ "\r\n"
        		+ "aso.cultivate.22@gmail.com\r\n"
        		+ "\r\n"
        		+ "722 199 574";
    }
     
    //Métodos
    public String obtenerAvisoLegal() {
        return avisoLegal;
    }

    public String obtenerPoliticaPrivacidad() {
        return politicaPrivacidad;
    }
    
    // Método para que cualquier persona pueda hacer un donativo económico
    public void hacerDonativo() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String documento = JOptionPane.showInputDialog("Ingrese su número de documento (DNI/NIE/NIF):");
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad donada:"));
        String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");
        String correo = JOptionPane.showInputDialog("Ingrese su correo electrónico:");

        Donativo nuevoDonativo = new Donativo(nombre, documento, cantidad, telefono, correo);
        donativosRegistrados.add(nuevoDonativo);
        apoyoDonativo += cantidad;

        JOptionPane.showMessageDialog(null, "¡Gracias por tu donativo! En un máximo de 72 horas nos pondremos en contacto contigo.");
    }

    // Método para mostrar la información

    public void mostrarInformacion() {
    	StringBuilder info = new StringBuilder();
        info.append("Donativo Total Recibido: ").append(apoyoDonativo).append("€\n");
        info.append("¿Quien colabora?:");
        	for (Donativo donativo : donativosRegistrados) {
            info.append("Nombre: ").append(donativo.getNombre()).append(", Cantidad Donada: ").append(donativo.getCantidad()).append("€\n");
        info.append("Aviso Legal: ").append(avisoLegal).append("\n");
        info.append("Política de Privacidad: ").append(politicaPrivacidad).append("\n");

         }JOptionPane.showMessageDialog(null, info.toString(), "Información Adicional", JOptionPane.INFORMATION_MESSAGE);
}  
}

