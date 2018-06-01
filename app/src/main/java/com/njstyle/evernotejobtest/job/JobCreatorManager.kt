package com.njstyle.evernotejobtest.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import com.njstyle.evernotejobtest.common.getTag

class JobCreatorManager : JobCreator {
    override fun create(tag: String): Job? {
        if (tag.contains(NetworkCheckJob::class.getTag())) {
            return NetworkCheckJob()
        }

        return null
    }
}