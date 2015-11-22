package com.trees.howtolinux.home;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.trees.howtolinux.R;
import com.trees.howtolinux.home.homerecycler.HetroRecyAdapter;

public class MainActivity extends AppCompatActivity
{
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init()
    {
        context=this;

        if(getSupportActionBar()!=null)
        getSupportActionBar().setElevation(0);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            GridLayoutManager manager=new GridLayoutManager(context, 2);

//        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS); //it helps to adjust the size at variant sizes
            manager.setSpanSizeLookup(
                    new GridLayoutManager.SpanSizeLookup() {
                        @Override
                        public int getSpanSize(int position) {
                            if (position == 0) return 2;
                            return 1;
                        }
                    });
            recyclerView.setLayoutManager(manager);
        }
        else
        {
            StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,1);
            manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
            recyclerView.setLayoutManager(manager);
        }

        recyclerView.setAdapter(new HetroRecyAdapter(context));

    }
}
