package edu.gatech.seclass.glm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.activities.AllGroceryListsActivity;
import edu.gatech.seclass.glm.models.GroceryList;

/**
 * Created by Anshul on 10/11/16.
 */

public class GroceryListAdapter extends ArrayAdapter implements View.OnClickListener{
    private LayoutInflater mInflater;
    private Context mContext;


    public GroceryListAdapter(Context context, List<GroceryList> items) {
        super(context,0,items);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    private class ViewHolder{
        private TextView mGroceryListNameTextView;
        private ImageView mEditItemImageView;
        private ImageView mRemoveItemImageView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            convertView =   mInflater.inflate(R.layout.card_grocery_list, parent, false);
            holder = new ViewHolder();
            holder.mGroceryListNameTextView = (TextView) convertView.findViewById(R.id.tv_grocery_list_name);
            holder.mEditItemImageView = (ImageView) convertView.findViewById(R.id.iv_edit_item);
            holder.mRemoveItemImageView = (ImageView) convertView.findViewById(R.id.iv_remove_item);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }

        GroceryList item= (GroceryList) getItem(position);
        holder.mGroceryListNameTextView.setText(item.getName());

        holder.mGroceryListNameTextView.setTag(item);
        holder.mEditItemImageView.setTag(item);
        holder.mRemoveItemImageView.setTag(item);

        holder.mGroceryListNameTextView.setOnClickListener(this);
        holder.mEditItemImageView.setOnClickListener(this);
        holder.mRemoveItemImageView.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        final GroceryList item = (GroceryList) v.getTag();
        switch (v.getId()) {
            case R.id.tv_grocery_list_name:
                ((AllGroceryListsActivity) getContext()).viewListDetails(item);
                break;
            case R.id.iv_edit_item:
                ((AllGroceryListsActivity) getContext()).renameList(item);
                break;
            case R.id.iv_remove_item:
                ((AllGroceryListsActivity) getContext()).removeList(item);
                break;
        }
    }
}
