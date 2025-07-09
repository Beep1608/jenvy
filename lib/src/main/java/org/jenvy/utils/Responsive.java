package org.jenvy.utils;

import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class Responsive {
    
 public static <T> void bindTableWithPagination(
            TableView<T> tableView,
            Pagination pagination,
            ObservableList<T> allItems
    ) {
        Consumer<Integer> updatePagination = (maxRowsPerPage) -> {
            int totalPages = (int) Math.ceil((double) allItems.size() / maxRowsPerPage);
            pagination.setPageCount(Math.max(totalPages, 1));
            pagination.setCurrentPageIndex(0);

            pagination.setPageFactory(pageIndex -> {
                int fromIndex = pageIndex * maxRowsPerPage;
                int toIndex = Math.min(fromIndex + maxRowsPerPage, allItems.size());
                tableView.setItems(FXCollections.observableArrayList(allItems.subList(fromIndex, toIndex)));
                return new Region(); // Required, but not shown
            });
        };

        // Cálculo inicial
        calcularMaxFilasVisibles(tableView, updatePagination);

        // Escuchar redimensionamiento
        ChangeListener<Number> resizeListener = (obs, oldVal, newVal) -> {
            calcularMaxFilasVisibles(tableView, updatePagination);
        };

        tableView.heightProperty().addListener(resizeListener);
    }

    public static void calcularMaxFilasVisibles(TableView<?> tableView, Consumer<Integer> callback) {
        Platform.runLater(() -> {
            TableRow<?> row = (TableRow<?>) tableView.lookup(".table-row-cell");
            double rowHeight = 24; // valor por defecto

            if (row != null && row.getHeight() > 0) {
                rowHeight = row.getHeight();
            }

            double tableHeight = tableView.getHeight();
            int maxRows = (int) (tableHeight / rowHeight);
            callback.accept(Math.max(1, maxRows));
        });
    }
}
