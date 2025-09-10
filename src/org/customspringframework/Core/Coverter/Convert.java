package org.customspringframework.Core.Coverter;

public interface Convert<T> {

    T convert(String source);
}