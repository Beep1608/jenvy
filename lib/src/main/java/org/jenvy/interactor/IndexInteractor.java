package org.jenvy.interactor;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.collections.FXCollections;

public class IndexInteractor<D extends Dto>  extends Interactor<IndexModel<D>> {
    


    public IndexInteractor(IndexModel<D> model){
        super(model);
    }

   public void createPage(Integer index){
        try {
            
            int fromIndex = (int)index * model.pagination().get();
            int toIndex = Math.min(fromIndex + model.pagination().get(), model.items().size());
            model.tempItems().set(
                FXCollections.observableArrayList(
                    model.items().subList(fromIndex, toIndex)
                )
            );

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void createFilteredPage(Integer index){
        try {
            
            int fromIndex = (int)index * model.pagination().get();
            int toIndex = Math.min(fromIndex + model.pagination().get(), model.searchedItems().size());
            model.tempItems().set(
                FXCollections.observableArrayList(
                    model.searchedItems().subList(fromIndex, toIndex)
                )
            );

        } catch (Exception e) {
        
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }

    public void updatePagination() {
        int pageCount = (int) Math.ceil((double) model.items().size() / model.pagination().get());
        model.pageCount().set(Math.max(pageCount, 1));
        createPage(model.index().get());
    }

    public void search(String text){

        if(!text.equals("")){
            model.searchedItems().setPredicate(item -> item.searcheable().toLowerCase().contains(text));
            createFilteredPage(0);
        }else{
            //model.index().set(0);
            //createPage(model.index().get());
        }
    }
}