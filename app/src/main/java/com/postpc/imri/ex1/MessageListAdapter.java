package com.postpc.imri.ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageHolder> {

    final List<ChatMessage> data;

    public MessageListAdapter(List<ChatMessage> input) {
        this.data = input;
    }

    public void addMessage(ChatMessage msg) {
        data.add(msg);
        notifyItemInserted(data.size() - 1);
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_list, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        ChatMessage msg = data.get(position);
        holder.timeText.setText(DateUtils.getRelativeTimeSpanString(holder.itemView.getContext(), msg.getTimeStamp()));
        holder.messageText.setText(msg.getMessage());
        holder.nameText.setText(msg.getSenderName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MessageHolder extends RecyclerView.ViewHolder {
        // class representing the message instance

        TextView nameText;
        TextView messageText;
        TextView timeText;

        public MessageHolder(View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
            nameText = (TextView) itemView.findViewById(R.id.text_message_name);
        }
    }



}
