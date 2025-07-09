package org.jenvy.view;


import java.util.List;

import org.jenvy.dto.Dto;
import org.jenvy.interactor.IndexInteractor;
import org.jenvy.model.IndexModel;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
//TODO: Mejorar estilo de barra de busqueda y de tabla, botones crear y editar y pagiando
public abstract  class IndexView<D extends Dto> implements Builder<Region> {
    protected final Pagination pagination = new Pagination();
    protected final IndexModel<D> model;
    private final Button editButton;
    private final Button createButton;
    protected final TableView<D> table;
    protected   VBox container;
    protected HBox buttonsContainer;
    protected HBox searchFieldContainer;
    protected HBox topContainer;
    protected TextField searchField;

    protected final  IndexInteractor interactor;

    public IndexView(IndexModel<D> model ,  IndexInteractor interactor){
        this.model = model;
        this.interactor  =interactor;
        this.searchField = createSearchField();
        this.searchFieldContainer = createSearchFieldContainer();
        this.createButton = createButton();
        this.editButton = editButton();
        this.topContainer = createTopContainer();
        this.table= createTable();
        this.buttonsContainer = createButtonsContainer();
        this.container = createMainContainer();
        paginate();
        addToContainers();
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
        return table_local;
    }

    public Pagination getPagination(){
        return  pagination;
    }

    protected  TableView<D> getTableView(){
        return table;
    }

    public StringProperty searchProperty(){
        return searchField.textProperty();
    }
    private void paginate(){
        pagination.setPageFactory(pageIndex ->{
            model.index().set(pageIndex);
            return  createTable();
        });
    }

    private void addToContainers(){
        buttonsContainer.getChildren()
        .addAll(
            createButton,
            editButton
        );
        searchFieldContainer.getChildren()
        .addAll(
            searchField
        );

        topContainer.getChildren()
        .addAll(
            searchFieldContainer,
            buttonsContainer
        );
        container.getChildren()
        .addAll(
            topContainer,
            pagination
        );
    }

    protected VBox createMainContainer(){
        container = new VBox();
        container.setPadding(new Insets(10,10,10,10));
        return  container;
    }

    protected TextField createSearchField(){
        TextField field = new TextField();
        
        return field;
    }

    protected  HBox createButtonsContainer(){
        buttonsContainer = new HBox();
        buttonsContainer.setAlignment(Pos.CENTER_RIGHT);
        buttonsContainer.setSpacing(5);
        return buttonsContainer;
    }

    protected HBox createSearchFieldContainer(){
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER_LEFT);
        container.setHgrow(container, Priority.ALWAYS);
        return container;
    }

    protected  HBox createTopContainer(){
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        return  container;
    }

    protected abstract  List<TableColumn<D, ?>> createColumns();
    protected abstract Button createButton();
    protected abstract Button editButton();
    
    
    
    
}
