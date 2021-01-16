package linio.test.favoritos.api;

import java.util.List;

import linio.test.favoritos.model.RequestEntity;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Provides a inteface requestApi
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
interface RequestApi {
    /**
     * Get request
     * @return lists of favorites
     */
    @GET("/linio-mobile-devs/linio-test-files/main/wishlist.json")
    Call<List<RequestEntity>> getLists();
}
