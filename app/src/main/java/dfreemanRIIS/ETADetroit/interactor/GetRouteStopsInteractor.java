package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetRouteStopsInteractor {

    public Cursor getRouteStops(String route_id, Context context) {
        Repository repository = new Repository();
        return repository.getRouteStops(route_id, context);
    }
}
