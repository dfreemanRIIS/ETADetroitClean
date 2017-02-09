package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.entity.DatabaseHelper;

public class GetRouteDetailInteractor {

    public Cursor getRouteDetails(String routeName, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getRouteDetails(routeName);
    }

    public Cursor getRouteStops(String route_id, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getRouteStops(route_id);
    }

}
