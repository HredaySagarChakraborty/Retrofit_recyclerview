package hreday.sagar.retrofit_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;

    List<PojoClas> list;


    public Adapter() {
    }

    public Adapter(Context context, List<PojoClas> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sample,parent,false);


        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PojoClas hh=list.get(position);
        holder.muthor.setText(hh.getName());
      //  Picasso.get().load(hh.getPhoto()).into(holder.img);
        Log.d("Creation","Here are the errors");
        holder.mame.setText(hh.getCategory());
        holder.price.setText(String.valueOf(hh.getPrice()));
        // Picasso.get().load(hh.getImage()).into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is the activity", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(context,NewActivity.class);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView muthor,mame,price;
        ImageView img;

        // ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);

            muthor=itemView.findViewById(R.id.text1Id);
        //.    img=itemView.findViewById(R.id.imageId);
            // img=itemView.findViewById(R.id.imageId);
            mame=itemView.findViewById(R.id.text2Id);
            price=itemView.findViewById(R.id.text3Id);

        }
    }
}