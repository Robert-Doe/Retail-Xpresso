package com.robertory.stockpot.ui.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.robertory.stockpot.R;

public class TransactionFragment extends Fragment {

    private TransactionModel transactionModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        transactionModel =
                ViewModelProviders.of(this).get(TransactionModel.class);
        View root = inflater.inflate(R.layout.fragment_transaction, container, false);
        final TextView textView = root.findViewById(R.id.text_transaction);
        transactionModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}