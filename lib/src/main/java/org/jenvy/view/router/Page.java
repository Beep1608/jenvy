package org.jenvy.view.router;

import atlantafx.base.theme.Styles;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;

import java.util.Objects;
import java.util.function.Consumer;

public interface  Page {

    final ReadOnlyObjectProperty <Consumer<Class<? extends Page>>> nav = new ReadOnlyObjectWrapper<>();

   default  void setNav(Consumer<Class<? extends Page>> nav){
       ((ReadOnlyObjectWrapper<Consumer<Class<? extends Page>>>) this.nav).set( nav);
    }
   default  void nav(Class<? extends Page> page){
        nav.get().accept(page);
    }

    Parent view();
    String name();
    Model model();
    Interactor interactor();

    void reset();

    class PageHeader extends HBox {
        public PageHeader(Page page){
            super();
            Objects.requireNonNull(page,"page");
            var titleLabel = new Label(page.name());
            titleLabel.setStyle(Styles.TITLE_2);

        }
    }
}
