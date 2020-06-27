package pe.kr.kth.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pe.kr.kth.test.adapters.MainAdapter;
import pe.kr.kth.test.data.Item;

public class DashboardActivity extends AppCompatActivity {

    ListView lv;
    List<Item> list;

    OnListViewItemClickListener onListViewItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lv = findViewById(R.id.listview);
        list = makeData();
        Log.d("TEST", "list size : " + list.size());

        final MainAdapter myAdapter = new MainAdapter(
                DashboardActivity.this,
                list,
                new OnListViewItemClickListener() {
                    @Override
                    public void onListViewClicked(int pos) {
                        Intent intent = new Intent(
                                DashboardActivity.this,
                                DetailActivity.class
                        );
                        //Detail Acitivity에 값을 넘겨주면 됨
                        Item item = list.get(pos);
//                        intent.putExtra("title", item.title);
//                        intent.putExtra("content", item.content);
                        intent.putExtra("item", item);
                        startActivity(intent);
                    }
                }
        );
        lv.setAdapter(myAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST", "click floating action button");
                // List에 데이터를 추가를 하는 것
                Item item = new Item(list.size(), "title" + list.size(), "content" + list.size());
                list.add(item);
                Log.d("TEST", "current list size => " + list.size());
                //리스트뷰를 갱신을 해줘야 함
                //리스트뷰에 담긴 데이터는 어뎁터...
                //어댑터를 갱신을 해줘야함
                myAdapter.notifyDataSetChanged();
            }
        });

    }


//    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(DashboardActivity.this,
//                    "current pos" + position, Toast.LENGTH_SHORT).show();
//        }
//    };

    private List<Item> makeData() {
        // 데이터를 생성합니다.
        //여러개의 아이템을 만든다.
        //반복문을 사용해서 여러개의 아이템을 추가
        List list = new ArrayList<Item>();
        for (int i=0;i<10;i++) {
            Item item = new Item(
                    i,
                    "title" + i,
                    "content" + i);
            list.add(item);
        }
        return list;
    }
}
