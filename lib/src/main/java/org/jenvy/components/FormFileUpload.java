package org.jenvy.components;
import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
public class FormFileUpload extends FormContainer {

    private ImageView imagePreview;
    private Button uploadButton;
    private String imagePath; // ← Atributo para guardar la ruta de la imagen

    public FormFileUpload(String title) {
        super(title);
        init();
    }

    private void init() {
        // Crear botón para seleccionar imagen
        uploadButton = new Button("Seleccionar imagen");

        // Crear ImageView para mostrar la preview
        imagePreview = new ImageView();
        imagePreview.setFitWidth(200);
        imagePreview.setFitHeight(200);
        imagePreview.setPreserveRatio(true);

        // Acción del botón para abrir FileChooser
        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar imagen");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );

            Window window = getScene() != null ? getScene().getWindow() : uploadButton.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(window);

            if (selectedFile != null) {
                imagePath = selectedFile.getAbsolutePath(); // ← Guardar la ruta
                Image image = new Image(selectedFile.toURI().toString());
                imagePreview.setImage(image);
                System.out.println(getImagePath());
            }
        });

        getContentContainer().getChildren().addAll(uploadButton, imagePreview);
        getFormContainer().setSpacing(10);
    }

    /**
     * Método público para obtener la ruta de la imagen seleccionada
     */
    public String getImagePath() {
        return imagePath;
    }
}