package il.co.shamai.shai.retrofitproject23718;

public class ApiUtils {

    public static final String BASE_URL = "https://api.flickr.com/";


    public static Api getItemsClient()
    {
        return RetrofitClient.getRetrofitClient(BASE_URL).create(Api.class);
    }
}
