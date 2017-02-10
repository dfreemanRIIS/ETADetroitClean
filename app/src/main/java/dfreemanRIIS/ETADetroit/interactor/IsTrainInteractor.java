package dfreemanRIIS.ETADetroit.interactor;

import android.content.Context;

import dfreemanRIIS.ETADetroit.repository.Repository;

public class IsTrainInteractor {

    public boolean isTrain(int position, Context context) {
        Repository repository = new Repository();
        return repository.isTrain(position, context);
    }
}
