package tech.aiq.aiqkit.sample.imagefile;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import tech.aiq.kit.AIQKit;

public class ImageFileApplication extends Application {
    private static final String TAG = ImageFileApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "ImageFileApplication Started");

        String serverUrl = BuildConfig.AIQ_APP_SERVER;

        if (TextUtils.isEmpty(serverUrl)) {
            serverUrl = AIQKit.getServiceEndPoint(AIQKit.ServiceType.STAG);
            Log.d(TAG, "Using AIQ staging server");
        }

        //initialize aiqkit
        AIQKit.init(this, BuildConfig.AIQ_APP_ID, BuildConfig.AIQ_APP_SECRET, serverUrl);
        Log.d(TAG, "Initialized AIQKit SDK");
    }
}
