package com.wave.livedataexample.ui;

import static android.support.constraint.Constraints.TAG;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wave.livedataexample.R;
import com.wave.livedataexample.model.Blog;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.list;
import com.wave.livedataexample.modelWeatherForecast.GetJsonValue.object;
import com.wave.livedataexample.viewmodel.WeatherMainViewModel;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolderWeather> {
    private List<list> weatherList;
    public WeatherAdapter(List<list> blogList) {
        weatherList = blogList;
    }

    @NonNull
    @Override
    public BaseViewHolderWeather onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WeatherAdapter.ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blog_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolderWeather baseViewHolderWeather, int i) {
        baseViewHolderWeather.onBind(i);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    @Override
    public int getItemCount() {
        if (weatherList != null && weatherList.size() > 0) {
            return weatherList.size();
        } else {
            return 0;
        }
    }
   public class ViewHolder extends BaseViewHolderWeather{

       ImageView ivThumbnail;
       TextView tvTitle;
       TextView tvDescription;
       TextView tvLink;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
           tvTitle = itemView.findViewById(R.id.tvTitle);
           tvDescription = itemView.findViewById(R.id.tvDescription);
           tvLink = itemView.findViewById(R.id.tvLink);
       }


       @Override
       protected void clear() {
           ivThumbnail.setImageDrawable(null);
           tvTitle.setText("");
           tvLink.setText("");
       }
       public void onBind(int position) {
           super.onBind(position);

           final list mList = weatherList.get(position);

//           if (mList.getClouds() != null) {
//               Glide.with(itemView.getContext())
//                       .load(mBlog.getThumbnail())
//                       .into(ivThumbnail);
//           }

           if (mList.getDate() != null) {
               tvTitle.setText(mList.getDate());
           }

           if (mList.getDt() != null) {
               tvDescription.setText(mList.getDt());
           }

//           if (mBlog.getLink() != null) {
//               tvLink.setText(mBlog.getLink());
//           }
//
//           tvLink.setOnClickListener(v -> {
//               if (mBlog.getLink() != null) {
//                   try {
//                       Intent intent = new Intent();
//                       intent.setAction(Intent.ACTION_VIEW);
//                       intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                       intent.setData(Uri.parse(mBlog.getLink()));
//                       itemView.getContext().startActivity(intent);
//                   } catch (Exception e) {
//                       Log.e(TAG, "onClick: Image url is not correct");
//                   }
//               }
//           });
       }
   }



}
