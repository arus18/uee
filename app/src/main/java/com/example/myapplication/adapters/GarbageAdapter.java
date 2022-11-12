package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.database.EnergyCalculationResultDatabaseHelper;
import com.example.myapplication.model.CollectedGarbage;

import java.util.List;

public class GarbageAdapter extends BaseAdapter {

    private Context context;
    private List<CollectedGarbage> arrayList;
    private TextView result;
    private ImageView delete;

    public GarbageAdapter(Context context,List<CollectedGarbage> list){
        this.context = context;
        this.arrayList = list;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.garbage_item, viewGroup, false);
        result = view.findViewById(R.id.garbage_item_text);
        delete = view.findViewById(R.id.delete_garbage);
        result.setText(String.valueOf(arrayList.get(i).getSize()));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnergyCalculationResultDatabaseHelper db = new EnergyCalculationResultDatabaseHelper(view.getContext());
                db.deleteResult(arrayList.get(i));
                arrayList.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
