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
    private Estado estado;

    public SolicitudDeCompra()
    {
        this.items = new ArrayList<>();
        this.domicilioEntrega = null;
        this.medioDePago= null;
        this.estado = null;
    }

    public boolean agregarProducto(Producto p)
    {
        if(VerificadorDeStock.hayStock(p))
        {
            int indice = -1;
            for (Item i : items)
            {
                if (i.getProducto().equals(p))
                {
                    indice = items.indexOf(i);
                    i.agregarUnidad(i);
                }
            }
            if (indice != -1)
            {
                return true;
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

    public void agregarDomicilio (Domicilio domicilioEntrega) {
       if (VerificadorDomicilio.existeDomicilio(domicilioEntrega)){
           this.domicilioEntrega = domicilioEntrega;
       }
    }

    public int calcularTotal () {

        int resultado = 0;
        for (Item i : this.items) {
            resultado += i.getProducto().getPrecio() * i.getCantidad();
        }
        return  resultado;

    }

    public MedioDePago getMedioDePago () {
        return this.medioDePago;
    }

    public void agregarMedioDePago (MedioDePago medioDePago) {
        if (APIPago.esValido(medioDePago)) {
            this.medioDePago = medioDePago;
        }
    }

    public Estado getEstado () {
        return this.estado;
    }

    public void setEstado (Estado estado) {
        this.estado = estado;
    }

    public void setDomicilioEntrega (Domicilio domicilio) {
        this.domicilioEntrega = domicilio;
    }

    public void setMedioDePago (MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public void confirmar() {
        this.estado = Estado.LISTA;
    }

    public void finalizar() {
        this.estado = Estado.FINALIZADA;
    }

}
