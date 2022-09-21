package com.zantung.listviewfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;

    public FoodAdapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgFood;
        TextView txtTenThucAn, txtGia, txtmota;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //anh xa
            holder.txtTenThucAn = view.findViewById(R.id.tvNameFood);
            holder.txtmota = view.findViewById(R.id.tvMota);
            holder.txtGia = view.findViewById(R.id.textViewPrice);
            holder.imgFood = view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        //gán giá trị
        Food food = foodList.get(i);
        holder.txtTenThucAn.setText(food.getTen());
        holder.txtmota.setText(food.getMota());
        holder.txtGia.setText("$" + food.getGia());
        holder.imgFood.setImageResource(food.getHinh());
        return view;
    }
}
