package org.dalol.aisapirest.controller;

import android.util.Log;

import org.dalol.aisapirest.model.api.RestApiManager;
import org.dalol.aisapirest.model.dado.Alunos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private FlowerCallbackListener mListener;
    private RestApiManager mApiManager;

    public Controller(FlowerCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getAlunoApi().getAlunos(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);

                try {
                    JSONArray array = new JSONArray(s);

                    for(int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        Alunos alunos = new Alunos.Builder()
                                .setAluno(object.getString("aluno"))
                                .setTurma(object.getString("turma"))
                                .setSerie(object.getInt("serie"))
                                .build();

                        mListener.onFetchProgress(alunos);

                    }

                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }


                mListener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }

    public interface FlowerCallbackListener {

        void onFetchStart();
        void onFetchProgress(Alunos alunos);
        void onFetchProgress(List<Alunos> alunosList);
        void onFetchComplete();
        void onFetchFailed();
    }
}
