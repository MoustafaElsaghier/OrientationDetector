package app.elsaghier.com.orientationdetector.OrientationEvent;

import android.content.Context;

public abstract class OrientationDetector extends SimpleOrientationEventListener {

    protected OrientationDetector(Context context) {
        super(context);
    }

    @Override
    public final void onChanged(int lastOrientation, int orientation) {
        int startDeg = lastOrientation == 0
                ? orientation == 3 ? 360 : 0
                : lastOrientation == 1 ? 90
                : lastOrientation == 2 ? 180
                : 270; // don't know how, but it works
        int endDeg = orientation == 0
                ? lastOrientation == 1 ? 0 : 360
                : orientation == 1 ? 90
                : orientation == 2 ? 180
                : 270; // don't know how, but it works

        onRotateChanged(startDeg, endDeg);
    }

    protected abstract void onRotateChanged(int startDeg, int endDeg);

}