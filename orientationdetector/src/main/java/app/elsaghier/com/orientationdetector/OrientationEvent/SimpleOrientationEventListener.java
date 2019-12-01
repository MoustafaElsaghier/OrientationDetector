package app.elsaghier.com.orientationdetector.OrientationEvent;

import android.content.Context;
import android.view.OrientationEventListener;

public abstract class SimpleOrientationEventListener extends OrientationEventListener {

    private static final int ORIENTATION_PORTRAIT = 0;
    private static final int ORIENTATION_LANDSCAPE = 1;
    private static final int ORIENTATION_PORTRAIT_REVERSE = 2;
    private static final int ORIENTATION_LANDSCAPE_REVERSE = 3;


    public int getActualRotateValue() {
        return actualRotateValue;
    }

    public void setActualRotateValue(int actualRotateValue) {
        this.actualRotateValue = actualRotateValue;
    }

    /**
     * return the actual angel user hold phone ( from 0 to 359 ).
     */
    private int actualRotateValue;

    private int lastOrientation = 0;
    private boolean isPortrait;
    private int rotateValue;

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

    SimpleOrientationEventListener(Context context) {
        super(context);
    }

    @Override
    public final void onOrientationChanged(int orientation) {
        if (orientation < 0) {
            return; // Flip screen, Not take account
        }
        actualRotateValue = orientation;
        int curOrientation;

        if (orientation <= 45) {
            curOrientation = ORIENTATION_PORTRAIT;
            isPortrait = true;
        } else if (orientation <= 135) {
            curOrientation = ORIENTATION_LANDSCAPE_REVERSE;
            rotateValue = 270;
            isPortrait = false;
        } else if (orientation <= 225) {
            curOrientation = ORIENTATION_PORTRAIT_REVERSE;
            rotateValue = 180;
            isPortrait = true;
        } else if (orientation <= 315) {
            curOrientation = ORIENTATION_LANDSCAPE;
            rotateValue = 90;
            isPortrait = false;
        } else {
            curOrientation = ORIENTATION_PORTRAIT;
            rotateValue = 0;
            isPortrait = true;
        }
        if (curOrientation != lastOrientation) {
            onChanged(lastOrientation, curOrientation);
            lastOrientation = curOrientation;
        }
    }

    public boolean isPortrait() {
        return isPortrait;
    }

    protected abstract void onChanged(int lastOrientation, int orientation);
}