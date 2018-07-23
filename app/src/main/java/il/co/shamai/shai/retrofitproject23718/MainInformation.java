package il.co.shamai.shai.retrofitproject23718;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainInformation {

    @SerializedName("title")
    public String title;

    @SerializedName("link")
    public String link;

    @SerializedName("description")
    public String description;

    @SerializedName("modified")
    public String modified;

    @SerializedName("generator")
    public String generator;

    @SerializedName("items")
    public List<Items> items;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getGenerator() {
        return generator;
    }

    public List<Items> getItems() {
        return items;
    }
}
