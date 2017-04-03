package pp2.app2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pp2.app2.R;
import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 25/03/2017.
 */

public class ProductoAdapter extends BaseAdapter{

    private List<Producto> productos;
    private LayoutInflater inflater;

    public ProductoAdapter(List<Producto> productos, LayoutInflater inflater) {
        this.productos = productos;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return this.productos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewItem item;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, null);
            item = new ViewItem();

            item.imageViewProducto = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem);

            item.tituloProducto = (TextView) convertView.findViewById(R.id.TextViewItem);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Producto actual = productos.get(position);

        item.imageViewProducto.setImageDrawable(actual.getImagen());
        item.tituloProducto.setText(actual.getDescripcion());

        return convertView;

    }

    private class ViewItem {
        ImageView imageViewProducto;
        TextView tituloProducto;
    }
}
