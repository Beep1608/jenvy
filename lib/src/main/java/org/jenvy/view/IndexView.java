package org.jenvy.view;

import java.util.List;

import org.jenvy.dto.Dto;
import org.jenvy.interactor.IndexInteractor;
import org.jenvy.model.IndexModel;

import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
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
    protected   VBox container;

    protected final  IndexInteractor interactor;

    public IndexView(IndexModel<D> model ,  IndexInteractor interactor){
        this.model = model;
        this.interactor  =interactor;
        this.editButton = editButton();
        this.table= createTable();
        this.container = createContainer();
        paginate();
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


    private void updatePagination() {
        int pageCount = (int) Math.ceil((double) model.items().size() / model.pagination().get());
        pagination.setPageCount(Math.max(pageCount, 1));
    }
    protected TableView<D> getTableView(){
        return table;

        
    }
    private void paginate(){
        pagination.setPageFactory(pageIndex ->{
                model.index().set(pageIndex);
               return  createTable();
        });
       container.getChildren().add(pagination);
    }

    protected abstract VBox createContainer();
    protected abstract  List<TableColumn<D, ?>> createColumns();
    protected abstract Button editButton();
    
    
    
    
}
