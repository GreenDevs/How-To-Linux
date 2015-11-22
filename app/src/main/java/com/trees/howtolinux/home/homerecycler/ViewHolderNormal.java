package com.trees.howtolinux.home.homerecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.trees.howtolinux.R;

/**
 * Created by trees on 11/21/15.
 */
public class ViewHolderNormal extends RecyclerView.ViewHolder
{

    TextView icon, catName, catSummary;
    View itemView;

    public ViewHolderNormal(View itemView)
    {
        super(itemView);

        this.itemView=itemView;
        icon=(TextView)itemView.findViewById(R.id.category_icon);
        catName=(TextView)itemView.findViewById(R.id.category_name);
        catSummary=(TextView)itemView.findViewById(R.id.category_summary);
    }
}
