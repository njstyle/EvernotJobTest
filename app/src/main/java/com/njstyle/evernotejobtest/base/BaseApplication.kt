package com.njstyle.evernotejobtest.base

import android.app.Application
import com.evernote.android.job.JobManager
import com.evernote.android.job.JobRequest
import com.njstyle.evernotejobtest.common.LogMgr
import com.njstyle.evernotejobtest.common.getTag
import com.njstyle.evernotejobtest.job.JobCreatorManager
import com.njstyle.evernotejobtest.job.NetworkCheckJob

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        LogMgr.d()

        JobManager.create(this).addJobCreator(JobCreatorManager())

        scheduleJob()
    }

    override fun onTerminate() {
        LogMgr.d()

        super.onTerminate()
    }

    fun scheduleJob() {
        val jobId = JobRequest.Builder(NetworkCheckJob::class.getTag() + " METERED")
                .setPeriodic(JobRequest.MIN_INTERVAL)
                .setRequiresDeviceIdle(false)
                .setUpdateCurrent(true)
                .setRequiredNetworkType(JobRequest.NetworkType.METERED)
                .build()
                .schedule()

        JobRequest.Builder(NetworkCheckJob::class.getTag() + " UNMETERED")
                .setPeriodic(JobRequest.MIN_INTERVAL)
                .setRequiresDeviceIdle(false)
                .setUpdateCurrent(true)
                .setRequiredNetworkType(JobRequest.NetworkType.UNMETERED)
                .build()
                .schedule()
    }
}