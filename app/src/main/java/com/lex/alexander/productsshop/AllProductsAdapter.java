package com.lex.alexander.productsshop;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lex.alexander.productsshop.mvp.PresenterLayer;

import java.util.ArrayList;
import java.util.List;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ItemViewHolder> {
    private List<CategoryModel> mCategories;
    private PresenterLayer mPresenter;

    public AllProductsAdapter(List<CategoryModel> categoryItemList, PresenterLayer presenter) {
        mCategories = categoryItemList;
        mPresenter = presenter;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.setCategoryName(mCategories.get(position).getCategoryName());
        holder.setProductList(mCategories.get(position).getProductList());
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.lex.alexander.productsshop.R.layout.item_category,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void addProductsToCategory(int categoryId, List<ProductModel> products){
        mCategories.get(categoryId).setProductList(products);

    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements CategoryView{
        TextView categoryNameView;
        RecyclerView productsRecycler;

        public ItemViewHolder(View itemView) {
            super(itemView);
            categoryNameView = (TextView) itemView.findViewById(com.lex.alexander.productsshop.R.id.category_name);
            productsRecycler = (RecyclerView) itemView.findViewById(com.lex.alexander.productsshop.R.id.product_items);
            productsRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
            productsRecycler.setItemAnimator(new DefaultItemAnimator());
            productsRecycler.setAdapter(new ProductsAdapter(new ArrayList<ProductModel>(),mPresenter));
        }

        @Override
        public void setCategoryName(String categoryName) {
            categoryNameView.setText(categoryName);
        }

        @Override
        public void setProductList(List<ProductModel> productList) {
            ProductsAdapter productsAdapter = (ProductsAdapter) productsRecycler.getAdapter();
            productsAdapter.setProductList(productList);
            productsAdapter.notifyDataSetChanged();
        }
    }

    public interface CategoryView{
        void setCategoryName(String categoryName);
        void setProductList(List<ProductModel> productList);
    }
}
