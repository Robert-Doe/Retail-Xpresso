package com.robertory.stockpot.ui.product;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.robertory.stockpot.Product;
import com.robertory.stockpot.StockRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private StockRepository repository;
    private LiveData<List<Product>> allProduct;

    public ProductViewModel(Application application) {
        super(application);
        repository=new StockRepository(application);
        allProduct=repository.getAllProduct();
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void insert(Product product)
    {
        repository.insertProd(product);
    }

    public void update(Product product)
    {
        repository.updateProd(product);
    }

    public void delete(Product product)
    {
        repository.deleteProd(product);
    }

    public LiveData<List<Product>> getAllProduct()
    {
       return repository.getAllProduct();
    }

}