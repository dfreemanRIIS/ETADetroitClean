package dfreemanRIIS.ETADetroit.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import dfreemanRIIS.ETADetroit.R;
import dfreemanRIIS.ETADetroit.adapters.CompanyListAdapter;
import dfreemanRIIS.ETADetroit.presenter.MainViewPresenter;

public class MainView extends Activity {

    public static Menu menu;
    public static boolean isListView;
    public static StaggeredGridLayoutManager mStaggeredLayoutManager;
    private Toolbar toolbar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        isListView = true;
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        CompanyListAdapter mAdapter = new CompanyListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(onItemClickListener);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpActionBar();
    }

    private final CompanyListAdapter.OnItemClickListener onItemClickListener = new CompanyListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            MainViewPresenter mainViewPresenter = new MainViewPresenter();
            mainViewPresenter.present(context, v, position, toolbar, MainView.this);
        }
    };

    private void setUpActionBar() {
        if (toolbar != null) {
            setActionBar(toolbar);
            getActionBar().setDisplayHomeAsUpEnabled(false);
            getActionBar().setDisplayShowTitleEnabled(true);
            getActionBar().setElevation(7);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            MainViewPresenter.toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
