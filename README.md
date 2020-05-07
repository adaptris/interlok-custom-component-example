# Custom Component Development

A quick start to writing your own custom component; this is just an example of a custom service.

## Intro

* Java 8 is preferred for the 3.x branch; things will build with Java 11 etc but since annotations have changed from Java9 onwards our custom taglets / annotation processing may not fire.

We default to using gradle as the build tool; this is the preferred build system. You can opt to use something else (check the other branches), but we find gradle gives us the most flexbility along with useful conventions.

## Before you start

The things you should consider changing are (You don't have to, but it will make your project a mystery when it comes to discoverability).

Some of these properties can be override by putting (the ones that use ?: ternary operators) those properties in a `gradle.properties` file. In most cases variables that should be environment specific are done like; variables that are specific to the build are left as normal variables defined in the gradle script.

| Gradle Entry | Impact | Description |
| ---| --- |--- | --- |
| componentName | JAR Manifest / UI | A short description of your component that shows up as the title in the optional components page |
| organizationName | JAR Manifest | Your organization (apologies for the americanism) |
| releaseVersion | JAR Manifest / Maven Repo | The version of your artifact |
| artifactGroup | JAR Manifest / Maven Repo | Your artifacts group name |
| componentDescription | UI |  A longer description that shows up inthe UI |
| componentTargetInterlokVersion | UI| Your target interlok version |
| componentInterlokTags | UI | Tags you want to show up in the UI |
| componentRequiresLicense | UI | Whether or not your custom component requires a license |
| mavenPublishUrl | Build | Where you are going to publish the artifact to. We don't yet have a good answer for a centralised Interlok artifact repository; this may cause some discoverability issues. |
| defaultNexusRepo | Build | if you have a custom maven repository that contains additional dependencies, then specify it here |


## Your first build

```
$ ./gradlew clean check

> Task :test
Picked up JAVA_TOOL_OPTIONS: -Djava.io.tmpdir=C:/Adaptris/TEMP

> Task :spotbugsMain

BUILD SUCCESSFUL in 11s
8 actionable tasks: 8 executed
```

You should be able to see various reports in `build/**/*.html`; along with a new jar in _build/libs_

## 3rd party plugins/apps

All these 3rd party items are either fully opensource, or free for opensource projects. We have enabled them on this sample project; but it is beyond the scope of this README to actually document *why* and *how* you use the plugins..

* [LGTM](https://lgtm.com) is enabled via a `.lgtm.yml` file; we use this to contextually scan source code.
* jacoco coverage is enabled and reports will be generated when `check` is invoked
    * If you don't want spotbugs checks then run `./gradlew clean test jacocoTestReport`
* Spotbugs is enabled via a gradle plugin; this is used to statically analyze source code; the gradle file is annotated such that you can add various filters as required.
    * This will be executed when you do `check`
    * Spotbugs analysis is disabled on test resources.
* OWASP dependency checks are enabled via a gradle plugin
    * You need to execute this manually using `gradle dependencyCheckAnalyze`
    * We have included a pointer to our standard suppression file
* [CircleCI](https://circleci.com)is enabled on the project to test building both with Java11 + Java8 via `.circleci/config.yml`
    * Coverage results from jacoco are injected into [codecov.io](https://codecov.io)
* [Travis-CI](https://travis-ci.com) is enabled on the project via `.travis.yml`
    * Coverage results from jacoco are injected into [codecov.io](https://codecov.io)
    * This means if you build with both circleCI + Travis you might get duplicate codecov entries.
* Github Actions are enabled via `.github/workflows/gradle.yml` - this runs the `check` task
    * Of course you could enable codecov integration on this as well.
* [dependabot](https://dependabot.com) is enabled via `.dependabot/config.yml` for managing dependencies; you could use whitesource renovate instead to manage updates to your dependencies.
    * Note that you may have to configure dependabot to add our public repositories.

## Additional features

### Versioning info based on git branch
If your project source control is git; then the generated `adaptris-version` will reflect the git branch. If it is what is considered the default branch, then the current date is used. All of this is done via the git executable which needs to be present on the path. You can disable this behaviour by modifying the __generateVersion__ task to remove the call to `buildInfo()`

In this instance the generated `adaptris-version` file should contain a `build.info=gradle` since this is on the gradle branch.

