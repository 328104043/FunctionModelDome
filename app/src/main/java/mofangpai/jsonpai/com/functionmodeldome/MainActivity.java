package mofangpai.jsonpai.com.functionmodeldome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ruler.RulerActivity;
import surface.SurfaceActivity;
import zxing.android.CaptureActivity;
import zxing.common.ZxingConstant;

public class MainActivity extends AppCompatActivity {
    Button btn,mRuler,mSurface;
    TextView tv;
    static final int REQUEST_CODE_SCAN=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        tv= (TextView) findViewById(R.id.tv);
        mRuler= (Button) findViewById(R.id.ruler);
        mSurface= (Button) findViewById(R.id.ruler_surface);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,111);
            }
        });
        mRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RulerActivity.class);
                startActivity(intent);
            }
        });
        mSurface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SurfaceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_SCAN&&resultCode==RESULT_OK){
            String result=data.getStringExtra(ZxingConstant.CODED_CONTENT);
            if (result!=null&&!result.equals("")){
                tv.setText(result);
            }else {
                Toast.makeText(MainActivity.this,"返回值是NULL",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
