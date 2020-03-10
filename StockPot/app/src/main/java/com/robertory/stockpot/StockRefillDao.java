package com.robertory.stockpot;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StockRefillDao
{
    @Insert
    void insert(StockRefill stockRefill);

    @Delete
    void delete(StockRefill stockRefill);
    @Update
    void update(StockRefill stockRefill);

    @Query("SELECT * FROM StockRefill")
    LiveData<List<StockRefill>> getAllStockRefill();

    @Query("SELECT * FROM StockRefill WHERE id=:id")
    StockRefill getStockRefill(int id);

}
