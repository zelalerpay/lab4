package msku.ceng.madlab.week4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        WebView webview = findViewById(R.id.webview);
        Button btnGo = findViewById(R.id.go);
        EditText txtAddress = findViewById(R.id.adress);
        if (getIntent() != null && getIntent().getData() != null) {
            // URL'yi EditText'e ve WebView'e yükleyin
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }

        webview.setWebViewClient(new WebViewClient());
        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                webview.loadUrl("http://" + txtAddress.getText());

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}