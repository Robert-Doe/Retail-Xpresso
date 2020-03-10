package com.robertory.stockpot;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StockStateDao
{
    @Insert
    void insert(StockState stockState);

    @Delete
    void delete(StockState state);

    @Update
    void update(StockState state);

    @Query("SELECT * FROM StockState where id=:id")
    StockState getStockState(int id);

    @Query("SELECT * FROM StockState")
    LiveData<List<StockState>> getAllStockState();

}
