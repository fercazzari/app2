package pp2.app2.vista.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pp2.app2.R;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Categoria;

public class CarritoActivity extends AppCompatActivity {

    Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);



    }
}
