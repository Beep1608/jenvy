package org.jenvy.interactor;

import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;

import javafx.collections.FXCollections;

public class IndexInteractor<D extends Dto>  extends Interactor<IndexModel<D>> {
    


    public IndexInteractor(IndexModel<D> model){
        super(model);
    }

   protected  Void createPage(Integer index){


        try {
            
            int fromIndex = (int)index * model.pagination().get();
            int toIndex = Math.min(fromIndex + model.pagination().get(), model.items().size());
    
            model.tempItems().set(
                FXCollections.observableArrayList(
                    model.items().subList(fromIndex, toIndex)
                )
            );

        } catch (Exception e) {
        
            System.out.println(e.getMessage());
        }


        return null;
    }

    //  private void updatePagination() {
    //     int pageCount = (int) Math.ceil((double) model.items().size() / model.pagination().get());
    //     pagination.setPageCount(Math.max(pageCount, 1));
    // }
}