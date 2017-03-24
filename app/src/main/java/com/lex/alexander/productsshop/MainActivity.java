package com.lex.alexander.productsshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.lex.alexander.productsshop.mvp.PresenterLayer;
import com.lex.alexander.productsshop.mvp.ViewLayer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewLayer {
    RecyclerView mAllProductsRecycler;
    PresenterLayer presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lex.alexander.productsshop.R.layout.activity_main);
        toolbarInit();

        allProductsRecyclerInit();

        presenter = new Presenter(this);
        presenter.onViewReady();
    }

    private void allProductsRecyclerInit() {
        mAllProductsRecycler = (RecyclerView) findViewById(com.lex.alexander.productsshop.R.id.all_products_recycler);
        mAllProductsRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAllProductsRecycler.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void showCategories(List<CategoryModel> categoryItemList, PresenterLayer presenter){
        mAllProductsRecycler.setAdapter(new AllProductsAdapter(categoryItemList, presenter));
    }

    @Override
    public void showProductsInCategory(int categoryId, List<ProductModel> productList, PresenterLayer presenter) {
        AllProductsAdapter adapter = (AllProductsAdapter) mAllProductsRecycler.getAdapter();
        adapter.addProductsToCategory(categoryId, productList);
        adapter.notifyItemChanged(categoryId);
    }

    private void toolbarInit() {
        Toolbar toolbar = (Toolbar) findViewById(com.lex.alexander.productsshop.R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.lex.alexander.productsshop.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.lex.alexander.productsshop.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == com.lex.alexander.productsshop.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
