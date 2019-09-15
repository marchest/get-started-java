package fashion.service;



import fashion.dbhelper.DbFactory;
import fashion.dbhelper.DbHelper;
import fashion.model.Product;

import java.util.Collection;

public class ProductService {

    DbHelper dbHelper= DbFactory.getInstance();

    public Collection<Product> getAll(){
        return dbHelper.getAll();
    }





}
