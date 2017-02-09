package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetCompanyInteractor {

    public Cursor getCompanies(Context context) {
        Repository repository = new Repository();
        return repository.getCompanies(context);
    }

}
