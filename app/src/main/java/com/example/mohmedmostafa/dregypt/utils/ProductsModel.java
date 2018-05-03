package com.example.mohmedmostafa.dregypt.utils;

/**
 * Created by Hima on 4/30/2018.
 */

public class ProductsModel {

    String idz, titlez, description,price, status, image ,address,created_at,phone_1,phone_2;

    public ProductsModel(String idz, String titlez, String description, String price, String status, String image, String address, String created_at, String phone_1, String phone_2) {
        this.idz = idz;
        this.titlez = titlez;
        this.description = description;
        this.price = price;
        this.status = status;
        this.image = image;
        this.address = address;
        this.created_at = created_at;
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public String getIdz() {
        return idz;
    }

    public String getTitlez() {
        return titlez;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }
}
