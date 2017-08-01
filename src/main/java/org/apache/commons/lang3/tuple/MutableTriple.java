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
package org.apache.commons.lang3.tuple;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.AnnotatedFor;

/**
 * <p>A mutable triple consisting of three {@code Object} elements.</p>
 *
 * <p>Not #ThreadSafe#</p>
 *
 * @param <L> the left element type
 * @param <M> the middle element type
 * @param <R> the right element type
 *
 * @since 3.2
 */
@AnnotatedFor({"nullness"}) 
public class MutableTriple<L, M, R> extends Triple<L, M, R> {

    /** Serialization version */
    private static final long serialVersionUID = 1L;

    /** Left object */
    public @Nullable L left;
    /** Middle object */
    public @Nullable M middle;
    /** Right object */
    public @Nullable R right;

    /**
     * <p>Obtains an mutable triple of three objects inferring the generic types.</p>
     *
     * <p>This factory allows the triple to be created using inference to
     * obtain the generic types.</p>
     *
     * @param <L> the left element type
     * @param <M> the middle element type
     * @param <R> the right element type
     * @param left  the left element, may be null
     * @param middle  the middle element, may be null
     * @param right  the right element, may be null
     * @return a triple formed from the three parameters, not null
     */
    public static <L, M, R> MutableTriple<L, M, R> of(final @Nullable L left, final @Nullable M middle, final @Nullable R right) {
        return new MutableTriple<>(left, middle, right);
    }

    /**
     * Create a new triple instance of three nulls.
     */
    public MutableTriple() {
        super();
    }

    /**
     * Create a new triple instance.
     *
     * @param left  the left value, may be null
     * @param middle  the middle value, may be null
     * @param right  the right value, may be null
     */
    public MutableTriple(final @Nullable L left, final @Nullable M middle, final @Nullable R right) {
        super();
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    //-----------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public @Nullable L getLeft() {
        return left;
    }

    /**
     * Sets the left element of the triple.
     *
     * @param left  the new value of the left element, may be null
     */
    public void setLeft(final @Nullable L left) {
        this.left = left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @Nullable M getMiddle() {
        return middle;
    }

    /**
     * Sets the middle element of the triple.
     *
     * @param middle  the new value of the middle element, may be null
     */
    public void setMiddle(final @Nullable M middle) {
        this.middle = middle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @Nullable R getRight() {
        return right;
    }

    /**
     * Sets the right element of the triple.
     *
     * @param right  the new value of the right element, may be null
     */
    public void setRight(final @Nullable R right) {
        this.right = right;
    }
}

