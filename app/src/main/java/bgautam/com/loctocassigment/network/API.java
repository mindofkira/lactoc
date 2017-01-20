package bgautam.com.loctocassigment.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gautam on 20/01/17.
 */
public class API {

    private static final String SERVER_URL = "http://139.59.12.25";

    private static  InterfaceAPI service;

    public InterfaceAPI getInstance() {

        synchronized (this) {
            if(service==null) {
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                Retrofit retrofit = new Retrofit.Builder()
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(SERVER_URL)
                        .build();

                service = retrofit.create(InterfaceAPI.class);
            }
        }
        return  service;
    }
}
