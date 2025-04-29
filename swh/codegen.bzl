load("@rules_java//java:defs.bzl", "java_library")

def codegen(
        name):
    genrule_name = name + "_codegen"
    outfile = "SampleGeneratedCode.java"

    cmd = (
        "$(location //swh:codegen) " +
        "--out $(location %s) " % outfile
    )

    native.genrule(
        name = genrule_name,
        srcs = [],
        cmd = cmd,
        outs = [outfile],
        tools = ["//swh:codegen"],
    )

    java_library(
        name = name,
        srcs = [genrule_name],
        deps = [],
    )
