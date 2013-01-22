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

import java.io.Reader;

/**
 *
 * @author adrian
 */
public interface LanguageProvider {

    public ScopeProvider createScope() throws Exception;

    public String getLanguage();
    public String getLanguageName();

    public String getExtension();
    public String getExtensionName();
    public String getMime();

    public String[] getGlobalScriptResources();
    public String[] getRunScriptResources();
    public String getNewScriptTemplate();

    public boolean isDebuggable();
    public void openDebugger();
    public void closeDebugger();
    public boolean isDebuggerOpen();

    public String getScriptTask(Reader task) throws Exception;
}
