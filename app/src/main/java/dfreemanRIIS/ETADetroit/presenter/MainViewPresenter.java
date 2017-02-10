package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetCompanyInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetTrainCompanyNameInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetTrainRouteNameInteractor;
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

    public String getTrainRouteName(String companyName, Context context) {
        GetTrainRouteNameInteractor getTrainRouteNameInteractor = new GetTrainRouteNameInteractor();
        return  getTrainRouteNameInteractor.getTrainRouteName(companyName, context);
    }

    public String getTrainCompanyName(int position, Context context) {
        GetTrainCompanyNameInteractor getTrainCompanyNameInteractor = new GetTrainCompanyNameInteractor();
        return getTrainCompanyNameInteractor.getTrainCompanyName(position, context);
    }
}