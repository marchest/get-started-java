package fashion.dbhelper;


import fashion.model.Product;

import java.util.Collection;

public interface DbHelper {

    Collection<Product> getAll();

    Product getProduct(String id);
}
