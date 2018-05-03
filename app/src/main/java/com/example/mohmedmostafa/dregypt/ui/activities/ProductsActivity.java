package com.example.mohmedmostafa.dregypt.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mohmedmostafa.dregypt.Data.remoteDataSource.NetworkRequests.ProductAdsRequests.GetProductAdsRequest;
import com.example.mohmedmostafa.dregypt.R;
import com.example.mohmedmostafa.dregypt.ui.adapters.ProductAdsAdapter;
import com.example.mohmedmostafa.dregypt.utils.ProductsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {

    private RecyclerView mRecyclerView;
    private ProductAdsAdapter mAdapter;
    private ArrayList<ProductsModel> modelArrayList;
    String id, title, description, price, image, status,address,created_at,phone_1,phone_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_products);
        GetProductAdsRequest getProductAdsRequest = new GetProductAdsRequest(this, this, this);
        getProductAdsRequest.start();

        //arrayLIST
        modelArrayList = new ArrayList<>();

        //recycler View horizon orientation
        mRecyclerView = findViewById(R.id.Recycler_Product);
        LinearLayoutManager LayoutManagaer = new GridLayoutManager(ProductsActivity.this, 3);
        mRecyclerView.setLayoutManager(LayoutManagaer);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
       Log.e("tagyy", error.toString());
    }

    @Override
    public void onResponse(String response) {

        Log.e("tagyyy",response);
        try {

            JSONObject object = new JSONObject(response);
            JSONArray dataArray = object.getJSONArray("data");
            for (int a = 0; a < dataArray.length(); a++) {
                JSONObject dataObject = dataArray.getJSONObject(a);
                id = dataObject.getString("id");
                title = dataObject.getString("title");
                price = dataObject.getString("price");
                image = dataObject.getString("img");
                status = dataObject.getString("status");
                address = dataObject.getString("address");
                created_at = dataObject.getString("created_at");
                description = dataObject.getString("description");
                JSONArray phoneArray =  dataObject.getJSONArray("phone");
                phone_1 = (String) phoneArray.get(0);
                phone_2 = (String) phoneArray.get(1);
                modelArrayList.add(new ProductsModel(id,title,description,price,status,image,address,created_at,phone_1,phone_2));

            }
            mAdapter = new ProductAdsAdapter(ProductsActivity.this, modelArrayList);
            mRecyclerView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
