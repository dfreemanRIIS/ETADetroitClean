package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class GetTrainCompanyNameInteractor {

    public String getTrainCompanyName(int position, Context context) {
        Repository repository = new Repository();
        return repository.getTrainCompanyName(position, context);
    }
}
