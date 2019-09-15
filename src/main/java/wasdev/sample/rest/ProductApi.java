package wasdev.sample.rest;

import com.google.gson.Gson;
import fashion.service.ProductService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
@Path("/products")
public class ProductApi extends Application {

    ProductService service=new ProductService();


    @GET
    @Path("/")
    @Produces("application/json")
    public String getProducts(){
        return new Gson().toJson(service.getAll());
    }

}
