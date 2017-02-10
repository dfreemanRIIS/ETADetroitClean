package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import dfreemanRIIS.ETADetroit.R;
import dfreemanRIIS.ETADetroit.interactor.GetRouteDetailInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetRouteStopsInteractor;
import dfreemanRIIS.ETADetroit.view.RouteDetailView;

public class RouteDetailViewPresenter {

    public void setup(Context context, String thisRoute, RouteDetailView v) {
        GetRouteDetailInteractor getRouteDetailInteractor = new GetRouteDetailInteractor();
        GetRouteStopsInteractor getRouteStopsInteractor = new GetRouteStopsInteractor();
        Cursor details = getRouteDetailInteractor.getRouteDetails(thisRoute, context);

        if(details.moveToFirst()) {
            TextView textView1 = (TextView)v.findViewById(R.id.listDetails);
            String placeHolder1 = "Company: " + details.getString(1)
                    + "\nRoute name: " + details.getString(2)
                    + "\nRoute number: " + details.getString(3)
                    + "\nDirection 1: " + details.getString(4)
                    + "\nDirection 2: " + details.getString(5)
                    + "\nDays active: " + details.getString(6);
            textView1.setText(placeHolder1);
        }

        Cursor stops = getRouteStopsInteractor.getRouteStops(details.getString(3), context);
        CursorAdapter listAdapter = new SimpleCursorAdapter(context,
                android.R.layout.simple_list_item_1,
                stops,
                new String[]{"stop_name"},
                new int[]{android.R.id.text1},
                0);

        ListView listStops = (ListView)v.findViewById(R.id.listStops);
        listStops.setAdapter(listAdapter);
    }
}