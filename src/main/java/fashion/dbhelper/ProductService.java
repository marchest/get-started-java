package fashion.dbhelper;


import fashion.model.Product;

import java.util.Collection;

public interface ProductService {

    public Object getDB();

    public Collection<Product> getProducts();

    public Product getById(String id);

    public Product store(Product product);

    public Product delete(Product product);

    public Product update(Product product);

}
