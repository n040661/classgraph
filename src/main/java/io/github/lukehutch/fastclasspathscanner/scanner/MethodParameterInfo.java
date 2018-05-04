/*
 * This file is part of FastClasspathScanner.
 *
 * Author: Luke Hutchison
 *
 * Hosted at: https://github.com/lukehutch/fast-classpath-scanner
 *
 * --
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Luke Hutchison
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.lukehutch.fastclasspathscanner.scanner;

import io.github.lukehutch.fastclasspathscanner.typesignature.TypeSignature;

public class MethodParameterInfo {
    private final AnnotationInfo[] annotationInfo;
    private final int modifiers;
    private final TypeSignature typeDescriptor;
    private final TypeSignature typeSignature;
    private final String name;

    public MethodParameterInfo(final AnnotationInfo[] annotationInfo, final int modifiers,
            final TypeSignature typeDescriptor, final TypeSignature typeSignature, final String name) {
        this.name = name;
        this.modifiers = modifiers;
        this.typeDescriptor = typeDescriptor;
        this.typeSignature = typeSignature;
        this.annotationInfo = annotationInfo;
    }

    /**
     * Method parameter name. May be null, for unnamed parameters (e.g. synthetic parameters), or if compiled for
     * JDK version lower than 8, or if compiled for JDK version 8+ but without the commandline switch `-parameters`.
     */
    public String getName() {
        return name;
    }

    /**
     * Method parameter modifiers. May be zero, if no modifier bits set, or if compiled for JDK version lower than
     * 8, or if compiled for JDK version 8+ but without the commandline switch `-parameters`.
     */
    public int getModifiers() {
        return modifiers;
    }

    /** Method parameter type descriptor. */
    public TypeSignature getTypeDescriptor() {
        return typeDescriptor;
    }

    /**
     * Method parameter type signature, or if not available, method type descriptor.
     */
    public TypeSignature getTypeSignatureOrTypeDescriptor() {
        return typeSignature != null ? typeSignature : typeDescriptor;
    }

    /**
     * Method parameter type signature, possibly including generic type information (or null if no type signature
     * information available for this parameter).
     */
    public TypeSignature getTypeSignature() {
        return typeSignature;
    }

    /** Method parameter annotation info (or null if no annotations). */
    public AnnotationInfo[] getAnnotationInfo() {
        return annotationInfo;
    }
}