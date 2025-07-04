package org.jenvy.view;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public abstract  class IndexView<D extends Dto> implements Builder<Region> {
    protected final Pagination pagination = new Pagination(10);
    protected final IndexModel<D> model;
    private final Button editButton;
    protected final TableView<D> table;
    protected  final VBox container;

    protected final  HashMap<String, Function<Object,Object>> actions;

    public IndexView(IndexModel<D> model , HashMap<String, Function<Object,Object>> actions){
        this.model = model;
        this.actions  =actions;
        this.editButton = editButton();
        this.table= createTable();
        this.container = createContainer();
        addPagination();
    }

    @Override
    public Region build() {
        return container;
    }

    protected TableView<D> createTable(){
        
       TableView<D> table_local = new TableView<>();
        table_local.setItems(model.tempItems());
        table_local.getColumns().setAll(createColumns());
        table_local.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table_local.getStyleClass().add("table-view");
     
        // pagination.setPageFactory(this::createPage);
        // updatePagination(); // <- inicializa el número de páginas
        return table_local;
    }

    private Region createPage(int pageIndex) {
        int fromIndex = pageIndex * model.pagination().get();
        int toIndex = Math.min(fromIndex + model.pagination().get(), model.items().size());

        table.setItems(FXCollections.observableArrayList(model.items().subList(fromIndex, toIndex)));

        if (table.getColumns().isEmpty()) {
            table.getColumns().setAll(createColumns());
            TableColumn<D, Void> editCol = new TableColumn<>("Editar");
            editCol.setCellFactory(param -> new TableCell<>() {
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : editButton);
                }
            });
            table.getColumns().add(editCol);
        }

        return new VBox(table); // puede ser VBox para incluir más cosas
    }
    private void updatePagination() {
        int pageCount = (int) Math.ceil((double) model.items().size() / model.pagination().get());
        pagination.setPageCount(Math.max(pageCount, 1));
    }
    protected TableView<D> getTableView(){
        return table;

        
    }
    private void addPagination(){
        pagination.setPageFactory(pageIndex ->{
                actions.get("createPage").apply(pageIndex);
               return  createTable();
        });
        container.getChildren().add(pagination);
    }

    protected abstract VBox createContainer();
    protected abstract  List<TableColumn<D, ?>> createColumns();
    protected abstract Button editButton();
    
    
    
    
}
