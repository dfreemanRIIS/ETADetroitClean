package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.database.Cursor;

import dfreemanRIIS.ETADetroit.interactor.GetCompanyInteractor;

public class MainViewPresenter {

    public Cursor getCompanies(Context context) {
        GetCompanyInteractor getCompanyInteractor = new GetCompanyInteractor();
        return getCompanyInteractor.getCompanies(context);
    }
}