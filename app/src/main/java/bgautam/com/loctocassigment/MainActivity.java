package bgautam.com.loctocassigment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import bgautam.com.loctocassigment.api.APIEndpoint;
import bgautam.com.loctocassigment.api.NetworkService;
import bgautam.com.loctocassigment.distancecalulator.HaversineDistanceCalculator;
import bgautam.com.loctocassigment.entity.APICoordinateRequest;
import bgautam.com.loctocassigment.entity.APICoordinateResponse;
import bgautam.com.loctocassigment.entity.APIKeyRequest;
import bgautam.com.loctocassigment.entity.APIKeyResponse;
import bgautam.com.loctocassigment.util.Constants;
import bgautam.com.loctocassigment.util.NumberFormatter;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button getDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        initializeListeners();
    }

    private void initializeView() {
        getDistance = (Button) findViewById(R.id.get_distance_button);
    }

    private void initializeListeners() {
        getDistance.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        CalculateDistanceAsync async = new CalculateDistanceAsync(this);
        async.execute();
    }

    private class CalculateDistanceAsync extends AsyncTask<Void, Void, Double> {

        public static final String ERROR_WHILE_COMPUTING_THE_DISTANCE = "Error while computing the distance";
        public static final String DISTANCE_IN_KMS = "Distance in KMS : ";
        public static final String GETTING_DISTANCE = "Getting Distance";
        public static final String PROGRESS_DIALOG = "Progress Dialog";

        private ProgressDialog progressDialog = null;
        private String permanentKey;
        private Context applicationContext;

        CalculateDistanceAsync(Context applicationContext) {
            this.applicationContext = applicationContext;
            progressDialog = new ProgressDialog(this.applicationContext );
            progressDialog.setMessage(GETTING_DISTANCE);
            progressDialog.setTitle(PROGRESS_DIALOG);
            progressDialog.setCancelable(false);
        }

        @Override
        protected void onPostExecute(Double result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result == null) {
                Toast.makeText(this.applicationContext ,  ERROR_WHILE_COMPUTING_THE_DISTANCE, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this.applicationContext , DISTANCE_IN_KMS + NumberFormatter.convertDoubleToTwoDecimals(result), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected Double doInBackground(Void... params) {

            APICoordinateResponse coordinateResponse1;
            APICoordinateResponse coordinateResponse2;
            HaversineDistanceCalculator haversineDistanceCalculator = new HaversineDistanceCalculator();
            final APIEndpoint service = new NetworkService().getInstance();

            APIKeyRequest req = new APIKeyRequest();
            req.setTempKey(Constants.DEFAULT_KEY);
            Call<APIKeyResponse> responseCall = service.getKey(req);
            try {
                permanentKey = responseCall.execute().body().getPermKey();
            } catch (Exception exception) {
                return null;
            }

            APICoordinateRequest apiCoordinateRequest = new APICoordinateRequest();
            apiCoordinateRequest.setPermKey(permanentKey);

            Call<APICoordinateResponse> coordinateResponseCall1 = service.getCoordinates(apiCoordinateRequest);
            Call<APICoordinateResponse> coordinateResponseCall2 = service.getCoordinates(apiCoordinateRequest);

            try {
                coordinateResponse1 = coordinateResponseCall1.execute().body();
            } catch (IOException e) {
                return null;
            }

            try {
                coordinateResponse2 = coordinateResponseCall2.execute().body();
            } catch (IOException e) {
                return null;
            }

            return haversineDistanceCalculator.getDistance(coordinateResponse1, coordinateResponse2);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

    }
}
