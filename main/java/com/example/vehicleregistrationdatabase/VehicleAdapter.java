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
public class VehicleAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList vehicleNo, vehicleModel, vehicleType, purchaseDate, ownerAadhar;
    VehicleAdapter(Context context, ArrayList vehicleNo, ArrayList vehicleModel, ArrayList vehicleType, ArrayList purchaseDate, ArrayList ownerAadhar) {
        this.context = context;
        this.vehicleNo = vehicleNo;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.purchaseDate = purchaseDate;
        this.ownerAadhar = ownerAadhar;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row2, parent, false);
        return new CustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.ownerIDText.setText(String.valueOf(vehicleNo.get((position))));
        holder.aadharNoText.setText(String.valueOf(vehicleModel.get((position))));
        holder.nameText.setText(String.valueOf(vehicleType.get((position))));
        holder.sexText.setText(String.valueOf(purchaseDate.get((position))));
        holder.dateOfBirthText.setText(String.valueOf(ownerAadhar.get((position))));
    }

    @Override
    public int getItemCount() {
        return vehicleNo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vehicleNoText, vehicleModelText, vehicleTypeText, purchaseDateText, ownerAadharText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleNoText = itemView.findViewById(R.id.insuranceNoText);
            vehicleModelText = itemView.findViewById(R.id.vehicleNoText);
            vehicleTypeText = itemView.findViewById(R.id.ownerAadharTxt);
            purchaseDateText = itemView.findViewById(R.id.amountText);
            ownerAadharText = itemView.findViewById(R.id.expDateText);
        }
    }
}
