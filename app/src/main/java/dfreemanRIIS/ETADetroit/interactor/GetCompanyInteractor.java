package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.entity.DatabaseHelper;

public class GetCompanyInteractor {

    public Cursor getCompanies(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return databaseHelper.getCompanies();
    }

}
