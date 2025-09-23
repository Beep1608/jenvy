package org.jenvy.utils;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class Responsive {
    

    public Responsive(){

    }


    public static void bindingToParent(Region container, double percentageW, double percentageH) {
     
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
                container.prefWidthProperty().bind(((Region) newParent).widthProperty().multiply(percentageW));
                container.prefHeightProperty().bind(((Region) newParent).heightProperty().multiply(percentageH));
          }
         });

    }

      public static void bindingImageToParent(ImageView imageView, double percentageW, double percentageH) {
     
        imageView.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
                imageView.fitHeightProperty().bind(((Region) newParent).widthProperty().multiply(percentageW));
                imageView.fitWidthProperty().bind(((Region) newParent).heightProperty().multiply(percentageH));
          }
         });

    }


    public static void bindingToParentWidth(Region container, double percentageW) {
     
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
                container.prefWidthProperty().bind(((Region) newParent).widthProperty().multiply(percentageW));
                
          }
         });

    }

    public static void bindingToParentHeight(Region container, double percentageH) {
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null) {
                if (newParent instanceof Region parentRegion) {
                    container.prefHeightProperty().bind(parentRegion.heightProperty().multiply(percentageH));
                } else if (newParent.getScene() != null) {
                    // Escuchar a la escena si ya existe
                    container.prefHeightProperty().bind(newParent.getScene().heightProperty().multiply(percentageH));
                }
            }
        });
    }

}