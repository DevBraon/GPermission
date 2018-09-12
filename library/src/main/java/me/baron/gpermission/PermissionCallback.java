package me.baron.gpermission;

public interface PermissionCallback {
    void onPermissionGranted();

    void shouldShowRational(String permisson);

    void onPermissonReject(String permisson);
}
