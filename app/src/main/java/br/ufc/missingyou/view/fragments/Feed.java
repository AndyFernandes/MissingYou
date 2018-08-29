package br.ufc.missingyou.view.fragments;


import android.content.res.TypedArray;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import br.ufc.missingyou.R;
import br.ufc.missingyou.adapters.CustomListAdapter;
import br.ufc.missingyou.model.Quadro;
import br.ufc.missingyou.services.FeedService;
import br.ufc.missingyou.services.ServiceListener;
import br.ufc.missingyou.view.activitys.MapsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feed extends Fragment {

    String[] nomes;
    TypedArray fotos;
    String[] locais_desaparecimento;
    String[] data_desaparecimentos;
    String[] dataNascimentoDesaparecido;
    String[] corOlhosDesaparecidos;
    String[] cabelosDesaparecidos;
    String[] sexoDesaparecidos;
    String[] racasDesaparecidos;
    String[] idDesaparecids;

    String[] statusCampanhasPerdidas;
    String[] dataCampanhas;
    String[] numerosBO;
    String[] idUsuarios;

    List<Quadro> quadros;
    ListView listView;

    private GpsTracker gpsTracker;




    public Feed() {}


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        fotos = getResources().obtainTypedArray(R.array.fotos);

        FeedService service = FeedService.getInstance(getActivity());
        service.getCampanhas(Bairro(), new ServiceListener<List<Quadro>>() {
            @Override
            public void onComplete(List<Quadro> quadros) {
                CustomListAdapter adapter = new CustomListAdapter(getActivity(), quadros);
                for(int i = 0; i < quadros.size(); i++){
                    quadros.get(i).setFoto_id(fotos.getResourceId(i, -1));
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(String erro) {
                Toast.makeText(getActivity(), "Serviço indisponível", Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public String Bairro(){
        gpsTracker = new GpsTracker(getActivity());
        gpsTracker.getLocation();
        String Bairro;
        String NomeBairro;

        Geocoder geo = new Geocoder(getContext(), Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geo.getFromLocation(gpsTracker.getLatitude(), gpsTracker.getLongitude(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Address address = addresses.get(0);


        NomeBairro = address.getAddressLine(0);
        String[] SplitBairro = NomeBairro.split(",");
        String NumeroBairro = SplitBairro[1];
        String[] BairroSplit = NumeroBairro.split("-");
        Bairro = BairroSplit[1];

        Bairro = Bairro.trim();

        return Bairro;
    }
}
