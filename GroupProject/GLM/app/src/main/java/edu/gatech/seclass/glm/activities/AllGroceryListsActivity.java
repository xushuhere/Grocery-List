package edu.gatech.seclass.glm.activities;

import android.app.Dialog;
import android.content.Intent;
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
import edu.gatech.seclass.glm.adapters.GroceryListAdapter;
import edu.gatech.seclass.glm.database.DatabaseUtil;
import edu.gatech.seclass.glm.models.GroceryList;

public class AllGroceryListsActivity extends AppCompatActivity {

    List<GroceryList> groceryLists;
    DatabaseUtil dataHandler;
    GroceryListAdapter adapter;
    ListView mGroceryListsListView;
    Button mAddListButton;
    Dialog dialog;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_grocery_lists);
        mGroceryListsListView = (ListView) findViewById(R.id.lv_all_grocery_lists);
        mAddListButton = (Button) findViewById(R.id.btn_add_list);

        user = getIntent().getStringExtra("user");
        if (user != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            TextView mtitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
            mtitle.setText("Welcome " + user);
        }

        groceryLists = new ArrayList<>();
        groceryLists = new ArrayList<>();
        dataHandler = new DatabaseUtil(getApplicationContext());

        groceryLists.addAll(dataHandler.getGroceryListsForUser(user));
        adapter = new GroceryListAdapter(AllGroceryListsActivity.this, groceryLists);
        mGroceryListsListView.setAdapter(adapter);

        mAddListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListDialog(user);
            }
        });
    }

    public void addListDialog(final String user){
        dialog = new Dialog(AllGroceryListsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_rename_list);
        final EditText newListNameEditText = (EditText) dialog.findViewById(R.id.ed_new_list_name);
        Button saveListButton = (Button) dialog.findViewById(R.id.btn_save_list);

        saveListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newListName = newListNameEditText.getText().toString();
                if(newListName.trim().length() == 0){
                    return;
                }

                GroceryList item = new GroceryList();
                item.setName(newListName);
                item.setId(UUID.randomUUID().toString().replace("-", ""));
                dataHandler.addGroceryListForUser(item, user);
                groceryLists.clear();
                groceryLists.addAll(dataHandler.getGroceryListsForUser(user));
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.show();

    }

    public void removeList(GroceryList groceryListItem){
        dataHandler.deleteGroceryList(groceryListItem);
        groceryLists.clear();
        groceryLists.addAll(dataHandler.getGroceryListsForUser(user));
        adapter.notifyDataSetChanged();
    }

    public void renameList(final GroceryList groceryList){
        dialog = new Dialog(AllGroceryListsActivity.this, R.style.CustomDialogTheme);
        dialog.setContentView(R.layout.dialog_rename_list);
        final EditText newListNameEditText = (EditText) dialog.findViewById(R.id.ed_new_list_name);
        Button saveListButton = (Button) dialog.findViewById(R.id.btn_save_list);

        newListNameEditText.setText(groceryList.getName());

        saveListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newListName = newListNameEditText.getText().toString();
                if(newListName.trim().length() == 0){
                    return;
                }
                groceryList.setName(newListName);
                dataHandler.renameGroceryListForUser(groceryList, user);
                groceryLists.clear();
                groceryLists.addAll(dataHandler.getGroceryListsForUser(user));
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.show();

    }

    public void viewListDetails(GroceryList item){
        Intent intent = new Intent(AllGroceryListsActivity.this, GroceryListDetailsActivity.class);
        intent.putExtra("grocery_list_id", item.getId());
        startActivity(intent);
    }
}


