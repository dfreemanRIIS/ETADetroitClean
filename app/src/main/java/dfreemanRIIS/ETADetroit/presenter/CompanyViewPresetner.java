package dfreemanRIIS.ETADetroit.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;

import dfreemanRIIS.ETADetroit.adapters.TodoCursorAdapter;
import dfreemanRIIS.ETADetroit.interactor.GetAllRouteInteractor;
import dfreemanRIIS.ETADetroit.view.CompanyView;
import dfreemanRIIS.ETADetroit.view.RouteDetailView;

public class CompanyViewPresetner {

    public void getAllRoutes(final CompanyView companyView, Context context) {
        GetAllRouteInteractor getAllRouteInteractor = new GetAllRouteInteractor();
        CompanyView.allRoutes = getAllRouteInteractor.getAllRoute(CompanyView.mBusCompany.name, context);
        CursorAdapter listAdapter = new TodoCursorAdapter(context, CompanyView.allRoutes);

        CompanyView.mList.setAdapter(listAdapter);
        CompanyView.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (CompanyView.allRoutes.moveToPosition(position)) {
                    Intent intent = new Intent(companyView, RouteDetailView.class);
                    intent.putExtra(RouteDetailView.EXTRA_ROUTE_NAME, CompanyView.allRoutes.getString(1));
                    companyView.startActivity(intent);
                }
            }
        });

    }
}