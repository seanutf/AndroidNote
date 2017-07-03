package com.sean.zq.android.utils.asynctask;

import android.content.AsyncTaskLoader;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sks on 2017/7/3.
 */

public class MyAppListLoader extends AsyncTaskLoader<List<MyAppEntry>> {

    private static final String TAG = "MyAppListLoader";

    final MyInterestingConfigChanges mLastConfig = new MyInterestingConfigChanges();
    final PackageManager mPm;
    List<MyAppEntry> mApps;
    PackageIntentReceiver mPackageObserver;
    public MyAppListLoader(Context context) {
        super(context);
        Log.i(TAG, "AppListLoader is init");
        // Retrieve the package manager for later use; note we don't
        // use 'context' directly but instead the save global application
        // context returned by getContext().
        mPm = getContext().getPackageManager();
    }
    /**
     * This is where the bulk of our work is done.  This function is
     * called in a background thread and should generate a new set of
     * data to be published by the loader.
     */
    @Override public List<MyAppEntry> loadInBackground() {
        // Retrieve all known applications.
        Log.i(TAG, "AppListLoader is start loadInBackground");
        List<ApplicationInfo> apps = mPm.getInstalledApplications(
                PackageManager.GET_UNINSTALLED_PACKAGES |
                        PackageManager.GET_DISABLED_COMPONENTS);
        if (apps == null) {
            apps = new ArrayList<ApplicationInfo>();
        }
        final Context context = getContext();
        // Create corresponding array of entries and load their labels.
        List<MyAppEntry> entries = new ArrayList<MyAppEntry>(apps.size());
        for (int i=0; i<apps.size(); i++) {
            MyAppEntry entry = new MyAppEntry(this, apps.get(i));
            entry.loadLabel(context);
            entries.add(entry);
        }
        // Sort the list.
        Collections.sort(entries, ALPHA_COMPARATOR);
        // Done!
        Log.i(TAG, "AppListLoader is end loadInBackground");
        return entries;
    }

    public static final Comparator<MyAppEntry> ALPHA_COMPARATOR = new Comparator<MyAppEntry>() {
        private final Collator sCollator = Collator.getInstance();
        @Override
        public int compare(MyAppEntry object1, MyAppEntry object2) {
            //Log.i(TAG, "Comprator compare object1 to object2");
            return sCollator.compare(object1.getLabel(), object2.getLabel());
        }
    };
    /**
     * Called when there is new data to deliver to the client.  The
     * super class will take care of delivering it; the implementation
     * here just adds a little more logic.
     */
    @Override public void deliverResult(List<MyAppEntry> apps) {
        Log.i(TAG, "AppListLoader is deliverResult");
        if (isReset()) {
            // An async query came in while the loader is stopped.  We
            // don't need the result.
            Log.i(TAG, "AppListLoader is deliverResult  isReset");
            if (apps != null) {
                Log.i(TAG, "AppListLoader is deliverResult  onReleaseResources");
                onReleaseResources(apps);
            }
        }
        List<MyAppEntry> oldApps = mApps;
        mApps = apps;
        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            Log.i(TAG, "AppListLoader is deliverResult  isStarted");
            super.deliverResult(apps);
        }
        // At this point we can release the resources associated with
        // 'oldApps' if needed; now that the new result is delivered we
        // know that it is no longer in use.
        if (oldApps != null) {
            Log.i(TAG, "AppListLoader is deliverResult  oldApps");
            onReleaseResources(oldApps);
        }
    }
    /**
     * Handles a request to start the Loader.
     */
    @Override protected void onStartLoading() {
        Log.i(TAG, "AppListLoader is onStartLoading");
        if (mApps != null) {
            // If we currently have a result available, deliver it
            // immediately.
            Log.i(TAG, "AppListLoader is onStartLoading deliverResult");
            deliverResult(mApps);
        }
        // Start watching for changes in the app data.
        if (mPackageObserver == null) {
            Log.i(TAG, "AppListLoader is onStartLoading new mPackageObserver");
            mPackageObserver = new PackageIntentReceiver(this);
        }
        // Has something interesting in the configuration changed since we
        // last built the app list?
        boolean configChange = mLastConfig.applyNewConfig(getContext().getResources());
        if (takeContentChanged() || mApps == null || configChange) {
            // If the data has changed since the last time it was loaded
            // or is not currently available, start a load.
            Log.i(TAG, "AppListLoader is onStartLoading forceLoad");
            forceLoad();
        }
    }

    public static class PackageIntentReceiver extends BroadcastReceiver {
        final MyAppListLoader mLoader;
        public PackageIntentReceiver(MyAppListLoader loader) {
            Log.i(TAG, "PackageIntentReceiver is init");
            mLoader = loader;
            IntentFilter filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
            filter.addDataScheme("package");
            Log.i(TAG, "PackageIntentReceiver is have  filter IntentFilter");
            mLoader.getContext().registerReceiver(this, filter);
            // Register for events related to sdcard installation.
            IntentFilter sdFilter = new IntentFilter();
            sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
            sdFilter.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
            Log.i(TAG, "PackageIntentReceiver is have  sdFilter IntentFilter");
            mLoader.getContext().registerReceiver(this, sdFilter);
        }
        @Override public void onReceive(Context context, Intent intent) {
            // Tell the loader about the change.
            Log.i(TAG, "PackageIntentReceiver is onReceive");
            mLoader.onContentChanged();
        }
    }
    /**
     * Handles a request to stop the Loader.
     */
    @Override protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        Log.i(TAG, "AppListLoader is onStopLoading");
        Log.i(TAG, "AppListLoader is onStopLoading cancelLoad");
        cancelLoad();
    }
    /**
     * Handles a request to cancel a load.
     */
    @Override public void onCanceled(List<MyAppEntry> apps) {
        super.onCanceled(apps);
        Log.i(TAG, "AppListLoader is onCanceled");
        // At this point we can release the resources associated with 'apps'
        // if needed.
        Log.i(TAG, "AppListLoader is onCanceled  onReleaseResources");
        onReleaseResources(apps);
    }
    /**
     * Handles a request to completely reset the Loader.
     */
    @Override protected void onReset() {
        super.onReset();
        Log.i(TAG, "AppListLoader is onReset");
        // Ensure the loader is stopped
        Log.i(TAG, "AppListLoader is onReset  onStopLoading");
        onStopLoading();
        // At this point we can release the resources associated with 'apps'
        // if needed.
        if (mApps != null) {
            Log.i(TAG, "AppListLoader is onReset  onReleaseResources");
            onReleaseResources(mApps);
            mApps = null;
        }
        // Stop monitoring for changes.
        if (mPackageObserver != null) {
            Log.i(TAG, "AppListLoader is onReset  unregisterReceiver");
            getContext().unregisterReceiver(mPackageObserver);
            mPackageObserver = null;
        }
    }
    /**
     * Helper function to take care of releasing resources associated
     * with an actively loaded data set.
     */
    protected void onReleaseResources(List<MyAppEntry> apps) {
        Log.i(TAG, "AppListLoader is onReleaseResources");
        // For a simple List<> there is nothing to do.  For something
        // like a Cursor, we would close it here.
    }
}
