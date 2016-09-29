package org.dalol.aisapirest.model.api;

import com.google.gson.GsonBuilder;

import org.dalol.aisapirest.model.utilities.Constants;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class RestApiManager {

    private AlunoApi mAlunoApi;

    public AlunoApi getAlunoApi() {

        if(mAlunoApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mAlunoApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(AlunoApi.class);
        }
        return mAlunoApi;
    }

}
