package com.robertory.stockpot;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StockState")
public class StockState {

    public StockState(int productId, int quantity, String date) {
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private int productId;
    @ColumnInfo(name="quantity")
    private int quantity;
    @ColumnInfo(name = "date")
    private String date;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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
