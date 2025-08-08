package org.jenvy;

import javafx.scene.Scene;
import org.jenvy.view.router.*;

import java.util.Map;

public class App {

    private final IPageProvider provider;

    private final IPageContainer container;

    private final  DefaultPageFactory factory;

    private Scene root ;

    public App(Map<String, Class<? extends IPage>> pagesMap, Class<? extends IPage> defaultPage){

        this.container = new DefaultPageContainer(pagesMap, defaultPage);
        this.provider = new DefaultIPageProvider(container);
        this.factory = new DefaultPageFactory(provider);
        provider.nav(defaultPage.getName());
        root = new Scene(provider.currentPage().get().view());
        provider.currentPage().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                root.setRoot(newValue.view());
            }
        });
    }

    public Scene scene(){
        return root;
    }

}
