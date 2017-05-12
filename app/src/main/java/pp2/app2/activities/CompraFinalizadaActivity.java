package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pp2.app2.R;

public class CompraFinalizadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_finalizada);

        TextView lbl_compra_finalizada = (TextView)findViewById(R.id.lbl_compra_finalizada);
        lbl_compra_finalizada.setText("Compra finalizada correctamente!");

    }
}
