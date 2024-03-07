
package oreja;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Oreja {

    public static void main(String[] args) {
        MarcoOreja elmarco = new MarcoOreja();
        elmarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        elmarco.setVisible(true);

    }

}

class MarcoOreja extends JFrame {
    public MarcoOreja(){
        File archivo1 = new File("64.png");//
        String Logo = archivo1.getAbsolutePath();
        //System.out.println("Logo = " + Logo);
        
        
        Toolkit mipantalla = Toolkit.getDefaultToolkit();//line related to the icon
        setTitle("Mapa de Auriculoterapía");
        setBounds(200,100,1037,715);
        
        OrejaPanel lamina = new OrejaPanel();
        add(lamina);
        
        Image miIcono = mipantalla.getImage(Logo);//line related to the icon
        
        setIconImage(miIcono);
    }
}

class OrejaPanel extends JPanel {
    public OrejaPanel() {

        EventoRaton evento = new EventoRaton();
        addMouseListener(evento);
        
        

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File archivo2 = new File("Puntos.jpg");//
        String imagen_oreja = archivo2.getAbsolutePath();
        try {
            imageB = ImageIO.read(archivo2);
            System.out.println("imagen_oreja = " + imagen_oreja);
            ImageIO.write(imageB, "jpg", new File("C:/Java/workspace/Oreja4/imagen_copia.jpg"));
            System.out.println("La imagen se es cribio correctamente");
        } catch (IOException ex) {
            
        }
        
        
        File miimagen = new File(imagen_oreja);
        try {
            imagen=ImageIO.read(miimagen);
        } catch (IOException e) {
            System.out.println("La imagen no se encuetra.");  
        }
        g.drawImage(imagen, 500, 15, null);
        }

    private Image imagen;
    BufferedImage imageB = null;
}

class EventoRaton extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {

        JOptionPane.showMessageDialog(null, "Coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());

    }

    private JOptionPane cuadro;
}
