package com.robertory.stockpot.ui.category;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.robertory.stockpot.Category;
import com.robertory.stockpot.StockRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private StockRepository repository;
    private LiveData<List<Category>> allCategory;

    public CategoryViewModel(Application application)
    {
        super(application);
        repository=new StockRepository(application);
        allCategory=repository.getAllCategory();
        mText = new MutableLiveData<>();
        mText.setValue("This is category fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void insert(Category category)
    {
        repository.insertCat(category);
    }

    public void update(Category category)
    {
        repository.updateCat(category);
    }

    public void delete(Category category)
    {
       repository.deleteCat(category);
    }

    public LiveData<List<Category>> getAllCategory()
    {
        return repository.getAllCategory();
    }


}