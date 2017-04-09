package br.com.pirlamps.farmtracker.foundation.joat;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.pirlamps.farmtracker.BR;
import br.com.pirlamps.farmtracker.R;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by matheus on 11/10/16.
 * Este é um adapter para qualquer ocasião, podendo haver headers em um grupo de views, ou seja "Section".
 *
 */

public class JoatAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<JoatObject> joatObjects;
    private int count;
    private LayoutInflater inflater;
    private int headerMeasure;

    public JoatAdapter(Context context){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.joatObjects = new ArrayList<>();
    }

    /**
     * Recebe uma lista de JoatObject e muda os dados da lista, caso haja uma lista anteriormente já setada ela será apagada.
     * @param joatObjects Uma lista de JoatObject.
     */
    public void setData(List<JoatObject> joatObjects){
        this.joatObjects = joatObjects;
        notifyDataSetChanged();
    }

    /**
     * Recebe uma lista de JoatObject e muda os dados da lista, caso haja uma lista anteriormente já setada, a nova será adicioinada na lista anterior.
     * @param joatObjects Uma lista de JoatObject.
     */
    public void addData(List<JoatObject> joatObjects) {
        this.joatObjects.addAll(joatObjects);
        notifyDataSetChanged();
    }

    /**
     * Remove todos os objetos com o HeaderID informado
     * @param headerID pode ser tanto como a propriedade headerType de um JoatObject como o hashcode do nome do header.
     */
    public void removeByHeader(Integer headerID){
        for(JoatObject item: this.joatObjects){
            if(item.getHeaderType().equals(headerID)){
                this.joatObjects.remove(item);
            }
        }
        notifyDataSetChanged();
    }

    /**
     * Retorna o tamanho da lista sem os headers.
     * @return Inteiro com o tamanho da lista.
     */
    @Override
    public int getCount() {
        return joatObjects==null ? 0 : joatObjects.size();
    }

    /**
     * Retorna o objeto na posição desejada na lista.
     * @param position a posição na lista que será pego o objeto.
     * @return Object referente à posição da lista.
     */
    @Override
    public Object getItem(int position) {
        return joatObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JoatObject object = joatObjects.get(position);
        ViewDataBinding viewDataBinding;
        if(convertView == null) {
            viewDataBinding = DataBindingUtil.inflate(this.inflater, object.getBindingRes(), parent, false);
            convertView = viewDataBinding.getRoot();
            convertView.setTag(viewDataBinding);
        }else{
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }

        viewDataBinding.setVariable(object.getBindingObjectID(), object.getBindingObject());

        return convertView;
    }


    /**
     * Retorna o número de rows + o número de headers inflados.
     * @return Inteiro com o total.
     */
    public int getTotalCount(){
        List<Integer> aux = new ArrayList<>();
        for(JoatObject item : this.joatObjects){
            if(!aux.contains(item.getHeaderType())){
                aux.add(item.getHeaderType());
            }
        }
        return aux.size() + getCount();
    }

    /**
     *
     * @return
     */
    public int getHeaderCount(){
        List<Integer> aux = new ArrayList<>();
        for(JoatObject item : this.joatObjects){
            if(!aux.contains(item.getHeaderType())){
                aux.add(item.getHeaderType());
            }
        }
        return aux.size();
    }

    public int getHeaderMeasure(){
        return headerMeasure;
    }

    //Retorna a View do Header por ID
    //não pode retronar null!
    @Override
    public View getHeaderView(final int position, View convertView, ViewGroup parent) {
        if(getHeaderId(position)!= 0) {
            JoatObject object = joatObjects.get(position);
            ViewDataBinding viewDataBinding;
            if (convertView == null) {

                viewDataBinding = DataBindingUtil.inflate(this.inflater, R.layout.header_simple, parent, false);
                convertView = viewDataBinding.getRoot();
                convertView.setTag(viewDataBinding);
            } else {
                viewDataBinding = DataBindingUtil.getBinding(convertView);
            }
            viewDataBinding.setVariable(BR.joat, object);
        }else{
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.header_empty, null, false);
            }
            convertView.measure(0,0);
            headerMeasure = convertView.getMeasuredHeight();
        }
        return convertView;
    }
    //Retorna o ID do header
    //não pode retronar null!
    @Override
    public long getHeaderId(int position) {
        JoatObject object = joatObjects.get(position);
        return object.getHeaderType();
    }

    /**
     * Método que retorna a lista de joatObjects
     * @return
     */
    public List<JoatObject> getData(){
        return joatObjects;
    }
}