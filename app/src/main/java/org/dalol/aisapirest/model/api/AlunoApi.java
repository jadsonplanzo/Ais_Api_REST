package org.dalol.aisapirest.model.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public interface AlunoApi {

    @GET("notas.json")
    void getAlunos(Callback<String> alunos);
}
