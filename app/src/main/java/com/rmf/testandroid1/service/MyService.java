package com.rmf.testandroid1.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.rmf.testandroid1.R;

public class MyService extends Service {

    private final IBinder binder = new LocalBinder();
    private ServiceCallback callback;

    public interface ServiceCallback {
        void onReceiveString(String data);
    }

    public class LocalBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }

        public void setCallback(ServiceCallback callback) {
            MyService.this.callback = callback;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Settings.canDrawOverlays(this)) {
            showButton();
        } else {
            Intent overlaySettingsIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            overlaySettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(overlaySettingsIntent);
        }
        return START_STICKY;
    }

    @SuppressLint("InflateParams")
    private void showButton() {
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.service_layout, null);
        Button button = view.findViewById(R.id.serviceBtn);
        button.setOnClickListener(v -> {
            if (callback != null) {
                callback.onReceiveString("Hello from Service");
            }
            windowManager.removeView(view);
            stopSelf();
        });

        WindowManager.LayoutParams params;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    WindowManager.LayoutParams.FORMAT_CHANGED
            );
        } else {
            params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    WindowManager.LayoutParams.FORMAT_CHANGED
            );
        }

        windowManager.addView(view, params);
    }
}