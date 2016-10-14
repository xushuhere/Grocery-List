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
import edu.gatech.seclass.glm.models.IteminData;
import edu.gatech.seclass.glm.models.IteminList;

/**
 * Created by Anshul on 10/11/16.
 * updated by Shu on 10/11/16.
 */

public class DatabaseUtil extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "glm_team_16";

    private static final String TABLE_ALL_ITEMS = "all_items";
    private static final String TABLE_GROCERY_LISTS = "grocery_lists";
    private static final String TABLE_GROCERY_LIST_ITEMS = "grocery_list_items";


    private static final String USERNAME = "username";
    private static final String GROCERY_LIST_NAME = "grocery_list_name";
    private static final String GROCERY_LIST_ID = "grocery_list_id";

    private static final String ITEM_ID = "item_id";
    private static final String ITEM_NAME = "item_name";
    private static final String ITEM_TYPE = "item_type";
    private static final String ITEM_QUANTITY = "item_quantity";
    private static final String ITEM_QUANTITY_UNIT = "item_quanity_unit";

    private static final String IS_CHECKED = "is_checked";
    private Context context;

    public DatabaseUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ALL_ITEMS = "CREATE TABLE " + TABLE_ALL_ITEMS + "(" + ITEM_NAME + " TEXT," +
                ITEM_TYPE + " TEXT, " + ITEM_QUANTITY_UNIT + " TEXT );";

        String CREATE_TABLE_GROCERY_LISTS = "CREATE TABLE " + TABLE_GROCERY_LISTS + "(" + USERNAME + " TEXT," +
                GROCERY_LIST_NAME + " TEXT, " + GROCERY_LIST_ID + " TEXT);";

        String CREATE_TABLE_GROCERY_LIST_ITEMS = "CREATE TABLE " + TABLE_GROCERY_LIST_ITEMS + "(" + ITEM_ID + " TEXT," +
                ITEM_NAME + " TEXT, " + ITEM_TYPE + " TEXT, " + ITEM_QUANTITY + " TEXT, "  + ITEM_QUANTITY_UNIT +
                " TEXT, " + IS_CHECKED + " INTEGER, "+ GROCERY_LIST_ID  + " TEXT);";
        try {
            db.execSQL(CREATE_TABLE_ALL_ITEMS);
            db.execSQL(CREATE_TABLE_GROCERY_LISTS);
            db.execSQL(CREATE_TABLE_GROCERY_LIST_ITEMS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALL_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_LISTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_LIST_ITEMS);

        onCreate(db);
    }

    // get all items from the database method
    public List<IteminData> getAllItemsFromDatabase(){
        List<IteminData> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_ALL_ITEMS;

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                IteminData item = new IteminData();
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                allItems.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return allItems;

    }

    public List<String> getAllItemsTypesFromDatabase(){
        List<String> allTypes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT DISTINCT(" + ITEM_TYPE + ") FROM " + TABLE_ALL_ITEMS ;

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String type = cursor.getString(cursor.getColumnIndex(ITEM_TYPE));
                allTypes.add(type);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return allTypes;

    }


    public List<IteminData> getItemsByTypeFromDatabase(String type){
        List<IteminData> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_ALL_ITEMS + " WHERE " + ITEM_TYPE + " ='" + type + "'";

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                IteminData item = new IteminData();
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                item.setQuantityUnit(cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY_UNIT)));
                allItems.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return allItems;

    }

    public List<IteminData> getSimilarItemsFromDatabase(String searchString){
        List<IteminData> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // select query
        String sql = "SELECT * FROM " + TABLE_ALL_ITEMS + " WHERE " + ITEM_NAME + " LIKE '" + searchString + "%'";
        String sql2 =  "SELECT * FROM " + TABLE_ALL_ITEMS + " WHERE " + ITEM_NAME + " LIKE '%" + searchString + "%'";

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                IteminData item = new IteminData();
                item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                item.setQuantityUnit(cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY_UNIT)));
                allItems.add(item);
            } while (cursor.moveToNext());
        }

        if (allItems.size() == 0) {
            cursor = db.rawQuery(sql2, null);

            if (cursor.moveToFirst()) {
                do {
                    IteminData item = new IteminData();
                    item.setName(cursor.getString(cursor.getColumnIndex(ITEM_NAME)));
                    item.setType(cursor.getString(cursor.getColumnIndex(ITEM_TYPE)));
                    item.setQuantityUnit(cursor.getString(cursor.getColumnIndex(ITEM_QUANTITY_UNIT)));
                    allItems.add(item);
                } while (cursor.moveToNext());
            }
        }

        cursor.close();
        return allItems;

    }

    public List<IteminList> getAllItemsInGroceryList(String grocery_list_id){
        List<IteminList> allItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String getAllQuery = "SELECT * FROM " + TABLE_GROCERY_LIST_ITEMS + " WHERE " + GROCERY_LIST_ID + " = '" + grocery_list_id + "'" + " ORDER BY " + ITEM_TYPE;

        Cursor cursor = db.rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()) {
            do {
                IteminList item = new IteminList();
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
        cursor.close();
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
        cursor.close();
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

    public void addItemToGroceryList(IteminList item, String grocery_list_id) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_ID, item.getId());
        values.put(ITEM_NAME, item.getName());
        values.put(ITEM_TYPE, item.getType());
        values.put(ITEM_QUANTITY, item.getQuantity());
        values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
        if(item.getIsChecked()){
            values.put(IS_CHECKED, 1);
        }else{
            values.put(IS_CHECKED, 0);
        }
        values.put(GROCERY_LIST_ID, grocery_list_id);
        db.insert(TABLE_GROCERY_LIST_ITEMS, null, values);
    }


    public void updateItemInGroceryList(IteminList item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_ID, item.getId());
        values.put(ITEM_NAME, item.getName());
        values.put(ITEM_TYPE, item.getType());
        values.put(ITEM_QUANTITY, item.getQuantity());
        values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
        if(item.getIsChecked()){
            values.put(IS_CHECKED, 1);
        }else{
            values.put(IS_CHECKED, 0);
        }

        db.update(TABLE_GROCERY_LIST_ITEMS, values, ITEM_ID + " = ?", new String[]{item.getId()});
        db.close();
    }

    public void deleteItemInGroceryList(IteminList item) {

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


    public void addItemToDatabase(IteminData item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, item.getName());
        values.put(ITEM_TYPE, item.getType());
        values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
        db.insert(TABLE_ALL_ITEMS, null, values);
    }

    public void populateDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        String getAllQuery = "SELECT * FROM " + TABLE_ALL_ITEMS;
        Cursor cursor = db.rawQuery(getAllQuery, null);
        int k = cursor.getCount();

        if (k <= 0) {
            List<IteminData> myList = new ArrayList<>();
            myList.add(new IteminData("Cereal","Fruity loops","Boxes"));
            myList.add(new IteminData("Household","Tide detergent","Boxes"));
            myList.add(new IteminData("Fruits","Apple","lb"));
            myList.add(new IteminData("Diary","Milk","gallon"));

            for(int i=0; i< myList.size(); i++){
                IteminData item = myList.get(i);
                ContentValues values = new ContentValues();
                values.put(ITEM_NAME, item.getName());
                values.put(ITEM_TYPE, item.getType());
                values.put(ITEM_QUANTITY_UNIT, item.getQuantityUnit());
                try {
                   long count =  db.insertOrThrow(TABLE_ALL_ITEMS, null, values);
                    count ++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        cursor = db.rawQuery(getAllQuery, null);
        k = cursor.getCount();
    }

}
