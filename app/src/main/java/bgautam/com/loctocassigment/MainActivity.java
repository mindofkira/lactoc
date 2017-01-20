package bgautam.com.loctocassigment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
        getDistance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Getting Distance");
        pd.setTitle("Progress Dialog");
        pd.show();
    }
}
