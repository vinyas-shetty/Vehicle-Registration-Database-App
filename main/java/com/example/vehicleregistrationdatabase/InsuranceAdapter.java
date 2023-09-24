package com.example.vehicleregistrationdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.MyViewHolder> {
    private Context context;
    private ArrayList insuranceNo, vehicleNo, ownerAadhar, amount, expDate;
    InsuranceAdapter(Context context, ArrayList insuranceNo, ArrayList vehicleNo, ArrayList ownerAadhar, ArrayList amount, ArrayList expDate) {
        this.context = context;
        this.insuranceNo = insuranceNo;
        this.vehicleNo = vehicleNo;
        this.ownerAadhar = ownerAadhar;
        this.amount = amount;
        this.expDate = expDate;
    }


    @NonNull
    @Override
    public InsuranceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row4, parent, false);
        return new InsuranceAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.insuranceNoText.setText(String.valueOf(insuranceNo.get((position))));
        holder.vehicleNoText.setText(String.valueOf(vehicleNo.get((position))));
        holder.ownerAadharTxt.setText(String.valueOf(ownerAadhar.get((position))));
        holder.amountText.setText(String.valueOf(amount.get((position))));
        holder.expDateText.setText(String.valueOf(expDate.get((position))));
    }

    @Override
    public int getItemCount() {
        return insuranceNo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView insuranceNoText, vehicleNoText, ownerAadharTxt, amountText, expDateText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            insuranceNoText = itemView.findViewById(R.id.insuranceNoText);
            vehicleNoText = itemView.findViewById(R.id.vehicleNoText);
            ownerAadharTxt = itemView.findViewById(R.id.ownerAadharTxt);
            amountText = itemView.findViewById(R.id.amountText);
            expDateText = itemView.findViewById(R.id.expDateText);
        }
    }
}
