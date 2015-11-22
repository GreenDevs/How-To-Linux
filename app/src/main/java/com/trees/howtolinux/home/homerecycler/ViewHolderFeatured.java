package com.trees.howtolinux.home.homerecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.trees.howtolinux.R;

/**
 * Created by trees on 11/21/15.
 */
public class ViewHolderFeatured extends RecyclerView.ViewHolder
{
    TextView featuredText;
    public ViewHolderFeatured(View itemView)
    {
        super(itemView);
        featuredText=(TextView)itemView.findViewById(R.id.featuredText);
    }
}
