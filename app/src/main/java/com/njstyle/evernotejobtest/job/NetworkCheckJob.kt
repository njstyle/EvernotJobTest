package com.njstyle.evernotejobtest.job

import com.evernote.android.job.Job
import com.njstyle.evernotejobtest.common.LogMgr

class NetworkCheckJob: Job() {
    override fun onRunJob(params: Params): Result {
        LogMgr.d()


        return Result.SUCCESS
    }

    override fun onCancel() {
        super.onCancel()

        LogMgr.d()
    }

    override fun onReschedule(newJobId: Int) {
        super.onReschedule(newJobId)

        LogMgr.d()
    }
}