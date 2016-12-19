package com.example.diong.todo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    final private String widgetUp = "android.appwidget.action.UpdateWidgetText";
    private int count;

    //TODO:更改Widget的UI样式
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
       // CharSequence widgetText = context.getString(R.string.appwidget_text);
       //  Construct the RemoteViews object
        //RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
       // views.setTextViewText(R.id.appwidget_text, widgetText);
        // Instruct the widget manager to update the widget
       // appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Intent clickInt = new Intent(context, MainActivity.class);
        PendingIntent po = PendingIntent.getActivity(context,0, clickInt, 0);
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        rv.setOnClickPendingIntent(R.id.appwidget_text, po);
        //rv.setTextViewText(R.id.appwidget_text, "TODOlist:" + count);

        appWidgetManager.updateAppWidget(appWidgetIds, rv);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        Bundle bundle = intent.getExtras();

        if (intent.getAction().equals(widgetUp)) {

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] widgetIDs = appWidgetManager.getAppWidgetIds(new ComponentName(context, NewAppWidget.class));
            count = bundle.getInt("KEY");
            rv.setTextViewText(R.id.appwidget_text, "TODOlist: " + count);
            appWidgetManager.updateAppWidget(widgetIDs, rv);
            Log.i("----------count" , count+"");
        }
    }
    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

