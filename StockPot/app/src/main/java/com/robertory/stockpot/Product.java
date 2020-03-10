package com.robertory.stockpot;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
   private String id;
    @ColumnInfo(name = "name")
   private String name;
    @ColumnInfo(name = "desc")
   private String desc;
    @ColumnInfo(name = "catId")
   private int catId;
    @ColumnInfo(name = "sellPrice")
   private int sellPrice;
    @ColumnInfo(name = "costPrice")
   private int costPrice;
    @ColumnInfo(name = "threshold")
   private int threshold;


    public Product(String id, String name, String desc, int catId, int sellPrice, int costPrice, int threshold) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.catId = catId;
        this.sellPrice = sellPrice;
        this.costPrice = costPrice;
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

   /*public com.robertory.stocker.Product(String id, String name, String desc, int catId, int sellPrice, int costPrice) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.catId = catId;
        this.sellPrice = sellPrice;
        this.costPrice = costPrice;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }
}
