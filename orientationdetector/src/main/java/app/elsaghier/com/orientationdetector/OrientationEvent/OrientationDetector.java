package app.elsaghier.com.orientationdetector.OrientationEvent;

import android.content.Context;
import android.view.OrientationEventListener;

public class OrientationDetector extends OrientationEventListener {

    private boolean isPortrait;


    private int rotateValue;

    public int getActualRotateValue() {
        return actualRotateValue;
    }

    /**
     * return the actual angel user hold phone ( from 0 to 359 ).
     */
    private int actualRotateValue;

    /**
     * return the orientation value
     * 0 for portrait
     * 90 for landscape
     * 180 for reverse-portrait
     * 270 for reverse-landscape
     */
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
        actualRotateValue = orientation;
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