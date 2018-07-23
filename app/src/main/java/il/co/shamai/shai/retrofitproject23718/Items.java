package il.co.shamai.shai.retrofitproject23718;

import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("link")
    public String link;

    @SerializedName("title")
    public String title;

    @SerializedName("media")
    public Media media;

    @SerializedName("date_taken")
    public String date_taken;

    @SerializedName("description")
    public String description;

    @SerializedName("published")
    public String published;

    @SerializedName("author")
    public String author;

    @SerializedName("author_id")
    public String author_id;

    @SerializedName("tags")
    public String tags;

}
