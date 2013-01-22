//    Task Executor is a simple script tasks executor.
//    Copyright (C) 2011 Adrián Romero Corchado.
//
//    This file is part of Task Executor
//
//    Task Executor is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Task Executor is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Task Executor. If not, see <http://www.gnu.org/licenses/>.

package com.adr.taskexecutor.common;

import java.io.PrintWriter;
import java.io.Reader;

/**
 *
 * @author adrian
 */
public abstract class ScopeProvider {

    protected LanguageProvider langparent;

    public final LanguageProvider getLanguageProvider() {
        return langparent;
    }
    
    public abstract Object eval(Reader code, String name) throws Exception;
    public abstract Object invoke(String function, Object... parameter) throws Exception;
    public abstract void put(String name, Object value);
    public abstract void setErr(PrintWriter err);
    public abstract void setOut(PrintWriter out);
}
