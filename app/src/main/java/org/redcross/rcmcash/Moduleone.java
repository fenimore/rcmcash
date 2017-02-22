package org.redcross.rcmcash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Moduleone extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView summary;
    private LinearLayout checklist;
    private String[] roadmap_0;
    private String[] roadmap_1;
    private String[] roadmap_2;
    private String[] roadmap_3;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_one);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.module_one_title);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        summary = (TextView) findViewById(R.id.one_summary);
        checklist = (LinearLayout) findViewById(R.id.checklist);

        roadmap_0 = getResources().getStringArray(R.array.one_zero);
        roadmap_1 = getResources().getStringArray(R.array.one_stage_one);
        roadmap_2 = getResources().getStringArray(R.array.one_stage_two);
        roadmap_3 = getResources().getStringArray(R.array.one_stage_three);
        setCheckList(roadmap_0, checklist);
        setTitleAndSummary(getString(R.string.module_one_title), summary, toolbar);
    }

    private void setTitleAndSummary(String title, TextView sum, Toolbar bar) {
        sum.setText("");
        bar.setTitle(title);
    }
    private void setCheckList(String[] roadmap, LinearLayout checklist) {
        checklist.removeAllViews();
        if (roadmap == null) {
            return;
        }
        for (int i = 0; i < roadmap.length; i += 1) {
            CheckBox checkbox = new CheckBox(getBaseContext());
            checkbox.setText(roadmap[i]);
            checklist.addView(checkbox);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.module_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_roadmap) {
            setCheckList(roadmap_0, checklist);
            setTitleAndSummary(getString(R.string.module_one_title), summary, toolbar);
        } else if (id == R.id.nav_stage_1){
            setTitleAndSummary(getString(R.string.mod1_stage1), summary, toolbar);
            setCheckList(roadmap_1, checklist);
        } else if (id == R.id.nav_stage_2){
            setTitleAndSummary(getString(R.string.mod1_stage2), summary, toolbar);
            setCheckList(roadmap_2, checklist);
        } else if (id == R.id.nav_stage_3){
            setTitleAndSummary(getString(R.string.mod1_stage3), summary, toolbar);
            setCheckList(roadmap_3, checklist);
        } else if (id == R.id.nav_summary){
            setCheckList(null, checklist);
            setTitleAndSummary(getString(R.string.module_one_title), summary, toolbar);
            summary.setText(R.string.modeul_1_roadmap);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
