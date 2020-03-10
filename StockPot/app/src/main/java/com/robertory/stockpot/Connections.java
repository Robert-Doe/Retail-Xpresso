package com.robertory.stockpot;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class Connections {

    private static Connections instance=null;
    final private AppDatabase database;

    private Connections(Context context)
    {
        //database= Room.databaseBuilder(context,AppDatabase.class,"mini_base").allowMainThreadQueries().build();
        database= Room.databaseBuilder(context,AppDatabase.class,"mini_base").fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build();
    }

    public static Connections getInstance(Context context)
    {
        synchronized (Connections.class)
        {
            if(instance==null)
            {
                instance=new Connections(context);
            }
            return instance;
        }

    }

    public AppDatabase getDatabase()
    {
        return  database;
    }

    private static RoomDatabase.Callback roomCallback= new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //////////You have to come here and check something out the argument for PopulateDbAsyncTask is questionable//////////////
            new PopulateDbAsyncTask(instance.getDatabase()).execute();
        }
    };

    public static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        CategoryDao categoryDao;
        ProductDao productDao;

        public PopulateDbAsyncTask(AppDatabase db)
        {
            categoryDao=db.getCategoryDao();
            productDao=db.getProductDao();
        }

//        public PopulateDbAsyncTask() {
//
//        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insert(new Category(1,"Category 1","Stones for Sale"));
            categoryDao.insert(new Category(2,"Category 2","Bags for Sale"));
            categoryDao.insert(new Category(3,"Category 3","Toys for Sale"));
            productDao.insert(new Product("1","Product 1","Product for babies",1,10,45,5));
            productDao.insert(new Product("2","Product 2","Product for adults",1,10,45,5));
            productDao.insert(new Product("3","Product 3","Product for teens",1,10,45,5));
            return null;
        }
    }


}
