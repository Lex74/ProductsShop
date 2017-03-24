package com.lex.alexander.productsshop.mvp;

import com.lex.alexander.productsshop.CategoryModel;
import com.lex.alexander.productsshop.ProductModel;

import java.util.List;

public interface ViewLayer {
    void showProductsInCategory(int categoryId, List<ProductModel> productList, PresenterLayer presenter);

    void showCategories(List<CategoryModel> categoryItemList, PresenterLayer presenter);
}
