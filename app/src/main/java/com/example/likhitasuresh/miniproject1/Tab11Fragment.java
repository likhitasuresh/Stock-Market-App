package com.example.likhitasuresh.miniproject1;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;


public class Tab11Fragment extends Fragment {
    LineGraphSeries<DataPoint> seriesx;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab11_fragment, container,
                false);
        GraphView graph = new GraphView(getActivity());
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        Bundle b = getActivity().getIntent().getExtras();
        String d = b.getString("name");
        ArrayList<Integer> q;
        q=databaseAccess.getData(d);
        seriesx = new LineGraphSeries<>();
        for(int i=0;i<q.size();i++) {
            seriesx.appendData(new DataPoint(i, q.get(i)), true, q.size());
        }
        graph.addSeries(seriesx);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.graph1);
        layout.addView(graph);
        return view;
    }

}

