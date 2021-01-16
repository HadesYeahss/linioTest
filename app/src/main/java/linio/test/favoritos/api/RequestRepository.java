package linio.test.favoritos.api;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import linio.test.favoritos.model.RequestEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Repository class that serves as favorites lists.
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class RequestRepository {

    private static RequestRepository requestRepository;

    /**
     * Instance a RequestRepository
     * @return
     */
    public static RequestRepository getInstance() {
        if (requestRepository == null) {
            requestRepository = new RequestRepository();
        }
        return requestRepository;
    }

    private RequestApi requestApi;

    /**
     * Instance a retrofit service
     */
    public RequestRepository() {
        requestApi = RetrofitService.cteateService(RequestApi.class);
    }

    /**
     * Send request for favorites lists
     * @return
     */
    public MutableLiveData<List<RequestEntity>> getLists() {
        MutableLiveData<List<RequestEntity>> newsData = new MutableLiveData<>();
        requestApi.getLists().enqueue(new Callback<List<RequestEntity>>() {
            @Override
            public void onResponse(Call<List<RequestEntity>> call, Response<List<RequestEntity>> response) {
                newsData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RequestEntity>> call, Throwable t) {
                newsData.setValue(null);
            }

        });
        return newsData;
    }
}
