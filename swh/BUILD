load("@rules_java//java:defs.bzl", "java_binary")
load("//swh:codegen.bzl", "codegen")

package(default_visibility = ["//visibility:public"])

codegen(
    name = "foo",
)

java_binary(
    name = "main",
    srcs = ["Main.java"],
    main_class = "swh.Main",
    deps = [
        ":foo",
    ],
)

java_binary(
    name = "codegen",
    srcs = ["CodeGen.java"],
    main_class = "swh.CodeGen",
    deps = [
    ],
)
