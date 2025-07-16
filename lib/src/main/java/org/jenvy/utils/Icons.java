package org.jenvy.utils;

import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;

public class Icons {
    
    
    public static void createIcon(String url, int width, int height, Region container) {
    
        Image image = new Image(url,
       width, height, false, true);
       BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT, // Repetir en eje X
            BackgroundRepeat.NO_REPEAT, // Repetir en eje Y
            BackgroundPosition.DEFAULT,  // Posicionar en el centro
            new BackgroundSize(
               BackgroundSize.AUTO,     // Ancho automático
               BackgroundSize.AUTO,     // Alto automático
                true,                   // Usar ancho absoluto
                true,                   // Usar alto absoluto
                true,                    // Ajustar para cubrir
                false                    // No recortar
            )
            );
           
        container.setMinWidth(width);
        container.setMinHeight(height);
        container.setBackground(new Background(backgroundImage));
       
        
    }

    public static void createIconGraphic(String url, int width, int height, Labeled button) {
        ImageView imageView = new ImageView(new Image(url, width, height, false, true));
        button.setGraphic(imageView);
        button.setText(""); // Opcional: Quitar texto si solo quieres el ícono
    }
}
