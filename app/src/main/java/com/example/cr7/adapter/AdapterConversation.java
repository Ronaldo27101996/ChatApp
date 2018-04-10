package com.example.cr7.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cr7.chatapp.R;
import com.example.cr7.model.Conversation;

import java.util.List;

/**
 * Created by CR7 on 3/9/2018.
 */

public class AdapterConversation extends RecyclerView.Adapter<AdapterConversation.ConversationViewHolder>{
    private List<Conversation> listConversation;
    private Context context;

    public List<Conversation> getListConversation() {
        return listConversation;
    }
//    public interface OnItemClickListener {
//        void onItemLongClick(View v,int pos);
//    }
//
//    public interface ItemLongClickListener {
//
//        void onItemLongClick(View v,int pos);
//
//    }

    public AdapterConversation(List<Conversation> listConversation, Context context) {
        this.listConversation = listConversation;
        this.context = context;
    }

    @Override
    public ConversationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_conversation,parent,false);
        return new ConversationViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ConversationViewHolder holder, int position) {
        Conversation conversation = listConversation.get(position);
        holder.txtName.setText(conversation.getName());
        holder.txtDate.setText(conversation.getDate());
        holder.txtLastMessage.setText(conversation.getLastMessage());
        //if(conversation.getImage().equals("")!=false){
            Glide.with(context)
                    .load(conversation.getImage())
                    .into(holder.imgAvatar);
       // }
        if(!conversation.isOnline()){
            holder.imgOnOff.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listConversation.size();
    }

    public class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener {
        private TextView txtName,txtDate,txtLastMessage;
        private ImageView imgAvatar;
        private ImageView imgOnOff;
        public ConversationViewHolder(View itemView) {
            super(itemView);
            txtName= itemView.findViewById(R.id.txtName);
            txtDate= itemView.findViewById(R.id.txtDate);
            txtLastMessage= itemView.findViewById(R.id.txtLastMessage);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            imgOnOff = itemView.findViewById(R.id.imgOnOff);
            itemView.setOnLongClickListener( this);
            itemView.setOnClickListener( this);
        }

        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(context, "LongClick"+ getListConversation().get(this.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            Conversation conversation = getListConversation().get(this.getAdapterPosition());
            myLongClickItem(conversation);
            return true;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();

        }
    }

    private void myLongClickItem(Conversation conversation) {
        
    }
}
