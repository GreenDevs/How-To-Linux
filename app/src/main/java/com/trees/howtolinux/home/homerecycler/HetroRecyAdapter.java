package com.trees.howtolinux.home.homerecycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trees.howtolinux.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trees on 11/21/15.
 */
public class HetroRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> 
{

    private List<Object> data;
    private Context context;
    private LayoutInflater inflater;
    private final int NORMAL_ITEM=1, FEATURED_ITEM=0;

    public HetroRecyAdapter (Context context)
    {
        data=new ArrayList();
        this.context=context;
        inflater=LayoutInflater.from(context);

        data.add("\"Linux was originally developed as a free operating system for personal computers based on the Intel x86 " +
                "architecture, but has since been ported to more computer hardware platforms than any other operating system.\"");
        data.add(new NormalItem("NAV", "Navigation", "ls cd  cp"));
        data.add(new NormalItem("NAV", "Scripting", "read $ for if else"));
        data.add(new NormalItem("NAV", "Editors", "vim Emacs Nano"));
        data.add(new NormalItem("NAV", "Quiz", "grep ? ps ? "));
        data.add(new NormalItem("NAV", "Miscallenous", "iptux regx funny"));
    }

    
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) 
    {
        RecyclerView.ViewHolder viewHolder;

        switch(viewType)
        {
            case FEATURED_ITEM:
                viewHolder=new ViewHolderFeatured(inflater.inflate(R.layout.featured_comands, parent, false));
                break;

            case NORMAL_ITEM:
                viewHolder=new ViewHolderNormal(inflater.inflate(R.layout.grid_item, parent, false));
                break;
            default:
                viewHolder=new ViewHolderFeatured(inflater.inflate(R.layout.featured_comands, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position)
    {
        switch (viewholder.getItemViewType())
        {
            case NORMAL_ITEM:

                Resources res=context.getResources();
                ViewHolderNormal holder=(ViewHolderNormal)viewholder;
                NormalItem item=(NormalItem)data.get(position);
                holder.catName.setText(item.catName);
                holder.catSummary.setText(item.catSummary);

                Typeface typeface=Typeface.createFromAsset(context.getAssets(), "home.ttf");
                holder.icon.setTypeface(typeface);

                switch (position)
                {
                    case 1:
                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.patro_green));
                        holder.icon.setText(res.getString(R.string.basic_icon));
                        break;
                    case 2:
                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.patro_orange));
                        holder.icon.setText(res.getString(R.string.script_icon));
                        break;
                    case 3:
                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.patro_yellow));
                        holder.icon.setText(res.getString(R.string.editor_icon));
                        break;
                    case 4:
                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.patro_grey));
                        holder.icon.setText(res.getString(R.string.quiz_icon));
                        break;
                    case 5:
                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.patro_blue));
                        holder.icon.setText(res.getString(R.string.miscallenous));
                        break;
                    default:
                        holder.icon.setText(res.getString(R.string.basic_icon));
                        break;
                }
                break;

            case FEATURED_ITEM:

                ((ViewHolderFeatured)viewholder).featuredText.setText((String) data.get(position));
                break;


            default:
                ((ViewHolderFeatured)viewholder).featuredText.setText((String)data.get(position));
                break;
        }


    }

    @Override
    public int getItemCount() 
    {
        return data.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        if(data.get(position) instanceof String)
        {
            return  FEATURED_ITEM;
        }
        else if(data.get(position) instanceof  NormalItem)
        {
            return NORMAL_ITEM;
        }
        return -1;

    }
}
