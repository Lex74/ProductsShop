package com.lex.alexander.productsshop;

import com.lex.alexander.productsshop.mvp.InteractorListener;
import com.lex.alexander.productsshop.mvp.PresenterLayer;
import com.lex.alexander.productsshop.mvp.InteractorLayer;
import com.lex.alexander.productsshop.mvp.ViewLayer;

import java.util.List;

public class Presenter implements PresenterLayer, InteractorListener {
    private InteractorLayer mInteractorLayer;
    private ViewLayer mViewLayer;
    private List<CategoryModel> mCategoryList;

    public Presenter(ViewLayer viewLayer){
        mViewLayer = viewLayer;
        mInteractorLayer = new ProductLoader(this);
    }

    @Override
    public void onViewReady(){
        mInteractorLayer.getCategories();
    }

    @Override
    public void presentProductItem(ProductsAdapter.SimpleListItemView view, int position){

    }

    @Override
    public void presentCategoryItem(AllProductsAdapter.CategoryView view, int position) {

    }

    @Override
    public void onProductsLoaded(int categoryId, List<ProductModel> products) {
        mViewLayer.showProductsInCategory(categoryId, products,this);
    }

    @Override
    public void onCategoriesLoaded(List<CategoryModel> categories) {
        mCategoryList = categories;
        mViewLayer.showCategories(categories, this);
        for (int i=0; i<categories.size(); i++)
            mInteractorLayer.getProducts(i);
    }
}
