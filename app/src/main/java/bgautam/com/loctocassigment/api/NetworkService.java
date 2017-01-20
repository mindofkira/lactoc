package bgautam.com.loctocassigment.api;

import bgautam.com.loctocassigment.util.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gautam on 20/01/17.
 */
public class NetworkService {

    private static APIEndpoint apiEndpoint;

    public APIEndpoint getInstance() {

        if (apiEndpoint == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.SERVER_URL)
                    .build();

            apiEndpoint = retrofit.create(APIEndpoint.class);
        }
        return apiEndpoint;
    }
}
