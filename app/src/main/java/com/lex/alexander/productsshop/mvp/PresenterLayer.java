package com.lex.alexander.productsshop.mvp;

import com.lex.alexander.productsshop.AllProductsAdapter;
import com.lex.alexander.productsshop.ProductsAdapter;

public interface PresenterLayer {
    void onViewReady();

    void presentProductItem(ProductsAdapter.SimpleListItemView view, int position);

    void presentCategoryItem (AllProductsAdapter.CategoryView view, int position);
}
