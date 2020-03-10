package com.robertory.stockpot;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.StringTokenizer;

public class StockRepository
{
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private StockRefillDao stockRefillDao;
    private StockStateDao stockStateDao;
    private TransactionDao transactionDao;
    private LiveData<List<Category>> allCategory;
    private LiveData<List<Product>> allProduct;
    private LiveData<List<StockRefill>> allStockRefill;
    private LiveData<List<StockState>> allStockState;
    private LiveData<List<Transaction>> allTransaction;

    public StockRepository(Application application)
    {
        Connections connections=Connections.getInstance(application);
        stockStateDao=connections.getDatabase().getStockStateDao();
        productDao=connections.getDatabase().getProductDao();
        stockRefillDao=connections.getDatabase().getStockRefillDao();
        categoryDao=connections.getDatabase().getCategoryDao();
        transactionDao=connections.getDatabase().getTransactionDao();
        allCategory=categoryDao.getAllCategories();
        allTransaction=transactionDao.getAllTransaction();
        allStockRefill=stockRefillDao.getAllStockRefill();
        allStockState=stockStateDao.getAllStockState();
        allProduct=productDao.getAllProducts();
    }

    //getAll StockState
    public LiveData<List<StockState>> getAllStockState()
    {
        return allStockState;
    }


    //getAll Transaction
    public LiveData<List<Transaction>> getAllTransaction()
    {
        return allTransaction;
    }


    //getAll StockRefill
    public LiveData<List<StockRefill>> getAllStockRefill()
    {
        return allStockRefill;
    }

    //  getAll Category
    public LiveData<List<Category>> getAllCategory()
    {
        return allCategory;
    }

    // getAll Product
    public LiveData<List<Product>> getAllProduct()
    {
        return allProduct;
    }

    //Category Operation
    public void deleteCat(Category cat)
    {
        new DeleteCategoryAsync(categoryDao).execute(cat);
    }
    public void insertCat(Category cat)
    {
        new InsertCategoryAsync(categoryDao).execute(cat);
    }
    public void updateCat(Category cat)
    {
        new UpdateCategoryAsync(categoryDao).execute(cat);
    }
//    public void AddCat(Category cat)
//    {
//
//    }


    //Product Operation
    public void deleteProd(Product product)
    {
        new DeleteProductAsync(productDao).execute(product);
    }
    public void insertProd(Product product)
    {
        new InsertProductAsync(productDao).execute(product);
    }
    public void updateProd(Product product)
    {
        new UpdateProductAsync(productDao).execute(product);
    }
//    public void AddProd(Product product)
//    {
//
//    }

    //Transaction Operation
    public void deleteTrans(Transaction transaction)
    {
        new DeleteTransactionAsync(transactionDao).execute(transaction);
    }
    public void insertTrans(Transaction transaction)
    {
        new InsertTransactionAsync(transactionDao).execute(transaction);
    }
    public void updateTrans(Transaction transaction)
    {
        new UpdateTransactionAsync(transactionDao).execute(transaction);
    }
//    public void AddTrans(Transaction transaction)
//    {
//
//    }


    //Refill Operation
    public void deleteRefill(StockRefill stockRefill)
    {
        new DeleteStockRefillAsync(stockRefillDao).execute(stockRefill);
    }
    public void insertRefill(StockRefill stockRefill)
    {
        new InsertStockRefillAsync(stockRefillDao).execute(stockRefill);
    }
    public void updateRefill(StockRefill stockRefill)
    {
        new UpdateStockRefillAsync(stockRefillDao).execute(stockRefill);
    }
//    public void AddRefill(StockRefill stockRefill)
//    {
//
//    }

    //Refill Operation
    public void deleteState(StockState stockState)
    {
        new DeleteStockStateAsync(stockStateDao).execute(stockState);
    }
    public void insertState(StockState stockState)
    {
        new InsertStockStateAsync(stockStateDao).execute(stockState);
    }
    public void updateState(StockState stockState)
    {
        new UpdateStockStateAsync(stockStateDao).execute(stockState);
    }
//    public void AddState(StockState stockState)
//    {
//
//    }


    /*
    *
    *Insertion AsyncTasks
    *
    *
    *
    */
    public static class InsertCategoryAsync extends AsyncTask<Category,Void,Void>
    {
        private CategoryDao categoryDao;

        private InsertCategoryAsync(CategoryDao categoryDao)
        {
            this.categoryDao=categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    public static class InsertProductAsync extends AsyncTask<Product,Void,Void>
    {
        private ProductDao productDao;

        private InsertProductAsync(ProductDao productDao)
        {
            this.productDao=productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }
    }

    public static class InsertStockStateAsync extends AsyncTask<StockState,Void,Void>
    {
        private StockStateDao stockStateDao;

        private InsertStockStateAsync(StockStateDao stockStateDao)
        {
            this.stockStateDao=stockStateDao;
        }

        @Override
        protected Void doInBackground(StockState... stockStates) {
            stockStateDao.insert(stockStates[0]);
            return null;
        }
    }

    public static class InsertStockRefillAsync extends AsyncTask<StockRefill,Void,Void>
    {
        private StockRefillDao stockRefillDao;

        private InsertStockRefillAsync(StockRefillDao stockRefillDao)
        {
            this.stockRefillDao=stockRefillDao;
        }

        @Override
        protected Void doInBackground(StockRefill... stockRefills) {
            stockRefillDao.insert(stockRefills[0]);
            return null;
        }
    }

    public static class InsertTransactionAsync extends AsyncTask<Transaction,Void,Void>
    {
        private TransactionDao transactionDao;

        private InsertTransactionAsync(TransactionDao transactionDao)
        {
            this.transactionDao=transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.insert(transactions[0]);
            return null;
        }
    }


    /*
    *End of Insertion
    *
    *
    *
    *
    */



    /*
     *
     *deletion AsyncTasks
     *
     *
     *
     */
    public static class DeleteCategoryAsync extends AsyncTask<Category,Void,Void>
    {
        private CategoryDao categoryDao;

        private DeleteCategoryAsync(CategoryDao categoryDao)
        {
            this.categoryDao=categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }

    public static class DeleteProductAsync extends AsyncTask<Product,Void,Void>
    {
        private ProductDao productDao;

        private DeleteProductAsync(ProductDao productDao)
        {
            this.productDao=productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }
    }

    public static class DeleteStockStateAsync extends AsyncTask<StockState,Void,Void>
    {
        private StockStateDao stockStateDao;

        private DeleteStockStateAsync(StockStateDao stockStateDao)
        {
            this.stockStateDao=stockStateDao;
        }

        @Override
        protected Void doInBackground(StockState... stockStates) {
            stockStateDao.delete(stockStates[0]);
            return null;
        }
    }

    public static class DeleteStockRefillAsync extends AsyncTask<StockRefill,Void,Void>
    {
        private StockRefillDao stockRefillDao;

        private DeleteStockRefillAsync(StockRefillDao stockRefillDao)
        {
            this.stockRefillDao=stockRefillDao;
        }

        @Override
        protected Void doInBackground(StockRefill... stockRefills) {
            stockRefillDao.delete(stockRefills[0]);
            return null;
        }
    }

    public static class DeleteTransactionAsync extends AsyncTask<Transaction,Void,Void>
    {
        private TransactionDao transactionDao;

        private DeleteTransactionAsync(TransactionDao transactionDao)
        {
            this.transactionDao=transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.delete(transactions[0]);
            return null;
        }
    }


    /*
     *End of deletion
     *
     *
     *
     *
     */

    /*
     *
     *updation AsyncTasks
     *
     *
     *
     */
    public static class UpdateCategoryAsync extends AsyncTask<Category,Void,Void>
    {
        private CategoryDao categoryDao;

        private UpdateCategoryAsync(CategoryDao categoryDao)
        {
            this.categoryDao=categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }

    public static class UpdateProductAsync extends AsyncTask<Product,Void,Void>
    {
        private ProductDao productDao;

        private UpdateProductAsync(ProductDao productDao)
        {
            this.productDao=productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.update(products[0]);
            return null;
        }
    }

    public static class UpdateStockStateAsync extends AsyncTask<StockState,Void,Void>
    {
        private StockStateDao stockStateDao;

        private UpdateStockStateAsync(StockStateDao stockStateDao)
        {
            this.stockStateDao=stockStateDao;
        }

        @Override
        protected Void doInBackground(StockState... stockStates) {
            stockStateDao.update(stockStates[0]);
            return null;
        }
    }

    public static class UpdateStockRefillAsync extends AsyncTask<StockRefill,Void,Void>
    {
        private StockRefillDao stockRefillDao;

        private UpdateStockRefillAsync(StockRefillDao stockRefillDao)
        {
            this.stockRefillDao=stockRefillDao;
        }

        @Override
        protected Void doInBackground(StockRefill... stockRefills) {
            stockRefillDao.update(stockRefills[0]);
            return null;
        }
    }

    public static class UpdateTransactionAsync extends AsyncTask<Transaction,Void,Void>
    {
        private TransactionDao transactionDao;

        private UpdateTransactionAsync(TransactionDao transactionDao)
        {
            this.transactionDao=transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.update(transactions[0]);
            return null;
        }
    }


    /*
     *End of updation
     *
     *
     *
     *
     */

}
