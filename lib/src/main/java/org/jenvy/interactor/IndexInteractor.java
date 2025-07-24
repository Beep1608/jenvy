package org.jenvy.interactor;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.collections.FXCollections;

public class IndexInteractor extends Interactor{
    


    public IndexInteractor(IndexModel model){
        super(model);
    }

   public void createPage(Integer index){
        try {
            
            int fromIndex = (int)index * getModel().pagination().get();
            int toIndex = Math.min(fromIndex + getModel().pagination().get(), getModel().items().size());
            getModel().tempItems().set(
               FXCollections.observableArrayList(
                    getModel().items().subList(fromIndex, toIndex)
                )
            );

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void createFilteredPage(Integer index){
        try {
            System.out.println("Chetos");
            int fromIndex = (int)index * getModel().pagination().get();
            int toIndex = Math.min(fromIndex + getModel().pagination().get(), getModel().searchedItems().size());
            getModel().tempItems().set(
                FXCollections.observableArrayList(
                    getModel().searchedItems().subList(fromIndex, toIndex)
                )
            );

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void updateFilteredPagination(){
        int pageCount = (int) Math.ceil((double) getModel().searchedItems().size() / getModel().pagination().get());
        getModel().pageCount().set(Math.max(pageCount, 1));
        getModel().index().set(0);
        createFilteredPage(getModel().index().get());
    }

    public void updatePagination() {
        int pageCount = (int) Math.ceil((double) getModel().items().size() / getModel().pagination().get());
        getModel().pageCount().set(Math.max(pageCount, 1));
        createPage(getModel().index().get());
    }

    public void search(String text){
  
        if(!text.equals("")){
            System.out.println("Chetos1");
            getModel().searchedItems().setPredicate(item -> ((Dto)item).searcheable().toLowerCase().contains(text));
            updateFilteredPagination();
            return;
        }
        if(text.equals("") && getModel().index().get()!= 0){
             System.out.println("Chetos2");
            getModel().index().set(0);
        }else{

             System.out.println("Chetos3");
            updatePagination();
        }
    }

    private void printSearchedItems(){
        for (var item : getModel().searchedItems()) {
                System.out.println("Item "+ ((Dto)item).searcheable());
        }
    }

    @Override
    public IndexModel getModel() {
        return (IndexModel)model;
    }

    
}