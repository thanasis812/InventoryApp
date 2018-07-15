package com.example.android.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


import com.example.android.inventoryapp.InvetoryAppData.InventoryContract.InventoryEntry;

/**
 * Created by Kostinas on 7/13/2018.
 */

public class InventoryCursorAdapter extends CursorAdapter{


    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);

        // Find the columns of product attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME);
        int breedColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME);

        // Read the prudact attributes from the Cursor for the current pet
        String productName = cursor.getString(nameColumnIndex);
        String productSupplier = cursor.getString(breedColumnIndex);

        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(productName);
        summaryTextView.setText(productSupplier);
    }


}
