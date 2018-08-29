package br.ufc.missingyou.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufc.missingyou.R;
import br.ufc.missingyou.model.Notificacao;
import br.ufc.missingyou.model.Quadro;
import br.ufc.missingyou.view.activitys.QuadroTelaFeed;

public class CustomListAdapterNotificacoes extends BaseAdapter {

    Activity context;
    LayoutInflater inflater;
    List<Notificacao> feedItems;

    public CustomListAdapterNotificacoes(FragmentActivity activity, List<Notificacao> notificacoes){
        this.context = activity;
        this.feedItems = notificacoes;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int position) {
        return feedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return feedItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView data;
        TextView descricao;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_notificacoes, null);
        }

        holder = new CustomListAdapterNotificacoes.ViewHolder();

        holder.data = (TextView) convertView.findViewById(R.id.data_notificacao);
        holder.descricao = (TextView) convertView.findViewById(R.id.descricao);


        final Notificacao row_pos = feedItems.get(position);

        holder.data.setText(row_pos.getData_notificacao());
        holder.descricao.setText(row_pos.getDescricao());

        return convertView;
    }
}
