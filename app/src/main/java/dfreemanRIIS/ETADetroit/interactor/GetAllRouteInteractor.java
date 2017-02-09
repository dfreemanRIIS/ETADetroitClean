package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetAllRouteInteractor {

    public Cursor getAllRoute(String companyName, Context context) {
        Repository repository = new Repository();
        return repository.getAllRoute(companyName, context);
    }

}
