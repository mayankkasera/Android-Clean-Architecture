plugins {
    id(Plugins.KTLINT) version Versions.KTLINT
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(AppDependencies.GRADLE)
        classpath(AppDependencies.KOTLIN)
        classpath(AppDependencies.DAGGER_HILT_GRADLE_PLUGIN)
        classpath(AppDependencies.SAFE_ARGS)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

subprojects {
    apply(plugin = Plugins.KTLINT)
    repositories {
        // Required to download KtLint
        mavenCentral()
    }
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            android.set(false)
            ignoreFailures.set(false)
            outputColorName.set("RED")
            disabledRules.set(setOf("final-newline", "max-line-length"))
            reporters {
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
