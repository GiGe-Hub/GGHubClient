package com.gghub.api.restful.model.bean

import java.util.ArrayList


class RepoCommitExt : RepoCommit() {

    val files: ArrayList<CommitFile>? = null
    val stats: CommitStats? = null
}
