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
public class LicenseAdapter extends RecyclerView.Adapter<LicenseAdapter.MyViewHolder> {
    private Context context;
    private ArrayList licenseNo, ownerAadhar, expDate;
    LicenseAdapter(Context context, ArrayList licenseNo, ArrayList ownerAadhar, ArrayList expDate) {
        this.context = context;
        this.licenseNo = licenseNo;
        this.ownerAadhar = ownerAadhar;
        this.expDate = expDate;
    }


    @NonNull
    @Override
    public LicenseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row3, parent, false);
        return new LicenseAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.licenseNoText.setText(String.valueOf(licenseNo.get((position))));
        holder.ownerAadharTxt.setText(String.valueOf(ownerAadhar.get((position))));
        holder.expDateTxt.setText(String.valueOf(expDate.get((position))));
    }

    @Override
    public int getItemCount() {
        return licenseNo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView licenseNoText, ownerAadharTxt, expDateTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            licenseNoText = itemView.findViewById(R.id.insuranceNoText);
            ownerAadharTxt = itemView.findViewById(R.id.vehicleNoText);
            expDateTxt = itemView.findViewById(R.id.ownerAadharTxt);
        }
    }
}
