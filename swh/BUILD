load("@rules_java//java:defs.bzl", "java_binary")
load("//swh:codegen.bzl", "java_lib_wrapper")

package(default_visibility = ["//visibility:public"])

java_lib_wrapper(
    name = "lib_wrapper",
)

java_binary(
    name = "main",
    srcs = ["Main.java"],
    main_class = "swh.Main",
    deps = [
        ":lib_wrapper",
    ],
)

java_binary(
    name = "codegen_tool",
    srcs = ["CodeGen.java"],
    main_class = "swh.CodeGen",
    deps = [
    ],
)
