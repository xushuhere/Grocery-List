package edu.gatech.seclass.glm.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapters.GroceryListItemAdapter;
import edu.gatech.seclass.glm.adapters.SearchListItemAdapter;
import edu.gatech.seclass.glm.database.DatabaseUtil;
import edu.gatech.seclass.glm.models.GroceryList;
import edu.gatech.seclass.glm.models.IteminData;
import edu.gatech.seclass.glm.models.IteminList;

//import edu.gatech.seclass.glm.models.IteminData;

public class GroceryListDetailsActivity extends AppCompatActivity implements View.OnClickListener{
    GroceryList groceryList;
    List<IteminList> items;
    DatabaseUtil dataHandler;
    GroceryListItemAdapter adapter;
    private ListView mListItemsListView;
    private Button mAddItemButton;
    Dialog dialog;
    private Button mCheckAllButton;
    private Button mUncheckAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list_details);
        mListItemsListView = (ListView) findViewById(R.id.lv_grocery_list_items);
        mAddItemButton = (Button) findViewById(R.id.btn_add_item);
        mCheckAllButton = (Button) findViewById(R.id.btn_check_all);
        mUncheckAllButton = (Button) findViewById(R.id.btn_uncheck_all);


        mListItemsListView = (ListView) findViewById(R.id.lv_grocery_list_items);
        mAddItemButton = (Button) findViewById(R.id.btn_add_item);

        dataHandler = new DatabaseUtil(getApplicationContext());

        final String list_id = getIntent().getStringExtra("grocery_list_id");
        groceryList = dataHandler.getGroceryListById(list_id);

        if (groceryList != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            TextView mtitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
            mtitle.setText(groceryList.getName());
        }

        items = new ArrayList<>();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));

        adapter = new GroceryListItemAdapter(GroceryListDetailsActivity.this, items);
        mListItemsListView.setAdapter(adapter);

        mAddItemButton.setOnClickListener(this);
        mCheckAllButton.setOnClickListener(this);
        mUncheckAllButton.setOnClickListener(this);

    }

//    public void addListDialog(final GroceryList groceryList){
//        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
//        dialog.setContentView(R.layout.dialog_add_list_item);
//        final EditText newItemNameEditText = (EditText) dialog.findViewById(R.id.ed_new_item_name);
//        final EditText newItemTypeEditText = (EditText) dialog.findViewById(R.id.ed_new_item_type);
//        final EditText newItemQuantityEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity);
//        final EditText newItemQuantityUnitEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity_unit);
//        Button saveItemButton = (Button) dialog.findViewById(R.id.btn_save_item);
//
//        saveItemButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                IteminList item = new IteminList();
//                item.setName(newItemNameEditText.getText().toString());
//                item.setType(newItemTypeEditText.getText().toString());
//                item.setQuantity(newItemQuantityEditText.getText().toString());
//                item.setQuantityUnit(newItemQuantityUnitEditText.getText().toString());
//                item.setChecked(false);
//                item.setId(UUID.randomUUID().toString().replace("-", ""));
//
//                dataHandler.addItemToGroceryList(item, groceryList.getId());
//                dialog.dismiss();
//
//                items.clear();
//                items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
//                adapter.notifyDataSetChanged();
//
//            }
//        });
//
//        dialog.setCancelable(true);
//        dialog.show();
//    }


    public void addListCriteriaSelection(final GroceryList groceryList){
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_add_criteria);
        Button nameSearchButton = (Button) dialog.findViewById(R.id.btn_name_search);
        Button hierarchicalListButton = (Button) dialog.findViewById(R.id.btn_Hierarchical_list);

        nameSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                addItemByName();
            }
        });

        hierarchicalListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                addItemByType();
            }
        });
        dialog.show();
    }

    public void addItemByName(){
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_search_by_name);
        final EditText searchBoxEditText = (EditText) dialog.findViewById(R.id.ed_searchBox);
        Button addItemButton = (Button) dialog.findViewById(R.id.btn_add_item);
        final ListView searchedItemsListView = (ListView) dialog.findViewById(R.id.lv_searchedItems);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IteminData itemInData = new IteminData();
                itemInData.setName(searchBoxEditText.getText().toString());
                itemSelected(itemInData);
            }
        });

        searchBoxEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<IteminData> results = dataHandler.getSimilarItemsFromDatabase(s.toString());
                SearchListItemAdapter searchAdapter = new SearchListItemAdapter(GroceryListDetailsActivity.this, results);
                searchedItemsListView.setAdapter(searchAdapter);
            }
        });

        dialog.show();
    }

    public void itemSelected(IteminData item){
        dialog.dismiss();
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_add_list_item);
        //final EditText newItemNameEditText = (EditText) dialog.findViewById(R.id.ed_new_item_name);
        final TextView newItemName = (TextView) dialog.findViewById(R.id.new_item_name);
        final TextView newItemType = (TextView) dialog.findViewById(R.id.new_item_type);
        final TextView newItemUnit = (TextView) dialog.findViewById(R.id.new_item_quantity_unit);

        //final EditText newItemTypeEditText = (EditText) dialog.findViewById(R.id.ed_new_item_type);
        final EditText newItemQuantityEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity);
        //final EditText newItemQuantityUnitEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity_unit);
        Button saveItemButton = (Button) dialog.findViewById(R.id.btn_save_item);
        //Button saveAndAddItemButton = (Button) dialog.findViewById(R.id.btn_save_and_add_item);
        if(item.getName() != null && !item.getName().isEmpty()){
            newItemName.setText(item.getName());
        }
        if(item.getType() != null && !item.getType().isEmpty()){
            newItemType.setText(item.getType());
        }else{
            itemnNewSelected(item);
            //saveItemButton.setVisibility(View.INVISIBLE);

        }
        if(item.getQuantityUnit() != null && !item.getQuantityUnit().isEmpty()){
            newItemUnit.setText(item.getQuantityUnit());
        }

        saveItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IteminList item = new IteminList();
                item.setName(newItemName.getText().toString());
                item.setType(newItemType.getText().toString());
                item.setQuantity(newItemQuantityEditText.getText().toString());
                item.setQuantityUnit(newItemUnit.getText().toString());
                item.setChecked(false);
                item.setId(UUID.randomUUID().toString().replace("-", ""));

                dataHandler.addItemToGroceryList(item, groceryList.getId());
                dialog.dismiss();

                items.clear();
                items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
                adapter.notifyDataSetChanged();
            }
        });


        dialog.setCancelable(true);
        dialog.show();
    }


    // TODO change the types as a spinner dropdown menu and pull type from database
    // Currently manual type in types for new item

    public void itemnNewSelected(IteminData item){
        dialog.dismiss();
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_add_new_list_item);
        final TextView newItemName = (TextView) dialog.findViewById(R.id.new_item_name);
        final EditText newItemQuantityEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity);
        final EditText newItemQuantityUnitEditText = (EditText) dialog.findViewById(R.id.new_item_quantity_unit);
        Button saveAndAddItemButton = (Button) dialog.findViewById(R.id.btn_save_and_add_item);
         if(item.getName() != null && !item.getName().isEmpty()){
             newItemName.setText(item.getName());
         }

        final Spinner newItemTypeSpinner = (Spinner) dialog.findViewById(R.id.new_item_type);


        ArrayAdapter<String> searchInAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.custom_list_item_text, dataHandler.getAllItemsTypesFromDatabase());
        searchInAdapter.setDropDownViewResource(R.layout.custom_list_item_text);
        newItemTypeSpinner.setAdapter(searchInAdapter);
        newItemTypeSpinner.setSelection(0);

        saveAndAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IteminList item = new IteminList();
                IteminData itemForDB = new IteminData();
                item.setName(newItemName.getText().toString());
                item.setType(newItemTypeSpinner.getSelectedItem().toString());
                item.setQuantity(newItemQuantityEditText.getText().toString());
                item.setQuantityUnit(newItemQuantityUnitEditText.getText().toString());
                item.setChecked(false);
                item.setId(UUID.randomUUID().toString().replace("-", ""));

                itemForDB.setName(item.getName());
                itemForDB.setType(item.getType());
                itemForDB.setQuantityUnit(item.getQuantityUnit());

                dataHandler.addItemToGroceryList(item, groceryList.getId());
                dataHandler.addItemToDatabase(itemForDB);
                dialog.dismiss();

                items.clear();
                items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
                adapter.notifyDataSetChanged();
            }
        });


        dialog.setCancelable(true);
        dialog.show();
    }

    public void editItemSelected(final IteminList item){
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_edit_list_item);
        final EditText editedItemQuantityEditText = (EditText) dialog.findViewById(R.id.ed_item_quantity);
        Button saveItemButton = (Button) dialog.findViewById(R.id.btn_save_item);

        saveItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setQuantity(editedItemQuantityEditText.getText().toString());
                dataHandler.updateItemInGroceryList(item);
                dialog.dismiss();
                items.clear();
                items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
                adapter.notifyDataSetChanged();
            }
        });

        dialog.setCancelable(true);
        dialog.show();
    }

    public void addItemByType(){
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_search_by_type_parent);
        ListView searchedItemsListView = (ListView) dialog.findViewById(R.id.lv_searchedItems);

        final List<String> results = dataHandler.getAllItemsTypesFromDatabase();

        ArrayAdapter<String> searchInAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.custom_list_item_text, results);
        searchedItemsListView.setAdapter(searchInAdapter);

        searchedItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addItemByTypeSecondDialog(results.get(position).toString());
            }
        });

        dialog.show();
    }


    public void addItemByTypeSecondDialog(String type){
        dialog.dismiss();
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_search_by_type_child);
        ListView searchedItemsListView = (ListView) dialog.findViewById(R.id.lv_searchedItems);
        List<IteminData> results = dataHandler.getItemsByTypeFromDatabase(type);
        SearchListItemAdapter searchAdapter = new SearchListItemAdapter(GroceryListDetailsActivity.this, results);
        searchedItemsListView.setAdapter(searchAdapter);
        dialog.show();
    }

    public void markItemAsCheckedUnchecked(IteminList item, boolean isChecked) {
        item.setChecked(isChecked);
        dataHandler.updateItemInGroceryList(item);
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void deleteItem(IteminList item) {
        dataHandler.deleteItemInGroceryList(item);
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void checkAll() {
        for(int i=0; i<items.size(); i++){
            IteminList item = items.get(i);
            item.setChecked(true);
            dataHandler.updateItemInGroceryList(item);
        }
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void uncheckAll() {
        for(int i=0; i<items.size(); i++){
            IteminList item = items.get(i);
            item.setChecked(false);
            dataHandler.updateItemInGroceryList(item);
        }
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_item:
                addListCriteriaSelection(groceryList);
                break;
            case R.id.btn_check_all:
                checkAll();
                break;
            case R.id.btn_uncheck_all:
                uncheckAll();
                break;
        }
    }
}
