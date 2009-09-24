package com.jnaerator;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Goal which touches a timestamp file.
 *
 * @goal jnaerate
 * @phase generate-sources
 */
public class JNAeratorMojo
    extends AbstractMojo
{
    /**
     * Output directory for JNAerated sources.
     * @parameter expression="${project.build.directory}/src/jnaerator/config.jnaerator"
     * @required
     */
    private File config;

    /**
     * Output directory for JNAerated sources.
     * @parameter expression="${project.build.directory}/generated-sources/jnaerator"
     * @optional
     */
    private File sourcesOutputDirectory;

    public void execute()
        throws MojoExecutionException
    {
        System.out.println(getPluginContext());

        List<String> args = new ArrayList<String>();
        if (sourcesOutputDirectory != null) {
            args.add("-o");
            args.add(sourcesOutputDirectory.getAbsolutePath());
        }
        args.add(config.getAbsolutePath());

        try
        {
            com.ochafik.lang.jnaerator.JNAerator.main(args.toArray(new String[0]));
        }
        catch (Exception e )
        {
            throw new MojoExecutionException( "Error running JNAerator on " + config, e );
        }
    }
}
