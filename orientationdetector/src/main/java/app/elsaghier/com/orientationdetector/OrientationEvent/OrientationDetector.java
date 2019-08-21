package app.elsaghier.com.orientationdetector.OrientationEvent;

import android.content.Context;
import android.view.OrientationEventListener;

public class OrientationDetector extends OrientationEventListener {

    private boolean isPortrait;
    private int rotateValue;

    public int getRotateValue() {
        return rotateValue;
    }

    public OrientationDetector(Context context) {
        super(context);
    }

    @Override
    public final void onOrientationChanged(int orientation) {
        if (orientation < 0) {
            return; // Flip screen, Not take account
        }

        if (orientation <= 45) {
            isPortrait = true;
        } else if (orientation <= 135) {
            rotateValue = 270;
            isPortrait = false;
        } else if (orientation <= 225) {
            rotateValue = 180;
            isPortrait = true;
        } else if (orientation <= 315) {
            rotateValue = 90;
            isPortrait = false;
        } else {
            rotateValue = 0;
            isPortrait = true;
        }

    }

    public boolean isPortrait() {
        return isPortrait;
    }

}