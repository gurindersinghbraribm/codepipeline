package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class CodePipelineApp {
    public static void main(final String[] args) {
        App app = new App();

        new CodePipelineStack(app, "PipelineStack", StackProps.builder()
                .env(Environment.builder()
                        .account("595076097930")
                        .region("eu-west-2")
                        .build())
                .build());

        app.synth();

    }
}

