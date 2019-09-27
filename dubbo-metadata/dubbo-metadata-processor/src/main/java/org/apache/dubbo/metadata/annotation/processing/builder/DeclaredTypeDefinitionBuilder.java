/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.metadata.annotation.processing.builder;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.Objects;

import static javax.lang.model.type.TypeKind.DECLARED;

/**
 * An interface of {@link TypeDefinitionBuilder} for {@link DeclaredType}
 *
 * @since 2.7.5
 */
public interface DeclaredTypeDefinitionBuilder extends TypeDefinitionBuilder<DeclaredType> {

    @Override
    default boolean accept(ProcessingEnvironment processingEnv, TypeMirror type) {
        TypeKind kind = type.getKind();
        if (!Objects.equals(DECLARED, kind)) {
            return false;
        }
        return accept(processingEnv, (DeclaredType) type);
    }

    /**
     * Test the specified {@link DeclaredType type} is accepted or not
     *
     * @param processingEnv {@link ProcessingEnvironment}
     * @param type          {@link DeclaredType type}
     * @return <code>true</code> if accepted
     */
    boolean accept(ProcessingEnvironment processingEnv, DeclaredType type);
}
