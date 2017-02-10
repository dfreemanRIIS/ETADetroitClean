package dfreemanRIIS.ETADetroit.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import dfreemanRIIS.ETADetroit.R;
import dfreemanRIIS.ETADetroit.interactor.GetCompanyInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetTrainCompanyNameInteractor;
import dfreemanRIIS.ETADetroit.interactor.GetTrainRouteNameInteractor;
import dfreemanRIIS.ETADetroit.interactor.IsTrainInteractor;
import dfreemanRIIS.ETADetroit.view.CompanyView;
import dfreemanRIIS.ETADetroit.view.MainView;
import dfreemanRIIS.ETADetroit.view.RouteDetailView;

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
        return getTrainRouteNameInteractor.getTrainRouteName(companyName, context);
    }

    public String getTrainCompanyName(int position, Context context) {
        GetTrainCompanyNameInteractor getTrainCompanyNameInteractor = new GetTrainCompanyNameInteractor();
        return getTrainCompanyNameInteractor.getTrainCompanyName(position, context);
    }

    public void present(Context context, View v, int position, Context mainViewContext) {
        if (isTrain(position, context)) {
            Intent intent = new Intent(mainViewContext, RouteDetailView.class);
            intent.putExtra(RouteDetailView.EXTRA_ROUTE_NAME, getTrainRouteName(getTrainCompanyName(position, context), context));
            context.startActivity(intent);
        } else {
            Intent transitionIntent = new Intent(mainViewContext, CompanyView.class);
            transitionIntent.putExtra(CompanyView.EXTRA_PARAM_ID, position);
            ImageView placeImage = (ImageView) v.findViewById(R.id.placeImage);
            LinearLayout placeNameHolder = (LinearLayout) v.findViewById(R.id.placeNameHolder);
            View navigationBar = v.findViewById(android.R.id.navigationBarBackground);
            View statusBar = v.findViewById(android.R.id.statusBarBackground);
            Pair<View, String> imagePair = Pair.create((View) placeImage, "tImage");
            Pair<View, String> holderPair = Pair.create((View) placeNameHolder, "tNameHolder");
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)mainViewContext, imagePair, holderPair);
            ActivityCompat.startActivity(mainViewContext, transitionIntent, options.toBundle());
        }
    }

    public static void toggle() {
        MenuItem item = MainView.menu.findItem(R.id.action_toggle);
        if (MainView.isListView) {
            MainView.mStaggeredLayoutManager.setSpanCount(2);
            item.setIcon(R.drawable.ic_action_list);
            item.setTitle("Show as list");
            MainView.isListView = false;
        } else {
            MainView.mStaggeredLayoutManager.setSpanCount(1);
            item.setIcon(R.drawable.ic_action_grid);
            item.setTitle("Show as grid");
            MainView.isListView = true;
        }
    }
}