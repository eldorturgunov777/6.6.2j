package com.example.a662j;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eldor Turgunov on 01.07.2022.
 * 6.6.2j
 * eldorturgunov777@gmail.com
 */
public class VolleyHttp {

    public static String TAG = VolleyHttp.class.getSimpleName();
    public static boolean IS_TESTER = true;
    private static final String SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/";
    private static final String SERVER_PRODUCTION = "https://dummy.restapiexample.com/api/v1/";

    static String server(String api) {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT + api;
        return SERVER_PRODUCTION + api;
    }

    static HashMap<String, String> headers() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json; charset=UTF-8");
        return headers;
    }

    public static void get(String api, HashMap<String, String> params, VolleyHandler handler) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, server(api),
                response -> {
                    Logger.d(TAG, response);
                    handler.onSuccess(response);
                }, error -> {
                    Logger.e(TAG, error.toString());
                    handler.onError(error.toString());
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        App.instance.addToRequestQueue(stringRequest);
    }

    public static void post(String api, HashMap<String, String> body, VolleyHandler handler) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server(api),
                response -> {
                    Logger.d(TAG, response);
                    handler.onSuccess(response);
                }, error -> {
                    Logger.e(TAG, error.toString());
                    handler.onError(error.toString());
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers();
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return new JSONObject(body).toString().getBytes();
            }
        };
        App.instance.addToRequestQueue(stringRequest);
    }

    public static void put(String api, HashMap<String, String> body, VolleyHandler handler) {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, server(api),
                response -> {
                    Logger.d(TAG, response);
                    handler.onSuccess(response);
                }, error -> {
                    Logger.e(TAG, error.toString());
                    handler.onError(error.toString());
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers();
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return new JSONObject(body).toString().getBytes();
            }
        };
        App.instance.addToRequestQueue(stringRequest);
    }

    public static void del(String api, VolleyHandler handler) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, server(api),
                response -> {
                    Logger.d(TAG, response);
                    handler.onSuccess(response);
                }, error -> {
                    Logger.e(TAG, error.toString());
                    handler.onError(error.toString());
                });
        App.instance.addToRequestQueue(stringRequest);
    }

    public static String API_LIST_POST = "employees";
    public static String API_CREATE_POST = "create";
    public static String API_UPDATE_POST = "update/"; //id
    public static String API_DELETE_POST = "delete/"; //id

    public static HashMap<String, String> paramsEmpty() {
        HashMap<String, String> params = new HashMap<String, String>();
        return params;
    }

    public static HashMap<String, String> paramsCreate(Poster poster) {
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("employee_name", poster.getEmployee_name());
        params.put("employee_salary", poster.getEmployee_salary());
        params.put("employee_age", String.valueOf(poster.getEmployee_age()));
        params.put("profile_image", String.valueOf(poster.getProfile_image()));
        return params;
    }

    public static HashMap<String, String> paramsUpdate(Poster poster) {
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("id", String.valueOf(poster.getId()));
        params.put("employee_name", poster.getEmployee_name());
        params.put("employee_salary", poster.getEmployee_salary());
        params.put("employee_age", String.valueOf(poster.getEmployee_age()));
        params.put("profile_image", String.valueOf(poster.getProfile_image()));
        return params;
    }
}
