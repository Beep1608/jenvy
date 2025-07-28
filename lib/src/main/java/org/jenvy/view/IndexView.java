package org.jenvy.view;


import java.util.List;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
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

    protected final VBox container;
    protected HBox buttonsContainer;
    protected HBox searchFieldContainer;
    protected HBox topContainer;
    protected TextField searchField;

    protected IndexModel model;
    public IndexView(IndexModel model){
        this.model = model;
        this.searchField = createSearchField();
        this.searchFieldContainer = createSearchFieldContainer();
        this.createButton = createButton();
        this.editButton = editButton();
        this.topContainer = createTopContainer();
        this.buttonsContainer = createButtonsContainer();
        this.container = createMainContainer();
        container.getStylesheets().add(
            IndexView.class.getResource("/org/jenvy/styles.css").toExternalForm()
        );
        
        paginate();
        addToContainers();
        listeners();
  
    }

    @Override
    public Region build() {
        return container;
    }

    protected <D extends Dto>  TableView<D> createTable(){
        
       TableView<D> table_local = new TableView<>();
        table_local.setItems( 
           getModel().tempItems()
        );
        table_local.getColumns().setAll(createColumns());
        table_local.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table_local.getStyleClass().add("table-view");
        table_local.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
            
            if(newValue != null){
                System.out.println("El nuevo dto es:" + newValue.searcheable());
                getModel().selectedItem().set(newValue);
                System.out.println("Nuevo modelo en modelo ejeje: "+ getModel().selectedItem().get());
            }
        });

        return table_local;
    }

    public Pagination getPagination(){
        return  pagination;
    }

    public StringProperty searchProperty(){
        return searchField.textProperty();
    }
    private void paginate(){
        pagination.setPageFactory(pageIndex ->{
            System.out.println("Page : " + pageIndex);
           getModel().index().set(pageIndex);
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


    protected IndexModel getModel(){
        return  model;
    }

    public void listeners(){
                
    
        model.visible().addListener((obs, oldVal, newValue) ->{
            
        });

        getModel().items().addListener((ListChangeListener)change->{
           
              updatePagination();

        });
    

        getModel().index().addListener((obs, oldVal, newValue) ->{
            if(getModel().search().get().equals("")){
                updatePagination();
            }
        });

        searchProperty().addListener((obs, oldVal, newValue) ->{
            search(newValue);
        });

    }


    //Interactor


    public void updateFilteredPagination(){
        int pageCount = (int) Math.ceil((double) getModel().searchedItems().size() / getModel().pagination().get());
        
        getModel().pageCount().set(Math.max(pageCount, 1));
        getModel().index().set(0);
       
        int index = getModel().index().get();

         try {
            
            int fromIndex = (int)index * getModel().pagination().get();
            int toIndex = Math.min(fromIndex + getModel().pagination().get(), getModel().searchedItems().size());
            getModel().updateTempItems(getModel().searchedItems().subList(fromIndex, toIndex));
           getPagination().setPageCount(pageCount);

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void updatePagination() {
        System.out.println("Index : "+ getModel().index());
        int pageCount = (int) Math.ceil((double) getModel().items().size() / getModel().pagination().get());
        getModel().pageCount().set(Math.max(pageCount, 1));
        int index = getModel().index().get();
        try {
            
            int fromIndex = (int)index * getModel().pagination().get();
            int toIndex = Math.min(fromIndex + getModel().pagination().get(), getModel().items().size());

            getModel().updateTempItems(getModel().items().subList(fromIndex, toIndex));
            System.out.println("Form index :" + fromIndex);
            System.out.println("to index :" + toIndex);

            getPagination().setPageCount(pageCount);
            

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void search(String text){
  
        if(!text.equals("")){
            System.out.println("Chetos1");
            getModel().searchedItems().setPredicate(item -> ((Dto)item).searcheable().toLowerCase().contains(text));
            updateFilteredPagination();
            System.out.println(" Searcheditems : "+ getModel().searchedItems().size());
            return;
        }
        if(text.equals("") && getModel().index().get()!= 0){
      
            getModel().index().set(0);
        }else{
            
            updatePagination();
        }

    
    }
}
