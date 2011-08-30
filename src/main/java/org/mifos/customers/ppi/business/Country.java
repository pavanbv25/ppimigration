/*
 * Copyright (c) 2005-2010 Grameen Foundation USA
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */

package org.mifos.customers.ppi.business;

public enum Country {
    INDIA(1);

    private int value;

    private Country(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Country fromInt(int id) {
        for (Country country : Country.values()) {
            if (country.getValue() == id) {
                return country;
            }
        }
        throw new RuntimeException("No countries have id " + id);
    }
}
