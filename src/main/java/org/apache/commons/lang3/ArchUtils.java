/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.arch.Processor;

import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.AnnotatedFor;

/**
 * An utility class for the os.arch System Property. The class defines methods for
 * identifying the architecture of the current JVM.
 * <p>
 * Important: The os.arch System Property returns the architecture used by the JVM
 * not of the operating system.
 * </p>
 * @since 3.6
 */
@AnnotatedFor({"nullness"}) 
public class ArchUtils {

    private static final Map<String, Processor> ARCH_TO_PROCESSOR;

    static {
        ARCH_TO_PROCESSOR = new HashMap<>();
        init();
    }

    private static void init() {
        init_X86_32Bit();
        init_X86_64Bit();
        init_IA64_32Bit();
        init_IA64_64Bit();
        init_PPC_32Bit();
        init_PPC_64Bit();
    }

    private static void init_X86_32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        addProcessors(processor, "x86", "i386", "i486", "i586", "i686", "pentium");
    }

    private static void init_X86_64Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        addProcessors(processor, "x86_64", "amd64", "em64t", "universal");
    }

    private static void init_IA64_32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64);
        addProcessors(processor, "ia64_32", "ia64n");
    }

    private static void init_IA64_64Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        addProcessors(processor, "ia64", "ia64w");
    }

    private static void init_PPC_32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.PPC);
        addProcessors(processor, "ppc", "power", "powerpc", "power_pc", "power_rs");
    }

    private static void init_PPC_64Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        addProcessors(processor, "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    /**
     * Adds the given {@link Processor} with the given key {@link String} to the map.
     *
     * @param key The key as {@link String}.
     * @param processor The {@link Processor} to add.
     * @throws IllegalStateException If the key already exists.
     */
    private static void addProcessor(String key, Processor processor) throws IllegalStateException {
        if (!ARCH_TO_PROCESSOR.containsKey(key)) {
            ARCH_TO_PROCESSOR.put(key, processor);
        } else {
            String msg = "Key " + key + " already exists in processor map";
            throw new IllegalStateException(msg);
        }
    }

    /**
     * Adds the given {@link Processor} with the given keys to the map.
     *
     * @param keys The keys.
     * @param processor The {@link Processor} to add.
     * @throws IllegalStateException If the key already exists.
     */
    private static void addProcessors(Processor processor, String... keys) throws IllegalStateException {
        for (String key : keys) {
            addProcessor(key, processor);
        }
    }

    /**
     * Returns a {@link Processor} object of the current JVM.
     *
     * <p>
     * Important: The os.arch System Property returns the architecture used by the JVM
     * not of the operating system.
     * </p>
     *
     * @return A {@link Processor} when supported, else <code>null</code>.
     */
    public static @Nullable Processor getProcessor() {
        return getProcessor(SystemUtils.OS_ARCH);
    }

    /**
     * Returns a {@link Processor} object the given value {@link String}. The {@link String} must be
     * like a value returned by the os.arch System Property.
     *
     * @param value A {@link String} like a value returned by the os.arch System Property.
     * @return A {@link Processor} when it exists, else <code>null</code>.
     */
    public static @Nullable Processor getProcessor(@Nullable String value) {
        return ARCH_TO_PROCESSOR.get(value);
    }

}
