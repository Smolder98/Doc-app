package com.application.pm1_proyecto_final.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.pm1_proyecto_final.R;
import com.application.pm1_proyecto_final.models.ChatMessage;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<ChatMessage> chatMessages;
    private final Bitmap reseiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;


    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap reseiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.reseiverProfileImage = reseiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_SENT){

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_container_send_message, parent, false);

            return new ChatAdapter.SendMessageViewHolder(view);

        }else {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_container_reseive_message, parent, false);

            return new ChatAdapter.ReceivedMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_SENT){
            ((SendMessageViewHolder) holder).setData(chatMessages.get(position));
        }else {
            ((ReceivedMessageViewHolder) holder).setData(chatMessages.get(position), reseiverProfileImage);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(chatMessages.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SENT;
        }else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    static class SendMessageViewHolder extends RecyclerView.ViewHolder{


        TextView textMessage;
        TextView textDateTime;
        View view;

        SendMessageViewHolder(@NonNull View itemView){
            super(itemView);

            textMessage = itemView.findViewById(R.id.textMessageSend);
            textDateTime = itemView.findViewById(R.id.textDateTimeSend);

        }

        void setData(ChatMessage chatMessage){

            textMessage.setText(chatMessage.message);
            textDateTime.setText(chatMessage.datatime);
        }

    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder{

        TextView textMessage;
        TextView textDateTime;
        View view;
        RoundedImageView imageProfile;

        ReceivedMessageViewHolder(@NonNull View itemView){
            super(itemView);

            textMessage = itemView.findViewById(R.id.textMessageReseiver);
            textDateTime = itemView.findViewById(R.id.textDateTimeReseiver);
            imageProfile = itemView.findViewById(R.id.imageProfileReseiver);

            view = itemView;

        }

        void setData(ChatMessage chatMessage, Bitmap receiverProfileImage){

            textMessage.setText(chatMessage.message);
            textDateTime.setText(chatMessage.datatime);

            imageProfile.setImageBitmap(receiverProfileImage);

        }
    }

}