package surface;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import mofangpai.jsonpai.com.functionmodeldome.R;

/**
 * Created by admin on 2018/8/10.
 */

public class SurfaceActivity extends Activity{
    RulerSurfaceView rulerView;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_surface);
        rulerView = (RulerSurfaceView) findViewById(R.id.rulerView);
        btn= (Button) findViewById(R.id.surface);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("尺寸："+rulerView.rulerLength());
            }
        });
    }
}
