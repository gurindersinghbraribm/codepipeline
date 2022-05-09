package com.myorg;

import software.amazon.awscdk.pipelines.CodePipeline;
import software.amazon.awscdk.pipelines.CodePipelineSource;
import software.amazon.awscdk.pipelines.ShellStep;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class CodePipelineStack extends Stack {
    public CodePipelineStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CodePipelineStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        CodePipeline pipeline = CodePipeline.Builder.create(this, "pipeline")
                .pipelineName("CodePipeline")
                .synth(ShellStep.Builder.create("Synth")
                        .input(CodePipelineSource.gitHub("gurindersinghbraribm/codepipeline", "main"))
                        .commands(Arrays.asList("npm install -g aws-cdk", "cdk synth"))
                        .build())
                .build();
    }
}
