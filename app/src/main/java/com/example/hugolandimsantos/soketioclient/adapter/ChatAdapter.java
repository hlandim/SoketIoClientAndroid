package com.example.hugolandimsantos.soketioclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hugolandimsantos.soketioclient.R;
import com.example.hugolandimsantos.soketioclient.model.Message;

import java.util.List;

/**
 * Created by hugo.landim.santos on 18/11/2015.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ListViewHolder>{

    private List<Message> messages;
    private static final Integer MESSAGE_SEND = 1;

    public ChatAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_line, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        if(viewType == MESSAGE_SEND){
            listViewHolder.getMessage().setGravity(Gravity.RIGHT);
        }
        return listViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(messages.get(position).getType().equals(Message.Type.SEND)){
            return MESSAGE_SEND;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.getMessage().setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder{

        private TextView message;

        public ListViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.tv_message);
        }

        public TextView getMessage() {
            return message;
        }
    }
}

