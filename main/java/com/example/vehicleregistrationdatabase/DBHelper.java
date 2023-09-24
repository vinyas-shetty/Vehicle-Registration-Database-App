package com.example.vehicleregistrationdatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String OWNER_TABLE = "OWNER";
    private static final String VEHICLE_TABLE = "VEHICLE";
    private static final String LICENSE_TABLE = "LICENSE";
    private static final String INSURANCE_TABLE = "INSURANCE";
    private static final String OWNER_ID = "OwnerID";
    private static final String AADHAR_NO = "AadharNo";
    private static final String NAME = "Name";
    private static final String SEX = "Sex";
    private static final String DATE_OF_BIRTH = "DateofBirth";
    private static final String ADDRESS = "Address";
    private static final String VEHICLE_NO = "VehicleNo";
    private static final String VEHICLE_MODEL = "VehicleModel";
    private static final String VEHICLE_TYPE = "VehicleType";
    private static final String PURCHASE_DATE = "PurchaseDate";
    private static final String OWNER_AADHAR = "OwnerAadhar";
    private static final String LICENSE_NO = "LicenseNo";
    private static final String EXPIRY_DATE = "ExpiryDate";
    private static final String INSURANCE_NO = "InsuranceNo";
    private static final String AMOUNT = "Amount";
    private Context context;
    private String select, from, where;

    public DBHelper(Context context) {
        super(context, "UserData.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + OWNER_TABLE + "(" + OWNER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + AADHAR_NO + " INTEGER UNIQUE, " + NAME + " TEXT, " + SEX + " TEXT, " + DATE_OF_BIRTH + " DATE, " + ADDRESS + " TEXT)");
        db.execSQL("CREATE TABLE " + VEHICLE_TABLE + "(" + VEHICLE_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VEHICLE_MODEL + " TEXT, " + VEHICLE_TYPE + " TEXT, " + PURCHASE_DATE + " DATE, " + OWNER_AADHAR + " INTEGER REFERENCES " + OWNER_TABLE + "(" + AADHAR_NO + "))");
        db.execSQL("CREATE TABLE " + LICENSE_TABLE + "(" + LICENSE_NO + " INTEGER PRIMARY KEY, " + OWNER_AADHAR + " INTEGER REFERENCES " + OWNER_TABLE + "(" + AADHAR_NO + "), " + EXPIRY_DATE + " DATE)");
        db.execSQL("CREATE TABLE " + INSURANCE_TABLE + "(" + INSURANCE_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VEHICLE_NO + " INTEGER references " + VEHICLE_TABLE + "(" + VEHICLE_NO + "), " + OWNER_AADHAR + " INTEGER references " + OWNER_TABLE + "(" + AADHAR_NO + "), " + AMOUNT + " INTEGER, " + EXPIRY_DATE + " DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS '" + OWNER_TABLE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + VEHICLE_TABLE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + LICENSE_TABLE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + INSURANCE_TABLE + "'");
        onCreate(db);
    }

    public void insertOwner(int aadharNo, String name, String sex, String dob, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AADHAR_NO, aadharNo);
        cv.put(NAME, name);
        cv.put(SEX, sex);
        cv.put(DATE_OF_BIRTH, dob);
        cv.put(ADDRESS, address);
        long result = db.insert(OWNER_TABLE, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertVehicle(String model, String vehicleType, String purchaseDate, int ownerAadhar){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(VEHICLE_MODEL, model);
        cv1.put(VEHICLE_TYPE, vehicleType);
        cv1.put(PURCHASE_DATE, purchaseDate);
        cv1.put(OWNER_AADHAR, ownerAadhar);
        long result = db1.insert(VEHICLE_TABLE, null, cv1);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertLicense(int licenseNo, int ownerAadhar, String expDate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LICENSE_NO, licenseNo);
        cv.put(OWNER_AADHAR, ownerAadhar);
        cv.put(EXPIRY_DATE, expDate);
        long result = db.insert(LICENSE_TABLE, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertInsurance(int vehicleNo, int ownerAadhar, int amount, String expDate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(VEHICLE_NO, vehicleNo);
        cv.put(OWNER_AADHAR, ownerAadhar);
        cv.put(AMOUNT, amount);
        cv.put(EXPIRY_DATE, expDate);
        long result = db.insert(INSURANCE_TABLE, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllOwner() {
        String query = "SELECT * FROM " + OWNER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllVehicle() {
        String query = "SELECT * FROM " + VEHICLE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllLicense() {
        String query = "SELECT * FROM " + LICENSE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllInsurance() {
        String query = "SELECT * FROM " + INSURANCE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    @SuppressLint("Recycle")
    public void updateOwner(int ownerID, int aadharNo, String name, String sex, String dateOfBirth, String address) {
        //String query = "UPDATE " + OWNER_TABLE + " SET " + AADHAR_NO + " = " + aadharNo + ", " + NAME + " = " + name + ", " + SEX + " = " + sex + ", " + DATE_OF_BIRTH + " = " + dateOfBirth + ", " + ADDRESS + " = " + address + " WHERE " + OWNER_ID + " = " + ownerID;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AADHAR_NO, aadharNo);
        cv.put(NAME, name);
        cv.put(SEX, sex);
        cv.put(DATE_OF_BIRTH, dateOfBirth);
        cv.put(ADDRESS, address);
        long result = db.update(OWNER_TABLE, cv, OWNER_ID + " = ?", new String[] {String.valueOf(ownerID)});
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateVehicle(int vehicleNo, String vehicleModel, String vehicleType, String purchaseDate, int ownerAadhar) {
        //String query = "UPDATE " + OWNER_TABLE + " SET " + AADHAR_NO + " = " + aadharNo + ", " + NAME + " = " + name + ", " + SEX + " = " + sex + ", " + DATE_OF_BIRTH + " = " + dateOfBirth + ", " + ADDRESS + " = " + address + " WHERE " + OWNER_ID + " = " + ownerID;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(VEHICLE_MODEL, vehicleModel);
        cv.put(VEHICLE_TYPE, vehicleType);
        cv.put(PURCHASE_DATE, purchaseDate);
        cv.put(OWNER_AADHAR, ownerAadhar);
        long result = db.update(VEHICLE_TABLE, cv, VEHICLE_NO + " = ?", new String[] {String.valueOf(vehicleNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateLicense(int licenseNo, int ownerAadhar, String expDate) {
        //String query = "UPDATE " + OWNER_TABLE + " SET " + AADHAR_NO + " = " + aadharNo + ", " + NAME + " = " + name + ", " + SEX + " = " + sex + ", " + DATE_OF_BIRTH + " = " + dateOfBirth + ", " + ADDRESS + " = " + address + " WHERE " + OWNER_ID + " = " + ownerID;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(OWNER_AADHAR, ownerAadhar);
        cv.put(EXPIRY_DATE, expDate);
        long result = db.update(LICENSE_TABLE, cv, LICENSE_NO + " = ?", new String[] {String.valueOf(licenseNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateInsurance(int insuranceNo, int vehicleNo, int ownerAadhar, int amount, String expDate) {
        //String query = "UPDATE " + OWNER_TABLE + " SET " + AADHAR_NO + " = " + aadharNo + ", " + NAME + " = " + name + ", " + SEX + " = " + sex + ", " + DATE_OF_BIRTH + " = " + dateOfBirth + ", " + ADDRESS + " = " + address + " WHERE " + OWNER_ID + " = " + ownerID;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(VEHICLE_NO, vehicleNo);
        cv.put(OWNER_AADHAR, ownerAadhar);
        cv.put(AMOUNT, amount);
        cv.put(EXPIRY_DATE, expDate);
        long result = db.update(INSURANCE_TABLE, cv, INSURANCE_NO + " = ?", new String[] {String.valueOf(insuranceNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteOwner(int ownerID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long result = db.delete(OWNER_TABLE, OWNER_ID + " = ?", new String[] {String.valueOf(ownerID)});
        if(result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteVehicle(int vehicleNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long result = db.delete(VEHICLE_TABLE, VEHICLE_NO + " = ?", new String[] {String.valueOf(vehicleNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteLicense(int licenseNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long result = db.delete(LICENSE_TABLE, LICENSE_NO + " = ?", new String[] {String.valueOf(licenseNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteInsurance(int insuranceNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long result = db.delete(INSURANCE_TABLE, INSURANCE_NO + " = ?", new String[] {String.valueOf(insuranceNo)});
        if(result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
        }
    }

    public void execQuery(String select, String from, String where) {
        this.select = select;
        this.from = from;
        this.where = where;
        String query = "SELECT " + select + " FROM " + from + " WHERE " + where;

    }
}
