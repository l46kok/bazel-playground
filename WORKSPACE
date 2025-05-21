workspace(name = "proto_transitive_failure")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "com_google_protobuf",
    sha256 = "2b695cb1eaef8e173f884235ee6d55f57186e95d89ebb31361ee55cb5fd1b996",
    strip_prefix = "protobuf-31.0",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v31.0.tar.gz"],
)


# http_archive(
#     name = "com_google_protobuf",
#     sha256 = "008a11cc56f9b96679b4c285fd05f46d317d685be3ab524b2a310be0fbad987e",
#     strip_prefix = "protobuf-29.3",
#     urls = ["https://github.com/protocolbuffers/protobuf/archive/v29.3.tar.gz"],
# )

### rules_android setup
http_archive(
    name = "rules_android",
    sha256 = "4135e2fa37a94bb36c7801e33faef2934c9fe4f9a84d0035eacc4154c2c30e44",
    strip_prefix = "rules_android-0.6.4",
    url = "https://github.com/bazelbuild/rules_android/releases/download/v0.6.4/rules_android-v0.6.4.tar.gz",
)

load("@rules_android//:prereqs.bzl", "rules_android_prereqs")
rules_android_prereqs()

load("@rules_java//java:rules_java_deps.bzl", "rules_java_dependencies")
rules_java_dependencies()

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")
protobuf_deps()

load("@rules_java//java:repositories.bzl", "rules_java_toolchains")
rules_java_toolchains()

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
rules_jvm_external_deps()
load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")
rules_jvm_external_setup()

load("@rules_android//:defs.bzl", "rules_android_workspace")
rules_android_workspace()

load("@rules_android//rules:rules.bzl", "android_sdk_repository")
android_sdk_repository(
    name = "androidsdk"
)

register_toolchains(
    "@rules_android//toolchains/android:android_default_toolchain",
    "@rules_android//toolchains/android_sdk:android_sdk_tools",
)

### end of rules_android setup


