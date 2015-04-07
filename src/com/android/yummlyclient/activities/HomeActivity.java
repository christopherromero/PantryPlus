package com.android.yummlyclient.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.actionbarsherlock.widget.SearchView;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.android.yummlyclient.R;

public class HomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
        final SearchView searchView;
        MenuItem searchItem = menu.findItem(R.id.ic_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
        	   ///Toast.makeText(getApplicationContext(), "GOT query" + query, Toast.LENGTH_SHORT).show();
        	   Bundle b = new Bundle();
        	   b.putString("query", query);
        	   Intent i = new Intent(getApplicationContext(), RecipeSearchActivity.class);
        	   i.putExtras(b);
        	   startActivity(i);
               return true;
           }

           @Override
           public boolean onQueryTextChange(String newText) {        	   
               return false;
           }
       });
        return super.onCreateOptionsMenu(menu);
	}	
	
	/*
	public void onClickSearch(MenuItem mi) { 
		Toast.makeText(this, "SEARCH FOUND", Toast.LENGTH_SHORT).show();
	    //Intent i = new Intent(getApplicationContext(), SearchRecipeActivity.class);
	    //startActivity(i);
	}*/
	
	public void onClickFavorites(MenuItem mi) { 
		Toast.makeText(this, "FAVORITES FOUND", Toast.LENGTH_SHORT).show();
		// Create an activity to display the list of favorite recipes
	    Intent i = new Intent(getApplicationContext(), FavoriteRecipeActivity.class);
	    startActivity(i);
	}

}
