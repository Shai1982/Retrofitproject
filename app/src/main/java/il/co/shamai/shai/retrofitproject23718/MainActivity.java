package il.co.shamai.shai.retrofitproject23718;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Api api;
    private Adapter adapter;

    private TextView title;
    private TextView link;
    private TextView description;
    private TextView modified;
    private TextView generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.title);
        findViewById(R.id.link);
        findViewById(R.id.description);
        findViewById(R.id.modified);
        findViewById(R.id.generator);


        api = ApiUtils.getItemsClient();
        recyclerView = findViewById(R.id.my_recycler_view);
        getItemsList();
    }

    private void getItemsList() {

        api.getItems().enqueue(new Callback<MainInformation>() {
            @Override
            public void onResponse(Call<MainInformation> call, Response<MainInformation> response) {
                if(response.isSuccessful()) {

                    Log.d("MainActivity", "Actors list loaded");

                    title.setText(response.body().getTitle());
                    link.setText(response.body().getLink());
                    description.setText(response.body().description);
                    modified.setText(response.body().modified);
                    generator.setText(response.body().generator);

                    adapter = new Adapter(response.body().getItems(), MainActivity.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.HORIZONTAL);
                    recyclerView.addItemDecoration(itemDecoration);
                }else {
                    int statusCode  = response.code();
                    switch (statusCode) {
                        case 404:
                            Toast.makeText(MainActivity.this, "not found " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                        case 500:
                            Toast.makeText(MainActivity.this, "server broken " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                        default:
                            Toast.makeText(MainActivity.this, "unknown error " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                    }


                }
            }

            @Override
            public void onFailure(Call<MainInformation> call, Throwable t) {
                Log.d("MainActivity", "" + t.getMessage());
            }
        });
    }
}
