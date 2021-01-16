package linio.test.favoritos.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import linio.test.favoritos.api.RequestRepository;
import linio.test.favoritos.model.ProductEntity;
import linio.test.favoritos.model.RequestEntity;


/**
 * Class used as viewmodel of fragment favorites
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class FavoritosViewModel extends ViewModel {

    private MutableLiveData<List<RequestEntity>> mRequestMutableLiveData;
    private RequestRepository requestRepository;
    private static String LIST_PERMISION = "public";

    public void init() {
        if (mRequestMutableLiveData != null) {
            return;
        }
        requestRepository = RequestRepository.getInstance();
        mRequestMutableLiveData = requestRepository.getLists();
    }

    public LiveData<List<RequestEntity>> getRequestRepository() {
        return mRequestMutableLiveData;
    }

    /**
     * Get object request whit filter
     *
     * @return List of RequestEntity
     */
    public LiveData<List<RequestEntity>> getRequestWhitPermisionRepository() {
        List<RequestEntity> favoritefilterlist = new ArrayList<RequestEntity>();
        for (RequestEntity favoriteList : mRequestMutableLiveData.getValue()) {
            if (favoriteList.getVisibility().equals(LIST_PERMISION)) {
                favoritefilterlist.add(favoriteList);
            }

        }
        mRequestMutableLiveData.setValue(favoritefilterlist);
        return mRequestMutableLiveData;
    }

    /**
     * Get list of all products in all favorites lists
     *
     * @return List of ProductEntity
     */
    public List<ProductEntity> getProducts() {
        List<ProductEntity> products = new ArrayList<ProductEntity>();
        for (RequestEntity favoriteList : mRequestMutableLiveData.getValue()) {
            for (Map.Entry<String, ProductEntity> entry : favoriteList.getProducts().entrySet()) {
                //TODO verify validations with the client
                /*if (entry.getValue().isActive()) {
                    products.add(entry.getValue());
                }*/
                products.add(entry.getValue());

            }
        }
        return products;

    }

}
