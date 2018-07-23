package il.co.shamai.shai.retrofitproject23718;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    public List<Items> list;
    public Context context;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Items item = list.get(position);
        holder.title.setText(item.title);
        holder.link.setText(item.author);
        Picasso.with(context)
                .load(item.media.m)
                .fit()
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title;
        public TextView link;
        public TextView media;
        public TextView date_token;
        public TextView description;
        public TextView published;
        public TextView author;
        public TextView author_id;
        public TextView tags;
        public ImageView imageView;



        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_1);
            link = itemView.findViewById(R.id.link_1);
            media = itemView.findViewById(R.id.media_1);
            date_token = itemView.findViewById(R.id.date_token_1);
            published = itemView.findViewById(R.id.published_1);
            author = itemView.findViewById(R.id.author_1);
            author_id = itemView.findViewById(R.id.author_id_1);
            tags = itemView.findViewById(R.id.author_tags_1);
            imageView = itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {
            Items item = getItem(getAdapterPosition());
            notifyDataSetChanged();
            if (view.getTag().equals("image"))
            {
                Toast.makeText(context,"" + item.title,Toast.LENGTH_LONG).show();
            }

        }
    }

    public Adapter(List<Items> itemsList, Context context) {
        this.list = itemsList;
        this.context = context;
    }


    private Items getItem(int adapterPosition)
    {
        return list.get(adapterPosition);
    }
}
