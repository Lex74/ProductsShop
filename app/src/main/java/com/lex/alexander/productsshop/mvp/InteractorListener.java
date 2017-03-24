package com.lex.alexander.productsshop.mvp;

import com.lex.alexander.productsshop.CategoryModel;
import com.lex.alexander.productsshop.ProductModel;

import java.util.List;

public interface InteractorListener {
    void onProductsLoaded(int id, List<ProductModel> products);

    void onCategoriesLoaded(List<CategoryModel> categories);
}
