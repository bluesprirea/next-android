package org.nhnnext.skyler;

import java.io.IOException;

import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button button;
	private ImageButton imgbutton;
	private TextView textview;
	private Button button2;
	private EditText edittext;
	
	private ImageView imageview;
	private boolean changeImage = true;
	private String imgPath ="";
	
	private Button button3;
	
	private int touchCount = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
		imgbutton = (ImageButton) findViewById(R.id.imageButton2);
		imgbutton.setOnClickListener(this);
		
		textview = (TextView) findViewById(R.id.textView1);
		textview.setOnClickListener(this);
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
		edittext = (EditText) findViewById(R.id.editText1);
		
		imageview = (ImageView) findViewById(R.id.imageView1);
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		try{
			switch(arg0.getId()) {
			case R.id.button1:
				Toast.makeText(MainActivity.this,"textview1을 getText로 가져온 값 : "+textview.getText().toString()+" ", Toast.LENGTH_SHORT).show();
				Log.i("ButtonTest", textview.getText().toString());
				break;
			case R.id.imageButton2:
				++touchCount;
				textview.setText(touchCount + " 눌림!");
				Toast.makeText(MainActivity.this,"Image Pressed.", Toast.LENGTH_SHORT).show();
				Log.i("imageButton", touchCount+"pressed");
				break;
			case R.id.button2:
				Toast.makeText(MainActivity.this,"입력란을 getText로 가져온 값 : "+edittext.getText().toString()+" " , Toast.LENGTH_SHORT).show();
				Log.i("button2", edittext.getText().toString());
				break;
			case R.id.button3:
				if(changeImage){
					changeImage = false;
					imgPath = "English.png";
					Log.i("Test1", "English");
				} else {
					changeImage = true;
					imgPath = "korean.png";
					Log.i("Test1", "korean");
				}
				
				InputStream ims;
				try{
					ims = getAssets().open(imgPath);
					Drawable d = Drawable.createFromStream(ims, null);
					imageview.setImageDrawable(d);
				}catch (IOException e){
					e.printStackTrace();
				}
		}
		}
		catch(Exception e){
			Log.e("Test", "error");
			e.printStackTrace();
		
		}
		
		
	}

}
