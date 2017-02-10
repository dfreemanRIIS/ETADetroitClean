package dfreemanRIIS.ETADetroit.view;

import android.app.Activity;
import android.os.Bundle;

import dfreemanRIIS.ETADetroit.R;
import dfreemanRIIS.ETADetroit.presenter.RouteDetailViewPresenter;

public class RouteDetailView extends Activity {

    public static final String EXTRA_ROUTE_NAME = "route_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);
        RouteDetailViewPresenter routeDetailViewPresenter = new RouteDetailViewPresenter();
        routeDetailViewPresenter.setup(this, (String) getIntent().getExtras().get(EXTRA_ROUTE_NAME), RouteDetailView.this);
    }
}
