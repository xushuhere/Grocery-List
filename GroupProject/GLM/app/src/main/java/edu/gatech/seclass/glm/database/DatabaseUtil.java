package edu.gatech.seclass.glm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.glm.models.GroceryList;
import edu.gatech.seclass.glm.models.Item;

/**
 * Created by Anshul on 10/11/16.
 */

public class DatabaseUtil extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "glm_team_16";

    public static final String TABLE_ALL_ITMES = "all_items";
    public static final String TABLE_GROCERY_LISTS = "grocery_lists";
    public static final String TABLE_GROCERY_LIST_ITEMS = "grocery_list_items";


    public static final String USERNAME = "username";
    public static final String GROCERY_LIST_NAME = "grocery_list_name";
    public static final String GROCERY_LIST_ID = "grocery_list_id";

    public static final String ITEM_ID = "item_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_TYPE = "item_type";
    public static final String ITEM_QUANTITY = "item_quantity";
    public static final String ITEM_QUANTITY_UNIT = "item_quanity_unit";

    public static final String IS_CHECKED = "is_checked";
    Context context;

    public DatabaseUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ALL_ITEMS = "CREATE TABLE " + TABLE_ALL_ITMES + "(" + ITEM_NAME + " TEXT," +
                ITEM_TYPE + " TEXT);";

        String CREATE_TABLE_GROCERY_LISTS = "CREATE TABLE " + TABLE_GROCERY_LISTS + "(" + USERNAME + " TEXT," +
                GROCERY_LIST_NAME + " TEXT, " + GROCERY_LIST_ID + " TEXT);";

        String CREATE_TABLE_GROCERY_LIST_ITEMS = "CREATE TABLE " + TABLE_GROCERY_LIST_ITEMS + "(" + ITEM_ID + " TEXT," +
                ITEM_NAME + " TEXT, " + ITEM_TYPE + " TEXT, " + ITEM_QUANTITY + " TEXT, "  + ITEM_QUANTITY_UNIT +
                " TEXT, " + IS_CHECKED + " INTEGER, "+ GROCERY_LIST_ID  + " TEXT);";
        try {
            db.execSQL(CREATE_TABLE_ALL_ITEMS);
            db.execSQL(CREATE_TABLE_GROCERY_LISTS);
            db.execSQL(CREATE_TABLE_GROCERY_LIST_ITEMS);

            // Todo populate all items table

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALL_ITMES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_LISTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_LIST_ITEMS);

        onCreate(db);
    }

    public List<Item> getAllItemsFromDatabase(){
        List<Item> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_ALL_ITMES ;

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                allItems.add(item);
            } while (cursor.moveToNext());
        }
        return allItems;

    }

    public List<Item> getSimilarItemsFromDatabase(String searchString){
        List<Item> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // select query
        String sql = "";
        String sql2 = "";
        sql += "SELECT * FROM " + TABLE_ALL_ITMES;
        sql += " WHERE " + ITEM_NAME + " LIKE '" + searchString + "%'";

        sql2 += "SELECT * FROM " + TABLE_ALL_ITMES;
        sql2 += " WHERE " + ITEM_NAME + " LIKE '%" + searchString + "%'";

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                allItems.add(item);
            } while (cursor.moveToNext());
        }

        if (allItems.size() == 0) {
            db = this.getWritableDatabase();
            cursor = db.rawQuery(sql2, null);

            if (cursor.moveToFirst()) {
                do {
                    Item item = new Item();
                    item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                    item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                    allItems.add(item);
                } while (cursor.moveToNext());
            }
        }

        cursor.close();
        return allItems;

    }

    public List<Item> getAllItemsInGroceryList(String grocery_list_id){
        List<Item> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_GROCERY_LIST_ITEMS + " WHERE " + GROCERY_LIST_ID + " = '" + grocery_list_id + "'" + " ORDER BY " + ITEM_TYPE;

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(cursor.getString(cursor.getColumnIndex(ITEM_ID)));
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                item.setQuantity(cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY)));
                item.setQuantityUnit(cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY_UNIT)));
                if(cursor.getInt(cursor.getColumnIndex(IS_CHECKED)) == 1){
                    item.setChecked(true);
                }else{
                    item.setChecked(false);
                }

                allItems.add(item);
            } while (cursor.moveToNext());
        }
        return allItems;
    }

    public GroceryList getGroceryListById(String grocery_list_id){
        GroceryList item = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_GROCERY_LISTS + " WHERE " + GROCERY_LIST_ID + " = '" + grocery_list_id + "'";

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            item = new GroceryList();
            item.setId(cursor.getString(cursor.getColumnIndex(GROCERY_LIST_ID)));
            item.setName(cursor.getString(cursor.getColumnIndex(GROCERY_LIST_NAME)));
        }
        return item;
    }

    public List<GroceryList> getGroceryListsForUser(String username){
        List<GroceryList> allLists = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_GROCERY_LISTS + " WHERE " + USERNAME + " = '" + username + "'";

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                GroceryList item = new GroceryList();
                item.setId(cursor.getString(cursor.getColumnIndex(GROCERY_LIST_ID)));
                item.setName(cursor.getString(cursor.getColumnIndex(GROCERY_LIST_NAME)));

                allLists.add(item);
            } while (cursor.moveToNext());
        }
        return allLists;
    }

    public void addGroceryListForUser(GroceryList item, String username) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, username);
        values.put(GROCERY_LIST_NAME, item.getName());
        values.put(GROCERY_LIST_ID, item.getId());
        db.insert(TABLE_GROCERY_LISTS, null, values);
    }

    public void addItemToGroceryList(Item item, String grocery_list_id) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_ID, item.getId());
        values.put(ITEM_NAME, item.getName());
        values.put(ITEM_TYPE, item.getType());
        values.put(ITEM_QUANTITY, item.getQuantity());
        values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
        if(item.isChecked()){
            values.put(IS_CHECKED, 1);
        }else{
            values.put(IS_CHECKED, 0);
        }
        values.put(GROCERY_LIST_ID, grocery_list_id);
        db.insert(TABLE_GROCERY_LIST_ITEMS, null, values);
    }


    public void updateItemInGroceryList(Item item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_ID, item.getId());
        values.put(ITEM_NAME, item.getName());
        values.put(ITEM_TYPE, item.getType());
        values.put(ITEM_QUANTITY, item.getQuantity());
        values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
        if(item.isChecked()){
            values.put(IS_CHECKED, 1);
        }else{
            values.put(IS_CHECKED, 0);
        }

        db.update(TABLE_GROCERY_LIST_ITEMS, values, ITEM_ID + " = ?", new String[]{item.getId()});
        db.close();
    }

    public void deleteItemInGroceryList(Item item) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GROCERY_LIST_ITEMS, ITEM_ID + " = ? ", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public void deleteGroceryList(GroceryList item) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GROCERY_LISTS, GROCERY_LIST_ID + " = ?", new String[]{item.getId()});
        db.delete(TABLE_GROCERY_LIST_ITEMS, GROCERY_LIST_ID + " = ? ", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public void renameGroceryListForUser(GroceryList item, String username) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, username);
        values.put(GROCERY_LIST_NAME, item.getName());
        values.put(GROCERY_LIST_ID, item.getId());
        db.update(TABLE_GROCERY_LISTS, values, GROCERY_LIST_ID + " = ?", new String[]{item.getId()});
    }

}
