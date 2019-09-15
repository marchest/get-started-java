package fashion.dbhelper;

public class DbFactory {

    private static DbHelper instance;
    static {
        MongoDbHelper dbHelper=new MongoDbHelper();
        instance =dbHelper;

    }
    public static DbHelper getInstance(){
        return instance;
    }
}
