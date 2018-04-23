package com.example.mohmedmostafa.dregypt.Data.remoteDataSource;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mohmedmostafa.dregypt.DrEgyptApp;

import java.util.HashMap;
import java.util.Map;


public class VolleyLIbUtils extends StringRequest implements Response.Listener<String> , Response.ErrorListener{

    public int  method;
    public String url;
    Response.Listener<String> listener;
    Response.ErrorListener errorListener;
    Context context;

    private HashMap<String, String> params;

    /**
     *
     * @param context
     * @param method
     * @param url
     * @param listener
     * @param errorListener
     */
    public VolleyLIbUtils(Context context, int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener ) {
        super(method, url, listener, errorListener);
        this.method=method;
        this.url=url;
        this.listener=listener;
        this.errorListener=errorListener;
        this.context=context;
    }

    public VolleyLIbUtils(Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
        this.url=url;
        this.listener=listener;
        this.errorListener=errorListener;
        this.context=context;
    }

    private void setListener(Response.Listener<String> listener) {
        this.listener = listener;
    }

    private void setErrorListener(Response.ErrorListener errorListener) {
        this.errorListener = errorListener;
    }

    @Override
    public void onResponse(String response){
        if (listener != null)
            listener.onResponse(response);
    }

    @Override
    public void onErrorResponse(VolleyError error){
        if(errorListener!=null)
            errorListener.onErrorResponse(error);

    }

    /**
     *
     * @return
     * @throws AuthFailureError
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    /**
     *
     */
    public void start(){
        DrEgyptApp.getInstance().addToRequestQueue(this, "");
    }
}
