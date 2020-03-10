package com.robertory.stockpot;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Transaction")
public class Transaction
{

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private int transId;

    @ColumnInfo(name="date")
    private String date;

    @ColumnInfo(name = "produtId")
    private String productId;
    @ColumnInfo(name = "quantityBought")
    private int quantityBought;
    @ColumnInfo(name = "quantityLeft")
    private int quantityLeft;

    public Transaction(int transId, String date, String productId, int quantityBought, int quantityLeft) {
        this.transId = transId;
        this.date = date;
        this.productId = productId;
        this.quantityBought = quantityBought;
        this.quantityLeft = quantityLeft;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }
}
