package com.hedgehog.scanner.data

import android.app.usage.UsageStatsManager
import android.content.Context
import android.util.Log
import com.hedgehog.scanner.domain.AppModel
import com.hedgehog.scanner.domain.InfoRepository
import java.util.*

class AppImageNameRepository(private val context: Context) : InfoRepository {

    override fun fetchAppsImageName(): List<AppModel> {
        val pm = context.packageManager
        val packages = pm.getInstalledPackages(0)
        val list = mutableListOf<AppModel>()

        for (packageInfo in packages) {
            val intentOfStartActivity =
                pm.getLaunchIntentForPackage(packageInfo.packageName)
                    ?: continue
            packageInfo.firstInstallTime
            list.add(
                AppModel(
                    drawable = pm.getActivityIcon(intentOfStartActivity),
                    appName = packageInfo.applicationInfo.loadLabel(pm).toString(),
                    packageName = packageInfo.packageName,
                )
            )
        }
        return list
    }

    override fun fetchAppInfo(): Any {
        val calendar = Calendar.getInstance()

        val usm = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        val usageStatsList = usm.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            calendar.timeInMillis - 31560000000,
            calendar.timeInMillis,
        )
        Log.d("QWE", "${usageStatsList.size}")

        for (stat in usageStatsList) {
            Log.d("QWE", "info:${stat.packageName}")
//            Log.d("QWE", "info:${convertLongToTime(stat.lastTimeUsed)}")
        }
        Log.d("QWE", "done")

        return 1
    }
}