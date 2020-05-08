/**
 *  Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.kie.kogito.examples;

import java.util.ArrayList;
import java.util.List;

import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;
import org.kie.kogito.rules.SingletonStore;

public class Hello implements RuleUnitData {
	DataStore<String> messages = DataSource.createStore();

	SingletonStore<ArrayList> resultList = DataSource.createSingleton();

	public DataStore<String> getMessages() {
		return messages;
	}

	public void setMessages(DataStore<String> messages) {
		this.messages = messages;
	}

	public SingletonStore<ArrayList> getResultList() {
		return resultList;
	}

	public void setResultList(SingletonStore<ArrayList> resultList) {
		this.resultList = resultList;
	}

}
