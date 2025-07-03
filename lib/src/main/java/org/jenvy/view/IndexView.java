package org.jenvy.view;

import java.util.List;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract  class IndexView<D extends Dto> implements Builder<Region> {
    protected final IndexModel<D> model;
    private final Button editButton;
    protected final TableView<D> table;
    public IndexView(IndexModel<D> model){
        this.model = model;
        this.editButton = editButton();
        this.table= createTable();
    }

    @Override
    public Region build() {
        throw new UnsupportedOperationException("Unimplemented method in EditView");
    }

    protected TableView<D> createTable(){
        
       TableView<D> table_local = new TableView<>();
        table_local.setItems(model.items());
        table_local.getColumns().setAll(createColumns());
        TableColumn<D, Void> editCol = new TableColumn<>("Editar");
        editCol.setCellFactory(param -> new TableCell<>() {
        
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(editButton);
                }
            }
        });

        table_local.getColumns().add(editCol);
        return table_local;
    }

    protected TableView<D> getTableView(){
        return table;

        
    }

    protected abstract  List<TableColumn<D, ?>> createColumns();
    protected abstract Button editButton();
    
    
    
    
}
