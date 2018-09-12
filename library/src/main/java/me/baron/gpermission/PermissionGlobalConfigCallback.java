package me.baron.gpermission;

public abstract class PermissionGlobalConfigCallback {
    abstract public void shouldShowRational(String permission, int ration);
    abstract public void onPermissonReject(String permission, int reject);
}
