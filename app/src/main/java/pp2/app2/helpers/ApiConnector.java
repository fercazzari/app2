package pp2.app2.helpers;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jony on 25/03/2017.
 */

public class ApiConnector
{
    private URL url;

    public ApiConnector()
    {

    }

    public boolean revisarConexion(String url)
    {
        try {
            this.url = new URL(url);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void abrirConexion()
    {

    }
}
