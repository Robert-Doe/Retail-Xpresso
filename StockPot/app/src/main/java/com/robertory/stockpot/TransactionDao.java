package com.robertory.stockpot;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDao
{
    @Insert
    void insert(Transaction transaction);
    @Delete
    void delete(Transaction transaction);
    @Update
    void update(Transaction transaction);

    @Query("SELECT * FROM `Transaction`")
    LiveData<List<Transaction>> getAllTransaction();

    @Query("SELECT * FROM `Transaction` WHERE id=:id")
    Transaction getTransaction(int id);
}
