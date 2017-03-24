package com.lex.alexander.productsshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lex.alexander.productsshop.mvp.PresenterLayer;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ItemViewHolder> {
    private List<ProductModel> mProducts;
    private PresenterLayer mPresenter;

    public ProductsAdapter(List<ProductModel> products, PresenterLayer presenter){
        mProducts = products;
        mPresenter = presenter;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(com.lex.alexander.productsshop.R.layout.item_products,parent,false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (mProducts != null)
            holder.setImageRes(mProducts.get(position).getImageRes());
    }

    @Override
    public int getItemCount() {
        if (mProducts == null) return 0;
        return mProducts.size();
    }

    public void setProductList(List<ProductModel> productList){
        mProducts = productList;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements SimpleListItemView{
        private ImageView productImage;

        ItemViewHolder(View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(com.lex.alexander.productsshop.R.id.product_image);
        }

        @Override
        public void setImageRes(int imgRes) {
            productImage.setImageResource(imgRes);
        }
    }

    public interface SimpleListItemView{
        void setImageRes(int imgRes);
    }


}
