package com.example.mohmedmostafa.dregypt.Data.remoteDataSource.NetworkRequests.FiltersRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.mohmedmostafa.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.mohmedmostafa.dregypt.utils.Constants;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class GetClinicSpecialitiesRequest {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int methodId;

    public GetClinicSpecialitiesRequest(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener){
        setValues();
        volleyLIbUtils=new VolleyLIbUtils(context,methodId,url,listener,errorListener);
    }
    private void setValues(){
        url= Constants.basicUrl+"/clinicSpecialities";
        methodId= Request.Method.GET;
    }

    public void start(){
        volleyLIbUtils.start();
    }
}
