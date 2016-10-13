package edu.gatech.seclass.glm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.glm.R;
import edu.gatech.seclass.glm.activities.GroceryListDetailsActivity;
import edu.gatech.seclass.glm.models.IteminData;

/**
 * Created by Anshul on 10/11/16.
 */

public class SearchListItemAdapter extends ArrayAdapter{
    private LayoutInflater mInflater;
    private Context mContext;


    public SearchListItemAdapter(Context context, List<IteminData> items) {
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
        private TextView mGroceryListItemNameTextView;
        private TextView mGroceryListItemTypeTextView;
        private LinearLayout card;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SearchListItemAdapter.ViewHolder holder;
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.card_search_list_item, parent, false);
            holder = new SearchListItemAdapter.ViewHolder();
            holder.mGroceryListItemNameTextView = (TextView) convertView.findViewById(R.id.tv_search_list_item_name);
            holder.mGroceryListItemTypeTextView = (TextView) convertView.findViewById(R.id.tv_search_list_item_type);
            holder.card = (LinearLayout) convertView.findViewById(R.id.card_search_item);


            convertView.setTag(holder);
        }
        else {
            holder= (SearchListItemAdapter.ViewHolder) convertView.getTag();
        }

        final IteminData item= (IteminData) getItem(position);

        holder.mGroceryListItemNameTextView.setText(item.getName());
        holder.mGroceryListItemTypeTextView.setText(item.getType());
        holder.card.setTag(item);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GroceryListDetailsActivity) getContext()).itemSelected((IteminData) v.getTag());
            }
        });
        return convertView;
    }
}
