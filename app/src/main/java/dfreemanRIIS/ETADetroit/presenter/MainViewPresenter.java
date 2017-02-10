package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetCompanyInteractor;
import dfreemanRIIS.ETADetroit.interactor.IsTrainInteractor;

public class MainViewPresenter {

    public Cursor getCompanies(Context context) {
        GetCompanyInteractor getCompanyInteractor = new GetCompanyInteractor();
        return getCompanyInteractor.getCompanies(context);
    }

    public boolean isTrain(int position, Context context) {
        IsTrainInteractor isTrainInteractor = new IsTrainInteractor();
        return isTrainInteractor.isTrain(position, context);
    }
}