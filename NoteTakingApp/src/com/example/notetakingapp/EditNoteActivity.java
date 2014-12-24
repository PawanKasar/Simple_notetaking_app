package com.example.notetakingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.notetakingapp.data.NoteItem;

public class EditNoteActivity extends Activity {

	private NoteItem note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_note);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Intent intent = this.getIntent();
		note=NoteItem.getNew();
		note.setKey(intent.getStringExtra("key"));
		note.setText(intent.getStringExtra("text"));
		
		EditText et = (EditText) findViewById(R.id.noteText);
		
		et.setText(note.getText());
		et.setSelection(note.getText().length());
		
	}
	
	private void saveAndFinish(){
		
		EditText et = (EditText) findViewById(R.id.noteText);
		String noteText = et.getText().toString();
		Intent in = new Intent();
		in.putExtra("key", note.getKey());
		in.putExtra("text", noteText);
		setResult(RESULT_OK, in);
		finish();
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		if(item.getItemId() == android.R.id.home){
			
			saveAndFinish();
			
		}
		
		return false;
	}
	public void onBackPressed(){
		
	}

}
	