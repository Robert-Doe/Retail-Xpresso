package com.robertory.stockpot;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class,Product.class,Transaction.class,StockRefill.class,StockState.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract CategoryDao getCategoryDao();
    public abstract TransactionDao getTransactionDao();
    public abstract StockRefillDao getStockRefillDao();
    public abstract ProductDao getProductDao();
    public abstract StockStateDao getStockStateDao();

}
