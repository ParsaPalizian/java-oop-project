package com.company.interfaces;

import com.company.Result;

public interface Editable<T> {
    public Result<T> edit(String content, boolean... saveToDatabase) throws Exception;
    public Result<T> delete() throws Exception;
}
