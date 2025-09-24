package org.customspringframework.Core.Coverter.typeconversion;

public interface Convert<T> {

    T convert(String source);
}