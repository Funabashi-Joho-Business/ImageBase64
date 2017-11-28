package jp.ac.chiba_fjb.oikawa.imagebase64;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//外部サイトからイメージを取得
		new ImageGetTask("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/2016-06-14_Orange_and_white_tabby_cat_born_in_2016_%E8%8C%B6%E3%83%88%E3%83%A9%E7%99%BD%E3%81%AD%E3%81%93_DSCF6526%E2%98%86%E5%BD%A1.jpg/200px-2016-06-14_Orange_and_white_tabby_cat_born_in_2016_%E8%8C%B6%E3%83%88%E3%83%A9%E7%99%BD%E3%81%AD%E3%81%93_DSCF6526%E2%98%86%E5%BD%A1.jpg",new ImageGetTask.ImageListener(){
			@Override
			public void OnBitmap(Bitmap bitmap) {
				String base64 = BitmapUtil.toBase64(bitmap,64,64);    //Base64に変換
				System.out.println(base64);                     //Base64表示
				Bitmap dest = BitmapUtil.fromBase64(base64);    //Bitmapに変換
				//元に戻ったか確認
				((ImageView)findViewById(R.id.imageView)).setImageBitmap(dest);
			}
		});
	}
}
