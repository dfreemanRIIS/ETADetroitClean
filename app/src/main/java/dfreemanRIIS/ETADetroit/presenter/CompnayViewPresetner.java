package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetAllRouteInteractor;

public class CompnayViewPresetner {

    public Cursor getAllRoute(String companyName, Context context) {
        GetAllRouteInteractor getAllRouteInteractor = new GetAllRouteInteractor();
        return getAllRouteInteractor.getAllRoute(companyName, context);
    }

}