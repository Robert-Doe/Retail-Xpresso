package com.robertory.stockpot;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao
{

    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM Product WHERE id=:id")
    void delete(int id);

    @Update()
    void update(Product product);

    @Query("SELECT * FROM Product order by id")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM Product where id=:id")
    Product getProduct(int id);


}
