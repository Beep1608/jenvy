package org.jenvy;

import javafx.scene.Scene;
import org.jenvy.view.router.*;

import java.util.Map;

public class App {

    private final PageProvider provider;

    private Scene root ;

    public App(PageProvider provider){
        this.provider = provider;
        root = new Scene(provider.currentPage().get().view());
        provider.currentPage().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                root.setRoot(newValue.view());
            }
        });
    }

    public PageProvider provider(){
        return provider;
    }

    public Scene scene(){
        return root;
    }

}
