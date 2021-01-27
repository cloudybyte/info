/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee.errors;

public class IntelligenzException extends Exception{
    public IntelligenzException(IntelligenzExceptionCause cause) {
        super(String.valueOf(cause));
    }
}

