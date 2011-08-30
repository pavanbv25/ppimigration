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

import java.util.Collections;

import org.mifos.customers.surveys.business.QuestionChoice;
import org.mifos.customers.surveys.business.Survey;
import org.mifos.customers.surveys.business.SurveyInstance;
import org.mifos.customers.surveys.business.SurveyQuestion;
import org.mifos.customers.surveys.helpers.SurveyType;

public class PPISurvey extends Survey {

    private Country country;
    private int veryPoorMin;
    private int veryPoorMax;
    private int poorMin;
    private int poorMax;
    private int atRiskMin;
    private int atRiskMax;
    private int nonPoorMin;
    private int nonPoorMax;

    public static int DEFAULT_VERY_POOR_MIN = 0;
    public static int DEFAULT_VERY_POOR_MAX = 24;
    public static int DEFAULT_POOR_MIN = 25;
    public static int DEFAULT_POOR_MAX = 49;
    public static int DEFAULT_AT_RISK_MIN = 50;
    public static int DEFAULT_AT_RISK_MAX = 74;
    public static int DEFAULT_NON_POOR_MIN = 75;
    public static int DEFAULT_NON_POOR_MAX = 101;

    /**
     * TODO: Not used
     */

    /**
     * implements a dispatch pattern so that a client will get the correct class
     * of survey without having to invoke instanceOf(). This method overrides
     * the superclass method to return
     */
    @Override
    public SurveyInstance createSurveyInstance() {
        return new PPISurveyInstance();
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCountry(int id) {
        this.country = Country.fromInt(id);
    }

    public int getCountry() {
        return country.getValue();
    }

    public Country getCountryAsEnum() {
        return country;
    }

    public void setVeryPoorMin(int veryPoorMin) {
        this.veryPoorMin = veryPoorMin;
    }

    public int getVeryPoorMin() {
        return veryPoorMin;
    }

    public void setVeryPoorMax(int veryPoorMax) {
        this.veryPoorMax = veryPoorMax;
    }

    public int getVeryPoorMax() {
        return veryPoorMax;
    }

    public void setPoorMin(int poorMin) {
        this.poorMin = poorMin;
    }

    public int getPoorMin() {
        return poorMin;
    }

    public void setPoorMax(int poorMax) {
        this.poorMax = poorMax;
    }

    public int getPoorMax() {
        return poorMax;
    }

    public void setAtRiskMin(int atRiskMin) {
        this.atRiskMin = atRiskMin;
    }

    public int getAtRiskMin() {
        return atRiskMin;
    }

    public void setAtRiskMax(int atRiskMax) {
        this.atRiskMax = atRiskMax;
    }

    public int getAtRiskMax() {
        return atRiskMax;
    }

    public void setNonPoorMin(int nonPoorMin) {
        this.nonPoorMin = nonPoorMin;
    }

    public int getNonPoorMin() {
        return nonPoorMin;
    }

    public void setNonPoorMax(int nonPoorMax) {
        this.nonPoorMax = nonPoorMax;
    }

    public int getNonPoorMax() {
        return nonPoorMax;
    }

    public void populateDefaultValues() {
        setVeryPoorMin(DEFAULT_VERY_POOR_MIN);
        setVeryPoorMax(DEFAULT_VERY_POOR_MAX);
        setPoorMin(DEFAULT_POOR_MIN);
        setPoorMax(DEFAULT_POOR_MAX);
        setAtRiskMin(DEFAULT_AT_RISK_MIN);
        setAtRiskMax(DEFAULT_AT_RISK_MAX);
        setNonPoorMin(DEFAULT_NON_POOR_MIN);
        setNonPoorMax(DEFAULT_NON_POOR_MAX);
    }

    @Override
    public void setAppliesTo(String dummy) {
        super.setAppliesTo(SurveyType.CLIENT);
    }

    @Override
    public void setAppliesTo(SurveyType dummy) {
        super.setAppliesTo(SurveyType.CLIENT);
    }

    @Override
    public String toString() {
        String output = "Survey name: " + getName() + ", country: " + getCountryAsEnum().toString() + "\n";
        Collections.sort(getQuestions());
        for (SurveyQuestion sQuestion : getQuestions()) {
            output += "\t";
            output += sQuestion.getMandatory() == 1 ? "*" : "";
            output += sQuestion.getOrder() + "\n";
            output += "\t " + sQuestion.getQuestion().getQuestionText() + "\n";
            for (QuestionChoice choice : sQuestion.getQuestion().getChoices()) {
                output += "\t\t" + choice.getChoiceText() + "\n";
            }
        }
        return output;
    }

}
