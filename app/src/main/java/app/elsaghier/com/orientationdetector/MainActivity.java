package app.elsaghier.com.orientationdetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.elsaghier.com.orientationdetector.OrientationEvent.OrientationDetector;

public class MainActivity extends AppCompatActivity {
    OrientationDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new OrientationDetector(this);

        boolean isPortraite = detector.isPortrait();
        int rotateValue = detector.getRotateValue();
    }

    @Override
    protected void onStart() {
        super.onStart();
        detector.enable();
    }

    @Override
    protected void onStop() {
        super.onStop();
        detector.disable();
    }
}
