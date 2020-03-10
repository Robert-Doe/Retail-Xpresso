package com.robertory.stockpot.ui.product;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.robertory.stockpot.Category;
import com.robertory.stockpot.Product;
import com.robertory.stockpot.R;
import com.robertory.stockpot.ui.category.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductFragment extends Fragment {

    private ProductViewModel productViewModel;
    private CategoryViewModel categoryViewModel;
    private ArrayAdapter<String> productAdapter;
    private ArrayAdapter<String> categoryAdapter;
    private Spinner spinnerCategory=null;
    private Spinner spinnerProduct=null;
    private ArrayList<String> productName=new ArrayList<String>();
    private ArrayList<String> categoryName=new ArrayList<String>();
    //private Spinner spinnerProduct;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        categoryViewModel=ViewModelProviders.of(this).get(CategoryViewModel.class);


        View root = inflater.inflate(R.layout.fragment_product, container, false);
//        final TextView textView = root.findViewById(R.id.text_product);
//        productViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        try
        {
            spinnerCategory=getView().findViewById(R.id.spCategory);
            spinnerProduct=getView().findViewById(R.id.spDeleteProduct);
            categoryAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,categoryName);
            productAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,productName);
            spinnerCategory.setAdapter(categoryAdapter);
            spinnerProduct.setAdapter(productAdapter);
        }
        catch (Exception ex)
        {
            Toast.makeText(getContext(), ex.getMessage()+ "Declaration", Toast.LENGTH_LONG).show();
        }


        categoryViewModel.getAllCategory().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                try
                {
                    for(Category i:categories)
                    {
                        categoryName.add(i.getCatName());
                    }
                   //Adapter declaration
                   // categoryAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,categoryName);
                    //spinnerCategory.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                }
                catch (Exception ex)
                {
                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        productViewModel.getAllProduct().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                try
                {

                    for(Product i:products)
                    {
                        productName.add(i.getName());
                    }
                    //Adapter Declaration
                   //productAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,productName);
                    //spinnerCategory.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();

                }
                catch (Exception ex)
                {
                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
//        Spinner catSpinner= getView().findViewById(R.id.spCategory);
//        ArrayAdapter<String> catAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.string.))


        try
        {
            this.getActivity().runOnUiThread( new Runnable() {
                @Override
                public void run() {

                    try
                    {

                        ImageButton btnAddProduct=getView().findViewById(R.id.btnAdd);
                        ImageButton btnDeleteProduct=getView().findViewById(R.id.btnDelete);
                        ImageButton btnViewProduct= getView().findViewById(R.id.btnView);
                        ImageButton btnUpdateProduct=getView().findViewById(R.id.btnUpdate);

                        final RelativeLayout rlAddProduct=getView().findViewById(R.id.rlAddProduct);
                        final RelativeLayout rlDeleteProduct=getView().findViewById(R.id.rlDeleteProduct);
                        final RelativeLayout rlUpdateProduct=getView().findViewById(R.id.rlUpdateProduct);
                        btnAddProduct.setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {

                                                                 if(rlAddProduct.getVisibility()==View.VISIBLE)
                                                                 {
                                                                     rlAddProduct.setVisibility(View.GONE);
                                                                 }
                                                                 else
                                                                 {
                                                                     rlAddProduct.setVisibility(View.VISIBLE);
                                                                 }
                                                             }
                                                         }
                        );


                        btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(rlDeleteProduct.getVisibility()==View.VISIBLE)
                                {
                                    rlDeleteProduct.setVisibility(View.GONE);
                                }
                                else
                                {
                                    rlDeleteProduct.setVisibility(View.VISIBLE);
                                }
                            }
                        });

                        btnUpdateProduct.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if(rlUpdateProduct.getVisibility()==View.VISIBLE)
                                {
                                    rlUpdateProduct.setVisibility(View.GONE);
                                }
                                else
                                {
                                    rlUpdateProduct.setVisibility(View.VISIBLE);
                                }
                            }
                        });


                        //            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        //            final String selectedDate = sdf.format(new Date(calenderView.));
                        //            btnDisplayDate.setOnClickListener(new View.OnClickListener() {
                        //                @Override
                        //                public void onClick(View v) {
                        //                    Toast.makeText(getActivity(), selectedDate, Toast.LENGTH_SHORT).show();
                        //                }
                        //            });
                    }
                    catch (NullPointerException e)
                    {
                        try {
                            Log.i(getClass().getSimpleName(), e.getMessage());
                        }catch (NullPointerException ex)
                        {
                            Log.i(getClass().getSimpleName(), ex.getMessage());
                        }

                    }
                    catch (Exception e)
                    {
                        try {
                            Log.i(getClass().getSimpleName(), e.getMessage());
                        }catch (NullPointerException ex)
                        {
                            Log.i(getClass().getSimpleName(), ex.getMessage());
                        }
                    }

                }
            });

        }
        catch (Exception ex)
        {
            Toast.makeText(getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}