package com.example.mohmedmostafa.dregypt.Data.remoteDataSource.NetworkRequests.HospitalsRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.mohmedmostafa.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.mohmedmostafa.dregypt.utils.Constants;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class GetHospitalByIdRequest {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int method_id;

    public GetHospitalByIdRequest(Context context,int id,Response.Listener<String> listener, Response.ErrorListener errorListener){
        setValues(id);
        volleyLIbUtils=new VolleyLIbUtils(context,method_id,url,listener,errorListener);
    }
    private void setValues(int id){
        url= Constants.basicUrl+"/hospitals/"+id+"";
        method_id= Request.Method.GET;
    }

    public void start(){
        volleyLIbUtils.start();
    }

}
