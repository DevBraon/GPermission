package me.baron.gpermission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class GPermisson {
    private static PermissionGlobalConfigCallback globalConfigCallback;
    private PermissionCallback callback;
    private String[] permissions;
    private Context context;

    public GPermisson(Context context) {
        this.context = context;
    }

    public static void init(PermissionGlobalConfigCallback callback) {
        globalConfigCallback = callback;
    }

    static PermissionGlobalConfigCallback getGlobalConfigCallback() {
        return globalConfigCallback;
    }

    public static GPermisson with(Context context) {
        GPermisson permisson = new GPermisson(context);
        return permisson;
    }

    public GPermisson permisson(String[] permissons) {
        this.permissions = permissons;
        return this;
    }

    public GPermisson callback(PermissionCallback callback) {
        this.callback = callback;
        return this;
    }

    public void request() {
        if (permissions == null || permissions.length <= 0) {
            return;
        }
        PermissionActivity.request(context, permissions, callback);
    }

    /**
     * Jump to Settings page of your application
     * @param context
     */
    public static void startSettingsActivity(Context context) {
        Uri packageURI = Uri.parse("package:" + context.getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
