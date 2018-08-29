package br.ufc.missingyou.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ufc.missingyou.R;
import br.ufc.missingyou.adapters.CustomListAdapterNotificacoes;
import br.ufc.missingyou.model.Notificacao;
import br.ufc.missingyou.model.Quadro;

public class FeedNotificacoes extends Fragment {

    String[] datas;
    String[] descricoes;

    List<Notificacao> notificacoes;
    ListView listView;

    public FeedNotificacoes() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        notificacoes = new ArrayList<Notificacao>();

        datas = getResources().getStringArray(R.array.datas);
        descricoes = getResources().getStringArray(R.array.Nomes);


        for(int i = 0; i < 2; i++){
            Notificacao notificacao = new Notificacao(datas[i], descricoes[i]);
            notificacoes.add(notificacao);
        }

        View view = inflater.inflate(R.layout.fragment_feed_notificacoes, container, false);
        //nao sei se ta certo DUVIDA
        listView = (ListView) view.findViewById(R.id.listNotificacoes);
        CustomListAdapterNotificacoes adapter = new CustomListAdapterNotificacoes(getActivity(), notificacoes);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

}
