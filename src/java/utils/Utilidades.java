/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author cr7_k
 */
public class Utilidades {
    
    public static void guardarImagen(String rutaCompleta, Image imagen) throws IOException{
         String directorio = Paths.get(rutaCompleta).getParent().toString();

        // Asegurarse de que el directorio exista, si no, créalo
        File crearDirectorio = new File(directorio);
        if (!crearDirectorio.exists()) {
             crearDirectorio.mkdirs();
        }
        
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imagen, null);

        // Guardar la imagen como JPEG en la ubicación especificada
        ImageIO.write(bufferedImage, "png", new File(rutaCompleta));
    }
    
     public static Image decodificarImagenBase64(String imagenBase64) {
        byte[] decodeImage = Base64.getDecoder().decode(imagenBase64.replaceAll("\\n", ""));

        Image imagen = new Image(new ByteArrayInputStream(decodeImage));
        return imagen;
    }
     
    public static String convertirImagenABase64(File archivoImagen) throws IOException {
        byte[] bytesDeImagen = Files.readAllBytes(archivoImagen.toPath());
        return Base64.getEncoder().encodeToString(bytesDeImagen);
    }
   
}
