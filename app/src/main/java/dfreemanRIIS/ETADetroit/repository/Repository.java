package dfreemanRIIS.ETADetroit.repository;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.entity.BusCompanyData;
import dfreemanRIIS.ETADetroit.entity.DatabaseHelper;

public class Repository {

    public Cursor getCompanies(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getCompanies();
    }

    public Cursor getRouteDetails(String routeName, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getRouteDetails(routeName);
    }

    public Cursor getRouteStops(String route_id, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getRouteStops(route_id);
    }

    public Cursor getAllRoute(String companyName, Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getAllRoutes(companyName);
    }

    public boolean isTrain(int position, Context context) {
        BusCompanyData busCompanyData = new BusCompanyData(context);
        return busCompanyData.isTrain(position);
    }

    public String getTrainRouteName(String companyName, Context context) {
        BusCompanyData busCompanyData = new BusCompanyData(context);
        return busCompanyData.getTrainRouteName(companyName);
    }

    public String getTrainCompanyName(int position, Context context) {
        BusCompanyData busCompanyData = new BusCompanyData(context);
        return busCompanyData.getTrainCompanyName(position);
    }
}
