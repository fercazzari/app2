package pp2.app2.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pp2.app2.R;

public class MainActivityOLD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityold_main);
    }

    public void verCatalogo(View view) {
        Intent intent = new Intent(this, CatalogoActivityOLD.class);
        startActivity(intent);
    }

}
