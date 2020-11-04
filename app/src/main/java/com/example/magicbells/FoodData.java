package com.example.magicbells;

public class FoodData {

    String foodName, foodPrice, foodDetail, imageLink, uid;

    public FoodData() {
    }

    public FoodData(String foodName, String foodPrice, String foodDetail, String imageLink, String uid) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDetail = foodDetail;
        this.imageLink = imageLink;
        this.uid = uid;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDetail() {
        return foodDetail;
    }

    public void setFoodDetail(String foodDetail) {
        this.foodDetail = foodDetail;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
