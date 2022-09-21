package com.zantung.listviewfood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvThucAn;
    ArrayList<Food> arrayFood;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new FoodAdapter(this, R.layout.dong_food, arrayFood);
        lvThucAn.setAdapter(adapter);

        lvThucAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });
        lvThucAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailFood.class);
                intent.putExtra("data", arrayFood.get(i));
                startActivity(intent);
            }
        });
    }
    private void AnhXa(){
        lvThucAn = (ListView) findViewById(R.id.lvFood);
        arrayFood = new ArrayList<>();
        arrayFood.add(new Food("Bánh nướng chảo", "loại bánh được chế biến từ bột...",R.drawable.banhnuongchao, 6));
        arrayFood.add(new Food("Trứng ốp la", "là trứng chiên để nguyên lòng đỏ...",R.drawable.trungopla, 7));
        arrayFood.add(new Food("Salad rau dầm", "món hỗn hợp gồm nhiều...",R.drawable.saladraudam, 6));
        arrayFood.add(new Food("Trái cây tổng hợp", "tổng hợp nhiều loại trái cây...",R.drawable.traicaytonghop, 5));
        arrayFood.add(new Food("Spaghetti", "mì spaghetti thường được trộn..." ,R.drawable.spaghetti, 8));
        arrayFood.add(new Food("Bánh Donut", "loại bánh ngọt rán hoặc nướng để ăn..." ,R.drawable.donut, 8));
        arrayFood.add(new Food("Hamburger", "loại thức ăn bao gồm bánh mì kẹp..." ,R.drawable.hamburger, 9));
        arrayFood.add(new Food("Bánh panini", "một món ăn thường bao gồm ..." ,R.drawable.panini, 10));
    }

    private void XacNhanXoa(final int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo");
        alertDialog.setIcon(R.drawable.dialogwarning);
        alertDialog.setMessage("Bạn có muốn xóa món ăn này không?");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayFood.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}