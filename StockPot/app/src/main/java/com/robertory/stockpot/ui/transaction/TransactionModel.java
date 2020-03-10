package com.robertory.stockpot.ui.transaction;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.robertory.stockpot.StockRepository;
import com.robertory.stockpot.Transaction;

import java.util.List;

public class TransactionModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private StockRepository repository;
    private LiveData<List<Transaction>> allTransaction;

    public TransactionModel(Application application) {
        super(application);
        repository=new StockRepository(application);
        allTransaction=repository.getAllTransaction();
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void insert(Transaction transaction)
    {
        repository.insertTrans(transaction);
    }

    public void update(Transaction transaction)
    {
        repository.updateTrans(transaction);
    }

    public void delete(Transaction transaction)
    {
        repository.deleteTrans(transaction);
    }
}