package org.jenvy.view.router;

import atlantafx.base.theme.Styles;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;

import java.util.Objects;

public interface IPage {



    Parent view();
    String name();
    Model model();
    Interactor interactor();

    void reset();

    class PageHeader extends HBox{
        public PageHeader(IPage IPage){
            super();
            Objects.requireNonNull(IPage,"page");
            var titleLabel = new Label(IPage.name());
            titleLabel.setStyle(Styles.TITLE_2);

        }
    }
}
