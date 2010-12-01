/* 
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hazelcast.web.tomcat;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ali
 *
 */

public class HazelAttribute implements Serializable {
	
	private String sessionId = null;
	
	private String name = null;
	
	private Object value = null;
	
	private transient Set<Long> touchedByRequest = new HashSet<Long>();
	
	public HazelAttribute(String sessionId, String name, Object value){
		this.sessionId = sessionId;
		this.name = name;
		this.value = value;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public void touch(long requestId){
		touchedByRequest.add(requestId);
	}
	
	public boolean isTouched(long requestId){
		return touchedByRequest.remove(requestId);
	}
	
	public String getKey(){
		return sessionId + "_" + name;
	}
	
}