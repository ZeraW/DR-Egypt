package com.example.mohmedmostafa.dregypt.Data.remoteDataSource.NetworkRequests.ClinicRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.mohmedmostafa.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.mohmedmostafa.dregypt.utils.Constants;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class SearchClinicsRequest {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int methodId;

    public SearchClinicsRequest(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener){
        setValues();
        volleyLIbUtils=new VolleyLIbUtils(context,methodId,url,listener,errorListener);
    }
    private void setValues(){
        url= Constants.basicUrl+"/clinics/search";
        methodId= Request.Method.POST;
    }

    public void start(){
        volleyLIbUtils.start();
    }
}
