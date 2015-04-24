package com.scychina.demos;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by pengxu on 15-4-23.
 */
public class MyAdapter extends BaseAdapter {
    private List<Video> videos;
    Context context;

    public MyAdapter(Context context, List<Video> videos) {
        this.videos = videos;
        this.context = context;
    }

    //获取里面的数据个数
    @Override
    public int getCount() {
        return videos == null ? 0 : videos.size();
    }

    public class ViewHolder {
        TextView textViewFileName;
        TextView textViewFileTime;
        ImageView imageViewFileImage;
        TextView textViewCountOfPeople;
        TextView textViewPrice;
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final Video video = (Video) getItem(position);
        ViewHolder viewHolder = null;

        /**
         * 先设置view里面列表的排列方式信息
         */
        if (view == null) {
            Log.i("MyAdapter", "新建view,position=" + position);
            //这个view 是那个一整行的数据
            view = LayoutInflater.from(context).inflate(R.layout.list_view_items, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewFileName = (TextView) view.findViewById(R.id.base_filmName);
            viewHolder.textViewFileTime = (TextView) view.findViewById(R.id.base_filmTime);
            viewHolder.textViewCountOfPeople = (TextView) view.findViewById(R.id.countOfPeople);
            viewHolder.textViewPrice = (TextView) view.findViewById(R.id.price);

            //设置图片
            viewHolder.imageViewFileImage = (ImageView) view.findViewById(R.id.base_fileImage);

            //动态的添加一行
//            viewHolder.imageViewFileImage2=new ImageView(context);
//            LinearLayout.LayoutParams mp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//            mp.gravity= Gravity.CENTER;
//            mp.width=150;
//            viewHolder.imageViewFileImage2.setLayoutParams(mp);

//            ((LinearLayout)view).addView(viewHolder.imageViewFileImage2,5);
            view.setTag(viewHolder);
        } else {
//       如果有缓存的话  直接就拿出这个view的缓存   从缓存里面获取已经做好的排列方式

            viewHolder = (ViewHolder) view.getTag();
            Log.i("myAdapter", "旧的view,position=" + position);
        }

        viewHolder.textViewFileName.setText(video.filmName);
        viewHolder.textViewPrice.setText(video.price);
        viewHolder.textViewFileTime.setText(video.filmTime);
        viewHolder.textViewCountOfPeople.setText(String.valueOf(video.countOfPeople));
        viewHolder.imageViewFileImage.setImageResource(video.filmImage);
//        viewHolder.imageViewFileImage2.setImageResource(video.fileImage2);

//        viewHolder.textViewFileName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("myAdapter的fileName您选择的电影名称：",video.filmName);
//                Toast.makeText(context,"myAdapter的fileName您选择的电影名称："+video.filmName,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("myAdapter内的整个view您选择的电影名称：",video.filmName);
//                Toast.makeText(context,"myAdapter内的整个view您选择的电影名称："+video.filmName,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                Log.i("myAdapter的setOnLongClickListener的fileName您选择的电影名称：",video.filmName);
//                return true;
//            }
//        });

        return view;
    }
}
