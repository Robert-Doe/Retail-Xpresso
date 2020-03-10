package com.robertory.stockpot;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    public void insert(Category category);

    @Delete
    public void delete(Category category);

    @Query("DELETE FROM Category where id=:id")
    void delete(int id);

    @Update
    void update(Category category);

    @Query("SELECT * FROM category order by name")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM category WHERE id=:id")
    Category getCategory(int id);


}
