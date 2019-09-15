package fashion.dbhelper;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import fashion.model.Product;
import fashion.utils.Utility;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;


public class MongoDbHelper implements DbHelper {



    private MongoDatabase db=null;

    private MongoCollection<Document> collection;
    private static final String dbName="trendfitscraperdb",collectionName="ZaraProducts";

    public MongoDbHelper(){
        MongoClient client=createClient();
        db=client.getDatabase(dbName);
        if (db == null) {
            System.out.println("Could not find database with name \"" +
                    dbName +
                    "\". A new database will be created.");
        }
        collection=db.getCollection(collectionName);
    }


    public static MongoClient createClient(){
        String url= null;
        try {
            url = Utility.getProp("mongo.properties").getProperty("mongo_url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (url == null || url.length() == 0) {
            System.out.println("To use a database, set the MongoDB url in src/main/resources/mongo.properties");
            return null;
        }
        MongoClient mongoClient=new MongoClient(new MongoClientURI(url));
        return mongoClient;
    }

    public Collection<Product> getAll() {
        Collection<Product> products=new HashSet<Product>();
        try {
            MongoIterable<Document> foundedProducts=collection.find();
            for (Document doc: foundedProducts
                 ) {
                Product p=new Product();
                p.setColor(doc.getString("color"));
                p.setDescription(doc.getString("description"));
                p.setId(doc.getObjectId("_id").toString());
                p.setImgUrls(doc.getString("imgUrls"));
                p.setItemLink(doc.getString("itemLink"));
                p.setName("name");
                p.setPrice(doc.getString("price"));
                products.add(p);
            }



        }catch (Exception e){
            return null;
        }
        return products
                ;
    }

    public Product getProduct(String id) {
        Document doc=collection.find(Filters.eq("_id",id)).first();
        Product p=new Product();
        p.setColor(doc.getString("color"));
        p.setDescription(doc.getString("description"));
        p.setId(doc.getObjectId("_id").toString());
        p.setImgUrls(doc.getString("imgUrls"));
        p.setItemLink(doc.getString("itemLink"));
        p.setName("name");
        p.setPrice(doc.getString("price"));
        return p;
    }

    public MongoDatabase getDb() {
        return db;
    }
}
