package com.robertory.stockpot.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.robertory.stockpot.R;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private byte wasFocused=0;
    private TextView txtToDate = null;
    private TextView txtFromDate =null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.txtHome);
//        final CalendarView calenderView=root.findViewById(R.id.cvStartDate);
////        calenderView.
////        textView.setText((String.valueOf(calenderView.getDate())));
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try
        {
            Button btnProfit=getView().findViewById(R.id.btnCheckProfit);
            Button btnStockState=getView().findViewById(R.id.btnStockState);
            Button btnSetCal= getView().findViewById(R.id.btnSetCalender);
            ImageButton btnShowCalender = (ImageButton)getView().findViewById(R.id.btnShowCalender);
                       txtToDate = getView().findViewById(R.id.txtFrom);
                       txtFromDate = getView().findViewById(R.id.txtTo);
            final LinearLayout llDateText=getView().findViewById(R.id.llDateText);
            btnSetCal.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if(llDateText.getVisibility()==View.VISIBLE)
                            {
                                llDateText.setVisibility(View.GONE);
                            }
                            else
                            {
                                llDateText.setVisibility(View.VISIBLE);
                            }
                        }
                    }
            );
            final CalendarView calenderView=getView().findViewById(R.id.cvStartDate);
            txtFromDate.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       wasFocused=0;
                       showMakeFocused(v);
                   }
               }

            );
            txtToDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wasFocused=1;
                    showMakeFocused(v);
                }
            });



            btnShowCalender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(calenderView.getVisibility()==View.VISIBLE)
                    {
                        calenderView.setVisibility(View.GONE);
                    }
                    else
                    {
                        calenderView.setVisibility(View.VISIBLE);
                    }
                }
            });

            calenderView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    if (wasFocused==0 && llDateText.getVisibility()==View.VISIBLE)
                    {
                        txtFromDate.setText(String.format(Locale.US, "%d-%d-%d", dayOfMonth, month, year));
                    }
                    else if(wasFocused==1 && llDateText.getVisibility()==View.VISIBLE)
                    {
                        txtToDate.setText(String.format(Locale.US, "%d-%d-%d", dayOfMonth, month, year));
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

    private void showMakeFocused(View v)
    {
        try {
            //ViewGroup parentView =getView().findViewById(R.id.llDateText);
            ViewGroup parentView= (ViewGroup) v.getParent();
            for(int i=0;i<parentView.getChildCount();i++)
            {
                final View child = parentView.getChildAt(i);
                if (child.getId()!=v.getId()&& child.getId()!=R.id.btnShowCalender)
                {
                    child.setBackgroundResource(R.drawable.unfocusedtextview);
                }
                else if(child.getId()==v.getId() &&  child.getId()!=R.id.btnShowCalender)
                {
                    child.setBackgroundResource(R.drawable.focusedtextview);
                }
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}