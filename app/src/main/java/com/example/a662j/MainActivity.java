package com.example.a662j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get();
        post();
//        put();
//        delete();


    }

    Poster poster = new Poster(2, "Elon Mask", "35000", 24, 0);

    void get() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void post() {
        VolleyHttp.post(VolleyHttp.API_CREATE_POST, VolleyHttp.paramsCreate(poster), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
            }

            @Override
            public void onError(String error) {
            }
        });
    }

    private void put() {
        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + poster.getId(), VolleyHttp.paramsUpdate(poster), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
            }

            @Override
            public void onError(String error) {
            }
        });
    }

    private void delete() {
        VolleyHttp.del(VolleyHttp.API_DELETE_POST + poster.getId(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
            }

            @Override
            public void onError(String error) {
            }
        });
    }
}