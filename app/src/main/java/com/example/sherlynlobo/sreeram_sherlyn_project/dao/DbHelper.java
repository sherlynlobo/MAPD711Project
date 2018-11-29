/*

Team Members: Sherlyn Lobo & Sreeram Ramakrishnan
Android Assignment 3

 */

package com.example.sherlynlobo.sreeram_sherlyn_project.dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "FurnitureStore", null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCustomers = "CREATE TABLE Customers (" +
                "                 customerId INTEGER PRIMARY KEY, " +
                "                 userName TEXT NOT NULL, " +
                "                 password TEXT NOT NULL, " +
                "                 firstName TEXT NOT NULL, " +
                "                 lastName TEXT NOT NULL, " +
                "                 address TEXT NOT NULL, " +
                "                 city TEXT NOT NULL, " +
                "                 postalCode TEXT NOT NULL);";
        db.execSQL(sqlCustomers);
        String sqlOrders = "CREATE TABLE Orders (" +
                "                 orderId INTEGER PRIMARY KEY, " +
                "                 customerId INTEGER NOT NULL, " +
                "                 itemId INTEGER NOT NULL, " +
                "                 orderDate TEXT NOT NULL, " +
                "                 quantity INTEGER NOT NULL, " +
                "                status TEXT NOT NULL); ";
        db.execSQL(sqlOrders);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlCustomer = "DROP TABLE IF EXISTS Customers; ";
        db.execSQL(sqlCustomer);

        String sqlOrder = "DROP TABLE IF EXISTS Orders; ";
        db.execSQL(sqlOrder);

        onCreate(db);
    }
}