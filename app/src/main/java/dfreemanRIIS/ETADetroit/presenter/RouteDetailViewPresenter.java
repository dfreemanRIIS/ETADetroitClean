package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetRouteDetailInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetRouteStopsInteractor;

public class RouteDetailViewPresenter {

    public Cursor getRouteDetails(String routeName, Context context) {
        GetRouteDetailInteractor getRouteDetailInteractor = new GetRouteDetailInteractor();
        return getRouteDetailInteractor.getRouteDetails(routeName, context);
    }

    public Cursor getRouteStops(String route_id, Context context) {
        GetRouteStopsInteractor getRouteStopsInteractor = new GetRouteStopsInteractor();
        return getRouteStopsInteractor.getRouteStops(route_id, context);
    }
}