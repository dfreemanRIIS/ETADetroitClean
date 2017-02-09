package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetRouteDetailInteractor {

    public Cursor getRouteDetails(String routeName, Context context) {
        Repository repository = new Repository();
        return repository.getRouteDetails(routeName, context);
    }

}
