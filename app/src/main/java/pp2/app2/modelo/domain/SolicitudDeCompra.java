package pp2.app2.modelo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class SolicitudDeCompra
{
    private List<Item> items;
    private Domicilio domicilioEntrega;
    private MedioDePago medioDePago;

    public SolicitudDeCompra()
    {
        this.items = new ArrayList<>();
        this.domicilioEntrega = null;
    }

    public boolean agregarProducto(Producto p)
    {
        if(VerificadorDeStock.hayStock(p))
        {
            int indice = -1;
            for (Item i : items)
            {
                if (i.esProducto(p))
                {
                    indice = items.indexOf(i);
                    // i.agregarUnidad();
                    return true;
                }
            }
            items.add(new Item(p, 1));
            return true;
        }
        return false;
    }

    //Revisar de quien es la responsabilidad.

    public List<Item> getItems () {
        return this.items;
    }

    public Domicilio getDomicilioEntrega ()
    {
        return this.domicilioEntrega;
    }

    public void setDomicilioEntrega (Domicilio domicilioEntrega) {
        this.domicilioEntrega = new Domicilio();
        this.domicilioEntrega = domicilioEntrega;
    }

    public int calcularTotal () {

        int resultado = 0;
        for (Item i : this.items) {
            resultado += i.getProducto().getPrecio() * i.getCantidad();
        }
        return  resultado;

    }

    public void pagar (MedioDePago medioDePago) {
        medioDePago.pagar(this.calcularTotal());
    }

    /* Npublic void setMedioDePago (MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    } */

    public MedioDePago getMedioDePago () {
        return this.medioDePago;
    }

}
