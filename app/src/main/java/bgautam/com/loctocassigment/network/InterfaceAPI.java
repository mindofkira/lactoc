package bgautam.com.loctocassigment.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by gautam on 20/01/17.
 */
public interface InterfaceAPI {

        @POST("/getKey")
        @Headers( "Content-Type: application/json" )
        Call<APIKeyResponse> getKey(
                @Body APIKeyRequest request
        );

    @POST("/getCoordinates")
    @Headers( "Content-Type: application/json" )
    Call<APICoordinateResponse> getCoordinates(
            @Body APICoordinateRequest request
    );
}
