package edu.gatech.seclass.glm.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.adapters.GroceryListItemAdapter;
import edu.gatech.seclass.glm.database.DatabaseUtil;
import edu.gatech.seclass.glm.models.GroceryList;
import edu.gatech.seclass.glm.models.Item;

public class GroceryListDetailsActivity extends AppCompatActivity implements View.OnClickListener{
    GroceryList groceryList;
    List<Item> items;
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

    public void addListDialog(final GroceryList groceryList){
        dialog = new Dialog(GroceryListDetailsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_add_list_item);
        final EditText newItemNameEditText = (EditText) dialog.findViewById(R.id.ed_new_item_name);
        final EditText newItemTypeEditText = (EditText) dialog.findViewById(R.id.ed_new_item_type);
        final EditText newItemQuantityEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity);
        final EditText newItemQuantityUnitEditText = (EditText) dialog.findViewById(R.id.ed_new_item_quantity_unit);
        Button saveItemButton = (Button) dialog.findViewById(R.id.btn_save_item);

        saveItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item();
                item.setName(newItemNameEditText.getText().toString());
                item.setType(newItemTypeEditText.getText().toString());
                item.setQuantity(newItemQuantityEditText.getText().toString());
                item.setQuantityUnit(newItemQuantityUnitEditText.getText().toString());
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

    public void markItemAsCheckedUnchecked(Item item, boolean isChecked) {
        item.setChecked(isChecked);
        dataHandler.updateItemInGroceryList(item);
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void deleteItem(Item item) {
        dataHandler.deleteItemInGroceryList(item);
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void checkAll() {
        for(int i=0; i<items.size(); i++){
            Item item = items.get(i);
            item.setChecked(true);
            dataHandler.updateItemInGroceryList(item);
        }
        items.clear();
        items.addAll(dataHandler.getAllItemsInGroceryList(groceryList.getId()));
        adapter.notifyDataSetChanged();
    }

    public void uncheckAll() {
        for(int i=0; i<items.size(); i++){
            Item item = items.get(i);
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
                addListDialog(groceryList);
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
