package marcosjr.com.apidefilmes.ViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import marcosjr.com.apidefilmes.Model.Result;
import marcosjr.com.apidefilmes.R;

public class AdapterRecyclerview extends RecyclerView.Adapter<AdapterRecyclerview.ViewHolder> {

    List<Result> resultList;
    Context context;

    public AdapterRecyclerview(List<Result> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @Override
    public AdapterRecyclerview.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new ViewHolder(inflater.inflate(R.layout.item_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerview.ViewHolder holder, int position) {
        Result result =resultList.get(position);
        holder.bind(result.getTitle(),result.getBackdropPath());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            this.title = itemView.findViewById(R.id.titleTextView);
            this.image = itemView.findViewById(R.id.image);
        }
        public void bind (String titulo , String endPointImage){
            this.title.setText(titulo);
            String path = "https://image.tmdb.org/t/p/w780";
            Picasso.get().load(path+endPointImage).into(this.image);
        }
    }
}
