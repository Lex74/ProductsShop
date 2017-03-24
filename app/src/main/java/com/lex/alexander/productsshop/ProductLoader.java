package com.lex.alexander.productsshop;

import android.os.Handler;

import com.lex.alexander.productsshop.mvp.InteractorLayer;
import com.lex.alexander.productsshop.mvp.InteractorListener;

import java.util.ArrayList;
import java.util.List;

public class ProductLoader implements InteractorLayer {
    private InteractorListener mInteractorListener;

    public ProductLoader(InteractorListener interactorListener){
        mInteractorListener = interactorListener;
    }

    @Override
    public void getProducts(final int categoryId) {
        final List<ProductModel> products = new ArrayList<>();
        for (int i=0;i<7;i++) {
            ProductModel productModel = new ProductModel();
            productModel.setImageRes(com.lex.alexander.productsshop.R.drawable.cream);
            ProductModel productModel2 = new ProductModel();
            productModel2.setImageRes(com.lex.alexander.productsshop.R.drawable.eyeshadows);
            products.add(productModel);
            products.add(productModel2);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mInteractorListener.onProductsLoaded(categoryId, products);
            }
        },4000);
    }

    @Override
    public void getCategories() {
        final List<CategoryModel> categories = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName("Products 1");

        CategoryModel categoryModel2 = new CategoryModel();
        categoryModel2.setCategoryName("Products 2");

        categories.add(categoryModel);
        categories.add(categoryModel2);

        mInteractorListener.onCategoriesLoaded(categories);
    }
}
