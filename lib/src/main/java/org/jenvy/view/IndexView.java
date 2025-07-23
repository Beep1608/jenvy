package org.jenvy.view;


import java.util.List;

import org.jenvy.dto.Dto;
import org.jenvy.interactor.IndexInteractor;
import org.jenvy.model.IndexModel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
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
//TODO: Mejorar estilo de barra de busqueda y de tabla, botones crear y editar y pagiando
public abstract  class IndexView extends View {
    protected final Pagination pagination = new Pagination();
    private final Button editButton;
    private final Button createButton;
    protected final TableView<Dto> table;
    protected final VBox container;
    protected HBox buttonsContainer;
    protected HBox searchFieldContainer;
    protected HBox topContainer;
    protected TextField searchField;

    public IndexView(IndexModel model ,  IndexInteractor interactor){
        super(model, interactor);
        this.searchField = createSearchField();
        this.searchFieldContainer = createSearchFieldContainer();
        this.createButton = createButton();
        this.editButton = editButton();
        this.topContainer = createTopContainer();
        this.table= createTable();
        this.buttonsContainer = createButtonsContainer();
        this.container = createMainContainer();
        container.getStylesheets().add(
            IndexView.class.getResource("/org/jenvy/styles.css").toExternalForm()
        );

        paginate();
        addToContainers();
  
    }

    @Override
    public Region build() {
        return container;
    }

    protected <D extends Dto>  TableView<D> createTable(){
        
       TableView<D> table_local = new TableView<>();
        table_local.setItems( 
            FXCollections.observableArrayList( 
            ((IndexModel)model).tempItems())
        );
        table_local.getColumns().setAll(createColumns());
        table_local.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table_local.getStyleClass().add("table-view");
        table_local.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
            System.out.println("El nuevo dto es:" + newValue.searcheable());
            if(newValue != null){
                getModel().selectedItem().set(newValue);
                System.out.println("Nuevo modelo en modelo ejeje: "+ getModel().selectedItem().get());
            }
        });
        return table_local;
    }

    public Pagination getPagination(){
        return  pagination;
    }

    protected  TableView<Dto> getTableView(){
        return table;
    }

    public StringProperty searchProperty(){
        return searchField.textProperty();
    }
    private void paginate(){
        pagination.setPageFactory(pageIndex ->{
           ((IndexModel)model).index().set(pageIndex);
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
        VBox container = new VBox();
        container.setPadding(new Insets(10,10,10,10));
        container.setSpacing(10);
        container.setAlignment(Pos.CENTER);
        container.getStyleClass().add("main-container");
        return  container;
    }

    protected TextField createSearchField(){
        TextField field = new TextField();
        field.getStyleClass().add("search-field");
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
        container.getStyleClass().add("search-container");
        return container;
    }

    protected  HBox createTopContainer(){
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        return  container;
    }

    protected abstract <D extends Dto>  List<TableColumn<D, ?>> createColumns();
    protected abstract Button createButton();
    protected abstract Button editButton();

   

    public Button getCreateButton(){
        return  createButton;
    }

    public Button getEditButton(){
        return editButton;
    }

    @Override
    protected IndexModel getModel(){
        return (IndexModel)model;
    }
    
    
}
