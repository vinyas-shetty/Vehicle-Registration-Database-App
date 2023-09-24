package com.example.vehicleregistrationdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList ownerID, aadharNo, name, sex, dateOfBirth, address;
    CustomAdapter(Context context, ArrayList ownerID, ArrayList aadharNo, ArrayList name, ArrayList sex, ArrayList dateOfBirth, ArrayList address) {
        this.context = context;
        this.ownerID = ownerID;
        this.aadharNo = aadharNo;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.ownerIDText.setText(String.valueOf(ownerID.get((position))));
        holder.aadharNoText.setText(String.valueOf(aadharNo.get((position))));
        holder.nameText.setText(String.valueOf(name.get((position))));
        holder.sexText.setText(String.valueOf(sex.get((position))));
        holder.dateOfBirthText.setText(String.valueOf(dateOfBirth.get((position))));
        holder.addressText.setText(String.valueOf(address.get((position))));
    }

    @Override
    public int getItemCount() {
        return ownerID.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ownerIDText, aadharNoText, nameText, sexText, dateOfBirthText, addressText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ownerIDText = itemView.findViewById(R.id.insuranceNoText);
            aadharNoText = itemView.findViewById(R.id.vehicleNoText);
            nameText = itemView.findViewById(R.id.ownerAadharTxt);
            sexText = itemView.findViewById(R.id.amountText);
            dateOfBirthText = itemView.findViewById(R.id.expDateText);
            addressText = itemView.findViewById(R.id.address_txt);
        }
    }
}
