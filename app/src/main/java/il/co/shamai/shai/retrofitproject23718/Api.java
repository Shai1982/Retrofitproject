package il.co.shamai.shai.retrofitproject23718;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/services/feeds/photos_public.gne?tags=kitten&format=json")
    Call<MainInformation> getItems();
}
