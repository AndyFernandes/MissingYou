package br.ufc.missingyou.services;

import java.util.List;

import br.ufc.missingyou.model.Quadro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceAPI {
    @GET("selecionarCampanhaBairro/{bairro}")
    Call<List<Quadro>> getCampanhasBairro(@Path("bairro") String bairro);

    @POST("validarLogin")
    Call<List<User>> login(@Body User user);

}
