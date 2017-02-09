package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.entity.DatabaseHelper;

public class GetAllRouteInteractor {

    public Cursor getAllRoute(String companyName, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getAllRoutes(companyName);
    }

}
