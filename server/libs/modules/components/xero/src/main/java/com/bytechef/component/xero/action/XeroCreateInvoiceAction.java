/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.xero.action;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;

import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.bool;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNTS_PAYABLE_TAX_TYPE;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNTS_RECEIVABLE_TAX_TYPE;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNT_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.ADDRESSES;
import static com.bytechef.component.xero.constant.XeroConstants.BANK_ACCOUNT_DETAILS;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_ID;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_PERSONS;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_STATUS;
import static com.bytechef.component.xero.constant.XeroConstants.CREATE_INVOICE;
import static com.bytechef.component.xero.constant.XeroConstants.DEFAULT_CURRENCY;
import static com.bytechef.component.xero.constant.XeroConstants.EMAIL_ADDRESS;
import static com.bytechef.component.xero.constant.XeroConstants.FIRST_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.IS_CUSTOMER;
import static com.bytechef.component.xero.constant.XeroConstants.IS_SUPPLIER;
import static com.bytechef.component.xero.constant.XeroConstants.LAST_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.NAME;
import static com.bytechef.component.xero.constant.XeroConstants.PAYMENT_TEAMS;
import static com.bytechef.component.xero.constant.XeroConstants.PHONES;
import static com.bytechef.component.xero.constant.XeroConstants.PURCHASES_DEFAULT_ACCOUNT_CODE;
import static com.bytechef.component.xero.constant.XeroConstants.PURCHASES_TRACKING_CATEGORIES;
import static com.bytechef.component.xero.constant.XeroConstants.SALES_DEFAULT_ACCOUNT_CODE;
import static com.bytechef.component.xero.constant.XeroConstants.SALES_TRACKING_CATEGORIES;
import static com.bytechef.component.xero.constant.XeroConstants.TAX_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.TRACKING_CATEGORY_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.TRACKING_OPTION_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.XERO_NETWORK_KEY;

/**
 * @author Mario Cvjetojevic
 */
public final class XeroCreateInvoiceAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(CREATE_INVOICE)
        .title("Create invoice")
        .description("Description")
        .properties()
        .outputSchema(string())
        .perform(XeroCreateInvoiceAction::perform);

    private XeroCreateInvoiceAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) {

        return null;
    }
}
