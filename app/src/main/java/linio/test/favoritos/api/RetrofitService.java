package linio.test.favoritos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Service class that instance retrofit service.
 *
 * @author Rigoberto Torres
 * @version 0.0.1
 * @since January 15, 2021
 */
public class RetrofitService {

    private static String BASE_URL = "https://raw.githubusercontent.com";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
