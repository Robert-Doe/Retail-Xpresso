package com.robertory.stockpot;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity()
@Entity(tableName = "category")
public class Category
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private int id;
    @ColumnInfo(name = "name")
    private String catName;
    @ColumnInfo(name = "desc")
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Category(int id,String catName, String desc) {
        this.catName = catName;
        this.desc = desc;
        this.id=id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
