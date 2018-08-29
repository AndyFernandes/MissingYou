package br.ufc.missingyou.services;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import br.ufc.missingyou.model.Quadro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedService {
    private Context context;
    private static FeedService instance;

    private FeedService(Context context){
        this.context = context;
    }

    public static FeedService getInstance(Context context){
        if(instance == null){
            instance = new FeedService(context);
        }
        return instance;
    }

    public void getCampanhas(String bairro, final ServiceListener<List<Quadro>> listener) {
        ServiceAPI service = RequestGenerator.createService(ServiceAPI.class);

        Call<List<Quadro>> campanhasBairro = service.getCampanhasBairro(bairro);
        
        campanhasBairro.enqueue(new Callback<List<Quadro>>() {
            @Override
            public void onResponse(Call<List<Quadro>> call, Response<List<Quadro>> response) {
                if (response.isSuccessful()) {
                    List<Quadro> listaBody = response.body();

                    listener.onComplete(listaBody);
                } else {
                    try {
                        listener.onError(response.errorBody().string());
                    } catch (IOException e) {
                        listener.onError("Serviço indisponível");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Quadro>> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }

    public void login(User user, final ServiceListener<List<User>> listener){
        ServiceAPI service = RequestGenerator.createService(ServiceAPI.class);

        Call<List<User>> call = service.login(user);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> body = response.body();
                    listener.onComplete(body);
                } else {
                    try{
                        listener.onError(response.errorBody().string());
                    } catch (IOException e){
                        listener.onError("Serviço indisponível");
                    }
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }

}
