package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetTrainRouteNameInteractor {

    public String getTrainRouteName(String companyName, Context context) {
        Repository repository = new Repository();
        return repository.getTrainRouteName(companyName, context);
    }
}