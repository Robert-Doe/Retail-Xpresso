package com.robertory.stockpot;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StockRefill
{
    @PrimaryKey
    @ColumnInfo(name="id" )
    @NonNull
    private int id;
    @ColumnInfo(name="productId" )
    private String productId;
    @ColumnInfo(name="quantity")
    private int quantity;
    @ColumnInfo(name="date" )
    private String date;

    public StockRefill(int id, String productId, int quantity, String date) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
