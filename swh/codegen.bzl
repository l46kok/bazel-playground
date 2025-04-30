load("@rules_java//java:defs.bzl", "java_library")

def java_lib_wrapper(name):
    codegen(
        name = name + "_codegen",
    )

    java_library(
        name = name,
        srcs = [":" + name + "_codegen"],
    )

def _codegen_impl(ctx):
    srcjar_output = ctx.actions.declare_file(ctx.attr.name + ".srcjar")

    ctx.actions.run(
        inputs = [],
        outputs = [srcjar_output],
        arguments = [srcjar_output.path, ctx.attr.name],
        progress_message = "Generating java files into '%s'" % srcjar_output,
        executable = ctx.executable._tool,
    )

    return [DefaultInfo(files = depset([srcjar_output]))]

codegen = rule(
    implementation = _codegen_impl,
    attrs = {
        "_tool": attr.label(
            executable = True,
            cfg = "host",
            allow_files = True,
            default = Label("//swh:codegen_tool"),
        ),
    },
)
