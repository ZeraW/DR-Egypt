package com.example.mohmedmostafa.dregypt.Data.remoteDataSource.NetworkRequests.HospitalsRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.mohmedmostafa.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.mohmedmostafa.dregypt.utils.Constants;

import java.util.HashMap;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class AddHospitalToFavouriteRequest {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int methodId;

    public AddHospitalToFavouriteRequest(Context context,int user_id,int id, Response.Listener<String> listener, Response.ErrorListener errorListener){
        setValues(user_id , id);
        volleyLIbUtils=new VolleyLIbUtils(context,methodId,url,listener,errorListener);
    }
    private void setValues(int user_id,int id){
        url= Constants.basicUrl+"/hospitals/"+id+"/users/"+user_id+"/fav";
        methodId= Request.Method.POST;
    }

    public void setBody(HashMap body){
        volleyLIbUtils.setParams(body);
    }

    public void start(){
        volleyLIbUtils.start();
    }
}
