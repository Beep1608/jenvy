package org.jenvy.components;

import atlantafx.base.theme.Styles;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.jenvy.view.AppWindow;
import org.jenvy.view.DashboardView;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Page {
    int MAX_WIDTH = AppWindow.MIN_WIDTH - AppWindow.SIDEBAR_WIDTH;
    int HGAP_10 = 10;
    int HGAP_20 = 20;
    int HGAP_30 = 30;
    int VGAP_10 = 10;
    int VGAP_20 = 20;

    String getName();
    Parent getView();

    void reset();

    default <T> List<T> generate(Supplier<T> supplier, int count){
        return Stream.generate(supplier).limit(count).toList();
    }

    default Label captionLabel(String text) {
        var label = new Label(text);
        label.setStyle("-fx-font-family:monospace");
        return label;
    }

    class PageHeader extends HBox{
        public PageHeader(Page page){
            super();
            Objects.requireNonNull(page,"page");
            var titleLabel = new Label(page.getName());
            titleLabel.setStyle(Styles.TITLE_2);

        }
    }
}
