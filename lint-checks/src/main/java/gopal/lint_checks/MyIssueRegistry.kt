package gopal.lint_checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import gopal.lint_checks.checks.AndroidEntryPointIssue

@Suppress("UnstableApiUsage")
class MyIssueRegistry: IssueRegistry() {

    override val issues = listOf(AndroidEntryPointIssue.ISSUE) // Add your all Issues

    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8
}