package gopal.lint_checks.visitor

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.JavaContext
import gopal.lint_checks.checks.AndroidEntryPointIssue
import org.jetbrains.uast.UClass

@Suppress("UnstableApiUsage")
class AndroidEntryPointVisitor(private val context: JavaContext) : UElementHandler() {

    private val superClassQualifiedNameFragment =
        "androidx.appcompat.app.AppCompatActivity"

    override fun visitClass(node: UClass) {
        if (node.javaPsi.superClass?.qualifiedName == superClassQualifiedNameFragment &&
            !node.hasAnnotation("dagger.hilt.android.AndroidEntryPoint")
        ) {
            reportIssue(node)
        }
    }

    private fun reportIssue(node: UClass) {
        context.report(
            issue = AndroidEntryPointIssue.ISSUE,
            scopeClass = node,
            location = context.getNameLocation(node),
            "Use @AndroidEntryPoint before running the app, Hurray Your First Lint",
        )
    }
}