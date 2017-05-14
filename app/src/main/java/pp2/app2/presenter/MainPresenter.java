package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;
import pp2.app2.activities.ProductoActivity;

/**
 * Created by fcazzari on 14/05/2017.
 */

public class MainPresenter {

    public void armarVista(Context contexto) {

        Intent i = new Intent(contexto, ProductoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        contexto.startActivity( i );

    }
}
