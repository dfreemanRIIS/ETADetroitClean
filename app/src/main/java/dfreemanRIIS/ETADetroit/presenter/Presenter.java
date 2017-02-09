package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetAllRouteInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetCompanyInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetRouteDetailInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetRouteStopsInteractor;

public class Presenter {

    public Cursor getCompanies(Context context) {
        GetCompanyInteractor getCompanyInteractor = new GetCompanyInteractor();
        return getCompanyInteractor.getCompanies(context);
    }

    public Cursor getRouteDetails(String routeName, Context context) {
        GetRouteDetailInteractor getRouteDetailInteractor = new GetRouteDetailInteractor();
        return getRouteDetailInteractor.getRouteDetails(routeName, context);
    }

    public Cursor getRouteStops(String route_id, Context context) {
        GetRouteStopsInteractor getRouteStopsInteractor = new GetRouteStopsInteractor();
        return getRouteStopsInteractor.getRouteStops(route_id, context);
    }

    public Cursor getAllRoute(String companyName, Context context) {
        GetAllRouteInteractor getAllRouteInteractor = new GetAllRouteInteractor();
        return getAllRouteInteractor.getAllRoute(companyName, context);
    }

}
