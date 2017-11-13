package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import Entities.Topic;

/**
 * Created by Ofek on 12-Nov-17.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.TopicVH> {
    private ArrayList<Topic> topics = new ArrayList<>();
    private Context context;


    public TopicsAdapter(ArrayList<Topic> topics, Context context) {
        this.topics = topics;
        this.context = context;
    }

    @Override
    public TopicVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new TopicVH(view);
    }

    @Override
    public void onBindViewHolder(TopicVH holder, int position) {
        holder.titleTV.setText(topics.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    class TopicVH extends RecyclerView.ViewHolder {
        TextView titleTV;
        public TopicVH(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (context instanceof OnItemListClickListener){
                        ((OnItemListClickListener)context).onItemListClick(topics.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
    public interface OnItemListClickListener{
        void onItemListClick(Topic topic);
    }
}