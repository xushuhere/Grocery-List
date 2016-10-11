package edu.gatech.seclass.glm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.activities.GroceryListDetailsActivity;
import edu.gatech.seclass.glm.models.Item;

import static edu.gatech.seclass.glm.R.id.iv_remove_item;

/**
 * Created by Anshul on 10/11/16.
 */

public class GroceryListItemAdapter extends ArrayAdapter{
    private LayoutInflater mInflater;
    private Context mContext;


    public GroceryListItemAdapter(Context context, List<Item> items) {
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
        private CheckBox mItemCheckedCheckBox;
        private TextView mGroceryListItemNameTextView;
        private TextView mGroceryListItemTypeTextView;
        private TextView mGroceryListItemQuantityTextView;
        private TextView mGroceryListItemQuantityUnitTextView;
        private ImageView mRemoveItemImageView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GroceryListItemAdapter.ViewHolder holder;
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.card_grocery_list_item, parent, false);
            holder = new GroceryListItemAdapter.ViewHolder();
            holder.mItemCheckedCheckBox = (CheckBox) convertView.findViewById(R.id.cd_item_checked);
            holder.mGroceryListItemNameTextView = (TextView) convertView.findViewById(R.id.tv_grocery_list_item_name);
            holder.mGroceryListItemTypeTextView = (TextView) convertView.findViewById(R.id.tv_grocery_list_item_type);
            holder.mGroceryListItemQuantityTextView = (TextView) convertView.findViewById(R.id.tv_grocery_list_item_quantity);
            holder.mGroceryListItemQuantityUnitTextView = (TextView) convertView.findViewById(R.id.tv_grocery_list_item_quantity_unit);
            holder.mRemoveItemImageView = (ImageView) convertView.findViewById(iv_remove_item);

            convertView.setTag(holder);
        }
        else {
            holder= (GroceryListItemAdapter.ViewHolder) convertView.getTag();
        }

        final Item item= (Item) getItem(position);

        holder.mGroceryListItemNameTextView.setText(item.getName());
        holder.mGroceryListItemTypeTextView.setText(item.getType());
        holder.mGroceryListItemQuantityTextView.setText(item.getQuantity());
        holder.mGroceryListItemQuantityUnitTextView.setText(item.getQuantityUnit());

        if(item.isChecked()){
            holder.mItemCheckedCheckBox.setChecked(true);
        }else{
            holder.mItemCheckedCheckBox.setChecked(false);
        }

        holder.mItemCheckedCheckBox.setTag(item);
        holder.mRemoveItemImageView.setTag(item);

        holder.mRemoveItemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item selectedItem = (Item) v.getTag();
                ((GroceryListDetailsActivity)getContext()). deleteItem(selectedItem);
            }
        });

        holder.mItemCheckedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Item selectedItem = (Item) buttonView.getTag();
                ((GroceryListDetailsActivity)getContext()). markItemAsCheckedUnchecked(selectedItem, isChecked);
            }
        });

        return convertView;
    }
}
