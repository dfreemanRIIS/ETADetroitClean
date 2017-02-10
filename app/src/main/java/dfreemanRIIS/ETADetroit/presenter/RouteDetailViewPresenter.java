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

    private Cursor getRouteDetails(String routeName, Context context) {
        GetRouteDetailInteractor getRouteDetailInteractor = new GetRouteDetailInteractor();
        return getRouteDetailInteractor.getRouteDetails(routeName, context);
    }

    private Cursor getRouteStops(String route_id, Context context) {
        GetRouteStopsInteractor getRouteStopsInteractor = new GetRouteStopsInteractor();
        return getRouteStopsInteractor.getRouteStops(route_id, context);
    }

    public void setup(Context context, String thisRoute, RouteDetailView v) {
        RouteDetailViewPresenter presenter = new RouteDetailViewPresenter();
        Cursor details = presenter.getRouteDetails(thisRoute, context);

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

        Cursor stops = presenter.getRouteStops(details.getString(3), context);
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